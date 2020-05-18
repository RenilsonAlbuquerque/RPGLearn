import React, {Component} from 'react';
import { Text } from 'native-base';
import { connect } from 'react-redux';


class SpellSheet extends Component {

    constructor(props){
        super(props);
    }
    render() {
       
        return (
            
            <Text>As magias funfaram funfaram</Text>
        )
    }
}
const mapStateToProps = state => ({ 
    sheetData: state.CharacterReducer.currentCharacter
})  
  

export default connect(mapStateToProps,null)(SpellSheet);