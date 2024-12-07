import React from 'react';
import quizPageStyle from '../QuizPageStyle';

import  my_questions from '../model/basic_questions.json';
import QuizController from '../controller/QuizController';
import MyState from '../model/MyState';
import { Link, Navigate } from 'react-router-dom';

const correctAnswers = [null, ...my_questions.map(q => q["answers"].filter(ans => ans["isCorrect"])[0]["answer"])];

class Quiz extends React.Component {
    qc = new QuizController()

    state = {
        attempts: MyState.quiz.attempts,
        score: MyState.quiz.score,
        count: MyState.quiz.count
    }

    updateScore(id, isCorrect) {
        if (this.state.attempts[id] === 2) return;

        this.setState(({count}) => ({count: count + 1}));
        
        if (isCorrect) {
            this.setState(({score}) => ({score: score + 1}))
            alert("You are correct!"); // could be executed before the setStates are done!
        } else {
            this.setState(({attempts}) => ({attempts: attempts.map((cnt, i) => (i === id ? cnt + 1 : cnt))}))
            if (this.state.attempts[id] < 1) {
                alert("Sorry - not correct");
            } else {
                alert("Sorry - not correct; the correct answer is " + correctAnswers[id]);
            }
        }
    }
    
    render() {
        return(
        <div style={quizPageStyle}>
            <h1>My Questions</h1>
            { my_questions.map((quest) => (
                <div> 
                    <h2>{quest["question"]}</h2>
                        {quest["answers"].map((ans) => (
                            <div>
                                <label>
                                <input  
                                        type = "radio"
                                        name = { quest["id"] }
                                        key = { quest["id"] }
                                        onClick = { () => this.updateScore(quest["id"], ans["isCorrect"]) }
                                        value = { ans["isCorrect"] } /> 
                                    { ans["answer"] }
                                </label> 
                                <br />
                            </div>
                        ))}
                    
                </div>
            ))}
            <br />
            <Link to="/score"><button onClick={() => this.qc.updateScore(this.state)} >Done</button></Link>
        </div>
        );
    }
}

export default Quiz;