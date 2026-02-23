
<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/users">Users</router-link> |
    <router-link to="/add">Add User</router-link>
  </nav>

  <router-view />


  <!-- <h1> Practice Vue js</h1>
  <h2>{{ name }}</h2>
  <input v-model="name">
  <button @click="changeName">Change</button> -->
</template>

<script>
  // export default{
  //   data(){
  //     return {
  //       name:""
  //     }
  //   },
  //   methods:{
  //     changeName(){
  //       this.name="john"
  //     }
  //   }
  // }
</script>