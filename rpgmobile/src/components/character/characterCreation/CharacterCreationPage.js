import React, {Component, useState} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import {Form,Icon,Item, Picker } from 'native-base';
import { getCharacterCreationMetadata } from '../../../actions/CharacterAction';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

// const CharacterCreationPage = (props) => {

//     const {
//         characterCreationMetadata,
//         getCharacterCreationMetadata
//     } = props;
//     props.getCharacterCreationMetadata();
//     console.log(props.characterCreationMetadata)
//     const [character, setCharacter] = useState(0);

//     let onValueChange2 = (value) => {
//         setCharacter({
//           selected2: value
//         });
//     }
//     return(
//         <View>
//             <Text style={styles.pageTitle}>Cadastre o seu personagem na história</Text>
//             <Form>
//                 <Item picker>
//                     <Picker
//                         mode="dropdown"
//                         iosIcon={<Icon name="arrow-down" />}
//                         style={{ width: undefined }}
//                         placeholder="Select your SIM"
//                         placeholderStyle={{ color: "#bfc6ea" }}
//                         placeholderIconColor="#007aff"
//                         selectedValue={character.selected2}
//                         onValueChange={onValueChange2.bind(this)}
//                     >
//                     {props.characterCreationMetadata.races.map((item, index) =>(
//                         <Picker.Item label={item.name} value={item.id} />    
//                     ))}    
                    
//                     </Picker>
//             </Item>
//             </Form>
//         </View>
//     )
// }
class CharacterCreationPage extends Component {

    constructor(props){
        super(props);
        this.props.getCharacterCreationMetadata();
        this.state = {
            raca: undefined,
            subRace: undefined
          };
    }
    
    onRaceChange(value){
        this.setState({
            raca: value
        });
    }
    onSubRaceChange(value){
        this.setState({
            subRace: value
        });
    }
    render(){
        return(
            <View>
                <Text style={styles.pageTitle}>Cadastre o seu personagem na história</Text>
                <Form>
                    <Text>Raça: </Text>
                    <Item picker>
                        <Picker
                            mode="dropdown"
                            iosIcon={<Icon name="arrow-down" />}
                            style={{ width: undefined }}
                            placeholder="Selecione a raça"
                            placeholderStyle={{ color: "#bfc6ea" }}
                            placeholderIconColor="#007aff"
                            selectedValue={this.state.raca}
                            onValueChange={this.onRaceChange.bind(this)}
                        >
                        {(this.props.characterCreationMetadata.races) ?
                            this.props.characterCreationMetadata.races.map((item, index) =>(
                                <Picker.Item label={item.name} value={item.id} key={index} />    
                            )) : <Picker.Item label="Selecione..." value="key0" /> 
                        }
                        </Picker>
                    </Item>
                    {/* {(this.props.characterCreationMetadata.races && this.props.characterCreationMetadata.races[0].subRaces) ?
                        (<View>
                            <Text>Sub-Raça: </Text>
                            <Item picker>
                                <Picker
                                    mode="dropdown"
                                    iosIcon={<Icon name="arrow-down" />}
                                    style={{ width: undefined }}
                                    placeholder="Selecione a raça"
                                    placeholderStyle={{ color: "#bfc6ea" }}
                                    placeholderIconColor="#007aff"
                                    selectedValue={this.state.subRace}
                                    onValueChange={this.onSubRaceChange.bind(this)}
                                >
                                {(this.props.characterCreationMetadata.races) ?
                                    this.props.characterCreationMetadata.races[0].subRaces.map((item, index) =>(
                                        <Picker.Item label={item.name} value={item.id} key={index}/>    
                                    )) : <Picker.Item label="Selecione..." value="key0" /> 
                                }
                                </Picker>
                            </Item>
                        </View> ) : 
                        (<></>)
                    } */}
                </Form>
            </View>
        )
    }
    
}
const mapStateToProps = state => ({ 
    characterCreationMetadata: state.CharacterReducer.characterCreationMetadata
})  
  
const mapDispatchToProps = dispatch => bindActionCreators({
    getCharacterCreationMetadata
}, dispatch);
export default connect(mapStateToProps,mapDispatchToProps)(CharacterCreationPage);
const styles = StyleSheet.create({

    pageTitle: {
        textAlignVertical: 'center',
        textAlign:'center',
        fontWeight:'bold',
        fontSize:20
      },
      panel: {
        zIndex:9999,
        
      }
});