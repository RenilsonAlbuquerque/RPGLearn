import React, {Component} from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import AsyncStorage from "@react-native-community/async-storage";
import { USER_STORAGE } from "../reducers/UserReducer";
import {setLoggedUser} from '../actions/UserAction';
import NavigationService from "../service/NavigationService";
import { View, StyleSheet,Image} from 'react-native';
import { ActivityIndicator } from "react-native-paper";
import Colors from '../styles/ColorsStyle'
import { StackActions, NavigationActions } from 'react-navigation';



class SplashScreenPage extends Component {
   
    static navigationOptions = {
        header: null,
    };
    constructor(props) {
        super(props);
        this.retrieveUser();
    }
    componentWillMount() { 
       
        //this.retrieveUser()
      
    };
    retrieveUser = () => {
      
        //function to get the value from AsyncStorage
        AsyncStorage.getItem(USER_STORAGE).then(
          value => {
            setTimeout(function(){
            }, 3000);
            if(value){
                this.props.setLoggedUser(JSON.parse(value));
                NavigationService.navigate('Main')
            }else{
                NavigationService.navigate('Login')
            }
          }
        );
      };
    render(){
        return (
            <View style={splashStyle.container}>
                <Image style={splashStyle.logoImage} source = {require('../resources/img/redshakal.png')}/>
                <ActivityIndicator size="large" color="white"></ActivityIndicator>
            </View>
        );
    }

}
const mapStateToProps = state => ({ 
    errorMessage: state.UserReducer.error
})  
  
const mapDispatchToProps = dispatch => bindActionCreators({
    setLoggedUser
}, dispatch);
  
export default connect(mapStateToProps,mapDispatchToProps)(SplashScreenPage)
const splashStyle = StyleSheet.create({
    container: {
      flex:1,
      alignItems: 'center',
      justifyContent:'center',
      backgroundColor: Colors.PRIMARY_COLOR,
      color: Colors.PRIMARY_COLOR
    },
    logoImage:{
        alignContent:'center',
        justifyContent:'center',
        height: 240
      }
});
