import React from 'react';
import Svg, {
    Circle,
    Ellipse,
    G,
    Text,
    TSpan,
    TextPath,
    Path,
    Polygon,
    Polyline,
    Line,
    Rect,
    Use,
    Image,
    Symbol,
    Defs,
    LinearGradient,
    RadialGradient,
    Stop,
    ClipPath,
    Pattern,
    Mask,
  } from 'react-native-svg';
  import { View, StyleSheet,TouchableOpacity } from 'react-native';
  import { SvgXml } from 'react-native-svg';
  import { connect } from 'react-redux';
  import { bindActionCreators } from 'redux';
  import { setWalkPoperties,setActionProperties } from '../../../actions/CombatAction';
  import CombatRoomService from '../../../service/CombatRoomService';
  import { adjustPosition } from '../../../helpers/Combat-helper';

let mountBoardWithXML = (speed,creaturePosition,creatureSize,squareDimension,mapOptions, isDash) => {
    console.log(speed)
    let squareColor = !isDash ? "#044894": "#C82333";
    let miniBoardDimension = 30 * speed;
    let result = `<svg xmlns="http://www.w3.org/2000/svg" width="${mapOptions.naturalWidth}" height="${mapOptions.naturalHeight}" >`;
    
    let matrixDimension,c,k,space = 1;

  
    creaturePosition.x -= miniBoardDimension;
    creaturePosition.y -= miniBoardDimension;
    matrixDimension = speed +1;
   
    
    space = matrixDimension -1;

    let jumpX = creaturePosition.x;
    let jumpY = creaturePosition.y;
    for(k =1; k <= matrixDimension; k++){
        for(c =1; c <= space;c++){
            jumpY += squareDimension
        }
        space --;
        for(c=1;c <= (2*k-1);c++){
            result += `<rect height="${squareDimension.toString()}" width="${squareDimension.toString()}" 
                    y="${jumpY}" x="${jumpX}" strokeWidth="1.5" stroke="#000" 
                    fill="${squareColor}" fillOpacity="0.4">
                    </rect>`;
            jumpY += squareDimension;            
        }
        jumpY = creaturePosition.y;
        jumpX += squareDimension;
    }
    space = 1;
    for(k =1; k <= matrixDimension -1; k++){
        for(c = 1; c <= space; c++){
            jumpY += squareDimension;
        }
        space++;
        for(c= 1; c <= 2*(matrixDimension-k)-1; c++ ){
            result += `<rect height="${squareDimension.toString()}" width="${squareDimension.toString()}" 
                y="${jumpY}" x="${jumpX}" strokeWidth="1.5" stroke="#000" 
                fill="${squareColor}" fillOpacity="0.4">
                </rect>`;
                jumpY += squareDimension;
        }
        jumpY = creaturePosition.y;
        jumpX += squareDimension;
    }
    result += `</svg>`;
    return result;

}  

let WalkArea = (props) =>{
    const {
        combatStatus,
        combatWalkMovement,
        combatCurrentMap,
        actionProperties,
        playerId,
        setWalkPoperties,
        setActionProperties
    } = props;

    let speed = 5;
    let creatureSize = 1;
    let squareDimension = 30;

    if(props.dash){
        speed = speed * 2;
    }

    let handlePressScreen = (evt) =>{

        let position = adjustPosition({x:evt.nativeEvent.locationX , y: evt.nativeEvent.locationY }, 30);
        let playerPosition = {x: props.movimentActionsStatus.x, y: props.movimentActionsStatus.y}
        let movimentDistance = calculateMovimentDistanceInSquares(position,playerPosition,speed);

        if(movimentDistance <= speed){
            let combatId = props.combatStatus.creatures.find(creature => creature.id === props.playerId).combatId;
            props.setWalkPoperties({
                x:position.x,
                y:position.y,
                walkVisible:false,
                dashVisible:false
            });
            CombatRoomService.moveCharacter(props.combatStatus,position,combatId);
            if(props.isDash){
                props.actionProperties.dashMove += movimentDistance
            }else{
                props.actionProperties.walkMove += movimentDistance
            }
        }
        
    }
    let calculateMovimentDistanceInSquares = (targetPosition,creaturePosition,speed) =>{
        creaturePosition = {
            x: (creaturePosition.x + (30 * speed)), 
            y: creaturePosition.y + (30 * speed)
        }
        return Math.abs( ((targetPosition.x - creaturePosition.x) /30) ) + 
            Math.abs( ((targetPosition.y - creaturePosition.y) /30))
    }
    let dashAllowed = (props.actionProperties.walkMove > 0 ) ? false: true;
    let walkAllowed = (props.actionProperties.dashMove > 0 ) ? false: true; 
    return(
        (props.shown && (props.dash ? dashAllowed : walkAllowed)) ? 
         (
         <TouchableOpacity style={{height:'100%',width:'100%',position:'absolute'}} onPress={(evt) => handlePressScreen(evt)}>
            <SvgXml style={{zIndex:7}} 
                xml={mountBoardWithXML((speed - props.actionProperties.walkMove),props.movimentActionsStatus,creatureSize,squareDimension,combatCurrentMap,props.dash)}>
            </SvgXml>
        </TouchableOpacity>
        ):
        (<></>) 
   
    )
}

const mapStateToProps = state => ({ 
    movimentActionsStatus: state.CombatReducer.movimentActionsStatus,
    combatCurrentMap : state.CombatReducer.currentMap,
    actionProperties: state.CombatReducer.actionProperties,
    combatStatus: state.CombatReducer.combatState,
    playerId: state.CharacterReducer.currentCharacter.characterSheet.id,
});
const mapDispatchToProps = dispatch => bindActionCreators({
    setWalkPoperties,
    setActionProperties
}, dispatch);
export default connect(mapStateToProps,mapDispatchToProps)(WalkArea);