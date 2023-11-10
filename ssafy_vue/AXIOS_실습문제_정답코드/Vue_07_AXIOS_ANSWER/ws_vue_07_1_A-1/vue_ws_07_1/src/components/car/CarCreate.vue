<template>
  <div class="container">
    <h2>자동차 등록</h2>
    <fieldset class="text-center">
      <label for="vin">자동차등록번호</label>
      <input type="text" id="vin" v-model="vin" class="view" /><br />
      <label for="modelName">모델 명</label>
      <input
        type="text"
        id="modelName"
        v-model="modelName"
        class="view"
      /><br />
      <label for="color">색상</label>
      <input type="text" id="color" v-model="color" class="view" /><br />
      <label for="mileage">주행 거리</label>
      <input type="number" id="mileage" v-model="mileage" class="view" /><br />
      <button class="btn" @click="createCar">등록</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import router from "@/router";
import http from "@/util/http-common";

// data
const vin = ref("");
const modelName = ref("");
const color = ref("");
const mileage = ref("");

const emit = defineEmits();

const createCar = () => {
  http
    .post("/", {
      vin: vin.value,
      modelName: modelName.value,
      color: color.value,
      mileage: mileage.value,
    })
    .then(({ data }) => {
      let msg = "등록 처리시 문제가 발생했습니다.";
      if (data === "success") {
        msg = "등록이 완료되었습니다.";
      }
      alert(msg);
      router.push("/car");
    });
};
</script>

<style>
/* content CSS */

.container {
  margin: 0px 30px;
}

label {
  display: inline-block;
  width: 130px;
}

.text-center {
  text-align: center;
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
</style>
