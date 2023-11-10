import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import About from "../views/About.vue";
import Book from "../views/Book.vue";
import BookCreate from "@/components/book/BookCreate.vue";
import BookDetail from "@/components/book/BookDetail.vue";
import BookList from "@/components/book/BookList.vue";
import BookModify from "@/components/book/BookModify.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    component: About,
  },
  {
    path: "/book",
    component: Book,
    children: [
      {
        path: "",
        name: "BookList",
        component: BookList,
      },
      {
        path: "create",
        name: "BookCreate",
        component: BookCreate,
      },
      {
        path: ":bookIsbn",
        name: "BookDetail",
        component: BookDetail,
      },
      {
        path: ":bookIsbn/modify",
        name: "BookModify",
        component: BookModify,
      },
    ],
    redirect: () => {
      return "/book";
    },
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
