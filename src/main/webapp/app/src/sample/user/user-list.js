import React, { Component } from "react";
import { connect } from "react-redux";
import { getUserList } from "./user.reducer";
import axios from "axios";
import userData from "../../common/data/user.json";

const mapDispatchToProps = { getUserList };
const mapStateToProps = state => {
  return state;
};

export class UserList extends Component {
  constructor(props) {
    super(props);
    /*
  this.state = {
    userList = userData
  }
  */
  }

  componentWillMount = () => {
    /* axios
      .get("../../common/data/user.json") // JSON File Path
      .then(response => {
        this.setState({
          userList: response.data
        });
      })
      .catch(function(error) {
        console.log(error);
      });
    
    console.log(this.state.userList);
    */
  };

  render() {
  
    return (
      <div>
        <div className="container">
          User List :
          {this.props.getUserList().map(userList => (
            <div key={userList.userId}>
              {userList.userId}
              {userList.email}
              <button>Edit</button>
              <button>Delete</button>
            </div>
          ))}
        </div>
      </div>
    );
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(UserList);
