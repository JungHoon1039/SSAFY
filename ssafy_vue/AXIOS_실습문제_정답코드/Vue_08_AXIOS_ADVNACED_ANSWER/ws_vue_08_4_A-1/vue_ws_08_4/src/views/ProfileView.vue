<template>
  <div class="profile-container">
    <div class="profile-item">사용자 아이디 : {{ user.userId }}</div>
    <div class="profile-item">사용자 이름 : {{ user.userName }}</div>
  </div>
</template>

<script setup>
import { inject } from 'vue'

const user = inject('user')
</script>

<style scoped>
.profile-container {
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  max-width: 400px;
  margin: 50px auto;
}

.profile-item {
  padding: 10px;
  margin-bottom: 10px;
  border-bottom: 1px solid #ccc;
  font-weight: bold;
}
</style>
