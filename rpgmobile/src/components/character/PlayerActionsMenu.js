import React, {Component} from 'react';
import { View, StyleSheet, Platform} from 'react-native';
import { Button, Icon } from 'native-base';
import  BaseComponentStyle  from '../../styles/BaseComponentStyle';


export default PlayerActionsMenu = (props) =>{
    console.log(props.creature.position.y)
    let calculateMenuPosition = () => {
        //40 is the half of menu square dimension
        //15 is the half of token size
        
        return {
            marginTop: props.creature.position.y - 40 + 15,
            marginLeft: props.creature.position.x - 40 + 13
        }
    }
    return(
        <View styles={[styles.menuContainer]}>
            <Button style={BaseComponentStyle.fab}>
                <Icon size={100} name={ Platform.OS === 'ios' ? (focused ? 'ios-person' : 'ios-home-outline') : 'md-running' }  />
            </Button>
            <Button style={[BaseComponentStyle.fab,{left:60}]}>
                <Icon size={100} name={ Platform.OS === 'ios' ? (focused ? 'ios-person' : 'ios-home-outline') : 'md-running' }  />
            </Button>
        </View>
    )

}
const styles = StyleSheet.create({
    menuContainer:{
        height:110, 
        width:110,
        backgroundColor:'#ffffff',
        position:'absolute',
        //opacity:0.7,
        // zIndex:999
    },
  });