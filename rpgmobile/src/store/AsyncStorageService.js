import AsyncStorage from "@react-native-community/async-storage";
import { USER_STORAGE } from "../reducers/UserReducer";
/*
export default retrieveUser = () => {
    //function to get the value from AsyncStorage
    AsyncStorage.getItem(USER_STORAGE).then(
      value => {
        if(value){
         console.log(JSON.parse(value))
         this.props.setLoggedUser(JSON.parse(value));
         NavigationService.navigate('StoryPage')
        }else{
            console.log(value)
            NavigationService.navigate('Login')
        }
      }
    );
  };
export default saveUser = () => {
    try {
        await AsyncStorage.setItem(USER_STORAGE, action.payload);
    } catch (error) {
        console.log(error)
    }
};
*/