import React from 'react';
import quizPageStyle from '../QuizPageStyle';


import QuizController from '../controllers/QuizController';
import my_state from '../model/my_state';
import { Link } from 'react-router-dom';


const my_questions = 
[{
    id:1,
    question: "What is the capital of Connecticut?",
    answers: [{ answer:"Stamford", isCorrect:false }, { answer: "Storrs", isCorrect:false }, { answer: "Hartford", isCorrect:true } ]
  },
  {
    id:2,
    question: "What is the square root of 16?",
    answers: [{ answer: "4", isCorrect:true }, { answer: "8", isCorrect:false }, { answer:"16", isCorrect:false }]
  },
  {
    id:3,
    question: "What type of number is 101?",
    answers: [{ answer: "prime", isCorrect:true }, { answer: "composite", isCorrect:false }, { answer:"neigher", isCorrect:false }, { answer:"both", isCorrect:false }]
  }
];

const correctAnswers = [null, ...my_questions.map(q => q["answers"].filter(ans => ans["isCorrect"])[0]["answer"])];

class Quiz extends React.Component {
    qc = new QuizController()
    
    state = {
        attempts: my_state.my_attempts ?? new Array(my_questions.length).fill(0),
        score: my_state.my_score,
        count: my_state.my_count
    }

    updateScore(id, isCorrect) {
        if (this.state.attempts[id] === 2) return;
        
        this.setState(({count, score, attempts}) => {
            const res = {count, score, attempts: [...attempts]};
            res.count++;
        
            if (isCorrect) {
                res.score++;
                res.attempts[id] = 2;
                alert("You are correct!");
            } else {
                res.attempts[id]++;
                if (res.attempts[id] < 2) {
                    alert("Sorry - not correct");
                } else {
                    alert("Sorry - not correct; the correct answer is " + correctAnswers[id]);
                }
            }

            this.qc.updateScore(res);
            return res;
        })
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