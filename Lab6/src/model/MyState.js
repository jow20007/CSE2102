import my_questions from "../model/basic_questions.json"

class MyState {
    static quiz = {
        attempts: new Array(my_questions.length + 1).fill(0),
        score: 0,
        count: 0
    }
}

export default MyState;