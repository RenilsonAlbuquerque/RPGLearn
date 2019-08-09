import React from 'react';
import { createStackNavigator, createAppContainer } from "react-navigation";
import LoginPage from '../pages/LoginPage';
import StoryPage from '../pages/StoryPage';
import CombatBottomNavigator from './CombatBottomNavigator';
import CombatPage from '../pages/CombatPage';



const ShakalStackNavigator = createStackNavigator({
    Login:{screen: LoginPage, navigatorOptions: navigatorOptions},
    StoryPage: {screen: StoryPage, navigatorOptions: navigatorOptions},
    Combat: {screen: CombatPage,navigatorOptions: navigatorOptions}
});

function navigatorOptions(){
  return {
    title: 'Aedes War',
    
    headerStyle: {
      backgroundColor: '#D32F2F',
    },
    headerTintColor: '#fff',
    headerTitleStyle: {
      fontWeight: 'bold',
    }
  }
}

export default createAppContainer(ShakalStackNavigator);