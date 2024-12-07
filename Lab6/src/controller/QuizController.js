import MyState from '../model/MyState';

class QuizController {
    updateScore = (state) => {
        MyState.quiz.attempts = state.attempts;
        MyState.quiz.score = state.score;
        MyState.quiz.count = state.count;
    }
}

export default QuizController;