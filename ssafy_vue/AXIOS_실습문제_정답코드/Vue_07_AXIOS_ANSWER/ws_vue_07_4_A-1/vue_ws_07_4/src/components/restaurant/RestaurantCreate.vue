<template>
  <main>
    <div class="form-div">
      <div class="form-control">
        <h1>맛집 등록</h1>
      </div>
      <div class="form-control">
        <div class="form-line"></div>
      </div>
      <div class="form-control">
        <label for="resId">식당번호 :</label>
        <input name="resId" id="resId" type="number" v-model="restaurant.resId" ref="resId" />
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
        <label for="resFile">파일 :</label>
        <input name="file" id="resFile" type="file" ref="resFile" />
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
  </main>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import http from '@/utils/http-common.js'

const router = useRouter()
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
const resFile = ref(null)

const makeFormData = function () {
  // multipart/form-data는 json형식으로 보낼수 없으니 FormData를 사용한다.
  let formData = new FormData()
  formData.append('resId', restaurant.value.resId)
  formData.append('resName', restaurant.value.resName)
  formData.append('resAddress', restaurant.value.resAddress)
  formData.append('signatureMenu', restaurant.value.signatureMenu)
  formData.append('resRate', restaurant.value.resRate)
  if (resFile.value != null) {
    formData.append('file', resFile.value.files[0])
  }
  return formData
}

const checkValue = function () {
  let valid = true
  let msg = ''
  !restaurant.value.resId &&
    ((msg = '식당번호를 입력해주세요.'), (valid = false), resId.value.focus())
  valid &&
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
  valid &&
    !resFile.value.files[0] &&
    ((msg = '사진을 첨부해주세요.'), (valid = false), resFile.value.focus())
  if (!valid) {
    alert(msg)
  } else {
    const formData = makeFormData()

    http
      .post(`/restaurantapi/res`, formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
      .then(({ data }) => {
        alert('식당이 등록되었습니다.')
        moveList()
      })
  }
}

const moveList = () => {
  router.push('/restaurants')
}
</script>

<style></style>
