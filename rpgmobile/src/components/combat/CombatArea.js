import React, {Component} from 'react';
import { Text} from 'native-base';
import {StyleSheet, View,SafeAreaView,ScrollView,Image} from 'react-native';
import { connect } from 'react-redux';
import { FlatGrid } from 'react-native-super-grid';
import CharacterCombatToken from '../character/CharacterCombatToken';

class CombatArea extends Component{
    constructor(props){
        super(props);
        this.state = {
            combatState : {
                creatures:[{id:2,name:'x'}]
            }
        }   
    }
    render() {
        const {
            combatStatusData
        } = this.props;
        return (
            
            <ScrollView>
                <ScrollView  directionalLockEnabled={false} horizontal={true}>
                    <Image style={{ width: 600, height: 900 }} 
                        source={{uri: 'https://i.pinimg.com/originals/34/60/07/346007827453cc41c9c05746f95582af.jpg'}} />
                        {this.state.combatState.creatures.map((item, index) =>
                            
                                <CharacterCombatToken key={index}></CharacterCombatToken>
                        
                        )}
                        
                </ScrollView>

            </ScrollView>
            
            
        )
    }
}
const mapStateToProps = state => ({ 
    combatStatusData: state.CombatReducer.combatState
});
const styles = StyleSheet.create({

    text: {
      fontSize: 42,
    },
  });  
export default connect(mapStateToProps,null)(CombatArea);