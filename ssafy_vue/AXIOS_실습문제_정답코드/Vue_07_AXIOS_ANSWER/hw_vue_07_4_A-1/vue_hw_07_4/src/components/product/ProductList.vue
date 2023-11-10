<template>
  <div class="text-center">
    <a href="#" class="menu-font">전체</a> |
    <a href="#" class="menu-font">냉장고</a> |
    <a href="#" class="menu-font">노트북</a> |
    <a href="#" class="menu-font">스마트폰</a>
  </div>
  <div class="product-list text-center">
    <div v-if="products.length">
      <ul class="content">
        <ProductListRow
          v-for="(product, index) in products"
          :key="index"
          :product="product"
          class="product-content"
        />
      </ul>
    </div>
    <div v-else>
      <h3>등록된 상품이 없습니다.</h3>
    </div>
  </div>
  <div class="form-control">
    <button @click="moveCreate">상품 등록</button>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import ProductListRow from "./ProductListRow.vue";
import { useRouter } from "vue-router";
import http from "../../util/http-product";

const router = useRouter();
const products = ref([]);

// 컴포넌트가 마운트되면 실행될 코드
onMounted(() => {
  http
    .get("/product")
    .then(({ data }) => {
      if (data) {
        products.value = data.products;
      } else {
        alert("데이터 없음");
      }
    })
    .catch((err) => {
      console.log(err);
      alert("서버에러");
    });
});

const moveCreate = () => {
  router.push("/product/create");
};
</script>

<style scoped></style>
<style scoped></style>
