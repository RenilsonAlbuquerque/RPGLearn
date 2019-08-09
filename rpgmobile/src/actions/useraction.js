import axios from "axios";
import NavigationSevice from '../service/NavigationService'

export const USER_FETCHED = 'USER_FETCHED';

//const USER_API =process.env.REACT_APP_URL_API + process.env.REACT_APP_PATH_PRESTADORA_API;
const USER_API = "http://192.168.0.112:8080/user"




export function loginAction(username, password){
   

    return (dispatch) => {
        return axios
            .get(`${USER_API}/detail`)
            .then(result =>
                dispatch([
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

                ])
            );
    }
}
function navigateToMenu(){
    NavigationSevice.navigate('StoryPage')
}