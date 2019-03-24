import userReducer from "../../sample/user-managment/user.reducer";
import { combineReducers } from 'redux';

const rootReducer = combineReducers({
  userReducer
});

export default rootReducer;
