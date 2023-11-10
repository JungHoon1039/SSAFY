<template>
  <UserLogin @login-user="loginUser" />
</template>

<script setup>
import UserLogin from '../components/user/UserLogin.vue'

const emit = defineEmits(['login-user-app'])

const loginUser = (useerData) => {
  emit('login-user-app', useerData)
}
</script>
<style scoped></style>
