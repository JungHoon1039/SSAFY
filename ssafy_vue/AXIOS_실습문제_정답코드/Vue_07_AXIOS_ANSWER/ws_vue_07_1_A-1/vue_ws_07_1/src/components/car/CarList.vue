<template>
  <div class="container">
    <h2>자동차 목록</h2>
    <h4>등록된 자동차의 수 : {{ carCnt }}</h4>
    <hr />
    <div v-if="carCnt">
      <table class="car-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>자동차등록번호</th>
            <th>모델 명</th>
            <th>색상</th>
            <th>주행 거리</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(car, index) in cars" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <RouterLink :to="`/car/${car.vin}`">{{ car.vin }}</RouterLink>
            </td>
            <td>{{ car.modelName }}</td>
            <td>{{ car.color }}</td>
            <td>{{ car.mileage }} km</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>등록된 자동차가 없습니다.</div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { RouterLink } from "vue-router";
import http from "@/util/http-common";

const cars = ref([]);
const carCnt = computed(() => cars.value.length);

onMounted(() => {
  // axios의 get을 이용하여 비동기방식으로 서버와 통신.
  http.get("").then(({ data }) => {
    cars.value = data;
  });
});
</script>

<style>
/* content CSS */

.container {
  margin: 0px 30px;
}

/* 테이블 CSS */
.car-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.car-list td,
.car-list th {
  border: 1px solid black;
}
</style>
