import axios from "axios";
import NavigationSevice from '../service/NavigationService'
import CustomAxios from "../service/AxiosConfig";



export const USER_FETCHED = 'USER_FETCHED';
export const LOGIN_ERROR = 'LOGIN_ERROR';
//const USER_API =process.env.REACT_APP_URL_API + process.env.REACT_APP_PATH_PRESTADORA_API;
const USER_API = "/user"




export function loginAction(username, password){
   

    return (dispatch) => {
        return CustomAxios
            .get(`${USER_API}/detail`)
            .then(result =>
                dispatch(
                    {
                        type: USER_FETCHED,
                        payload: {
                            id: 1,
                            nome: 'Renilson',
                            email: 'renilsonalbuquerque@gmail.com',
                            token: 'asdjoie93j08f2j3j8fas',
                            atuhenticated: true
                        }
                    },
                    navigateToMenu()
                )
            ).catch(error => 
                dispatch(
                    {
                        type:LOGIN_ERROR,
                        payload: error
                    }
                    
                )
            ).finally(o => console.log(o))
    }
}
function navigateToMenu(){
    NavigationSevice.navigate('StoryPage')
}