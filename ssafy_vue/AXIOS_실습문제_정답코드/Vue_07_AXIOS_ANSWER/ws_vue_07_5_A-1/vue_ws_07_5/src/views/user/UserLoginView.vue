<template>
  <main>
    <div>
      <div>
        <h3 class="text-center user-logo">로그인</h3>
      </div>
      <form class="form">
        <div>
          <input type="text" placeholder="아이디" v-model="user.userId" id="userId" />
        </div>
        <div>
          <input type="password" placeholder="비밀번호" v-model="user.userPwd" id="userPwd" />
        </div>
        <div class="checkbox">
          <input type="checkbox" id="id-save" style="width: auto; margin: 0 10px 0 0" />
          <label for="id-save">아이디 저장</label>
        </div>
        <button type="button" v-on:click="login">로그인</button>
        <div style="display: flex; justify-content: space-between">
          <p>회원이 아니신가요?</p>
          <RouterLink :to="{ name: 'signup' }" class="link">회원 가입하기</RouterLink>
        </div>
      </form>
    </div>
  </main>
</template>

<script setup>
import { ref } from 'vue'
import { RouterLink, useRouter } from 'vue-router'
import http from '@/util/http-common.js'

const router = useRouter()
const user = ref({
  userId: '',
  userPwd: ''
})

const login = function () {
  if (user.value.id === '' || user.value.userPwd === '') {
    alert('공백없이 내용을 작성해 주세요.')
    return
  }

  http
    .post(`/userapi/login`, user.value)
    .then(({ data }) => {
      alert('로그인 되었습니다!')
      const loginUser = {
        email: data.email,
        userNickName: data.nickname,
        userId: data.userId,
        userName: data.userName,
        userRank: data.userRank,
        userSeq: data.userSeq
      }
      localStorage.setItem('loginUser', JSON.stringify(loginUser))
      router.push({ name: 'home' }).then(() => {
        // Header가 적용이 안돼서 임시로 새로고침하는 코드
        location.reload()
      })
    })
    .catch(() => {
      alert('로그인 실패하였습니다.')
    })
}
</script>

<style scoped></style>
