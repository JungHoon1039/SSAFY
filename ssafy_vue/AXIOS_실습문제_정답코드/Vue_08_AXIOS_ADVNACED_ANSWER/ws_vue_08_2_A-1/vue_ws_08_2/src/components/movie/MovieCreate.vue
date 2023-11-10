<template>
  <div class="container">
    <h2>영화 등록</h2>
    <fieldset class="text-center">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" class="view" /><br />
      <label for="director">감독</label>
      <input type="text" id="director" v-model="director" class="view" /><br />
      <!-- 참고 (https://hjh0827.tistory.com/77) -->
      <label for="genre">장르</label>
      <select id="genre" v-model="genre" class="view">
        <option v-for="item in genres" :key="item.id" :value="item.name">
          {{ item.name }}
        </option></select
      ><br />
      <label for="runningTime">상영 시간</label>
      <input
        type="number"
        id="runningTime"
        v-model="runningTime"
        class="view"
      /><br />
      <button class="btn" @click="createMovie">등록</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import router from "@/router";
import http from "@/util/http-common";

const title = ref("");
const director = ref("");
const genre = ref("");
const runningTime = ref("");
const genres = [
  { name: "범죄", id: 1 },
  { name: "스릴러", id: 2 },
  { name: "모험", id: 3 },
  { name: "액션", id: 4 },
  { name: "드라마", id: 5 },
  { name: "판타지", id: 6 },
];

const createMovie = () => {
  http
    .post("", {
      title: title.value,
      director: director.value,
      genre: genre.value,
      runningTime: runningTime.value,
    })
    .then(({ data }) => {
      let msg = "등록 처리시 문제가 발생했습니다.";
      if (data === "success") {
        msg = "등록이 완료되었습니다.";
      }
      alert(msg);
      router.push("/movie");
    });
};
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
