<template>
  <HeaderNav :user="user" @logout="logout" />
  <RouterView @login-user-app="loginUserApp" />
  <Footer />
</template>

<script setup>
import { ref, onMounted, watch, provide } from 'vue'
import HeaderNav from './components/common/HeaderNav.vue'
import Footer from './components/common/Footer.vue'

const user = ref(null)

provide('user', user)

onMounted(() => {
  const savedUser = localStorage.getItem('loginUser')
  if (savedUser) {
    user.value = JSON.parse(savedUser)
  }
})

watch(user, () => {})

const loginUserApp = (loginUser) => {
  user.value = loginUser
}

const logout = () => {
  user.value = null
  localStorage.removeItem('loginUser')
}
</script>

<style scoped></style>
