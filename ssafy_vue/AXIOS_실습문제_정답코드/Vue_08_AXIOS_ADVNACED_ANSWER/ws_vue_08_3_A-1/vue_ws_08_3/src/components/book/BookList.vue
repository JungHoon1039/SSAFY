<template>
  <div id="container">
    <h1 class="underline">도서 목록</h1>
    <div style="text-align: right">
      <button class="sort-btn" @click="sortBooks('priceAsc')">
        가격 오름차순
      </button>
      <button class="sort-btn" @click="sortBooks('priceDesc')">
        가격 내림차순
      </button>
      <button class="sort-btn" @click="sortBooks('title')">제목 순</button>
      <RouterLink :to="`/book/create`">도서등록</RouterLink>
    </div>
    <div v-if="books.length">
      <table id="book-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 20%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>ISBN</th>
            <th>제목</th>
            <th>저자</th>
            <th>가격</th>
          </tr>
        </thead>
        <tbody>
          <ListRow
            v-for="(book, index) in books"
            :key="index"
            :no="`${index + 1}`"
            :isbn="book.isbn"
            :title="book.title"
            :author="book.author"
            :price="book.price"
          />
        </tbody>
      </table>
    </div>
    <div v-else class="text-center">게시글이 없습니다.</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import ListRow from "@/components/book/include/ListRow.vue";
import http from "@/util/http-common";

const books = ref([]);

onMounted(() => {
  http.get("").then(({ data }) => {
    books.value = data;
  });
});

const sortBooks = (criteria) => {
  switch (criteria) {
    case "priceAsc":
      books.value.sort((a, b) => parseFloat(a.price) - parseFloat(b.price));
      break;
    case "priceDesc":
      books.value.sort((a, b) => parseFloat(b.price) - parseFloat(a.price));
      break;
    case "title":
      books.value.sort((a, b) => a.title.localeCompare(b.title));
      break;
  }
};
</script>
<style>
#container {
  padding: 20px;
  background-color: #f9f9f9;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  margin: 20px 0;
}

.underline {
  border-bottom: 2px solid #333;
  display: inline-block;
  padding-bottom: 5px;
}

#book-list {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

#book-list th,
#book-list td {
  border: 1px solid #ccc;
  padding: 10px;
  text-align: center;
}

.text-center {
  text-align: center;
}

.sort-btn {
  margin-right: 10px;
  padding: 5px 10px;
  border: none;
  background-color: #e6e6e6;
  cursor: pointer;
  border-radius: 4px;
  transition: background-color 0.3s;
}

.sort-btn:hover {
  background-color: #d4d4d4;
}
</style>
