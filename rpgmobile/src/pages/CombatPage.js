import React, {Component} from 'react';
import { Text} from 'native-base';
import { StyleSheet, Image, View} from 'react-native';

class CombatPage extends Component {
    constructor(props){
        super(props);
        
    }
    render() {
        var monsters = [
            {
                id: 1,
                name: 'Strahd',
                lifePoints: 200,
                totalLifePoints: 20,
                imagePath: 'https://pm1.narvii.com/6662/7f403f5746ab0e90e96b8bd93250cd3f9c6faa4b_hq.jpg',
                color: 'red'
            },
            {
                id: 2,
                name: 'Tiamat',
                lifePoints: 200,
                totalLifePoints: 20,
                imagePath: 'https://cdn.inprnt.com/thumbs/9a/db/9adb133633a82e480b5cc72a16d9c42a.jpg?response-cache-control=max-age=2628000',
                color:'blue'
            }
        ]
        return (
            <View style={{
                flex: 1,
                flexDirection: 'row',
                justifyContent: 'center',
                alignItems: 'stretch',
              }}>
                 {monsters.map((monster, index) => 
                    <Image key={index} style={{
                        height:150,
                        width: 150,
                        borderRadius: 100,
                        borderWidth: 5,
                        borderColor: monster.color
                        
                    }} 
                            source={{uri: monster.imagePath}} />
                 )}
                 
            </View>
           
           
            
        )
    }
}
export default CombatPage;

const avatarStyle = StyleSheet.create({
    imageStyle:{
        height:150,
        width: 150,
        borderRadius: 100,
        borderWidth: 5,
        borderColor: 'red'
    }
})