<template>
  <div>
    <RouterView
      :users="users"
      @create-user="createUser"
      @update-user="updateUser"
      @delete-user="deleteUser"
    />
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import http from "@/util/http-common";

const router = useRouter();
const users = ref([]);

const getUserList = () => {
  http.get("/").then(({ data }) => {
    users.value = data;
  });
};

const createUser = (user) => {
  http
    .post(
      "",
      {},
      {
        params: user,
      }
    )
    .then(({ data }) => {
      alert("회원가입 완료");
      getUserList();
      router.push("/user");
    });
};

// 비밀번호 유효성 체크
const isPasswordValid = (pwd) => {
  return pwd.length >= 8 && /[!@#$%^&*(),.?":{}|<>]/g.test(pwd);
};

// 이메일 유효성 체크
const isEmailValid = (email) => {
  const re =
    /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(String(email).toLowerCase());
};

const updateUser = (user) => {
  if (!isPasswordValid(user.password)) {
    alert("비밀번호는 8자리 이상이며, 특수문자를 포함해야 합니다.");
    return;
  }

  if (!isEmailValid(user.email)) {
    alert("올바른 이메일 형식을 입력해주세요.");
    return;
  }

  const data = {
    id: user.id,
    password: user.password,
    name: user.name,
    email: user.email,
    age: user.age,
  };

  http.put(`/`, data).then(({ data }) => {
    alert("회원 정보 수정 완료");
    getUserList();
    router.push("/user");
  });
};

const deleteUser = (user) => {
  http.delete(`/${id}`).then(({ data }) => {
    alert("회원 삭제 완료");
    getUserList();
    router.push("/user");
  });
};

onMounted(() => {
  getUserList();
});
</script>

<style>
.user-link {
  color: black;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

/* 테이블 CSS */
.user-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.user-list td,
.user-list th {
  border: 1px solid black;
}
</style>
