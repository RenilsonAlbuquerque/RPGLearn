import React, {Component} from 'react';
//import { Text } from 'native-base';
import { connect } from 'react-redux';
import { View, Image } from 'react-native'
import { Container, Header, Content, Card, CardItem, Thumbnail, Text, Button, Icon, Left, Body, Right } from 'native-base';


class SheetDetail extends Component {

    constructor(props){
        super(props);
        console.log(props.sheetData.imagePath)
    }
    render() {
       
        return (
            // <View>
            //     <Text>{this.props.sheetData.name}</Text>
            //     <Image source={{uri: this.props.sheetData.imagePath}} />
            //     <Text>{this.props.sheetData.background}</Text>
            // </View>
            <Card transparent>
            <CardItem>
              <Left>
                
                <Body>
                  <Text>{this.props.sheetData.name}</Text>
                  <Text note>GeekyAnts</Text>
                </Body>
              </Left>
            </CardItem>
            <CardItem cardBody>
              <Image source={{uri: this.props.sheetData.imagePath}} style={{height: 200, width: null, flex: 1}}/>
            </CardItem>
            <CardItem >
                
              <Left>
                <View >
                  <Text>Altura</Text>
                  <Text>{this.props.sheetData.height}</Text>
                </View>
              </Left>
              <Right>
              <View style={{flex: 1, flexDirection: 'column'}}>
                  <Text>Idade</Text>
                  <Text>{this.props.sheetData.age}</Text>
                </View>
              </Right>
            </CardItem>
            <CardItem>
                <Text>
                    {this.props.sheetData.background}
                </Text>
              {/* <Left>
                <Button transparent>
                  <Icon active name="thumbs-up" />
                  <Text>12 Likes</Text>
                </Button>
              </Left>
              <Body>
                <Button transparent>
                  <Icon active name="chatbubbles" />
                  <Text>4 Comments</Text>
                </Button>
              </Body>
              <Right>
                <Text>11h ago</Text>
              </Right> */}
            </CardItem>
          </Card>
            
        )
    }
}
const mapStateToProps = state => ({ 
    sheetData: state.CharacterReducer.currentCharacter
})  
  

export default connect(mapStateToProps,null)(SheetDetail);