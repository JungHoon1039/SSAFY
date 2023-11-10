<template>
  <main>
    <div class="form-div">
      <div class="form-control">
        <h1>맛집 수정</h1>
      </div>
      <div class="form-control">
        <div class="form-line"></div>
      </div>
      <div class="form-control">
        <label for="resId">식당 번호</label>
        <input
          name="resId"
          id="resId"
          type="number"
          v-model="restaurant.resId"
          readonly
          ref="resId"
        />
      </div>
      <div class="form-control">
        <label for="resName">식당이름 :</label>
        <input name="resName" id="resName" type="text" v-model="restaurant.resName" ref="resName" />
      </div>
      <div class="form-control">
        <label for="resAddress">식당위치 :</label>
        <input
          name="resAddress"
          id="resAddress"
          type="text"
          v-model="restaurant.resAddress"
          ref="resAddress"
        />
      </div>
      <div class="form-control">
        <label for="signatureMenu">대표메뉴 :</label>
        <input
          name="signatureMenu"
          id="signatureMenu"
          type="text"
          v-model="restaurant.signatureMenu"
          ref="signatureMenu"
        />
      </div>
      <div class="form-control">
        <label for="resRate">별점 :</label>
        <input
          name="resRate"
          id="resRate"
          type="number"
          v-model="restaurant.resRate"
          ref="resRate"
        />
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
  </main>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import http from '@/utils/http-common.js'

const router = useRouter()
const route = useRoute()

const restaurant = ref({
  resId: 0,
  resName: '',
  resAddress: '',
  signatureMenu: '',
  resRate: 0
})
const resId = ref(null)
const resName = ref(null)
const resAddress = ref(null)
const signatureMenu = ref(null)
const resRate = ref(null)

onMounted(() => {
  const resId = route.params.resId
  http.get(`/restaurantapi/res/${resId}`).then(({ data }) => {
    restaurant.value = data
  })
})

const checkValue = function () {
  let valid = true
  let msg = ''
  !restaurant.value.resName &&
    ((msg = '식당이름을 입력해주세요.'), (valid = false), resName.value.focus())
  valid &&
    !restaurant.value.resAddress &&
    ((msg = '식당주소를 입력해주세요.'), (valid = false), resAddress.value.focus())
  valid &&
    !restaurant.value.signatureMenu &&
    ((msg = '대표메뉴를 입력해주세요.'), (valid = false), signatureMenu.value.focus())
  valid &&
    !restaurant.value.resRate &&
    ((msg = '별점을 입력해주세요.'), (valid = false), resRate.value.focus())
  if (!valid) {
    alert(msg)
  } else {
    http.put(`/restaurantapi/res`, restaurant.value).then(({ data }) => {
      console.log('mod', data)
      alert('식당이 수정되었습니다.')
      moveList()
    })

    moveList()
  }
}

const moveList = function () {
  router.push({ name: 'RestaurantList' })
}
</script>

<style scoped></style>
