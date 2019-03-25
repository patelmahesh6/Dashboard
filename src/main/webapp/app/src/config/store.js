import { createStore, applyMiddleware } from "redux";
import thunkMiddleware from "redux-thunk";
import rootReducer from "../common/reducers";
import { composeWithDevTools } from "redux-devtools-extension";

const defaultMiddlewares = [
  thunkMiddleware
  //errorMiddleware,
  //notificationMiddleware,
  //loggerMiddleware
];

const store = createStore(rootReducer, composeWithDevTools(applyMiddleware(...defaultMiddlewares)));

export default store;
