import my_state from '../model/my_state';

class QuizController {
    updateScore = (state) => {
        console.log(state)
        my_state.my_attempts = state.attempts;
        my_state.my_score = state.score;
        my_state.my_count = state.count;
    }
}

export default QuizController;