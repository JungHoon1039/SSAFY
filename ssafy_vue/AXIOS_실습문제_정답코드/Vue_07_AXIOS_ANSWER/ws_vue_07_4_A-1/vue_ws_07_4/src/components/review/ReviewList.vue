<template>
  <div>
    <div class="review-list">
      <ul v-if="reviews.length">
        <li v-for="(review, index) in reviews" :key="index">
          <span
            ><h3>{{ review.writer }}</h3></span
          ><button @click="deleteReview(review.reviewId)">x</button>
          <p>{{ review.content }}</p>
        </li>
      </ul>
      <h3 v-else>등록된 리뷰가 없습니다.</h3>
    </div>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="review-form">
      <form v-on:submit.prevent>
        <h3 class="left">리뷰 등록</h3>
        <div class="form-control">
          <div class="form-line"></div>
        </div>
        <div class="form-control">
          <span>작성자 :</span>
          <input type="text" name="writer" id="writer" v-model="review.writer" ref="writer" />
          <h4>내용</h4>
          <textarea name="content" v-model="review.content" ref="content"></textarea>
        </div>
        <div class="form-control">
          <button @click="checkReviewValue">등록</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import http from '@/utils/http-common.js'

const props = defineProps({
  resId: String
})

const review = ref({
  writer: '',
  content: ''
})
const reviews = ref([])

onMounted(() => {
  getReviewList()
})

const getReviewList = function () {
  http.get(`/restaurantapi/review/${props.resId}`).then(({ data }) => {
    reviews.value = data
  })
}

const checkReviewValue = () => {
  if (!review.value.writer || !review.value.content) {
    alert('내용을 채워주세요')
    return
  }

  const newReview = {
    resId: props.resId,
    writer: review.value.writer,
    content: review.value.content
  }

  http.post(`/restaurantapi/review`, newReview).then(() => {
    alert('리뷰가 정상적으로 등록됐습니다.')
    review.value.writer = ''
    review.value.content = ''
    // 리뷰 리스트 조회하기
    getReviewList()
  })
}

const deleteReview = (reviewId) => {
  http.delete(`/restaurantapi/review/${reviewId}`).then(() => {
    alert('리뷰가 정상적으로 삭제됐습니다.')
    // 리뷰 리스트 조회하기
    getReviewList()
  })
}
</script>

<style scoped></style>
