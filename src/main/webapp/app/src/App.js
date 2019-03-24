import React, { Component } from "react";
import "./App.css";
import RegisterUser from "./sample/user-managment/RegisterUser";
import UserList from "./sample/user-managment/UserList";

class App extends Component {
  render() {
    return (
      <div className="App">
        <RegisterUser />
        {/* <UserList /> */}
      </div>
    );
  }
}

export default App;
