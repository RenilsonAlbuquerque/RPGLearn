import React, {Component} from 'react';
import { Text } from 'native-base';
import { connect } from 'react-redux';
import { View,StyleSheet } from 'react-native'


class StatusSheet extends Component {

    constructor(props){
        super(props);
    }
    render() {
       
        return (
            <View style={statusStyle.container}>
                <View style={{flex: 1, flexDirection: 'row', flexWrap: 'wrap',justifyContent: 'space-between',}}>
                    <View style={statusStyle.mainStats}>
                        <Text>Armor class</Text> 
                        <Text>20</Text>
                    </View>
                    <View style={statusStyle.mainStats}>
                        <Text>Vida</Text> 
                        <Text>56</Text>
                    </View>
                    <View style={statusStyle.mainStats}>
                        <Text>Deslocamento</Text> 
                        <Text>6</Text>
                    </View>
                </View>
            </View>
            
        )
    }
}
const mapStateToProps = state => ({ 
    sheetData: state.CharacterReducer.currentCharacter
})  
  

export default connect(mapStateToProps,null)(StatusSheet);
const statusStyle = StyleSheet.create({
    container: {
      flex:1,
      alignContent:'center',
      justifyContent:'center',
      //alignItems: 'center',
    },
    mainStats:{
        alignContent:'center',
        alignItems:'center',
    },
    customTextField:{
      color: 'white'
    },
    logoImage:{
      alignContent:'center',
      justifyContent:'center',
      height: 240
    }
  
  
  })