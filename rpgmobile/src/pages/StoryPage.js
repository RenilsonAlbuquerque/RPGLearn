import React, {Component} from 'react';

import { Text } from 'native-base';

import { connect } from 'react-redux';
import { bindActionCreators } from "redux";

import { getStories} from '../actions/StoryAction'

class StoryPage extends Component{

    render() {
        return (
            <Text>Tela de História</Text>
        )
    }

}
function mapStateToProps(state){
    return state.StoryReducer;
}
  
const mapDispatchToProps = dispatch => bindActionCreators({
    getStories
}, dispatch);

export default connect(mapStateToProps,mapDispatchToProps)(StoryPage)