import React from 'react';
import { createStackNavigator, createAppContainer } from "react-navigation";
import LoginPage from '../pages/LoginPage';



const ShakalStackNavigator = createStackNavigator({
    Login:{screen: LoginPage, navigatorOptions: navigatorOptions}
});

function navigatorOptions(){
  header: null
}

export default createAppContainer(ShakalStackNavigator);