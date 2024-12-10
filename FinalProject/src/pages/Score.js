import React from 'react';
import my_state from '../model/my_state';

class Score extends React.Component {
  
    render() {
        return(
            <div>
                <h1>This is the Score page</h1>
                <h2>{this.props.s_prop}</h2>
                <h2> Your score so far is {my_state.my_score} / {my_state.my_count} </h2>
                <br/>
                <br/>
               
            </div>
        );
    }
}

export default Score;