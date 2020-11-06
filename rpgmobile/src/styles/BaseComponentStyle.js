import {StyleSheet, View,ScrollView,Image, Animated} from 'react-native';
const BaseComponentStyle = StyleSheet.create({
    fab: {
        zIndex:9999,
        color: '#ffffff',
        backgroundColor:'#000000',
        borderRadius:100,
        position:'absolute',
        height:50, 
        width: 50
    },
    container:{
        borderRadius:100,
        position:'absolute',
        zIndex:99
    },
    tokenImage:{height:26, width: 26, borderRadius:100}

});

export default BaseComponentStyle;