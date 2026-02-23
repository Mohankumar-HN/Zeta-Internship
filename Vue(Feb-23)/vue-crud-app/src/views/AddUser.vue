<template>
  <h2>Add User</h2>

  <input v-model="name" placeholder="Name" />
  <input v-model="email" placeholder="Email" />
  
  <br><br>

  <input type="radio" v-model="gender" value="Male" name="gender"/>
  <label>Male</label>

  <input type="radio" v-model="gender" value="Female" name="gender"/>
  <label>Female</label>

  <br><br>

  <h3>Select Skills</h3>

  <input type="checkbox" v-model="skills" value="C++"/> C++ <br>
  <input type="checkbox" v-model="skills" value="Java"/> Java <br>
  <input type="checkbox" v-model="skills" value="Vue JS"/> Vue JS <br>
  <input type="checkbox" v-model="skills" value="Spring"/> Spring <br>

  <br>

  <button @click="saveUser">Save</button>

</template>

<script>
import api from '../services/api'

export default {

data(){

return{

name:'',

email:'',

gender:'',

skills:[]

}

},

methods:{

saveUser(){

api.addUser({

name:this.name,

email:this.email,

gender:this.gender,

skills:this.skills

}).then(()=>{

this.$router.push('/users')

})

}

}

}

</script>