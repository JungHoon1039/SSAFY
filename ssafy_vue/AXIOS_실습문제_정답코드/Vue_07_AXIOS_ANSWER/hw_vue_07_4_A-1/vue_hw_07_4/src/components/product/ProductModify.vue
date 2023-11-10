<template>
  <div class="form-div">
    <div class="form-control">
      <h1>상품 수정</h1>
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
        ref="pName"
      />
    </div>
    <div class="form-control">
      <label for="price">가격 :</label>
      <input
        name="price"
        id="price"
        type="number"
        v-model="product.price"
        ref="price"
      />
    </div>
    <div class="form-control">
      <label for="quantity">수량 :</label>
      <input
        name="quantity"
        id="quantity"
        type="number"
        v-model="product.quantity"
        ref="quantity"
      />
    </div>
    <div class="form-control">
      <label for="brand">브랜드 :</label>
      <input
        name="brand"
        id="brand"
        type="text"
        v-model="product.brand"
        ref="brand"
      />
    </div>
    <div class="form-control">
      <label for="pDesc">설명 :</label>
      <textarea
        name="pDesc"
        id="pDesc"
        type="text"
        v-model="product.pDesc"
        ref="pDesc"
      ></textarea>
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="form-control">
      <button @click="checkValue">저장</button>
      <button type="reset">초기화</button>
      <button @click="moveList">목록</button>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import http from "../../util/http-product";

const router = useRouter();
const route = useRoute();

const product = ref({});

onMounted(() => {
  const pCode = route.params.pCode;
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

const checkValue = () => {
  let valid = true;
  let msg = "";
  !product.value.pCode &&
    ((msg = "상품 코드를 입력해주세요."), (valid = false), pCode.value.focus());
  valid &&
    !product.value.pName &&
    ((msg = "상품 이름을 입력해주세요."), (valid = false), pName.value.focus());
  valid &&
    !product.value.price &&
    ((msg = "상품 가격을 입력해주세요."), (valid = false), price.value.focus());
  valid &&
    !product.value.quantity &&
    ((msg = "상품 수량을 입력해주세요."),
    (valid = false),
    quantity.value.focus());
  valid &&
    !product.value.brand &&
    ((msg = "브랜드를 입력해주세요."), (valid = false), brand.value.focus());
  valid &&
    !product.value.pDesc &&
    ((msg = "상품 설명을 입력해주세요."), (valid = false), pDesc.value.focus());
  if (valid) {
    http
      .put("/product", product.value)
      .then(() => {
        alert("상품 정보가 수정되었습니다.");
        moveList();
      })
      .catch((err) => {
        console.log(err);
        alert("서버 에러");
      });
  } else {
    alert(msg);
  }
};

const moveList = () => {
  router.push({ name: "ProductList" });
};
</script>

<style scoped></style>
