
<template>
  <nav>
    <router-link to="/">Home</router-link> |
    
    <template v-if="isAuthenticated">
      <router-link to="/users">Users</router-link> |
      <router-link to="/add">Add User</router-link> |
      <router-link to="/dashboard">Dashboard</router-link> |
      <button @click="logout">Logout</button>
    </template>

    <template v-else>
      <router-link to="/login">Login</router-link> |
      <router-link to="/register">Register</router-link>
    </template>
  </nav>

  <router-view />

</template>

<script>
import { useRouter } from 'vue-router'
import authService from './services/authService'

export default {
  setup() {
    const router = useRouter()
    
    return {
      router,
      authService
    }
  },
  data() {
    return {
      isAuthenticated: false
    }
  },
  methods: {
    logout() {
      authService.logout()
      this.isAuthenticated = false
      this.$router.push('/login')
    },
    checkAuth() {
      this.isAuthenticated = authService.isAuthenticated()
    }
  },
  mounted() {
    this.checkAuth()
    this.$router.afterEach(() => {
      this.checkAuth()
    })
  }
}
</script>