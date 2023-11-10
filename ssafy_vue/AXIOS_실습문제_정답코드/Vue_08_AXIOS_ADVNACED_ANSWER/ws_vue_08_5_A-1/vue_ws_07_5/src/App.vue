<template>
  <HeaderNav />
  <RouterView />
  <FooterNav />
</template>

<script setup>
import { RouterView } from 'vue-router'
import HeaderNav from './components/common/HeaderNav.vue'
import FooterNav from './components/common/FooterNav.vue'
</script>

<!-- scoped 를 지정하지 않으면 하위 컴포넌트에게도 영향이 간다. -->
<style>
/* 상단 header 영역의 속성 설정 */
nav {
  line-height: 60px;
}

.ssafy-logo {
  width: 120px;
  height: 60px;
}

.form {
  background: #ffffff;
  max-width: 600px;
  margin: 0 auto 100px;
  padding: 45px;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.form input,
.form textarea {
  width: 100%;
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

.board-logo {
  margin: 20px auto;
  text-align: center;
}

.search-form {
  display: flex;
}

.files {
  border: 1px solid black;
  padding: 15px;
}

.comment-del-btn {
  color: white;
  background-color: red;
  border-radius: 5px;
}
</style>
