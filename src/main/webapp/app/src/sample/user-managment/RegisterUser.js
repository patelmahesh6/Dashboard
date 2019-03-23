import React, { Component } from "react";

export default class RegisterUser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      mobileNo: "",
      gender: "-1"
    };
  }

  handleSubmit(event) {}

  render() {
    return (
      <div>
        <div className="container">Register User : 
          <form onSubmit={this.handleSubmit}>
            <div className="form-group row">
              <label>Email address:</label>
              <input
                type="email"
                className="form-control"
                id="email"
                value={this.state.email}
              />
            </div>
            <div className="form-group row">
              <label>Mobile No:</label>
              <input
                type="text"
                className="form-control"
                id="mobileno"
                value={this.state.mobileNo}
              />
            </div>
            <div className="form-group row">
              <label>Gender:</label>
              <select className="form-control">
                <option value="-1">Please Choose</option>
                <option value="1">Male</option>
                <option value="0">Female</option>
              </select>
            </div>
            <div className="form-group row">
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}
