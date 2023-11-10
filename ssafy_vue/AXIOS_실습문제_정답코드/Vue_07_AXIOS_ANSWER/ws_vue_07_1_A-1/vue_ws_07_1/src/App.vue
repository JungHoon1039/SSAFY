<template>
  <div>
    <HeaderNav />
    <RouterView />
  </div>
</template>

<script setup>
import HeaderNav from "@/components/common/HeaderNav.vue";
</script>

<style>
/* 초기화 작업 */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
</style>
