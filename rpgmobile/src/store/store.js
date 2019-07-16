import { createStore } from 'redux'
import { combineReducers } from 'redux';
import UserReducer from '../reducers/userreducer'


const rootReducer = combineReducers({
    UserReducer
})

export default createStore(rootReducer);