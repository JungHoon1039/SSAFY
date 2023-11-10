<template>
  <div>
    <HeaderNav />
    <RouterView />
  </div>
</template>

<script setup>
import HeaderNav from "@/components/common/Navi.vue";
</script>

<style>
/* 초기화 작업 */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
.btn {
  margin-right: 10px;
  padding: 5px 10px;
  background-color: #007bff;
  color: white;
  text-decoration: none;
  border-radius: 4px;
  transition: background-color 0.3s ease;
}

.btn:hover {
  background-color: #0056b3;
}
</style>
