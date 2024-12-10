import React from 'react';
import Bradford from './Bradford';


class BradfordHOC extends React.Component {
    render() {
        return(
            <div style={{display: "flex", justifyContent: "center"}}>
            <Bradford speech_text={this.props.speech_text} displayBubble={this.props.displayBubble} clickBubble={this.props.clickBubble}/>
                {this.props.children}
            </div>
        );
    }
}

export default BradfordHOC;