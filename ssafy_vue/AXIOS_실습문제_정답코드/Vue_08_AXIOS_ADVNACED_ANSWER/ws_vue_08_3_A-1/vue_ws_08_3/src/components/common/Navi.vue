<template>
  <div>
    <div class="header">
      <RouterLink to="/" class="logo">도서관리</RouterLink>
      <div id="nav">
        <RouterLink to="/book" class="nav-link">도서목록</RouterLink>
        <RouterLink to="/about" class="nav-link">About</RouterLink>
      </div>
    </div>
  </div>
</template>

<script setup></script>

<style>
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 50px;
  background-color: #fafafa;
  box-shadow: 0px 1px 10px rgba(0, 0, 0, 0.3);
}
.nav-link {
  text-decoration: none;
  margin: 0 15px;
  font-size: 18px;
  color: #555;
  transition: color 0.3s ease;
}
.nav-link:hover {
  color: #007bff;
}
.logo {
  font-size: 30pt;
  font-weight: bold;
  color: #333;
  text-decoration: none;
}
</style>
