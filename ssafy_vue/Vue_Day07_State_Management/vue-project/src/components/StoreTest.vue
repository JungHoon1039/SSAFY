<template>
    <div>
      <h2>StoreTest</h2>
      <p>state : {{ store.count }}</p>
      <p>getters : {{ store.doubleCount }}</p>
      <button @click="store.increment()">증가1</button>
      <button @click="incre">증가2</button>
    </div>
  </template>
  
  <script setup>
  import { useCounterStore } from '@/stores/counter';
  const store = useCounterStore();
  const incre = function() {
    store.increment();
  }
  </script>
  
  <style scoped>
  
  </style>