<template>
  <RouterLink
    :to="{ name: 'board-detail', params: { id: board.boardId } }"
    class="list-group-item"
    style="cursor: pointer"
  >
    {{ board.boardName }}
    <p>{{ board.description }}</p>
  </RouterLink>
</template>

<script setup>
import { toRefs } from 'vue'
import { RouterLink } from 'vue-router'

const props = defineProps({
  board: Object
})

const { board } = toRefs(props)
</script>

<style scoped></style>
