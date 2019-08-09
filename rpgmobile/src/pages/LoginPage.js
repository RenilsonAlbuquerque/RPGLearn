import React, {Component} from 'react';
import { Image ,View, StyleSheet,Button } from 'react-native';


import { Container,  Content, Form, Item, Input, Label  ,Text } from 'native-base';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import { loginAction } from '../actions/UserAction'
import NavigationService from '../service/NavigationService';


class LoginPage extends Component{

    constructor(props){
        super(props)
        this.state ={
            username: '',
            password: ''
        }
      
    }
    
    
    render() {
        return (
          <Container >
          <Content padder >
            <Form>
              <Item floatingLabel>
                <Label>Email</Label>
                <Input value={this.props.username} onChangeText={(text) => this.setState({username: text}) }/>
              </Item>
              <Item floatingLabel >
                <Label>Senha</Label>
                <Input value={this.state.password} secureTextEntry={true} onChangeText={(text) => this.setState({password: text}) }/>
              </Item>
            </Form>
            <View style={{width: 20, height: 40}} />
            <Button onPress={() => this.props.loginAction('asdasd','asdasdasd')} title="Login"/>
                  
            <View style={{width: 20, height: 30}} />
           
          </Content>
        </Container>
      );
      }
}
function mapStateToProps(state){
    return state.UserReducer;
}
  
const mapDispatchToProps = dispatch => bindActionCreators({
  loginAction
}, dispatch);

export default connect(mapStateToProps,mapDispatchToProps)(LoginPage)