<template>
  <main>
    <div class="form-div" v-if="restaurant.resId">
      <div class="form-control">
        <h1>맛집 정보</h1>
      </div>
      <div class="form-control">
        <div class="form-line"></div>
      </div>
      <div class="form-control">
        <label for="resName">식당이름 :</label>
        <input name="resName" id="resName" type="text" v-model="restaurant.resName" readonly />
      </div>
      <div class="form-control">
        <label for="resAddress">식당위치 :</label>
        <input
          name="resAddress"
          id="resAddress"
          type="text"
          v-model="restaurant.resAddress"
          readonly
        />
      </div>
      <div class="form-control">
        <label for="signatureMenu">대표메뉴 :</label>
        <input
          name="signatureMenu"
          id="signatureMenu"
          type="text"
          v-model="restaurant.signatureMenu"
          readonly
        />
      </div>
      <div class="form-control">
        <label for="resRate">별점 :</label>
        <input name="resRate" id="resRate" type="number" v-model="restaurant.resRate" readonly />
      </div>
      <div class="form-control">
        <div class="form-line"></div>
      </div>
      <div class="form-control">
        <button @click="moveModify(restaurant.resId)">수정</button>
        <button @click="deleteRestaurant">삭제</button>
        <button @click="moveList">목록</button>
      </div>
      <div class="form-control">
        <div class="form-line"></div>
      </div>
      <ReviewList :resId="String(restaurant.resId)" />
    </div>
  </main>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import ReviewList from '../review/ReviewList.vue'
import http from '@/utils/http-common.js'

const router = useRouter()
const route = useRoute()
const restaurant = ref({})

onMounted(() => {
  const resId = route.params.resId
  http.get(`/restaurantapi/res/${resId}`).then(({ data }) => {
    restaurant.value = data
  })
})

const deleteRestaurant = () => {
  const resId = route.params.resId
  http.delete(`/restaurantapi/res/${resId}`).then(() => {
    alert('삭제 되었습니다.')
    moveList()
  })
}

const moveList = () => {
  router.push({ name: 'RestaurantList' })
}

const moveModify = (resId) => {
  router.push({
    name: 'RestaurantModify',
    params: { resId: resId }
  })
}
</script>

<style scoped></style>
