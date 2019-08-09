import React, {Component} from 'react';
import { StyleSheet, Image, View,Text} from 'react-native';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";


import changeColor from '../../helpers/Combat-helper';

class CombatMonsters extends Component {
    
      
   
    
    constructor(props){
        super(props);
        this.state = {
            combatState : {
                monsters:[]
            }
        }   
    }
    render() {
        const {
            combatStatusData
        } = this.props;
        return (
            <View style={avatarStyle.creatureContaier}>
                 {combatStatusData.monsters.map((monster, index) => 
                  
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
const mapStateToProps = state => ({ 
    combatStatusData: state.CombatReducer.combatState
})  
  

export default connect(mapStateToProps,null)(CombatMonsters);

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