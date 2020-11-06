import React, {Component} from 'react';

import { connect } from 'react-redux';
import StompWS from 'react-native-stomp-websocket';
import CombatBottomNavigator from '../router/CombatBottomNavigator';
import { bindActionCreators } from "redux";
import {setCombatStatus,getCombatStatusState,getCombatStatusStateNoReducing,getCombatAreaStatusState} from '../actions/CombatAction'
import {getCurrentCaracterFromStory, getCurrentCaracterFromStoryNoReducing,setCurrentCharacter } from '../actions/CharacterAction'
import { BASE_URL } from '../constants/constants';
import CustomAxios from '../service/AxiosConfig';
import { LogBox } from 'react-native';
import CombatRoomService from '../service/CombatRoomService';
import  CharacterCreationPage  from '../components/character/characterCreation/CharacterCreationPage';


class CombatPage extends Component {
  static navigationOptions = {
    title: 'Combate',
  };
      
    componentDidMount() {
      const storyId = this.props.currentCombat.id;
      //this.props.getCombatStatusState(storyId);

      //=================Requisita o status inicial do jogo======/
      this.requestCombatStatusAndScenario(storyId);
      

      //=================Conecta ao Stomp====================
      const client = StompWS.client(`ws://${BASE_URL}/stomp`);
      client.connect({}, (frame) => {
        
        CombatRoomService.setStoryId(storyId);
        
        client.subscribe('/topic/combat/' + storyId, (message) => {
            this.props.setCombatStatus(JSON.parse(message.body))
        });

        CombatRoomService.setInstance(client);
        this.initializeCharacterSheetFromStory();
        
      }, (err) => console.log(err))
      

      //===================Carrega os dados do jogador==========/
      

      //this.props.getCurrentCaracterFromStory(this.props.currentUser.id,this.props.currentStory.id);
      
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
    initializeCharacterSheetFromStory(){
      this.props.getCurrentCaracterFromStory(this.props.currentUser.id,this.props.currentStory.id)
        .then(
          result => {
            this.props.setCurrentCharacter(result.payload);
            CombatRoomService.initiateInCombat(this.props.combatState, result.payload.characterToken);
            //this.props.getCombatAreaStatusState(result.data.placeId);
          }
      )
    }
    
    constructor(props){
        super(props);
        // this.state = {
        //     combatState : {
        //         monsters:[]
        //     }
        // }   
    }
    render() {
      // console.log(this.props.characterInStory);
      if(!this.props.characterInStory.characterSheet || !this.props.characterInStory.characterSheet){
        return (<CharacterCreationPage></CharacterCreationPage>)
      }else{
        return (<CombatBottomNavigator></CombatBottomNavigator>)
      }
    }
    
}
const mapStateToProps = state => ({ 
    combatState: state.CombatReducer.combatState,
    currentCombat: state.StoryReducer.selectedStory,
    currentUser: state.UserReducer.currentUser,
    currentStory: state.StoryReducer.selectedStory,
    characterInStory: state.CharacterReducer.currentCharacter
})  
  
  const mapDispatchToProps = dispatch => bindActionCreators({
    setCombatStatus,
    getCombatStatusState,
    getCombatStatusStateNoReducing,
    getCurrentCaracterFromStory,
    getCurrentCaracterFromStoryNoReducing,
    setCurrentCharacter,
    getCombatAreaStatusState
  }, dispatch);
export default connect(mapStateToProps,mapDispatchToProps)(CombatPage);

