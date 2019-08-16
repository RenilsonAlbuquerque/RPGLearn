import React, {Component} from 'react';

import { connect } from 'react-redux';
import StompWS from 'react-native-stomp-websocket';
import CombatBottomNavigator from '../router/CombatBottomNavigator';
import { bindActionCreators } from "redux";
import {setCombatStatus,getCombatStatusState} from '../actions/CombatAction'


class CombatPage extends Component {
  static navigationOptions = {
    title: 'Combate',
  };
      
    componentDidMount() {
      const storyId = this.props.currentCombat.id;
      this.props.getCombatStatusState(storyId);
      const client = StompWS.client("ws://192.168.0.112:8080/stomp");
      client.connect({}, (frame) => {
        client.subscribe('/topic/combat/' + storyId, (message) => {
            this.props.setCombatStatus(JSON.parse(message.body))
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
    errorMessage: state.CombatReducer.combatState,
    currentCombat: state.StoryReducer.selectedStory
})  
  
  const mapDispatchToProps = dispatch => bindActionCreators({
    setCombatStatus,
    getCombatStatusState
  }, dispatch);
export default connect(mapStateToProps,mapDispatchToProps)(CombatPage);

