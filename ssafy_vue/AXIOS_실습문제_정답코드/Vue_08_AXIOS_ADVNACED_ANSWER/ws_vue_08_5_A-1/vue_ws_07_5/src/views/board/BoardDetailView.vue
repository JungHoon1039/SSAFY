<template>
  <main class="container">
    <div class="d-flex justify-content-between align-items-end">
      <div class="mt-4">
        <h3 class="mb-3">{{ board.boardName }}</h3>
        <p>{{ board.description }}</p>
      </div>
      <div>
        <form action="" class="search-form d-flex align-items-center">
          <div>
            <select name="" id="keytype">
              <option value="title">제목</option>
              <option value="nickname">글쓴이</option>
              <option value="content">내용</option>
            </select>
          </div>
          <div>
            <input type="text" />
          </div>
          <div>
            <button>검색</button>
          </div>
        </form>
      </div>
    </div>
    <div>
      <div class="d-flex justify-content-center p-3">
        <table border="1" class="text-center table" id="article-table">
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>작성일</th>
            <th>조회수</th>
            <th>좋아요</th>
          </tr>
          <ArticleListRow v-for="article in articles" :article="article" />
        </table>
      </div>
      <div style="display: flex; justify-content: end">
        <button class="btn btn-danger me-1" @click="deleteBoard">게시판 삭제</button>
        <RouterLink
          :to="{ name: 'article-write', params: { boardId: boardId } }"
          class="btn btn-success"
          >글쓰기</RouterLink
        >
      </div>
    </div>
  </main>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter, RouterLink } from 'vue-router'
import ArticleListRow from '@/components/article/ArticleListRow.vue'
import http from '@/util/http-common.js'

const route = useRoute()
const router = useRouter()

const articles = ref([])
const board = ref({})
const boardId = route.params.id

onMounted(() => {
  http.get(`/boardapi/${boardId}`).then(({ data }) => {
    board.value = data.board
    articles.value = data.articles
  })
})

const deleteBoard = function () {
  const isDelete = confirm('해당 게시판을 삭제합니까?')

  if (!isDelete) return

  http.delete(`/boardapi/${boardId}`).then(() => {
    alert('게시판 삭제 되었습니다.')
    router.push({ name: 'board-list' })
  })
}
</script>

<style scoped></style>
