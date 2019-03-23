import { createStore } from "redux";

import userReducer from "./../common/reducers/user.reducer";

const store = createStore(userReducer);
