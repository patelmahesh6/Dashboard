import userData from "../../common/data/user.json";

// Reducer
const userReducer = (state = [], action) => {
  switch (action.type) {
    case "ADD_USER":
      return state.concat([action.payload]);
    case "USER_LIST":
      return userData;
    case "RESET":
      return state;
    default:
      return state;
  }
};

// Actions
export const addUser = state => ({
  type: "ADD_USER",
  payload: state
});

export const reset = () => ({
  type: "RESET"
});

export const getUserList = () => ({
  type: "USER_LIST"
});

export default userReducer;
