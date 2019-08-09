import React from 'react';
import { createStackNavigator, createAppContainer } from "react-navigation";
import LoginPage from '../pages/LoginPage';
import StoryPage from '../pages/StoryPage';
import CombatBottomNavigator from './CombatBottomNavigator';



const ShakalStackNavigator = createStackNavigator({
    Login:{screen: LoginPage, navigatorOptions: navigatorOptions},
    StoryPage: {screen: StoryPage, navigatorOptions: navigatorOptions},
    Combat: {screen: CombatBottomNavigator,navigatorOptions: navigatorOptions}
});

function navigatorOptions(){
  header: null
}

export default createAppContainer(ShakalStackNavigator);