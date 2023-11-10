<template>
  <header>
    <nav class="navbar navbar-expand-lg shadow">
      <div class="container-fluid">
        <RouterLink :to="{ name: 'home' }" class="navbar-brand">
          <img src="/img/ssafy_logo.png" class="ssafy-logo" /><span>게시판</span>
        </RouterLink>

        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <span id="login-off" :style="{ display: loginOffDisplay }">
            <div class="d-flex">
              <RouterLink :to="{ name: 'login' }" class="nav-link mx-2">로그인</RouterLink>
              <RouterLink :to="{ name: 'signup' }" class="nav-link mx-2">회원가입</RouterLink>
            </div>
          </span>
          <span id="login-on" :style="{ display: loginOnDisplay }">
            <div class="d-flex">
              <span id="user-name">{{ loginUser.userName }}</span
              ><span>님 반갑습니다.</span>
              <button id="logout-btn" v-on:click="logout" class="btn">로그아웃</button>
              <RouterLink :to="{ name: 'mypage' }" class="nav-link mx-2">마이페이지</RouterLink>
            </div>
          </span>
        </div>
      </div>
    </nav>
  </header>
</template>

<script setup>
import { useRouter, RouterLink } from 'vue-router'
import { ref, onMounted } from 'vue'

const router = useRouter()
const loginOnDisplay = ref('none')
const loginOffDisplay = ref('block')
const loginUser = ref({})

onMounted(() => {
  let storedUser = localStorage.getItem('loginUser')
  if (storedUser !== null) {
    loginUser.value = JSON.parse(storedUser)
    loginOffDisplay.value = 'none'
    loginOnDisplay.value = 'block'
  }
})

const logout = () => {
  localStorage.removeItem('loginUser')
  loginOffDisplay.value = 'block'
  loginOnDisplay.value = 'none'
  router.push({ name: 'home' })
}
</script>

<style scoped></style>
