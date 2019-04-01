import userReducer from "../../sample/user/user.reducer";
import { combineReducers } from 'redux';

const rootReducer = combineReducers({
  userReducer
});

export default rootReducer;
