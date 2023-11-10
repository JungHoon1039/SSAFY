<template>
  <main class="container">
    <div>
      <div>
        <h3 class="text-center user-logo">회원가입</h3>
      </div>
      <form class="form">
        <div>
          <input type="text" placeholder="아이디" v-model="user.userId" id="userId" />
        </div>
        <div>
          <input type="password" placeholder="비밀번호" v-model="user.userPwd" id="userPwd" />
        </div>
        <div>
          <input type="password" placeholder="비밀번호확인" v-model="userPwd2" id="userPwd2" />
        </div>
        <div>
          <input type="text" placeholder="이름" v-model="user.userName" id="userName" />
        </div>
        <div>
          <input type="text" placeholder="닉네임" v-model="user.nickname" id="nickname" />
        </div>
        <div>
          <input type="email" placeholder="이메일주소" v-model="user.email" id="email" />
        </div>
        <button type="button" v-on:click="signup">계정 만들기</button>
        <div style="display: flex; justify-content: space-between">
          <p>이미 회원이신가요?</p>
          <RouterLink :to="{ name: 'login' }" class="link">로그인 하러가기</RouterLink>
        </div>
      </form>
    </div>
  </main>
</template>

<script setup>
import { useRouter, RouterLink } from 'vue-router'
import { ref } from 'vue'
import http from '@/util/http-common.js'

const router = useRouter()
const user = ref({
  userId: '',
  userPwd: '',
  userName: '',
  nickname: '',
  email: ''
})
const userPwd2 = ref('')

const signup = () => {
  // 유효성 검사를 실시한다.
  if (user.value.userPwd !== '' && user.value.userPwd !== userPwd2.value) {
    alert('비밀번호가 올바르지 않습니다.')
    return
  }

  if (
    user.value.id === '' ||
    user.value.userName === '' ||
    user.value.nickname === '' ||
    user.value.email === ''
  ) {
    alert('공백없이 내용을 작성해 주세요.')
    return
  }

  http.post(`/userapi/signup`, user.value).then(() => {
    alert('회원가입 되었습니다.')
    router.push({ name: 'login' })
  })
}
</script>

<style scoped></style>
