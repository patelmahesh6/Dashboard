import React, { Component } from "react";
import UserList from "./user-list";
import { RegisterUser } from "./register-user";

export default class User extends Component {
  render() {
    return (
      <div>
        <RegisterUser />
        <UserList />
      </div>
    );
  }
}
