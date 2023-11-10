<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo">영화관리</RouterLink>
      </div>
      <div>
        <RouterLink to="/movie/create" class="nabMenu">영화등록</RouterLink>
        <RouterLink to="/movie" class="nabMenu">영화목록</RouterLink>
      </div>
    </nav>
  </header>
</template>

<script setup></script>

<style>
/* header 태그 안에 CSS 속성 */
header {
  height: 70px;
  background-color: black;
  color: white;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  text-decoration: none;
  color: white;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}

.nabMenu {
  margin: 10px;
}
</style>
