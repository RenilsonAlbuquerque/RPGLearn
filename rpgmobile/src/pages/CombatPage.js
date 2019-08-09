import React, {Component} from 'react';
import { StyleSheet, Image, View,Text} from 'react-native';

import { connect } from 'react-redux';
import StompWS from 'react-native-stomp-websocket';
import changeColor from '../helpers/Combat-helper';
import CombatBottomNavigator from '../router/CombatBottomNavigator';
import { bindActionCreators } from "redux";
import {setCombatStatus} from '../actions/CombatAction'

class CombatPage extends Component {
    
      
    componentDidMount() {
        const client = StompWS.client("ws://192.168.0.112:8080/stomp");
        client.connect({}, (frame) => {
          client.subscribe('/topic/combat/1', (message) => {
            this.props.setCombatStatus(JSON.parse(message.body))
            //this.setState({combatState: JSON.parse(message.body)} );
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
            <CombatBottomNavigator></CombatBottomNavigator>
        )
    }
}
const mapStateToProps = state => ({ 
    errorMessage: state.CombatReducer.combatState
  })  
  
  const mapDispatchToProps = dispatch => bindActionCreators({
    setCombatStatus
  }, dispatch);
export default connect(mapStateToProps,mapDispatchToProps)(CombatPage);

