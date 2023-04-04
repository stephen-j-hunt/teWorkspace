<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input
              type="checkbox"
              v-model="selectAll"
              id="selectAll"
              @change="selectAllUsers()"
              :checked="
                selectedUsers.length === users.length
                  ? (selectAll = true)
                  : (selectAll = false)
              "
            />
          </td>
          <td>
            <input
              type="text"
              id="firstNameFilter"
              v-model="filter.firstName"
            />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Inactive">Inactive</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ deactivated: user.status === 'Inactive' }"
        >
          <td>
            <input
              type="checkbox"
              v-model="selectedUsers"
              :id="user.id"
              :value="user.id"
              :checked="selectedUsers.includes(user.id)"
            />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button class="btnActivateDeactivate" @click="changeStatus(user)">
              {{ user.status === "Active" ? "Deactivate" : "Activate" }}
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions">
      <button
        @click="activateUsers()"
        v-bind:disabled="selectedUsers.length === 0"
      >
        Activate Users
      </button>
      <button
        @click="deactivateUsers()"
        v-bind:disabled="selectedUsers.length === 0"
      >
        Deactivate Users
      </button>
      <button
        @click="deleteUsers()"
        v-bind:disabled="selectedUsers.length === 0"
      >
        Delete Users
      </button>
    </div>

    <button v-on:click="showForm = !showForm">Add New User</button>

    <form
      id="frmAddNewUser"
      v-on:submit.prevent="addNewUser()"
      v-show="showForm"
    >
      <div class="field">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" v-model="newUser.firstName" />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" v-model="newUser.lastName" />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input type="text" name="username" v-model="newUser.username" />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input type="text" name="emailAddress" v-model="newUser.emailAddress" />
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "",
      },
      showForm: false,
      nextUserId: 7,
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active",
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active",
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active",
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive",
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active",
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active",
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive",
        },
      ],
      selectedUsers: [],
      selectAll: false,
    };
  },
  methods: {
    selectAllUsers() {
      if (this.selectAll === true) {
        this.selectedUsers = [];
        this.users.forEach((user) => this.selectedUsers.push(user.id));
      } else {
        this.selectedUsers = [];
      }
    },

    deleteUsers() {
      this.selectedUsers.forEach((id) => {
        let anotherUser = this.users.find((user) => user.id === id);
        this.users.splice(this.users.indexOf(anotherUser), 1);
      });
      this.selectedUsers = [];
    },

    deactivateUsers() {
      this.selectedUsers.forEach((id) => {
        let anotherUser = this.users.find((user) => user.id === id);
        anotherUser.status = "Inactive";
      });
      this.selectedUsers = [];
    },

    activateUsers() {
      this.selectedUsers.forEach((id) => {
        let aUser = this.users.find((user) => user.id === id);
        aUser.status = "Active";
      });
      this.selectedUsers = [];
    },
    getNextUserId() {
      return this.nextUserId++;
    },
    addNewUser() {
      this.newUser.id = this.nextUserId;
      const realNewUser = {
        id: this.newUser.id,
        firstName: this.newUser.firstName,
        lastName: this.newUser.lastName,
        username: this.newUser.lastName,
        emailAddress: this.newUser.emailAddress,
        status: "Active",
      };
      this.users.push(realNewUser);
      this.getNextUserId();
      this.resetForm();
    },

    changeStatus(user) {
      if (user.status === "Active") {
        user.status = "Inactive";
      } else {
        user.status = "Active";
      }
    },
    resetForm() {
      this.newUser.id = null;
      this.newUser.firstName = "";
      this.newUser.lastName = "";
      this.newUser.username = "";
      this.newUser.emailAddress = "";
      this.newUser.status = "Active";
    },
  },

  computed: {
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter(
          (user) => user.status === this.filter.status
        );
      }
      return filteredUsers;
    },
  },
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
