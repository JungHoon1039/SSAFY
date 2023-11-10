<template>
  <main class="container d-flex justify-content-around">
    <section class="m-5">
      <div>
        <h3 class="mb-3">SSAFY 게시판에 오신 것을 환영합니다.</h3>
        <p>SSAFY 게시판에서 소통하며 즐겁게 프로그래밍을 공부합시다.</p>
        <br />
        <RouterLink :to="{ name: 'board' }" class="btn btn-primary">게시판 바로가기</RouterLink>
      </div>
      <br />
      <hr />
      <br />
      <div class="d-flex justify-content-around">
        <div class="m-3">
          <h4 class="text-center">
            <span class="badge bg-success">좋아요 Best</span>
          </h4>
          <ol class="list-group list-group-numbered">
            <li v-for="best in bests" class="list-group-item">
              {{ best }}
            </li>
          </ol>
        </div>
        <div class="m-3">
          <h4 class="text-center">
            <span class="badge bg-danger">인기 게시판</span>
          </h4>
          <ol class="list-group list-group-numbered">
            <li v-for="board in boards" class="list-group-item">
              {{ board }}
            </li>
          </ol>
        </div>
      </div>
    </section>
    <aside class="m-5">
      <h4 class="text-center">
        <span class="badge bg-secondary">유저랭킹</span>
      </h4>
      <ol class="list-group list-group-numbered">
        <li v-for="user in users" class="list-group-item">{{ user }}</li>
      </ol>
    </aside>
  </main>
</template>

<script setup>
import { RouterLink } from 'vue-router'
import { ref } from 'vue'

const bests = ref([
  '코딩테스트 공부하는 방법',
  '프론트엔드? 백엔드? 나의 적성은...',
  'Java언어 부수기',
  'Python 단기 학습방법',
  'Javascript의 역사'
])
const boards = ref(['SSAFY 공지사항', '코딩테스트 정보방', '취업 정보방'])
const users = ref(['ssafy.hong', '해피바이러스', '삼식이', '따봉맨', '프린스송'])
</script>

<style scoped></style>
