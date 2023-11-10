<template>
  <div class="form-div">
    <div class="form-control">
      <h1>상품 정보</h1>
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="form-control">
      <label for="pCode">상품코드 :</label>
      <span name="pCode" id="pCode" type="text">{{ product.pCode }}</span>
    </div>
    <div class="form-control">
      <label for="pName">상품이름 :</label>
      <input
        name="pName"
        id="pName"
        type="text"
        v-model="product.pName"
        readonly
      />
    </div>
    <div class="form-control">
      <label for="price">가격 :</label>
      <input
        name="price"
        id="price"
        type="number"
        v-model="product.price"
        readonly
      />
    </div>
    <div class="form-control">
      <label for="quantity">수량 :</label>
      <input
        name="quantity"
        id="quantity"
        type="number"
        v-model="product.quantity"
        readonly
      />
    </div>
    <div class="form-control">
      <label for="brand">브랜드 :</label>
      <input
        name="brand"
        id="brand"
        type="text"
        v-model="product.brand"
        readonly
      />
    </div>
    <div class="form-control">
      <label for="pDesc">설명 :</label>
      <textarea
        name="pDesc"
        id="pDesc"
        type="text"
        v-model="product.pDesc"
        readonly
      ></textarea>
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="form-control">
      <button @click="moveModify(product.pCode)">수정</button>
      <button @click="deleteProduct">삭제</button>
      <button @click="moveList">목록</button>
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <ReviewList :pCode="product.pCode"></ReviewList>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import ReviewList from "../review/ReviewList.vue";
import http from "../../util/http-product";

const router = useRouter();
const route = useRoute();

const product = ref({});

const props = defineProps(["user"]);

onMounted(() => {
  const pCode = route.params.pCode; // URL의 pCode 값을 가져옵니다.
  http
    .get(`/product/${pCode}`)
    .then(({ data }) => {
      if (data) {
        product.value = data;
      } else {
        alert("데이터 없음");
      }
    })
    .catch((err) => {
      console.log(err);
      alert("서버에러");
    });
});

const deleteProduct = () => {
  const pCode = route.params.pCode; // URL의 pCode 값을 가져옵니다.
  http
    .delete(`/product/${pCode}`)
    .then(() => {
      alert("삭제 완료");
      router.push({ name: "ProductList" }); // 상품 목록 페이지로 돌아갑니다.
    })
    .catch((err) => {
      console.log(err);
      alert("서버에러");
    });
};

const moveList = () => {
  router.push({ name: "ProductList" });
};

const moveModify = (pCode) => {
  router.push({
    name: "ProductModify",
    params: { pCode: pCode },
  });
};
</script>
<style scoped></style>
