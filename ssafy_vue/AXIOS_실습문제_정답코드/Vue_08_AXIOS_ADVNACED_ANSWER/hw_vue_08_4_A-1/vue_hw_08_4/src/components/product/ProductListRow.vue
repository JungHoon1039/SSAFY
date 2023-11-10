<template>
  <li>
    <RouterLink :to="`/product/${product.pCode}`" class="product-pCode">{{
      product.pCode
    }}</RouterLink>
    <div class="product-name">{{ product.pName }}</div>
    <div class="product-price">{{ numberWithCommas(product.price) }}원</div>
  </li>
</template>

<script setup>
const props = defineProps({
  product: Object,
});

const numberWithCommas = (x) => {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
};
</script>

<style scoped></style>
