import React, {Component} from 'react';
import { Platform } from 'react-native';
import { createMaterialBottomTabNavigator } from 'react-navigation-material-bottom-tabs'
import CombatMonsters from '../components/story/CombatMonsters';
import { Icon } from 'native-base';
import { createAppContainer } from 'react-navigation';
import CombatAllies from '../components/combat/CombatAllies';

const CombatBottomNavigator = createMaterialBottomTabNavigator({
    Monsters: {screen: CombatMonsters,
        navigationOptions: {
            tabBarLabel: 'Inimigos',
            tabBarIcon: ({ tintColor, focused }) => (
              <Icon size={30} name={ Platform.OS === 'ios' ? (focused ? 'ios-people' : 'ios-home-outline') : 'md-people' } style={{ color: tintColor }} />
            )
          }
    },
    Allies: {screen: CombatAllies,
      navigationOptions: {
          tabBarLabel: 'Aliados',
          tabBarIcon: ({ tintColor, focused }) => (
            <Icon size={30} name={ Platform.OS === 'ios' ? (focused ? 'ios-contacts' : 'ios-home-outline') : 'md-contacts' } style={{ color: tintColor }} />
          )
        }
    }

},
{
  initialRouteName: 'Monsters',
  //activeTintColor: '#f0edf6',
  //inactiveTintColor: '#3e2465',
  barStyle: { backgroundColor: '#212121' }
})
export default createAppContainer(CombatBottomNavigator);