import React, { Component } from "react";

export default class UserList extends Component {

  
  render() {
    return (
      <div>
        <div className="container">
          User List :
          <div>
            <h2>{this.props.user.userId}</h2>
            <p>{this.props.user.email}</p>
            <button>Edit</button>
            <button>Delete</button>
          </div>
        </div>
      </div>
    );
  }
}
