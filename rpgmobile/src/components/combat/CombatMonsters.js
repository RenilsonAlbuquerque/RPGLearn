import React, {Component} from 'react';
import { StyleSheet, Image, View,Text} from 'react-native';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import { FlatGrid } from 'react-native-super-grid';

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
            <FlatGrid
                itemDimension={130}
                items={combatStatusData.monsters}
                style={avatarStyle.gridView}
                // staticDimension={300}
                // fixed
                // spacing={20}
                renderItem={({ item, index }) => (
                    <View key={index} style={[{borderColor: changeColor(item.lifePercent), backgroundColor: changeColor(item.lifePercent) }]}>
                        <Image  style={{
                            height:140          
                        }} 
                        source={{uri: item.imagePath}} />
                        <Text style={avatarStyle.itemName}>{item.name}</Text>
                    </View>
                )}
            />
            
            
        )
    }
}
const mapStateToProps = state => ({ 
    combatStatusData: state.CombatReducer.combatState
})  
  

export default connect(mapStateToProps,null)(CombatMonsters);

const avatarStyle = StyleSheet.create({
    gridView: {
        marginTop: 20,
        flex: 1,
    },
    itemContainer: {
        justifyContent: 'flex-end',
        borderRadius: 5,
        padding: 10,
        height: 150,
    },
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
    },
    itemName: {
        fontSize: 16,
        color: '#fff',
        fontWeight: '600',
        borderColor: 'black'
    }

})