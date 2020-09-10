import React from 'react';
import {StyleSheet, View,ScrollView,Image, Animated} from 'react-native';
import { connect } from 'react-redux';
import CharacterCombatToken from '../character/CharacterCombatToken';
import { bindActionCreators } from 'redux';
import { getCombatAreaStatusState } from '../../actions/CombatAction';
import GestureHandler, { PinchGestureHandler } from 'react-native-gesture-handler';
import { Icon, Button } from 'native-base';
import { Platform } from 'react-native';
import WalkArea from './CombatShapes/WalkArea';
import CombatTurnPanel from './CombatTurnPanel';


let CombatArea = (props) =>{
    //******State of reducers ************/
    const {
        combatStatusData,
        areaMapStatusData,
        playerId
    } = props;

    
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
        console.log(searchForPlayerPosition());
        let playerPosition = searchForPlayerPosition();
        horizontalScroll.scrollTo( {x:playerPosition.x - (mainContainer.height/2)})
        verticalScroll.scrollTo( {y:playerPosition.y - (mainContainer.height/2)})
        scale.setValue(1);
    }
    let searchForPlayerPosition = function(){
        let result = {x: 0, y: 0};
        combatStatusData.creatures.map((item,index) => {
            if(item.id === playerId && item.position.x > 0 && item.position.y > 0){
                result = item.position;
            }
        });
        return result;
    }

    let checkIfIsMyTurn =()=>{
        
    }

    return (
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
                            <WalkArea></WalkArea>
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
        <Button style={[styles.fab,{right:5}]} onPress={ handleChangeToPosition}>
            <Icon size={100} name={ Platform.OS === 'ios' ? (focused ? 'ios-person' : 'ios-home-outline') : 'md-menu' }  />
        </Button> 
        
    </View>
    </View>
    )

}
const mapStateToProps = state => ({ 
    combatStatusData: state.CombatReducer.combatState,
    areaMapStatusData: state.CombatReducer.currentMap,
    playerId: state.CharacterReducer.currentCharacter.characterSheet.id
});
const mapDispatchToProps = dispatch => bindActionCreators({
    getCombatAreaStatusState
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
        
      }
});