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
  import { View, StyleSheet } from 'react-native';
  import { SvgXml } from 'react-native-svg';
  import { connect } from 'react-redux';

let mountBoardWithXML = (speed,creaturePosition,creatureSize,squareDimension,mapOptions) => {
    let squareColor = "#044894";
    let miniBoardDimension = 30 * speed;
    let result = `<svg xmlns="http://www.w3.org/2000/svg" width="${mapOptions.naturalWidth}" height="${mapOptions.naturalHeight}" >`;
    creaturePosition.x -= miniBoardDimension;
    creaturePosition.y -= miniBoardDimension;


    let matrixDimension,c,k,space = 1;
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
        combatWalkMovement,
        combatCurrentMap
    } = props;

    let speed = 5;
    let creatureSize = 1;
    let squareDimension = 30;

    return(
        (combatWalkMovement.visible) ? 
        (<SvgXml style={{zIndex:7,position:'absolute'}} 
            xml={mountBoardWithXML(speed,props.combatWalkMovement,creatureSize,squareDimension,combatCurrentMap)}>
        </SvgXml>):
        (<></>) 
   
    )
}

const mapStateToProps = state => ({ 
    combatWalkMovement: state.CombatReducer.walkMovement,
    combatCurrentMap : state.CombatReducer.currentMap
});
export default connect(mapStateToProps,null)(WalkArea);