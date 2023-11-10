<template>
  <div>
    <div class="review-list">
      <ul v-if="reviews.length">
        <li v-for="(review, index) in reviews" :key="index">
          <span>
            <h3>{{ review.writer }}</h3>
          </span>
          <!-- 로그인한 사용자와 리뷰 작성자가 같은 경우에만 삭제 버튼을 보여줍니다 -->
          <button
            v-if="user && user.userName === review.writer"
            @click="deleteReview(review.reviewId)"
          >
            삭제
          </button>
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
        <div class="form-control" v-if="getUser">
          <h4>내용</h4>
          <textarea
            name="content"
            v-model="review.content"
            ref="content"
          ></textarea>
        </div>
        <div class="form-control">
          <button @click="checkReviewValue" v-if="getUser">등록</button>
          <button @click="redirectToLogin" v-else>로그인하기</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed, inject } from "vue";
import http from "../../util/http-product";
import { useRoute, useRouter } from "vue-router";

const props = defineProps({
  pCode: String,
});

const route = useRoute();
const router = useRouter();

const review = ref({
  writer: "",
  content: "",
});

const user = inject("user");

const reviews = ref([]);
const getUser = computed(() => !!user.value);

const pCode = route.params.pCode;

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

// 로그인 안 됐다면 로그인 페이지로
const redirectToLogin = () => {
  router.push("/login");
};

// 리뷰 작성 로직
const checkReviewValue = () => {
  if (!review.value.content) {
    alert("내용을 체워주세요");
    return;
  }

  const newReview = {
    pCode: pCode,
    writer: user.value.userName,
    content: review.value.content,
  };

  http
    .post("/review", newReview)
    .then(({ data }) => {
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
