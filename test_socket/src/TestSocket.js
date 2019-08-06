import React from 'react';
import SockJsClient from 'react-stomp';
 
export class SampleComponent extends React.Component {
  constructor(props) {
    super(props);
  }
 
  sendMessage()  {
    this.clientRef.sendMessage('/hello', "Hello motherfucker");
  }
 
  render() {
    return (
      <div>
        <SockJsClient url='http://localhost:8080/combat' topics={['/room']}
            onMessage={(msg) => { console.log("We did it"); }}
            ref={ (client) => { this.clientRef = client }} />
            <a href="#" onClick={this.sendMessage}>Motherfucker</a>
      </div>
    );
  }
}