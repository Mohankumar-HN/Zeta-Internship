<template>
    <h2>Users</h2>

    <!-- <ul>
    <li v-for="user in users" :key="user.id">
      {{ user.name }} - {{ user.email }} -{{ user.gender }}-{{ user.skills }}
      <button @click="editUser(user.id)">Edit</button>
      <button @click="removeUser(user.id)">Delete</button>
    </li>
  </ul> -->
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>gender</th>
            <th>Skills</th>
        </tr>
        <tbody>
            <tr v-for="user in users" :key="user.id">

                <td>{{ user.name }}</td>

                <td>{{ user.email }}</td>

                <td>{{ user.gender }}</td>

                <td>{{ user.skills.join(", ") }}</td>

                <td>
                    <button @click="editUser(user.id)">Edit</button>
                    <button @click="removeUser(user.id)">Delete</button>
                </td>

            </tr>
        </tbody>
    </table>
</template>

<script>
import api from '../services/api'

export default {
    data() {
        return { users: [] }
    },
    mounted() {
        this.loadUsers()
    },
    methods: {
        loadUsers() {
            api.getUsers().then(res => {
                this.users = res.data
            })
        },
        editUser(id) {
            this.$router.push(`/edit/${id}`)
        },
        removeUser(id) {
            api.deleteUser(id).then(() => {
                this.loadUsers()
            })
        }
    }
}
</script>