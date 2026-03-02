<template>
    <h2>Users</h2>


    <table border="1">
        <thead>
            <tr>
            <th>Name</th>
            <th>Email</th>
            <th>gender</th>
            <th>Skills</th>
        </tr>
        </thead>
        
        <tbody>
            <tr v-for="user in users" :key="user.id">

                <td>{{ user.name }}</td>

                <td>{{ user.email }}</td>

                <td>{{ user.gender }}</td>

                <td>{{ user.skills ? user.skills.join(", ") : "" }}</td>

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