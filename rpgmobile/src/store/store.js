import { createStore, compose, applyMiddleware } from 'redux'
import { combineReducers } from 'redux';
import UserReducer from '../reducers/UserReducer'
import StoryReducer from '../reducers/StoryReducer'
import thunk from 'redux-thunk';

const rootReducer = combineReducers({
    UserReducer,
    StoryReducer
})

export default createStore(rootReducer, applyMiddleware(thunk));