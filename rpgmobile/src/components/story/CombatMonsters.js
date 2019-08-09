import React, {Component} from 'react';
import { StyleSheet, Image, View,Text} from 'react-native';
import { connect } from 'react-redux';

import StompWS from 'react-native-stomp-websocket';
import changeColor from '../../helpers/Combat-helper';

class CombatMonsters extends Component {
    
      
    componentDidMount() {
        const client = StompWS.client("ws://192.168.0.112:8080/stomp");
        client.connect({}, (frame) => {
          client.subscribe('/topic/combat/1', (message) => {
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
                            borderColor: changeColor(monster.lifePercent),          
                    }} 
                        source={{uri: monster.imagePath}} />
                 )}
                 
            </View>
        )
    }
}
export default connect(null,null)(CombatMonsters);

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
        alignItems: 'stretch'
    }

})