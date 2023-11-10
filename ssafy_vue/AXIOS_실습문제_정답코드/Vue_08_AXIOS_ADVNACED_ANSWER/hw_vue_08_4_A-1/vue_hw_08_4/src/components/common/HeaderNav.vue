Copy code
<template>
  <header>
    <nav class="header-nav">
      <div>
        <h2>
          <RouterLink to="/" class="logo">싸핑몰</RouterLink>
        </h2>
      </div>
      <div class="header-nav-side">
        <form action="#" class="mx-3">
          <input type="text" placeholder="상품이름을 작성하세요." />
          <button @click="searchProduct">검색</button>
        </form>
        <a href="#" class="mx-3">문의사항</a>
        <RouterLink to="/login" class="mx-3" v-if="!getUser">로그인</RouterLink>
        <a href="#" class="mx-3" @click="logout" v-else>로그아웃</a>
      </div>
    </nav>
  </header>
</template>

<script setup>
import { watch, computed } from "vue";
import { RouterLink } from "vue-router";

const props = defineProps(["user"]);
const emit = defineEmits(["logout"]);

const getUser = computed(() => !!props.user);

watch(
  () => props.user,
  () => {}
);

const logout = () => {
  emit("logout");
};
</script>
<style scoped></style>
