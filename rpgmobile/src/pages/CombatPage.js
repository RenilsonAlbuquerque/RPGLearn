import React, {Component} from 'react';
import { StyleSheet, Image, View,Text} from 'react-native';

import SockJsClient from 'react-stomp';
import { Client } from '@stomp/stompjs';
import StompWS from 'react-native-stomp-websocket';

class CombatPage extends Component {
    
      
    componentDidMount() {
        const client = StompWS.client("ws://192.168.0.112:8080/stomp");
        client.connect({}, (frame) => {
          console.log("OK")
          client.subscribe('/topic/combat/1', (message) => {
            //this.setState(combatState = JSON.parse(message.body));
            this.setState({combatState: JSON.parse(message.body)} );
          });
        }, (err) => console.log(err))
    }
    
    constructor(props){
        super(props);
        this.state = {
            combatState : {
                monsters:[]
            }
        }   
    }
    render() {
        
        return (
            <View style={avatarStyle.creatureContaier}>
                 {this.state.combatState.monsters.map((monster, index) => 
                    <Image key={index} style={{
                        height:150,
                        width: 150,
                        borderRadius: 100,
                        borderWidth: 5,
                        borderColor: monster.color
                        
                    }} 
                            source={{uri: monster.imagePath}} />
                 )}
            </View>
           
           
            
        )
    }
}
export default CombatPage;

const avatarStyle = StyleSheet.create({
    imageStyle:{
        height:150,
        width: 150,
        borderRadius: 100,
        borderWidth: 5,
        borderColor: 'red'
    },
    creatureContaier:{
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'stretch',
    }

})