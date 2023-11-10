<template>
  <div class="container">
    <h1>영화 상세 정보</h1>
    <fieldset class="detail-content">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="movie.title" class="view" /><br />
      <label for="director">감독</label>
      <input
        type="text"
        id="title"
        v-model="movie.director"
        class="view"
      /><br />
      <label for="genre">장르</label>
      <select id="genre" v-model="movie.genre" class="view">
        <option v-for="item in genres" :key="item.id" :value="item.name">
          {{ item.name }}
        </option></select
      ><br />
      <label for="runningTime">상영시간</label>
      <input
        type="text"
        id="title"
        v-model="movie.runningTime"
        class="view"
      /><br />
      <button class="btn" @click="modifyMovie">완료</button>
      <button class="btn" @click="deleteyMovie">삭제</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import http from "@/util/http-common";

const movie = ref({
  title: "",
  director: "",
  genre: "",
  runningTime: "",
});

const genres = [
  { name: "범죄", id: 1 },
  { name: "스릴러", id: 2 },
  { name: "모험", id: 3 },
  { name: "액션", id: 4 },
  { name: "드라마", id: 5 },
  { name: "판타지", id: 6 },
];

const route = useRoute();
const idParam = route.params.movieId;

const router = useRouter();

const deleteyMovie = () => {
  alert("추후 구현할 기능입니다");
};

const modifyMovie = () => {
  http
    .put(`/${idParam}`, {
      id: idParam,
      title: movie.value.title,
      director: movie.value.director,
      genre: movie.value.genre,
      runningTime: movie.value.runningTime,
    })
    .then(({ data }) => {
      let msg = "수정 처리시 문제가 발생했습니다.";
      if (data === "success") {
        msg = "수정이 완료되었습니다.";
      }
      alert(msg);
      router.push("/movie");
    });
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
