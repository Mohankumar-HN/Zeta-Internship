<template>
  <h2>Register</h2>

  <input v-model="email" placeholder="Email" />
  <input v-model="password" type="password" placeholder="Password" />
  <button @click="register">Register</button>

  <p v-if="error" style="color: red;">{{ error }}</p>
  <p v-if="success" style="color: green;">{{ success }}</p>
</template>

<script>
import authService from '../services/authService'

export default {
  data() {
    return {
      email: '',
      password: '',
      error: '',
      success: ''
    }
  },
  methods: {
    async register() {
      this.error = ''
      this.success = ''
      
      try {
        await authService.register({
          email: this.email,
          password: this.password,
          role: 'user'
        })
        this.success = 'Registration successful! Redirecting to login...'
        setTimeout(() => {
          this.$router.push('/login')
        }, 1500)
      } catch (err) {
        this.error = err.message || 'Registration failed. Please try again.'
      }
    }
  }
}
</script>
