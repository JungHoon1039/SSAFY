<template>
  <div>
    <h1>App.vue</h1>
    <!-- <MyComponent/> -->
    <my-component></my-component>
  </div>
</template>

<script setup>
// import MyComponent from './components/MyComponent.vue'
//@ --> src/ 절대경로
import MyComponent from '@/components/MyComponent.vue'
</script>

<style scoped>

</style>