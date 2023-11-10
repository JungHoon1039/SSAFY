<template>
  <main class="container">
    <div>
      <h3 class="board-logo">게시판 만들기</h3>
    </div>
    <div>
      <form action="" class="form">
        <div>
          <label for="board-name">게시판 이름 : </label>
          <input type="text" id="board-name" v-model="board.boardName" />
        </div>
        <div>
          <label for="board-desc">게시판 설명 : </label>
          <textarea id="board-desc" cols="30" rows="10" v-model="board.description"></textarea>
        </div>
        <div>
          <button type="button" @click="createBoard">저장</button>
        </div>
      </form>
    </div>
  </main>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import http from '@/util/http-common.js'

const router = useRouter()

const board = ref({
  boardName: '',
  description: ''
})

const createBoard = function () {
  if (board.value.boardName == '' || board.value.description == '') {
    alert('공백없이 내용을 작성해 주세요.')
    return
  }

  http.post(`/boardapi`, board.value).then(() => {
    alert('게시판이 생성되었습니다.')
    router.push({ name: 'board-list' })
  })
}
</script>

<style scoped></style>
