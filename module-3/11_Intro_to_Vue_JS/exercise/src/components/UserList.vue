<template>
  <table id="tblUsers">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>
          <input v-model="search.firstName" type="text" id="firstNameFilter" />
        </td>
        <td>
          <input v-model="search.lastName" type="text" id="lastNameFilter" />
        </td>
        <td>
          <input v-model="search.username" type="text" id="usernameFilter" />
        </td>
        <td>
          <input v-model="search.emailAddress" type="text" id="emailFilter" />
        </td>
        <td>
          <select id="statusFilter">
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
          </select>
        </td>
      </tr>
      <!-- user listing goes here -->
      <tr>
        <td v-for="user in users" v-bind:key="user.firstName">
          {{ user.firstName }}
        </td>
        <td v-for="user in users" v-bind:key="user.lastName">
          {{ user.lastName }}
        </td>
        <td v-for="user in users" v-bind:key="user.username">
          {{ user.username }}
        </td>
        <td v-for="user in users" v-bind:key="user.emailAddress">
          {{ user.emailAddress }}
        </td>
        <td v-for="user in users" v-bind:key="user.status">
          {{ user.status }}
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  data() {
    return {
      search: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "",
      },
    };
  },
};
</script>
<script>
export default {
  name: "user-list",
  data() {
    return {
      users: [
        {
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active",
        },
        {
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active",
        },
        {
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive",
        },
        {
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active",
        },
        {
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active",
        },
        {
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive",
        },
      ],
    };
  },
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.inactive {
  color: red;
}
input,
select {
  font-size: 16px;
}
</style>










 