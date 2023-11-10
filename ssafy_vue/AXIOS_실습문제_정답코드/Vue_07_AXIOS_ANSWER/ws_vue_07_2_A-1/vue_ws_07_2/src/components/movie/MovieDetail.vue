<template>
  <div class="container">
    <h1>영화 상세 정보</h1>
    <fieldset class="detail-content">
      <label for="title">제목</label>
      <div class="view">{{ movie.title }}</div>
      <label for="director">감독</label>
      <div class="view">{{ movie.director }}</div>
      <label for="genre">장르</label>
      <div class="view">{{ movie.genre }}</div>
      <label for="runningTime">상영시간</label>
      <div class="view">{{ movie.runningTime }}</div>
      <RouterLink :to="`/movie/${movie.id}/modify`" class="btn"
        >수정</RouterLink
      >
      <button class="btn" @click="deleteyMovie">삭제</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import http from "@/util/http-common";

const movie = ref({});

const deleteyMovie = () => {
  alert("추후 구현할 기능입니다");
};

onMounted(() => {
  const route = useRoute();
  const idParam = route.params.movieId;

  // axios의 get을 이용하여 비동기방식으로 서버와 통신.
  http.get(`/${idParam}`).then(({ data }) => {
    movie.value = data;
  });
});
</script>

<style scoped>
header {
  height: 70px;
  background-color: skyblue;
  line-height: 70px;
  padding: 0px 30px;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

header a:not(.logo) {
  margin-right: 10px;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}
.container {
  margin: 0px 30px;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 80px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px 0;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

/* 테이블 CSS */
.movie-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.movie-list td,
.movie-list th {
  border: 1px solid black;
}

.detail-content {
  padding: 10px 30px;
}
</style>
