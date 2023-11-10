import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import LoginView from "../views/LoginView.vue";
import ProductMainView from "../views/ProductMainView.vue";
import ProductCreate from "../components/product/ProductCreate.vue";
import ProductList from "../components/product/ProductList.vue";
import ProductView from "../components/product/ProductView.vue";
import ProductModify from "../components/product/ProductModify.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/login",
    name: "Login",
    component: LoginView,
  },
  {
    path: "/product",
    component: ProductMainView,
    children: [
      {
        path: "",
        name: "ProductList",
        component: ProductList,
      },
      {
        path: "create",
        name: "ProductCreate",
        component: ProductCreate,
      },
      {
        path: ":pCode",
        name: "ProductView",
        component: ProductView,
      },
      {
        path: ":pCode/modify",
        name: "ProductModify",
        component: ProductModify,
      },
    ],
    redirect: () => {
      return "/product";
    },
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
