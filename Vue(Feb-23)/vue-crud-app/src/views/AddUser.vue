<template>
  <h2>Add User</h2>

  <input v-model="name" placeholder="Name" />
  <input v-model="email" placeholder="Email" />
  
  <br>
  <input type="radio" v-model="gender" value="Male" name="gender"/>
  <label>Male</label>
  <input type="radio" v-model="gender" value="Female" name="gender"/>
  <label>Female</label>
  <br>
  <button @click="saveUser">Save</button>
</template>

<script>
import api from '../services/api'

export default {
  data() {
    return {
      name: '',
      email: '',
      gender:''
    }
  },
  methods: {
    saveUser() {
      api.addUser({
        name: this.name,
        email: this.email,
        gender:this.gender
      }).then(() => {
        this.$router.push('/users')
      })
    }
  }
}
</script>
