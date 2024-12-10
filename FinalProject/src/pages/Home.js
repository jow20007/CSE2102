import React from 'react';
import { Link, Outlet } from "react-router-dom";
import BradfordHOC from './BradfordHOC';


class Home extends React.Component {
    state = {
        displayBubble: false,
        bubbleText: "Welcome to CSE2102!",
        timeoutId: null
    }

    updateTimeout() {
        clearTimeout(this.state.timeoutId);
        let id = setTimeout(() => this.setState(() => ({displayBubble: false, timeoutId: null})), 3000);
        return id;
    }

    updateBubble(msg) {
        let id = this.updateTimeout();
        this.setState(() => ({displayBubble: true, bubbleText: msg, timeoutId: id}));
    }

    toggleBubble() {
        this.setState((state) => {
            if (state.displayBubble) {
                clearTimeout(state.timeoutId);
                return {displayBubble: false, timeoutId: null};
            }
            let id = this.updateTimeout()
            return {displayBubble: true, timeoutId: id};
        });
    }
    
    componentDidMount() {
        setTimeout(() => this.toggleBubble(), 200);
    }

    render() {
        return(
            <div className='Home'>
                <div style={{width: "60vw", marginLeft: "20vw", display: "flex", justifyContent: "space-evenly", margin: "96px 20vw 48px"}}>
                    <Link to="/" onClick={() => this.updateBubble("Welcome to CSE2102!")}>Home</Link> {  }
                    <Link to="/Quiz" onClick={() => this.updateBubble("Answer me these questions three!")}>Quiz</Link> {  }
                    <Link to="/Score" onClick={() => this.updateBubble("Not bad!")}>Score</Link> {  }
                    <Link to="/Contact" onClick={() => this.updateBubble("Let's chat some more!")}>Contact us</Link> { }
                    <Link to="/TabExample" onClick={() => this.updateBubble("Uh oh!")}>Tab example</Link>
                </div>
                <div>
                    <BradfordHOC speech_text={this.state.bubbleText} displayBubble={this.state.displayBubble} clickBubble={() => this.toggleBubble()}>
                        <div className='outlet'>
                            <Outlet />
                        </div>
                    </BradfordHOC>
                </div>
            </div>
        );
    }
}

export default Home;