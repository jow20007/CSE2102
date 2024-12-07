import React from 'react';
import quizPageStyle from '../QuizPageStyle';
import MyState from '../model/MyState';
import { Link } from 'react-router-dom';

class Score extends React.Component {
    render() {
        return(
        <div style={quizPageStyle}>
            <h1>Score</h1>
            <h2>{MyState.quiz.score}/{MyState.quiz.count}</h2>
            <Link to="/"><button>Go back</button></Link>
        </div>
        );
    }
}

export default Score;