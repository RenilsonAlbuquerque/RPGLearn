import React, {Component} from 'react';
import { Text} from 'native-base';
import {StyleSheet, View,SafeAreaView,ScrollView,Image, PanResponder,ImageBackground} from 'react-native';
import { connect } from 'react-redux';
import { FlatGrid } from 'react-native-super-grid';
import CharacterCombatToken from '../character/CharacterCombatToken';
import { bindActionCreators } from 'redux';
import { getCombatAreaStatusState } from '../../actions/CombatAction';
import CustomAxios from '../../service/AxiosConfig';

class CombatArea extends Component{
    constructor(props){
        super(props);
        this.state = {
            combatState : {
                creatures:[]
            },
            mapDim: {
                width: 12,
                height: 12
            }
        }
    }

    render() {
        const {
            combatStatusData,
            areaMapStatusData
        } = this.props;
        return (
            <View styles={{flex: 1}}>
                <ScrollView styles={{flex: 1, height: '100%', width: '100%' }}> 
                    <ScrollView 
                        directionalLockEnabled={false} horizontal={true} >
                        <Image style={{width: areaMapStatusData.naturalWidth,
                                        height: areaMapStatusData.naturalHeight}} 
                                source={{uri: areaMapStatusData.map}}/>
                        
                            {combatStatusData.creatures.map((item, index) =>
                            
                                <CharacterCombatToken key={index} creature={item}></CharacterCombatToken>
                                
                            )}
                    </ScrollView>
                </ScrollView>
            </View>
            
        )
    }
}
const mapStateToProps = state => ({ 
    combatStatusData: state.CombatReducer.combatState,
    areaMapStatusData: state.CombatReducer.currentMap
});
const mapDispatchToProps = dispatch => bindActionCreators({
    getCombatAreaStatusState
}, dispatch);
const styles = StyleSheet.create({

    text: {
      fontSize: 42,
    },
    image: {
        flex: 1,
        resizeMode: "cover",
        justifyContent: "center"
      }
  });  
export default connect(mapStateToProps,mapDispatchToProps)(CombatArea);