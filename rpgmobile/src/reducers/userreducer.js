let currentUser = {
    id: 0,
    nome:'',
    email:'',
    token:'',
    atuhenticated: false
}

export default(state = currentUser, actions) =>{
    
    switch(actions.type){
        case 'CHANGE_USER':{
            currentUser = actions.newUser;
        }
        default:
            return currentUser
    }
}