<template>
  <li>
    <RouterLink :to="`/product/${product.pCode}`" class="product-pCode">{{
      product.pCode
    }}</RouterLink>
    <div class="product-name">{{ product.pName }}</div>
    <div class="product-price">{{ product.price }}원</div>
  </li>
</template>

<script setup>
const props = defineProps({
  product: Object,
});
</script>

<style scoped></style>
