<template>
  <HeaderNav :user="user" @logout="logout" />
  <RouterView @login-user="loginUser" />
  <FooterNav />
</template>

<script setup>
import { ref, onMounted, watch, provide } from "vue";
import HeaderNav from "./components/common/HeaderNav.vue";
import FooterNav from "./components/common/FooterNav.vue";

const user = ref(null);

provide("user", user);

onMounted(() => {
  const savedUser = localStorage.getItem("loginUser");
  if (savedUser) {
    user.value = JSON.parse(savedUser);
  }
});

watch(user, () => {});

const loginUser = (loginUser) => {
  user.value = loginUser;
  localStorage.setItem("loginUser", JSON.stringify(loginUser));
};

const logout = () => {
  user.value = null;
  localStorage.removeItem("loginUser");
};
</script>

<style scoped></style>
