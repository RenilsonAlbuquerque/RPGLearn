import CustomAxios from "../service/AxiosConfig";


export const CURRENT_CHARACTER_FETCHED = 'CURRENT_CHARACTER_FETCHED';

const CHARACTER_API ="/character";


export function getCurrentCaracterFromStory( uId,sId){
    let bodyFilter = {userId: uId, storyId: sId}
    console.log(bodyFilter)
    return (dispatch) => {
        return CustomAxios
        .post(`${CHARACTER_API}/user-story`, bodyFilter)
        .then(result =>
            dispatch(
                {
                    type:CURRENT_CHARACTER_FETCHED,
                    payload: result.data
                }
        )).catch(error => console.log(error))
        
    };
}