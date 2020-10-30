import React, {Component} from 'react';
import { StyleSheet, Image, View,Text} from 'react-native';
import changeColor from '../../helpers/Combat-helper';
import CustomAxios from '../../service/AxiosConfig';
import PlayerActionsMenu from './PlayerActionsMenu';
import { PinchGestureHandler } from "react-native-gesture-handler";



export default class CharacterCombatToken extends Component{

    constructor(props){
        super(props);
        this.state = {
            tokenSource : ""
        }
        this.changeToken();
    }
    changeToken() {
        CustomAxios
        .get(`/creature/token/${this.props.creature.id}`).then(
            result => {
                this.setState({
                    tokenSource: result.data.picture
                });
            }
        )
        
    }
    render(){
        return(
        <View style={[tokenStyle.container,
            {marginTop: this.props.creature.position.y ,
            marginLeft: this.props.creature.position.x,
            borderColor: changeColor(this.props.creature.lifePercent),
            backgroundColor: changeColor(this.props.creature.lifePercent) }]}>
            <Image style={{...tokenStyle.tokenImage}} 
                source={{uri: this.state.tokenSource}} /> 
            <PlayerActionsMenu></PlayerActionsMenu>         
        </View>
        )
    }
}

const tokenStyle = StyleSheet.create({
    container:{
        height:30, 
        width: 30,
        borderRadius:100,
        position:'absolute',
    },
    tokenImage:{height:26, width: 26, borderRadius:100}

});
