import React from 'react';
import { createStackNavigator, createAppContainer, createSwitchNavigator } from "react-navigation";
import LoginPage from '../pages/LoginPage';
import StoryPage from '../pages/StoryPage';
import CombatPage from '../pages/CombatPage';
import Colors from '../styles/ColorsStyle';
import SplashScreenPage from '../pages/SplashScreenPage';
import {Text} from 'react-native'
import NavigationService from "../service/NavigationService";
import {removeUser} from '../store/AsyncStorageService'
import { Icon } from 'react-native-elements';



const ShakalStackNavigator = createStackNavigator({
    StoryPage: {screen: StoryPage},
    Combat: {screen: CombatPage}
},{
  initialRouteName:'StoryPage',
  defaultNavigationOptions: {
    headerLeft: 
    <Icon name='menu' size={24} color='white'
      onPress={()=> logout()}/>,
    headerStyle: {
      backgroundColor: Colors.DARK_PRIMARY_COLOR,
    },
    headerTintColor: '#fff',
    headerTitleStyle: {
      fontWeight: 'bold',
    },
  },
});
const ShakalSwitchNavigator = createSwitchNavigator({
  Splash:{screen:SplashScreenPage},
  Login:{screen: LoginPage},
  Main: {screen: ShakalStackNavigator}
})
function logout(){
  removeUser()
  NavigationService.navigate('Login')
}
export default createAppContainer(ShakalSwitchNavigator);