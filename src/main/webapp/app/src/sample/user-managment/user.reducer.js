const intialState = { email: "", mobileNo: "", gender: "-1" };
// Reducer
const userReducer = (state = [], action) => {
  switch (action.type) {
    case "ADD_USER":
      return state.concat([action.payload]);
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

export default userReducer;
