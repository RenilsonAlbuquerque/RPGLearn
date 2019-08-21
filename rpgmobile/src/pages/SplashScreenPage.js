import React, {Component} from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import AsyncStorage from "@react-native-community/async-storage";
import { USER_STORAGE } from "../reducers/UserReducer";
import {setLoggedUser} from '../actions/UserAction';
import NavigationService from "../service/NavigationService";
import { View, StyleSheet} from 'react-native';
import { ActivityIndicator } from "react-native-paper";
import Colors from '../styles/ColorsStyle'


class SplashScreenPage extends Component {
   
    static navigationOptions = {
        header: null,
      };
    componentWillMount() { 
       
        this.retrieveUser()
      
    };
    retrieveUser = () => {
        AsyncStorage.getAllKeys().then(
            value => {console.log(value)}
        )
        //function to get the value from AsyncStorage
        AsyncStorage.getItem(USER_STORAGE).then(
          value => {
            if(value){
                this.props.setLoggedUser(JSON.parse(value));
                NavigationService.navigate('StoryPage')
            }else{
                NavigationService.navigate('Login')
            }
          }
        );
      };
    render(){
        return (
            <View style={splashStyle.container}>
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
    }
});
