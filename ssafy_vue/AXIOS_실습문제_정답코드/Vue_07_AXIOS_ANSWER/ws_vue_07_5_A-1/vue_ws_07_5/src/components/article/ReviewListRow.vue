<template>
  <li class="list-group-item d-flex justify-content-between align-items-center mb-1">
    <div class="d-flex align-items-center">
      <div>
        <strong>{{ props.comment.userName }}</strong>
        <div>{{ props.comment.content }}</div>
      </div>
    </div>
  </li>
</template>

<script setup>
const props = defineProps({
  comment: Object
})
</script>

<style scoped>
.list-group-item {
  border: none;
  border-bottom: 1px solid #ddd;
}
</style>
