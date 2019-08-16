import React from 'react';
import { createStackNavigator, createAppContainer } from "react-navigation";
import LoginPage from '../pages/LoginPage';
import StoryPage from '../pages/StoryPage';
import CombatBottomNavigator from './CombatBottomNavigator';
import CombatPage from '../pages/CombatPage';
import Colors from '../styles/ColorsStyle';


const ShakalStackNavigator = createStackNavigator({
    Login:{screen: LoginPage},
    StoryPage: {screen: StoryPage},
    Combat: {screen: CombatPage}
},{
 
  defaultNavigationOptions: {
    headerStyle: {
      backgroundColor: Colors.DARK_PRIMARY_COLOR,
    },
    headerTintColor: '#fff',
    headerTitleStyle: {
      fontWeight: 'bold',
    },
  },
});


export default createAppContainer(ShakalStackNavigator);