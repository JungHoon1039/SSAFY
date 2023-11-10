import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/HomeView.vue";
import Car from "../views/CarView.vue";
import CarList from "@/components/car/CarList.vue";
import CarCreate from "@/components/car/CarCreate.vue";
import CarDetail from "@/components/car/CarDetail.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/car",
    component: Car,
    children: [
      {
        path: "",
        name: "CarList",
        component: CarList,
      },
      {
        path: "create",
        name: "CarCreate",
        component: CarCreate,
      },
      {
        path: ":vin",
        name: "CarDetail",
        component: CarDetail,
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
