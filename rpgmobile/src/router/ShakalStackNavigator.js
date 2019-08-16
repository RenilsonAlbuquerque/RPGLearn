import React from 'react';
import { createStackNavigator, createAppContainer } from "react-navigation";
import LoginPage from '../pages/LoginPage';
import StoryPage from '../pages/StoryPage';
import CombatPage from '../pages/CombatPage';
import Colors from '../styles/ColorsStyle';
import SplashScreenPage from '../pages/SplashScreenPage';


const ShakalStackNavigator = createStackNavigator({
    Splash:{screen:SplashScreenPage},
    Login:{screen: LoginPage},
    StoryPage: {screen: StoryPage},
    Combat: {screen: CombatPage}
},{
  initialRouteName:'Splash',
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