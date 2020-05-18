import { createStore, compose, applyMiddleware } from 'redux'
import { combineReducers } from 'redux';
import UserReducer from '../reducers/UserReducer'
import StoryReducer from '../reducers/StoryReducer'
import CombatReducer from '../reducers/CombatReducer'
import CharacterReducer from '../reducers/CharacterReducer'
import thunk from 'redux-thunk';

const rootReducer = combineReducers({
    UserReducer,
    StoryReducer,
    CombatReducer,
    CharacterReducer
})

export default createStore(rootReducer, applyMiddleware(thunk));