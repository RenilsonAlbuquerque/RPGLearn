import React, {Component} from 'react';

import { View,ScrollView,TouchableOpacity,Image  } from 'react-native';

import { connect } from 'react-redux';
import { bindActionCreators } from "redux";

import { getStories} from '../actions/StoryAction'
import { Text,Card, CardItem, Right} from 'native-base';
import { FlatList } from 'react-native-gesture-handler';

class StoryPage extends Component{

    componentWillMount() { this.props.getStories({page:1, size:10}); };

    isCloseToBottom({ layoutMeasurement, contentOffset, contentSize }) {   return layoutMeasurement.height + contentOffset.y 
        >= contentSize.height - 50; }
    render() {
        const {
            storyData
        } = this.props;

        return (
            <FlatList
                data={storyData.elements}
                extraData={this.state}
                keyExtractor={item => item.name}
                renderItem={({ item }) => (
                    <Card key={item.id}
                       featuredTitle={item.name}
                       image={{ uri: item.folderImage }}
                       >
                        <CardItem cardBody>
                        
                            <Image source={{uri: item.folderImage}} style={{height: 200, width: null, flex: 1}}/>
                        </CardItem>
                        <CardItem>
                            <Right>
                                <Text>{item.name}</Text>
                            </Right>
                        </CardItem>
                     </Card>
                  )}
            />
             
        )
      }
      
}
const mapStateToProps = state => ({ 
    storyData: state.StoryReducer.stories
})


const mapDispatchToProps = dispatch => bindActionCreators({
    getStories
}, dispatch);

export default connect(mapStateToProps,mapDispatchToProps)(StoryPage)