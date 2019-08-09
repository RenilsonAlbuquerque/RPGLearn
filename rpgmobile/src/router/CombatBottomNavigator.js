import React, {Component} from 'react';
import { Platform } from 'react-native';
import { createMaterialBottomTabNavigator } from 'react-navigation-material-bottom-tabs'
import CombatMonsters from '../components/story/CombatMonsters';
import { Icon } from 'native-base';

const CombatBottomNavigator = createMaterialBottomTabNavigator({
    Monsters: {screen: CombatMonsters,
        navigationOptions: {
            tabBarLabel: 'Inimigos',
            tabBarIcon: ({ tintColor, focused }) => (
              <Icon size={30} name={ Platform.OS === 'ios' ? (focused ? 'ios-people' : 'ios-home-outline') : 'md-people' } style={{ color: tintColor }} />
            )
          }
    }

})
export default CombatBottomNavigator;