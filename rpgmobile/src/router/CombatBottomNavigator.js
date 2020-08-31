import React, {Component} from 'react';
import { Platform } from 'react-native';
import { createMaterialBottomTabNavigator } from 'react-navigation-material-bottom-tabs'
import CombatMonsters from '../components/combat/CombatMonsters';
import { Icon } from 'native-base';
import { createAppContainer } from 'react-navigation';
import CombatAllies from '../components/combat/CombatAllies';
import CombatArea from '../components/combat/CombatArea';
import MonsterSheetTopNavigator from '../components/character/CharacterSheet'
import Colors from '../styles/ColorsStyle';

const CombatBottomNavigator = createMaterialBottomTabNavigator({
    Area: {screen: CombatArea,
    navigationOptions: {
        tabBarLabel: 'Área',
        tabBarIcon: ({ tintColor, focused }) => (
          <Icon size={30} name={ Platform.OS === 'ios' ? (focused ? 'ios-people' : 'ios-home-outline') : 'md-map' } style={{ color: tintColor }} />
        )
      }
    },
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
    },
    CharacterSheet: {screen: MonsterSheetTopNavigator,
      navigationOptions: {
          tabBarLabel: 'Ficha',
          tabBarIcon: ({ tintColor, focused }) => (
            <Icon size={30} name={ Platform.OS === 'ios' ? (focused ? 'ios-person' : 'ios-home-outline') : 'md-person' } style={{ color: tintColor }} />
          )
        }
    }

},
{
  initialRouteName: 'Monsters',
  //activeTintColor: '#f0edf6',
  //inactiveTintColor: '#3e2465',
  barStyle: { backgroundColor: Colors.DARK_PRIMARY_COLOR }
})
export default createAppContainer(CombatBottomNavigator);