import CustomAxios from "../service/AxiosConfig";


export const CURRENT_CHARACTER_FETCHED = 'CURRENT_CHARACTER_FETCHED';
export const CHARACTER_CREATION_METADATA_FETCHED = 'CHARACTER_CREATION_METADATA_FETCHED';

const CHARACTER_API ="/character";


export function getCurrentCaracterFromStory( uId,sId){
    let bodyFilter = {userId: uId, storyId: sId}

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
export function getCharacterCreationMetadata(){
    return (dispatch) => {
        return CustomAxios
        .get(`${CHARACTER_API}/metadata`)
        .then(result => {
            console.log(result),
            dispatch(
                {
                    type:CHARACTER_CREATION_METADATA_FETCHED,
                    payload: result.data
                }
        )}).catch(error => console.log(error))
        
    };
}
export function getCurrentCaracterFromStoryNoReducing(uId,sId){
    let bodyFilter = {userId: uId, storyId: sId}
    return CustomAxios
        .post(`${CHARACTER_API}/user-story`, bodyFilter);
}


//===================Sets============================///
export function setCurrentCharacter(character){
    return {
        type:CURRENT_CHARACTER_FETCHED,
        payload: character
    }
}