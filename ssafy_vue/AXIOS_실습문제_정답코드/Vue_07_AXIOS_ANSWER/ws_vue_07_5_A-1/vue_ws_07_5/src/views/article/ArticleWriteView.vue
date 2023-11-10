<template>
  <main>
    <div>
      <h3 class="text-center m-3">글작성</h3>
    </div>
    <div>
      <form action="" class="form">
        <div>
          <label for="title">게시글 제목 : </label>
          <input type="text" id="title" placeholder="제목을 입력하세요." v-model="article.title" />
        </div>
        <div>
          <label for="content">게시글 내용 : </label>
          <textarea id="content" cols="30" rows="10" v-model="article.content"></textarea>
        </div>
        <div>
          <label for="files">첨부파일 : </label>
          <input type="file" id="files" multiple ref="fileInfos" />
        </div>
        <div>
          <button type="button" @click="writeArticle">저장</button>
        </div>
      </form>
    </div>
  </main>
</template>

<script setup>
import { ref } from 'vue'
import http from '@/util/http-common.js'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

const article = ref({
  title: '',
  content: ''
})
const fileInfos = ref(null)
const boardId = route.params.boardId

const writeArticle = function () {
  const loginUser = JSON.parse(localStorage.getItem('loginUser'))

  const formData = new FormData()
  formData.append('title', article.value.title)
  formData.append('content', article.value.content)
  formData.append('boardId', boardId)
  formData.append('userSeq', loginUser.userSeq)
  Array.from(fileInfos.value.files).forEach((file) => {
    formData.append('fileInfos', file)
  })

  http
    .post(`/articleapi`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
    .then(() => {
      alert('게시글이 생성되었습니다.')
      router.push({ name: 'board-detail', params: { id: boardId } })
    })
}
</script>

<style scoped></style>
