<template>
  <main>
    <div class="menu">
      <a class="menufont" href="#"><h4>전체</h4></a> |
      <a class="menufont" href="#"><h4>한식</h4></a> |
      <a class="menufont" href="#"><h4>중식</h4></a> |
      <a class="menufont" href="#"><h4>양식</h4></a> |
      <a class="menufont" href="#"><h4>일식</h4></a> |
      <a class="menufont" href="#"><h4>퓨전</h4></a> |
      <a class="menufont" href="#"><h4>디저트</h4></a>
    </div>
    <form id="searchForm" class="row" ref="searchForm">
      <!-- 현재의 페이지 정보를 hidden으로 관리한다. -->
      <input
        type="hidden"
        name="currentPage"
        id="currentPage"
        v-model="searchCondition.currentPage"
      />
      <span>
        <label class="item">검색 컬럼 : </label>
        <select class="item" name="key" id="key" v-model="searchCondition.key">
          <option value="none">없음</option>
          <option value="resName">이름</option>
          <option value="signatureMenu">대표메뉴</option>
          <option value="resAddress">위치</option>
        </select>
      </span>
      <span>
        <label class="item">검색어:</label>
        <input class="item" type="text" name="word" id="word" v-model="searchCondition.word" />
      </span>
      <span>
        <label class="item">정렬 컬럼:</label>
        <select class="item" name="orderBy" id="orderBy" v-model="searchCondition.orderBy">
          <option value="none">없음</option>
          <option value="resName">이름</option>
          <option value="signatureMenu">대표메뉴</option>
          <option value="resAddress">위치</option>
        </select>
      </span>
      <span>
        <label class="item">정렬 방향:</label>
        <select class="item" name="orderByDir" id="orderByDir" v-model="searchCondition.orderByDir">
          <option value="asc">오름차순</option>
          <option value="desc">내림차순</option>
        </select>
      </span>
      <span>
        <!-- 클릭 시 전송되는 것을 막기 위해 type은 submit이 아니라 button이다. -->
        <input @click="movePage(1)" class="searchBtn" type="button" value="검색" id="btnSearch" />
      </span>
    </form>
    <div class="restaurant-content">
      <div v-if="restaurants?.length" class="restaurant-card">
        <ul class="content">
          <RestaurantListRow
            v-for="(restaurant, index) in restaurants"
            :key="index"
            :restaurant="restaurant"
          />
        </ul>
      </div>
      <div v-else>
        <h1>등록된 맛집이 없습니다.</h1>
      </div>
    </div>
    <ul class="pagination">
      <li class="page-item">
        <a @click.prevent="movePage(1)" class="page-link">최신</a>
      </li>
      <li class="page-item">
        <a
          @click.prevent="movePage(navigation.startRange ? 1 : navigation.startPage - 1)"
          href="#"
          class="page-link"
          >이전</a
        >
      </li>
      <li
        v-for="index in pageList"
        :key="index"
        :class="navigation.currentPage == index ? 'page-item active' : 'page-item'"
      >
        <a @click.prevent="movePage(index)" href="#" class="page-link">{{ index }}</a>
      </li>
      <li class="page-item">
        <a
          @click.prevent="
            movePage(navgation.endRange ? navigation.endPage : navigation.endPage + 1)
          "
          href="#"
          class="page-link"
          >다음</a
        >
      </li>
      <li class="page-item">
        <a @click.prevent="movePage(navigation.totalPageCount)" href="#" class="page-link"
          >마지막</a
        >
      </li>
    </ul>
    <div class="form-control">
      <div class="form-line"></div>
    </div>
    <div class="form-control">
      <button @click="moveCreate">맛집 등록</button>
    </div>
  </main>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import RestaurantListRow from './RestaurantListRow.vue'
import http from '@/utils/http-common.js'

const router = useRouter()
const restaurants = ref([])
const pageList = ref([])
const navigation = ref({
  startRange: Boolean,
  startPage: 1,
  endRange: Boolean,
  endPage: 5,
  currentPage: 1
})
const searchCondition = ref({
  key: 'none',
  orderBy: 'none',
  orderByDir: 'asc',
  word: '',
  currentPage: 1
})

onMounted(() => {
  http.get(`/restaurantapi/res`).then(({ data }) => {
    restaurants.value = data.restaurants
    navigation.value = data.navigation
    makePage()
  })
})

const makePage = function () {
  pageList.value = []
  for (let i = navigation.value.startPage; i <= navigation.value.endPage; i++) {
    pageList.value.push(i)
  }
}
const movePage = function (page) {
  // get 방식은 파라미터를 json 형식으로 보낼수 없다.
  navigation.value.currentPage = page
  searchCondition.value.currentPage = page
  let searchUrl = '/restaurantapi/res?'

  let params =
    `key=${searchCondition.value.key}&` +
    `word=${searchCondition.value.word}&` +
    `orderBy=${searchCondition.value.orderBy}&` +
    `orderByDir=${searchCondition.value.orderByDir}&` +
    `currentPage=${searchCondition.value.currentPage}`
  // 검색 결과
  http.get(searchUrl + params).then(({ data }) => {
    restaurants.value = data.restaurants
    navigation.value = data.navigation
    makePage()
  })
}
const moveCreate = () => {
  router.push('/restaurants/create')
}
</script>

<style scoped>
h1 {
  margin-bottom: 10px;
}
li {
  margin-left: 10px;
}

ul {
  list-style-type: none;
  margin-bottom: 20px;
}

a {
  text-decoration: none;
}

.pagination {
  padding-left: 0;
  justify-content: center;
}
.page-item {
  padding: 5px;
  display: inline-block;
  border: 1px solid black;
}
.active {
  background: black;
}
.active a {
  color: white;
}
#restaurant-list {
  border-collapse: collapse;
  width: 100%;
}

#restaurant-list td,
#restaurant-list th {
  border: 1px solid black;
}

#searchForm {
  border: 2px solid black;
  padding: 10px;
  margin-bottom: 20px;
  display: flex;
  justify-content: space-between;
}
.searchBtn {
  width: 50px;
  height: 30px;
  background-color: aliceblue;
}
.item {
  vertical-align: middle;
  height: 30px;
  margin: 2px;
}
input[type='text'] {
  padding-left: 5px;
}
</style>
