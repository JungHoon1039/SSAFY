<template>
  <div>
    <h1>AppView</h1>
    <header>
    <RouterLink to ="/">Home</RouterLink>
    <RouterLink :to ="{name: 'home'}">HomeName</RouterLink>
    <RouterLink to ="/about">About</RouterLink>
    <RouterLink :to ="{name: 'about'}">AboutName</RouterLink>
    <RouterLink :to ="{name: 'user', params: {id:'ssafy1'}}">ssafy1</RouterLink>
    <RouterLink :to ="{name: 'user', params: {id:'ssafy2'}}">ssafy2</RouterLink>
    <RouterLink :to ="{name: 'login'}">login</RouterLink>
    <RouterLink :to ="{name: 'board'}">게시판1</RouterLink>
    <RouterLink to ="/board">게시판2</RouterLink>
    </header>
    <RouterView/>
  </div>
</template>

<script setup>
import { RouterView } from 'vue-router';

</script>

<style scoped>
  header {
    display: flex;
    justify-content: space-around;
  }
  a {
    text-decoration: none;
  }
</style>