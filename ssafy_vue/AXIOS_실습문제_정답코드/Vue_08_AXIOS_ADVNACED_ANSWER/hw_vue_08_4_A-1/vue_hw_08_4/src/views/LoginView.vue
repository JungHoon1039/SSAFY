<template>
  <div class="form-div">
    <form v-on:submit.prevent>
      <div class="form-control">
        <h1>로그인</h1>
      </div>
      <div class="form-control">
        <div class="form-line"></div>
      </div>
      <div class="form-control">
        <label for="userId">아이디 : </label>
        <input name="userId" id="userId" type="text" v-model="user.userId" />
      </div>
      <div class="form-control">
        <label for="password">비밀번호 : </label>
        <input
          name="password"
          id="password"
          type="password"
          v-model="user.password"
        />
      </div>
      <div class="form-control">
        <div class="form-line"></div>
      </div>
      <div class="form-control">
        <button @click="login">로그인</button>
        <button type="reset">초기화</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import http from "@/util/http-login";

const router = useRouter();

const emit = defineEmits(["login-user"]);

const user = ref({
  userId: "",
  password: "",
});

const login = () => {
  http
    .post("", {
      userId: user.value.userId,
      userPass: user.value.password,
    })
    .then(({ data }) => {
      emit("login-user", data);
      alert("로그인 성공");
      router.push({ name: "Home" });
    })
    .catch((err) => {
      console.log(err);
    });
};
</script>

<style scoped></style>
