<template>
  <UserLogin @login-user="loginUser" />
</template>

<script setup>
import UserLogin from '../components/user/UserLogin.vue'

const emit = defineEmits(['login-user'])

const loginUser = (useerData) => {
  emit('login-user', useerData)
}
</script>
<style scoped></style>
