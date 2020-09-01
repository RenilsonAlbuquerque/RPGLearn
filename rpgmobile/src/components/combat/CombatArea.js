import React, {Component} from 'react';
import { Text} from 'native-base';
import {StyleSheet, View,SafeAreaView,ScrollView,Image} from 'react-native';
import { connect } from 'react-redux';
import { FlatGrid } from 'react-native-super-grid';
import CharacterCombatToken from '../character/CharacterCombatToken';
import { bindActionCreators } from 'redux';
import { getCombatAreaStatusState } from '../../actions/CombatAction';

class CombatArea extends Component{
    constructor(props){
        super(props);
        this.state = {
            combatState : {
                creatures:[]
            }
        } 
        this.props.mapProps = {
            width: 12,
            height: 12,
            map: 'https://i.pinimg.com/originals/34/60/07/346007827453cc41c9c05746f95582af.jpg'
        }; 
    }
    calculateMapWidith(place){
        let multifplierFactor = Number((50/(place.squareDimension)).toFixed(1));
        return place.xDimension * multifplierFactor; 
    }
    calculateMapHeight(place){
        let multifplierFactor = Number((50/(place.squareDimension)).toFixed(1));
        return place.yDimension * multifplierFactor;
    }
    componentDidUpdate(prevProps,prevState,snapshot){
        if(prevProps.combatStatusData.placeId != this.props.combatStatusData.placeId){
            this.props.getCombatAreaStatusState(this.props.combatStatusData.placeId);

        }
    }
    render() {
        const {
            combatStatusData,
            areaMapStatusData
        } = this.props;
        return (
            <ScrollView>
                <ScrollView  directionalLockEnabled={false} horizontal={true}>
                    <Image style={{ width: this.calculateMapWidith(areaMapStatusData),
                                    height: this.calculateMapWidith(areaMapStatusData),
                                resizeMode: 'stretch' }} 
                        source={{uri: areaMapStatusData.map}} />
                        
                        {combatStatusData.creatures.map((item, index) =>
                            
                                <CharacterCombatToken key={index} creature={item}></CharacterCombatToken>
                        
                        )}
                        
                </ScrollView>

            </ScrollView>
            
            
        )
    }
}
const mapStateToProps = state => ({ 
    combatStatusData: state.CombatReducer.combatState,
    areaMapStatusData: state.CombatReducer.currentMap
});
const mapDispatchToProps = dispatch => bindActionCreators({
    getCombatAreaStatusState,
}, dispatch);
const styles = StyleSheet.create({

    text: {
      fontSize: 42,
    },
  });  
export default connect(mapStateToProps,mapDispatchToProps)(CombatArea);
//