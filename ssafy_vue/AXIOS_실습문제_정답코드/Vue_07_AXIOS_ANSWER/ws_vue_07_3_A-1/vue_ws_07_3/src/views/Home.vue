<template>
  <div class="container">
    <br />
    <div class="text-center">
      <img src="../assets/ssafy_logo.png" alt="" class="ssafy-logo" />
      <h1>{{ message }}</h1>
    </div>
    <br />
  </div>
</template>

<script setup>
const message = "도서 관리.";
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f7f7f7;
}

.text-center {
  text-align: center;
}

.ssafy-logo {
  width: 150px;
  margin-bottom: 20px;
}
</style>
