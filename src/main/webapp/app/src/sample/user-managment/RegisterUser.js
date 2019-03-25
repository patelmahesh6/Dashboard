import React, { Component } from "react";
import { connect } from "react-redux";
import { addUser, reset } from "./user.reducer";

const mapStateToProps = state => {
  return state;
};

const mapDispatchToProps = { addUser, reset };

export class RegisterUser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      mobileNo: "",
      gender: "-1"
    };
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentWillUnmount() {
    console.log("unMount");
    this.props.reset();
    
  }

  componentWillMount() {
    console.log("Mount")
    console.log(this.state);
    
  }

  onChange = e => {
    this.setState({ [e.target.name]: e.target.value });
  };

  handleSubmit(e) {
    this.props.addUser(this.state);
    console.log(this.state);
    this.props.reset();
    console.log(this.state);
    e.preventDefault();
  }


  render() {
    return (
      <div>
        <div className="container">
          Register User :
          <form onSubmit={this.handleSubmit}>
            <div className="form-group row">
              <label>Email address:</label>
              <input
                type="text"
                className="form-control"
                id="email"
                name="email"
                value={this.state.email}
                onChange={this.onChange}
              />
            </div>
            <div className="form-group row">
              <label>Mobile No:</label>
              <input
                type="text"
                className="form-control"
                id="mobileNo"
                name="mobileNo"
                value={this.state.mobileNo}
                onChange={this.onChange}
              />
            </div>
            <div
              className="form-group row"
              value={this.state.gender}
              onChange={this.onChange}
            >
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
export default connect(
  mapStateToProps,
  mapDispatchToProps
)(RegisterUser);
