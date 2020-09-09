import React, {Component} from 'react';

import { connect } from 'react-redux';
import StompWS from 'react-native-stomp-websocket';
import CombatBottomNavigator from '../router/CombatBottomNavigator';
import { bindActionCreators } from "redux";
import {setCombatStatus,getCombatStatusState,getCombatStatusStateNoReducing,getCombatAreaStatusState} from '../actions/CombatAction'
import {getCurrentCaracterFromStory} from '../actions/CharacterAction'
import { BASE_URL } from '../constants/constants';
import CustomAxios from '../service/AxiosConfig';
import { LogBox } from 'react-native';


class CombatPage extends Component {
  static navigationOptions = {
    title: 'Combate',
  };
      
    componentDidMount() {
      const storyId = this.props.currentCombat.id;
      //this.props.getCombatStatusState(storyId);
      this.requestCombatStatusAndScenario(storyId);
      const client = StompWS.client(`ws://${BASE_URL}/stomp`);
      client.connect({}, (frame) => {
        client.subscribe('/topic/combat/' + storyId, (message) => {
            
            this.props.setCombatStatus(JSON.parse(message.body))
          });
      }, (err) => console.log(err))
      
      
        
      this.props.getCurrentCaracterFromStory(this.props.currentUser.id,this.props.currentStory.id)
      
    }
    requestCombatStatusAndScenario(storyId){
      CustomAxios
        .get(`/combat/status/${storyId}`)
        .then(
          result => {
            this.props.setCombatStatus(result.data);
            this.props.getCombatAreaStatusState(result.data.placeId);
          }
        )
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
    currentCombat: state.StoryReducer.selectedStory,
    currentUser: state.UserReducer.currentUser,
    currentStory: state.StoryReducer.selectedStory
})  
  
  const mapDispatchToProps = dispatch => bindActionCreators({
    setCombatStatus,
    getCombatStatusState,
    getCombatStatusStateNoReducing,
    getCurrentCaracterFromStory,
    getCombatAreaStatusState
  }, dispatch);
export default connect(mapStateToProps,mapDispatchToProps)(CombatPage);

