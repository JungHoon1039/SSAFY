<template>
  <HeaderNav :user="user" @logout="logout" />
  <RouterView @login-user="loginUser" />
  <Footer />
</template>

<script setup>
import { ref, onMounted, watch } from 'vue'
import HeaderNav from './components/common/HeaderNav.vue'
import Footer from './components/common/Footer.vue'

const user = ref(null)

onMounted(() => {
  const savedUser = localStorage.getItem('loginUser')
  if (savedUser) {
    user.value = JSON.parse(savedUser)
  }
})

watch(user, () => {})

const loginUser = (loginUser) => {
  user.value = loginUser
  localStorage.setItem('loginUser', JSON.stringify(loginUser))
}

const logout = () => {
  user.value = null
  localStorage.removeItem('loginUser')
}
</script>

<style scoped></style>
