import React, {Component} from 'react';
import { StyleSheet, Image, View,Text, Platform, TouchableHighlight} from 'react-native';
import changeColor from '../../helpers/Combat-helper';
import CustomAxios from '../../service/AxiosConfig';
import PlayerActionsMenu from './PlayerActionsMenu';
import { Button, Icon } from 'native-base';
import  BaseComponentStyle  from '../../styles/BaseComponentStyle';
import { setWalkPoperties} from '../../actions/CombatAction';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';




const TOKEN_DEFAULT_SIZE =  30;

class CharacterCombatToken extends Component{

    constructor(props){
        super(props);
        this.state = {
            tokenSource : "",
            menuOpen: false,
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
    calculateMenuPosition(){
        //40 is the half of menu square dimension
        //15 is the half of token size
        return {
            marginTop: this.props.creature.position.y - 55 + 15,
            marginLeft: this.props.creature.position.x - 55 + 13
        }
    }
    handlePressWalkButton(){
        this.props.setWalkPoperties({
            x:this.props.creature.position.x,
            y:this.props.creature.position.y,
            visible: true
        });
        this.setState({menuOpen: !this.state.menuOpen})
    }
    render(){
        let TOKEN_DIMENSION = TOKEN_DEFAULT_SIZE * this.props.creature.size;

        return(
            <View style={{height:100,width:100, position:'absolute'}}>
                {/* <PlayerActionsMenu style={{marginTop:120,position:'absolute'}} creature={this.props.creature} position={this.calculateMenuPosition()}></PlayerActionsMenu> */}
                {(this.state.menuOpen) ? 
                (<View style={[tokenStyle.menuContainer,this.calculateMenuPosition()]}>
                        
                    <Button style={BaseComponentStyle.fab} onPress={() => this.handlePressWalkButton()}>
                        <Icon size={100} name={ Platform.OS === 'ios' ? (focused ? 'ios-person' : 'ios-home-outline') : 'md-walk' }  />
                    </Button>
                    <Button style={[BaseComponentStyle.fab,{left:60}]}>
                        <Icon size={100} name={ Platform.OS === 'ios' ? (focused ? 'ios-person' : 'ios-home-outline') : 'md-fastforward' }  />
                    </Button>
                </View>) : (<></>)
                }
                <TouchableHighlight onPress={() => this.setState({menuOpen: !this.state.menuOpen})}
                    style={[tokenStyle.container,
                    {height: TOKEN_DIMENSION,
                    width: TOKEN_DIMENSION,
                    marginTop: this.props.creature.position.y ,
                    marginLeft: this.props.creature.position.x,
                    borderColor: changeColor(this.props.creature.lifePercent),
                    backgroundColor: changeColor(this.props.creature.lifePercent)}]}>
                    <Image style={{...tokenStyle.tokenImage}} 
                        source={{uri: this.state.tokenSource}}/> 
                                 
                </TouchableHighlight>
                
            </View>
        )
    }
}

const mapDispatchToProps = dispatch => bindActionCreators({
    setWalkPoperties
}, dispatch);
export default connect(null,mapDispatchToProps)(CharacterCombatToken);

const tokenStyle = StyleSheet.create({
    menuContainer:{
        height:110, 
        width:110,
        position:'absolute',
        zIndex:88
    },
    container:{
        borderRadius:100,
        position:'absolute',
        zIndex:99
    },
    tokenImage:{height:26, width: 26, borderRadius:100}

});
