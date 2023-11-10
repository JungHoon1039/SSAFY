import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/HomeView.vue";
import Movie from "../views/MovieView.vue";
import MovieList from "@/components/movie/MovieList.vue";
import MovieCreate from "@/components/movie/MovieCreate.vue";
import MovieDetail from "@/components/movie/MovieDetail.vue";
import MovieModify from "@/components/movie/MovieModify.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/movie",
    component: Movie,
    children: [
      {
        path: "",
        name: "MovieList",
        component: MovieList,
      },
      {
        path: "create",
        name: "MovieCreate",
        component: MovieCreate,
      },
      {
        path: ":movieId",
        name: "MovieDetail",
        component: MovieDetail,
      },
      {
        path: ":movieId/modify",
        name: "MovieModify",
        component: MovieModify,
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
