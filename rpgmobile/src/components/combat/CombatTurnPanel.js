import React, {useEffect}  from 'react';
import {StyleSheet, View,ScrollView,Image, Animated, Text} from 'react-native';
import Colors from '../../styles/ColorsStyle';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

let CombatTurnPanel = (props) =>{
    const {
        combatStatus
    } = props;

    useEffect(() => {
        console.log("the turn has been changed")
    }, [props.combatStatus.currentCreatureTurn]);

    let creature = props.combatStatus.creatures.find(creature => creature.combatId === props.combatStatus.currentCreatureTurn)
    
    return(
        <View style={{width:"100%",backgroundColor:Colors.PRIMARY_COLOR,height:'4%'}}>
            {(creature) ? 
                <Text style={{color:Colors.TEXT_COLOR}}>Turno de {creature.name}</Text> :
                <Text   style={{color:Colors.TEXT_COLOR}}>O combate ainda não foi iniciado</Text>
        }
            
        </View>
    )
}
const mapStateToProps = state => ({ 
    combatStatus: state.CombatReducer.combatState,
});
export default connect(mapStateToProps,null)(CombatTurnPanel);