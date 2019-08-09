import React from 'react';
import { createStackNavigator, createAppContainer } from "react-navigation";
import LoginPage from '../pages/LoginPage';
import StoryPage from '../pages/StoryPage';



const ShakalStackNavigator = createStackNavigator({
    Login:{screen: LoginPage, navigatorOptions: navigatorOptions},
    StoryPage: {screen: StoryPage, navigatorOptions: navigatorOptions}
});

function navigatorOptions(){
  header: null
}

export default createAppContainer(ShakalStackNavigator);