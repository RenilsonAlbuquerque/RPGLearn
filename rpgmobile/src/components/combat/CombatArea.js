import React, {useEffect} from 'react';
import {StyleSheet, View,ScrollView,Image, Animated, Text, TouchableHighlight} from 'react-native';
import { connect } from 'react-redux';
import CharacterCombatToken from '../character/CharacterCombatToken';
import { bindActionCreators } from 'redux';
import { getCombatAreaStatusState, setWalkPoperties } from '../../actions/CombatAction';
import GestureHandler, { PinchGestureHandler } from 'react-native-gesture-handler';
import { Icon, Button } from 'native-base';
import { Platform } from 'react-native';
import WalkArea from './CombatShapes/WalkArea';
import CombatTurnPanel from './CombatTurnPanel';
import CombatPlayerMenu from './CombatPlayerMenu';
import Colors from '../../styles/ColorsStyle';
import CombatRoomService from '../../service/CombatRoomService';
import { Dimensions } from 'react-native';


let CombatArea = (props) =>{
    //******State of reducers ************/
    const {
        combatStatusData,
        areaMapStatusData,
        playerId,
        movimentActionsStatus,
        setWalkPoperties
    } = props;

    useEffect(() => {
        console.log("The map has been changed");
        props.getCombatAreaStatusState(combatStatusData.placeId);
    }, [combatStatusData.placeId]);
    
    //****** Pinch part ************/
    const scale = React.useRef(new Animated.Value(1)).current;
  
    const handlePinch = Animated.event([{ nativeEvent: {scale} }]);
  
    let gestureHandlerStateChange = (event) =>{
 
        if(event.nativeEvent.scale < 1){
            scale.setValue(1);
          
        }
    }
    //********** Scrollview ***********************************/
    let mainContainer = null;
    let horizontalScroll = null;
    let verticalScroll = null;

    let handleChangeToPosition = function(){
        let playerPosition = searchForPlayerPosition();
        horizontalScroll.scrollTo( {x:playerPosition.x - (Dimensions.get('window').width/2)})
        //(mainContainer.height/2)
        verticalScroll.scrollTo( {y:playerPosition.y - (Dimensions.get('window').height/2)})
        scale.setValue(1);
    }
    //++++++++++++++++++++++++++++++Screen methods++++++++++++++++++++++++++++++++//
    let searchForPlayerPosition = function(){
        let result = {x: 0, y: 0};
        combatStatusData.creatures.map((item,index) => {
            if(item.playerId === playerId && item.position.x > 0 && item.position.y > 0){
                result = item.position;
            }
        });
        return result;
    }
    // let handlePressScreen = (evt) => {
    //     console.log("hira")
    //     if(props.walkProperties.visible){
    //         handleWalkCharacter(evt);
    //     }
    // }

    // let handleWalkCharacter = (evt) => {
    //     let position = {x:evt.nativeEvent.locationX , y: evt.nativeEvent.locationY };
    //     let combatId = combatStatusData.creatures.find(creature => creature.id === props.playerId).combatId;
    //     props.setWalkPoperties({
    //         x:position.x,
    //         y:position.y,
    //         visible: false
    //     });
    //     CombatRoomService.moveCharacter(props.combatStatusData,position,combatId);
    // }


    let fieldResult = (
    /*******Only gesture**************************************** */
   
    <View>
       <CombatTurnPanel styles={styles.panel}></CombatTurnPanel>
    <View style={{height:'96%'}} onLayout={(event) => {mainContainer  = event.nativeEvent.layout;}} >
        <ScrollView styles={{ height: '100%', width: '100%' }} ref={(scrollView) => { verticalScroll = scrollView; }}> 
            <ScrollView directionalLockEnabled={false} horizontal={true} ref={(scrollView) => { horizontalScroll = scrollView; }}> 
                <PinchGestureHandler onGestureEvent={handlePinch}
                        onHandlerStateChange={gestureHandlerStateChange}>
                    <Animated.View style={{transform:[{scale}]}}>

                        <Image style={[{width: areaMapStatusData.naturalWidth,
                            height: areaMapStatusData.naturalHeight}]} 
                            source={{uri: areaMapStatusData.map}}/>
            
                        <WalkArea 
                            shown={movimentActionsStatus.walkVisible}
                            dash={false}
                        ></WalkArea>
                        <WalkArea 
                            shown={movimentActionsStatus.dashVisible}
                            dash={true}
                        ></WalkArea>
                        {combatStatusData.creatures.map((item, index) =>    
                            <CharacterCombatToken key={index} creature={item}></CharacterCombatToken>                        
                        )}        
                    </Animated.View>            
                </PinchGestureHandler>
            </ScrollView>
        </ScrollView>
        <Button style={[styles.fab,{left:5}]} onPress={ handleChangeToPosition}>
            <Icon size={100} name={ Platform.OS === 'ios' ? (focused ? 'ios-person' : 'ios-home-outline') : 'md-locate' }  />
        </Button> 
        {/* <Button style={[styles.fab,{right:5}]} onPress={ handleChangeToPosition}>
            <Icon size={100} name={ Platform.OS === 'ios' ? (focused ? 'ios-person' : 'ios-home-outline') : 'md-menu' }  />
        </Button> */}
        {CombatRoomService.checkIfIsMyTurn(combatStatusData,playerId) ? 
            (<CombatPlayerMenu></CombatPlayerMenu>):(<></>)
        }
        </View>
    </View>
    )
    let emptyPage = (
        <View style={styles.emptyPageConainer}>
            <Text style={styles.warningText}>O mestre ainda não selecionou um mapa</Text>
        </View>)
    return (props.areaMapStatusData.id > 0) ? fieldResult : emptyPage;

}
const mapStateToProps = state => ({ 
    combatStatusData: state.CombatReducer.combatState,
    areaMapStatusData: state.CombatReducer.currentMap,
    playerId: state.CharacterReducer.currentCharacter.characterSheet.id,
    movimentActionsStatus: state.CombatReducer.movimentActionsStatus,
    
});
const mapDispatchToProps = dispatch => bindActionCreators({
    getCombatAreaStatusState,
    setWalkPoperties
}, dispatch);
export default connect(mapStateToProps,mapDispatchToProps)(CombatArea);
const styles = StyleSheet.create({

    fab: {
        zIndex:9999,
        color: '#ffffff',
        backgroundColor:'#000000',
        borderRadius:100,
        position:'absolute',
        height:50, 
        width: 50,
        bottom: 5,
      },
      panel: {
        zIndex:9999,
        
      },
      emptyPageConainer:{
        alignItems: 'center', 
        flex:1,
        justifyContent: 'center',
        backgroundColor: Colors.LIGHT_PRIMARY_COLOR
      },
      warningText:{
        textAlignVertical: 'center',
        textAlign:'center',
        fontWeight:'bold',
        fontSize:40,
        color:Colors.TEXT_COLOR
      }
});