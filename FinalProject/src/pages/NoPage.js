import React from 'react';


class NoPage extends React.Component {

    render() {
        return(
            <div>
                <h1 style = {{color: "red"}}>This is a 404 error !</h1>
                <h2 style = {{color: "blue"}}>Yipes</h2>
            </div>
        );
    }
}

export default NoPage;