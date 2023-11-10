<template>
  <div>
    <div class="review-list">
      <ul v-if="reviews.length">
        <li v-for="(review, index) in reviews" :key="index">
          <span>
            <h3>{{ review.writer }}</h3>
          </span>
          <button @click="deleteReview(review.reviewId)">삭제</button>
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
          <input
            type="text"
            name="writer"
            id="writer"
            v-model="review.writer"
            ref="writer"
          />
          <h4>내용</h4>
          <textarea
            name="content"
            v-model="review.content"
            ref="content"
          ></textarea>
        </div>
        <div class="form-control">
          <button @click="checkReviewValue">등록</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import http from "../../util/http-product";
import { useRoute } from "vue-router";

const route = useRoute();

const props = defineProps({
  pCode: String,
});

const review = ref({
  writer: "",
  content: "",
});

const reviews = ref([]);
const pCode = route.params.pCode; // URL의 pCode 값을 가져옵니다.

onMounted(() => {
  getReviews;
});

// 리뷰 가져오기
const getReviews = () => {
  http
    .get(`/review/${pCode}`)
    .then(({ data }) => {
      if (data) {
        reviews.value = data;
      } else {
        alert("데이터 없음");
      }
    })
    .catch((err) => {
      console.log(err);
      alert("서버에러");
    });
};

// 리뷰 작성 로직
const checkReviewValue = () => {
  if (!review.value.writer || !review.value.content) {
    alert("내용을 체워주세요");
    return;
  }

  const newReview = {
    pCode: pCode,
    writer: review.value.writer,
    content: review.value.content,
  };

  http
    .post("/review", newReview)
    .then(({ data }) => {
      console.log("Returned data:", data);
      alert("댓글이 등록되었습니다.");
      getReviews();
    })
    .catch((err) => {
      console.log(err);
      alert("서버 에러");
    });
};

// 리뷰 삭제 로직
const deleteReview = (reviewId) => {
  console.log(reviewId);
  http
    .delete(`/review/${reviewId}`)
    .then(() => {
      alert("댓글이 삭제되었습니다.");
      const index = reviews.value.findIndex((r) => r.reviewId === reviewId);
      if (index !== -1) {
        reviews.value.splice(index, 1);
      }
    })
    .catch((err) => {
      console.log(err);
      alert("서버 에러");
    });
};
</script>

<style scoped></style>
