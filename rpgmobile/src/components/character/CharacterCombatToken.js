import React, {Component} from 'react';
import { StyleSheet, Image, View,Text} from 'react-native';
import changeColor from '../../helpers/Combat-helper';

export default function CharacterCombatToken(props){
    return(
        <View style={tokenStyle.container}>
            <Image style={tokenStyle.tokenImage} 
                source={{uri: 'https://www.vippng.com/png/detail/83-831021_d-d-token-png-transparent-background-drow-token.png'}} />     
        </View>
    )
}

const tokenStyle = StyleSheet.create({
    container:{
        height:50, 
        width: 50,
        borderRadius:100,
        position:'absolute',
        marginTop:33
    },
    tokenImage:{height:50, width: 50, borderRadius:100}

})