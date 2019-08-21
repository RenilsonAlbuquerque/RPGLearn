import React, {Component} from 'react';

import { View,TouchableOpacity,Image,StyleSheet  } from 'react-native';

import { connect } from 'react-redux';
import { bindActionCreators } from "redux";

import { getStories,setCurrentStory} from '../actions/StoryAction'
import { Text} from 'native-base';
import { FlatList } from 'react-native-gesture-handler';
import NavigationService from '../service/NavigationService';
import { USER_STORAGE } from '../reducers/UserReducer';
import AsyncStorage from '@react-native-community/async-storage';



class StoryPage extends Component{

    static navigationOptions = {
        title: 'Histórias',
    };
    componentWillMount() { 
        this.props.getStories({page:1, size:10});
        AsyncStorage.getItem(USER_STORAGE).then(
          value => {
            if(value){
             console.log(JSON.parse(value))
            
             
            }else{
                console.log(value)
               
            }
          }
        );
    };
    loadStories = async () =>{
      if(this.props.storyData.last === false){
        await this.props.getStories({page:this.props.storyData.currentPageNumber +1,size:10})
      }
      
    }
   
    // isCloseToBottom({ layoutMeasurement, contentOffset, contentSize }) {   return layoutMeasurement.height + contentOffset.y 
    //     >= contentSize.height - 50; }

    renderItem = ({ item, idenx }) => (
      <TouchableOpacity key={idenx} onPress={() =>  {this.props.setCurrentStory(item), NavigationService.navigate('Combat')}}>
        
       <View style={styles.card}>
          <Image style={styles.cardImage} source={{uri: item.folderImage}}/>
          <View style={styles.cardContent}>
              <View>
                  <Text style={styles.title}>{item.name}</Text>
              </View>
          </View>
       </View>
      </TouchableOpacity>
      
    );   
    render() {
        const {
            storyData
        } = this.props;

        return (
            <FlatList
                data={storyData.elements}
                extraData={this.state}
                ItemSeparatorComponent={() => {
                    return (
                      <View style={styles.separator}/>
                    )
                  }}
                keyExtractor={item => item.name}
                renderItem={this.renderItem}
                onEndReached={this.loadStories}
                onEndReachedThreshold={0.1}
                
            />
             
        )
      }
      
}
const mapStateToProps = state => ({ 
    storyData: state.StoryReducer.stories
})


const mapDispatchToProps = dispatch => bindActionCreators({
    getStories,
    setCurrentStory
}, dispatch);

export default connect(mapStateToProps,mapDispatchToProps)(StoryPage)
const styles = StyleSheet.create({
    container:{
      flex:1,
      marginTop:20,
    },
    list: {
      backgroundColor:"#E6E6E6",
    },
    separator: {
      marginTop: 1,
    },
    /******** card **************/
    card:{
      margin: 0,
      borderRadius: 2,
      borderWidth: 1,
      borderColor: "#DCDCDC",
      backgroundColor: "#DCDCDC",
    },
    
    cardContent: {
      paddingVertical: 12.5,
      paddingHorizontal: 16,
      //overlay efect
      flex: 1,
      height: 200,
      width: null,
      position: 'absolute',
      zIndex: 100,
      left: 0,
      right: 0,
      backgroundColor: 'transparent'
    },
    cardImage:{
      flex: 1,
      height: 150,
      width: null,
    },
    /******** card components **************/
    title:{
      fontSize:22,
      color: "#ffffff",
      marginTop: 10,
      fontWeight:'bold'
    },
    
  });