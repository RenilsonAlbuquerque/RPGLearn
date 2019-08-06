import React from 'react';
import SockJsClient from 'react-stomp';
import { Client } from '@stomp/stompjs';
 
export class SampleComponent extends React.Component {
  constructor(props) {
    super(props);
  }
 
  state = {
    serverTime: null,
  }
  componentDidMount() {
    
    // The compat mode syntax is totally different, converting to v5 syntax
    // Client is imported from '@stomp/stompjs'
    this.client = new Client();

    this.client.configure({
      brokerURL: 'ws://localhost:8080/stomp',
      onConnect: () => {
      

        this.client.subscribe('/queue/now', message => {
          console.log(message);
          //this.setState({serverTime: message.body});
        });

        this.client.subscribe('/topic/combat/1', message => {
          console.log(JSON.parse(message.body))
        });
      },
      // Helps during debugging, remove in production
      debug: (str) => {
        console.log(new Date(), str);
      }
    });

    this.client.activate();
  }
  clickHandler = () => {
    this.client.publish({destination: '/app/combat/1', body: 'Hello world'});
  }
 
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <p>
            Server time: {this.state.serverTime ? this.state.serverTime : 'no data'}
          </p>
          <p>
            <button onClick={this.clickHandler}>Click me</button>
          </p>
        </header>
      </div>
    );
  }
}