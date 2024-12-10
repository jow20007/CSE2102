import React from 'react';
import bradford from '../images/Bradford.jpeg';
import speechBubble from '../images/speech-bubble.png';
import my_state from '../model/my_state';


class Bradford extends React.Component {

    render() {
        // console.log(this.props.displayBubble);
        return(
            <div style={{display: "grid", justifyItems: "center", position: "relative"}}>
                <img className={"bubble " + (this.props.displayBubble ? "shown" : "hidden")} style={{width: "23vw", position: "absolute", top:"-1vw", left: "29vw"}} src={speechBubble} alt="speech bubble"/>
                <span className={"bubble " + (this.props.displayBubble ? "shown" : "hidden")} style={{width: "16vw", fontSize: "2vw", lineHeight: "1.5", textAlign: "center", position: "absolute", top:"3.5vw", left: "32vw", color: "black"}}>{this.props.speech_text}</span>
                <img id='bfi' style={{width: "40vw", height: "40vw", borderRadius: "20vw", objectFit: "cover"}} src={bradford} alt="prof" onClick={() => this.props.clickBubble()} />
            </div>
        );
    }
}

export default Bradford;