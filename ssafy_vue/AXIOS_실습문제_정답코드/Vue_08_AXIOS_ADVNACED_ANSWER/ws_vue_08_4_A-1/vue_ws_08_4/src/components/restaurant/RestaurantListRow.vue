<template>
  <li>
    <RouterLink :to="{ name: 'RestaurantView', params: { resId: restaurant.resId } }">
      <img :src="src" width="200" height="200" />
    </RouterLink>
    <h4>{{ restaurant.resName }}</h4>
    <div>대표메뉴 : {{ restaurant.signatureMenu }}</div>
  </li>
</template>

<script setup>
import { computed, toRefs } from 'vue'

const props = defineProps({
  restaurant: Object
})

const { restaurant } = toRefs(props)

const src = computed(() => {
  if (restaurant.value && restaurant.value.fileName) {
    return 'http://localhost:9999/restaurantapi/download?fileName=' + restaurant.value.fileName
  }
  return '/logo.png'
})
</script>

<style scoped></style>
