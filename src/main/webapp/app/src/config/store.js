import { createStore, applyMiddleware } from "redux";
import thunkMiddleware from "redux-thunk";
import rootReducer from "../common/reducers";

const defaultMiddlewares = [
  thunkMiddleware
  //errorMiddleware,
  //notificationMiddleware,
  //loggerMiddleware
];

const store = createStore(rootReducer, applyMiddleware(...defaultMiddlewares));

export default store;
