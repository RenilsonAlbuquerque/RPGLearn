import axios from "axios";
import NavigationSevice from '../service/NavigationService'
import CustomAxios from "../service/AxiosConfig";



export const USER_FETCHED = 'USER_FETCHED';
export const LOGIN_ERROR = 'LOGIN_ERROR';
//const USER_API =process.env.REACT_APP_URL_API + process.env.REACT_APP_PATH_PRESTADORA_API;
const USER_API = "/login"




export function loginAction(nome, senha){
   var user = { username: nome,
                password: senha}

    return (dispatch) => {
        return CustomAxios
            .post(`${USER_API}`,user)
            .then(result => {
                console.log(result.data)
                dispatch(
                    {
                        type: USER_FETCHED,
                        payload: result.data
                    },
                    navigateToMenu()
                )} 
            )
            
            .catch(error => 
                dispatch(
                    {
                        type:LOGIN_ERROR,
                        payload: (error.response.data.detail) ? error.response.data.detail : error.message
                    },
                    
                )
            ).finally(o => console.log(o))
            
    }
}
function navigateToMenu(){
    NavigationSevice.navigate('StoryPage')
}