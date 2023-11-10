<template>
  <main class="container">
    <div class="d-flex justify-content-between m-4">
      <h3>게시판 리스트</h3>
      <RouterLink :to="{ name: 'board-create' }" class="btn btn-primary" id="board-create"
        >게시판 만들기</RouterLink
      >
    </div>
    <div>
      <ol id="board-list" class="list-group list-group-numbered">
        <BoardListRow v-for="board in boards" :board="board" />
      </ol>
    </div>
  </main>
</template>

<script setup>
import { RouterLink } from 'vue-router'
import { ref, onMounted } from 'vue'
import BoardListRow from '@/components/board/BoardListRow.vue'
import http from '@/util/http-common.js'

const boards = ref([])

onMounted(() => {
  http.get(`/boardapi`).then(({ data }) => {
    boards.value = data
  })
})
</script>

<style scoped></style>
