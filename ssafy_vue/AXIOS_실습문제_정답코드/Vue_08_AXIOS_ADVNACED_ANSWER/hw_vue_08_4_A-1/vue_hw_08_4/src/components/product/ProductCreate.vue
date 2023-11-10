<template>
  <div class="form-div">
    <div class="form-control">
      <h1>상품 등록</h1>
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="form-control">
      <label for="pCode">상품코드 :</label>
      <input name="pCode" id="pCode" type="text" v-model="product.pCode" />
    </div>
    <div class="form-control">
      <label for="pName">상품이름 :</label>
      <input name="pName" id="pName" type="text" v-model="product.pName" />
    </div>
    <div class="form-control">
      <label for="price">가격 :</label>
      <input name="price" id="price" type="number" v-model="product.price" />
    </div>
    <div class="form-control">
      <label for="quantity">수량 :</label>
      <input
        name="quantity"
        id="quantity"
        type="number"
        v-model="product.quantity"
      />
    </div>
    <div class="form-control">
      <label for="brand">브랜드 :</label>
      <input name="brand" id="brand" type="text" v-model="product.brand" />
    </div>
    <div class="form-control">
      <label for="pDesc">설명 :</label>
      <textarea
        name="pDesc"
        id="pDesc"
        type="text"
        v-model="product.pDesc"
      ></textarea>
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="form-control">
      <button @click="checkValue">등록</button>
      <button type="reset">초기화</button>
      <button @click="moveList">목록</button>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import http from "../../util/http-product";

const router = useRouter();

const product = ref({
  pCode: "",
  pName: "",
  price: 0,
  quantity: 0,
  brand: "",
  pDesc: "",
});

const products = ref([]);

onMounted(() => {
  http
    .get("/product")
    .then(({ data }) => {
      products.value = data.products;
    })
    .catch((err) => {
      console.log(err);
      alert(" 서버 에러 ");
    });
});

const checkValue = () => {
  let valid = true;
  let msg = "";

  // 중복 pCode 체크
  if (products.value.some((p) => p.pCode === product.value.pCode)) {
    alert("이미 등록된 Code 번호입니다.");
    return;
  }

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
  if (!valid) {
    alert(msg);
  } else {
    let formData = new FormData();
    formData.append("pCode", product.value.pCode);
    formData.append("pName", product.value.pName);
    formData.append("price", product.value.price);
    formData.append("quantity", product.value.quantity);
    formData.append("brand", product.value.brand);
    formData.append("pDesc", product.value.pDesc);

    http
      .post("/product", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then(() => {
        alert("상품이 등록되었습니다.");
        moveList();
      })
      .catch((err) => {
        console.log(err);
        alert("서버 에러");
      });
  }
};

const moveList = () => {
  router.push("/product");
};
</script>

<style scoped></style>
