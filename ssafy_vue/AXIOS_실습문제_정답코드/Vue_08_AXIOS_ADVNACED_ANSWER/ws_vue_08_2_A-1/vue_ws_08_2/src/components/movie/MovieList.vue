<template>
  <div class="container">
    <h2>영화 목록</h2>
    <h4>등록된 영화의 수 : {{ movieCnt }}</h4>
    <hr />
    <div v-if="movies.length">
      <table class="movie-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>ID</th>
            <th>제목</th>
            <th>감독</th>
            <th>장르</th>
            <th>상영시간</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(movie, index) in movies" :key="index">
            <td>{{ movie.id }}</td>
            <!-- 클릭시 상세정보로 이동할 수 있게 바인딩하여 링크생성 -->
            <td>
              <RouterLink :to="`/movie/${movie.id}`">{{
                movie.title
              }}</RouterLink>
            </td>
            <td>{{ movie.director }}</td>
            <td>{{ movie.genre }}</td>
            <td>{{ movie.runningTime }}분</td>
          </tr>
        </tbody>
      </table>
      <GenreChart :genresData="genreCounts" />
    </div>
    <div v-else>등록된 영화가 없습니다.</div>
  </div>
</template>
<script setup>
import { ref, onMounted, computed, reactive } from "vue";
import { RouterLink } from "vue-router";
import http from "@/util/http-common";
import GenreChart from "@/components/movie/include/GenreChart.vue";

const movies = ref([]);
const movieCnt = computed(() => movies.value.length);

const genreCounts = reactive({}); // 장르별 카운트를 저장하기 위한 객체

onMounted(() => {
  // axios의 get을 이용하여 비동기방식으로 서버와 통신.
  http.get("").then(({ data }) => {
    movies.value = data;

    // 장르별 영화 수를 계산
    data.forEach((movie) => {
      if (!genreCounts[movie.genre]) {
        genreCounts[movie.genre] = 1;
      } else {
        genreCounts[movie.genre]++;
      }
    });
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
