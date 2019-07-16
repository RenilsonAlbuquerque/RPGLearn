

export function changeCurrentUser(newUser){
    
    return {
        type: 'CHANGE_USER',
        newUser
    };
}