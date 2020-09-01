import React, {Component} from 'react';
import { Image ,View, StyleSheet, } from 'react-native';


import { Container,  Content, Form, Item, Input, Label  ,Text,Button } from 'native-base';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import { loginAction } from '../actions/UserAction'
import Colors from '../styles/ColorsStyle';


class LoginPage extends Component{

    static navigationOptions = {
      header: null,
    };
    constructor(props){
        super(props)
        this.state ={
            username: '',
            password: ''
        }
      
    }
    
    
    render() {
        const {
          errorMessage
        } = this.props;

        return (
          <Container style={loginStyle.container}>
          <Content padder >
         
            <Form>
              <Container full style={loginStyle.imageContainer}>
                <Image style={loginStyle.logoImage} source = {require('../resources/img/redshakal.png')}/>
              </Container>
              <View style={{width: 20, height: 10}} />
              <Item rounded>
                <Input placeholder="Nome" style={loginStyle.customTextField} value={this.props.username} onChangeText={(text) => this.setState({username: text}) }/>
              </Item>
              <View style={{width: 20, height: 10}} />
              <Item rounded >
                <Input placeholder="Senha" style={loginStyle.customTextField} value={this.state.password} secureTextEntry={true} onChangeText={(text) => this.setState({password: text}) }/>
              </Item>
            </Form>
            <View style={{width: 20, height: 40}} />
            <Button  full rounded style={loginStyle.customButton} onPress={() => this.props.loginAction(this.state.username,this.state.password)}>
                <Text>Entrar</Text>
            </Button>
            <Button  full rounded style={loginStyle.customButton}>
                <Text>Trocar endereço</Text>
            </Button>
                  
            <View style={{width: 20, height: 30}} />
            <Text style={{textAlign:'center',color:'red'}}>{errorMessage}</Text>
          </Content>
        </Container>
      );
      }
}

const mapStateToProps = state => ({ 
  errorMessage: state.UserReducer.error
})  

const mapDispatchToProps = dispatch => bindActionCreators({
  loginAction
}, dispatch);

export default connect(mapStateToProps,mapDispatchToProps)(LoginPage)

const loginStyle = StyleSheet.create({
  container: {
    flex:1,
    alignContent:'center',
    justifyContent:'center',
    //alignItems: 'center',
    backgroundColor: Colors.PRIMARY_COLOR
  },
  customButton:{
    backgroundColor: Colors.LIGHT_PRIMARY_COLOR
  },
  customTextField:{
    color: 'white'
  },
  logoImage:{
    alignContent:'center',
    justifyContent:'center',
    height: 240
  },
  imageContainer:{
    alignItems:'center', 
    height:240,
    backgroundColor: Colors.PRIMARY_COLOR
  }


})


