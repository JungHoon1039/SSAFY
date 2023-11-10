<template>
  <div class="form-div">
    <div class="form-control">
      <h1>로그인</h1>
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="form-control">
      <label for="userId">아이디 : </label>
      <input name="userId" id="userId" type="text" v-model="user.userId" />
    </div>
    <div class="form-control">
      <label for="userPass">비밀번호 : </label>
      <input name="userPass" id="userPass" type="password" v-model="user.userPass" />
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="form-control">
      <button @click="login">로그인</button>
      <button type="reset">초기화</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import http from '@/utils/http-common.js'

const router = useRouter()

const emit = defineEmits(['login-user'])

const user = ref({
  userId: '',
  userPass: '',
  userName: ''
})

const login = function () {
  let valid = true
  let msg = ''
  !user.value.userId && ((msg = '아이디를 입력해주세요.'), (valid = false))
  !user.value.userPass && ((msg = '비밀번호를 입력해주세요.'), (valid = false))

  if (!valid) {
    alert(msg)
    return
  }

  http.post(`/userapi/login`, user.value).then((res) => {
    alert('로그인 성공')
    emit('login-user', res.data)
    localStorage.setItem('loginUser', JSON.stringify(res.data))
    router.push({
      name: 'Home'
    })
  })
}
</script>

<style scoped></style>
