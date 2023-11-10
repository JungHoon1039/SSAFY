<template>
  <main>
    <div class="mt-5">
      <div>
        <h3 class="text-center user-logo mb-3">회원 정보 수정</h3>
      </div>
      <form class="form">
        <div>
          <input type="text" placeholder="아이디" v-model="user.userId" id="userId" disabled />
        </div>
        <div>
          <input
            type="password"
            placeholder="새로운 비밀번호"
            v-model="user.userPwd"
            id="userPwd"
          />
        </div>
        <div>
          <input
            type="password"
            placeholder="새로운 비밀번호확인"
            v-model="userPwd2"
            id="userPwd2"
          />
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
        <button type="button" v-on:click="update">회원 정보 수정</button>
      </form>
    </div>
  </main>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import http from '@/util/http-common'

const router = useRouter()
const user = ref({
  userId: '',
  userPwd: '',
  userName: '',
  nickname: '',
  email: '',
  userSeq: ''
})
const userPwd2 = ref('')

onMounted(() => {
  const loginUser = JSON.parse(localStorage.getItem('loginUser'))

  user.value.userId = loginUser.userId
  user.value.userName = loginUser.userName
  user.value.nickname = loginUser.userNickName
  user.value.email = loginUser.email
  user.value.userSeq = loginUser.userSeq
})

const update = () => {
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

  http.put(`/userapi`, user.value).then(() => {
    alert('회원정보 수정되었습니다.')
    const loginUser = {
      email: user.value.email,
      userNickName: user.value.nickname,
      userId: user.value.userId,
      userName: user.value.userName,
      userSeq: user.value.userSeq
    }
    localStorage.setItem('loginUser', JSON.stringify(loginUser))
    router.push({ name: 'mypage' })
  })
}
</script>

<style scoped>
.form {
  background: #ffffff;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.form input {
  outline: 0;
  background: #f2f2f2;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  font-size: 14px;
}

.form button {
  margin: 0 0 15px;
  outline: 0;
  background: #1e71ee;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #ffffff;
  font-size: 14px;
  cursor: pointer;
}
.form button:hover {
  background: #50a3a2;
}
</style>
