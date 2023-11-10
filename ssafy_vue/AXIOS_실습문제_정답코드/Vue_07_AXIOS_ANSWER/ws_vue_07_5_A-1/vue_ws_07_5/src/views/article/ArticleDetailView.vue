<template>
  <main>
    <div class="m-5">
      <div>
        <h3 id="title"></h3>
        <div class="d-flex justify-content-between align-items-end">
          <div>
            <div>
              작성자 : <span id="writer">{{ article.userName }}</span>
            </div>
            <div>
              작성일 : <span id="create-date">{{ article.createdAt }}</span>
            </div>
            <div>
              <i class="bi bi-eye"></i> : <span id="view-cnt">{{ article.viewCnt }}</span>
            </div>
            <div>
              <i class="bi bi-hand-thumbs-up" style="color: green"></i> :
              <span id="like">{{ article.likeCnt }}</span>
            </div>
            <div>
              <i class="bi bi-hand-thumbs-down" style="color: red"></i> :
              <span id="dislike">{{ article.dislikeCnt }}</span>
            </div>
          </div>
          <div>
            <!-- <a href="#">글 수정</a>
            <a href="../board/list.html" class="btn btn-primary">목록으로</a> -->
          </div>
        </div>
        <hr />
        <h4>제목</h4>
        <div>{{ article.title }}</div>
        <br />
        <h4>내용</h4>
        <div>{{ article.content }}</div>
        <div>
          <p class="p-3 m-3" id="article-content"></p>
          <br />
          <div class="files">
            <div>
              <span id="file-cnt">{{ fileCnt }}</span
              >개의 첨부파일
            </div>
            <div id="fileList"></div>
          </div>
        </div>
        <br />
        <div>
          <div>
            <span id="comment-count">{{ comments.length }}</span> 개의 댓글
          </div>
          <br />
          <ul id="comment-list">
            <ReviewListRow v-for="(comment, index) in comments" :comment="comment" />
          </ul>
          <br />
          <div>
            <h4>댓글 작성</h4>
            <input type="text" id="comment-content" v-model="commentContent" style="width: 500px" />
            <button id="comment-btn" @click="createComment">작성</button>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import http from '@/util/http-common.js'
import ReviewListRow from '@/components/article/ReviewListRow.vue'

const route = useRoute()

const article = ref({})
const comments = ref([])
const fileCnt = ref(0)
const commentContent = ref('')
const loginUser = JSON.parse(localStorage.getItem('loginUser'))
const articleId = route.params.id

onMounted(() => {
  // 게시글 상세 조회
  http
    .get(`/articleapi/${articleId}`, {
      params: {
        articleId,
        userSeq: loginUser.userSeq
      }
    })
    .then(({ data }) => {
      article.value = data
    })

  // 첨부 파일 조회
  http.get(`/articleapi/${articleId}/files`).then(({ data }) => {
    fileCnt.value = data.length
  })

  // 댓글 조회
  getComments()
})

const getComments = function () {
  http.get(`/articleapi/${articleId}/comments`).then(({ data }) => {
    comments.value = data
  })
}

const createComment = function () {
  if (commentContent.value == '') {
    alert('댓글을 작성해주세요.')
    return
  }

  http
    .post(`/articleapi/${articleId}/comments`, {
      content: commentContent.value,
      userSeq: loginUser.userSeq,
      articleId: article.value.articleId,
      boardId: article.value.boardId
    })
    .then(() => {
      alert('댓글이 작성되었습니다.')
      commentContent.value = ''
      getComments()
    })
}
</script>

<style scoped></style>
