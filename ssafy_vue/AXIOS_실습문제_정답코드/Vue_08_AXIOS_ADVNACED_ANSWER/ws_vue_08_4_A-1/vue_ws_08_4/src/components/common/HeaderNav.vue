<template>
  <header>
    <nav class="container">
      <div>
        <RouterLink to="/" class="header_nav_home">딜리싸피</RouterLink>
      </div>
      <div class="header_nav_search">
        <form action="#">
          <input type="text" placeholder="검색어를 입력해주세요" />
          <button class="button">검색</button>
        </form>
      </div>
      <div class="header_nav_menuitem" v-if="!getUser">
        <RouterLink to="/login" class="router-menu">로그인</RouterLink>
      </div>
      <div class="header_nav_menuitem" v-else>
        <a href="#" @click="logout">로그아웃</a>
        <RouterLink :to="`/${user.userId}/profile`" class="router-menu">프로필</RouterLink>
      </div>
    </nav>
  </header>
</template>

<script setup>
import { watch, computed } from 'vue'
import { RouterLink } from 'vue-router'

const props = defineProps(['user'])
const emit = defineEmits(['logout'])

const getUser = computed(() => !!props.user)

watch(
  () => props.user,
  () => {}
)

const logout = () => {
  emit('logout')
}
</script>

<style scoped>
.header_nav_menuitem > a {
  margin-left: 10px;
}
form > button {
  margin-left: 10px;
}
</style>
