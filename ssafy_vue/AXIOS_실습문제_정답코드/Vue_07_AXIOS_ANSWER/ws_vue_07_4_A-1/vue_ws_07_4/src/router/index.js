import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import RestaurantMainView from '../views/RestaurantMainView.vue'
import RestaurantCreate from '../components/restaurant/RestaurantCreate.vue'
import RestaurantList from '../components/restaurant/RestaurantList.vue'
import RestaurantView from '../components/restaurant/RestaurantView.vue'
import RestaurantModify from '../components/restaurant/RestaurantModify.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginView
  },
  {
    path: '/restaurants',
    component: RestaurantMainView,
    children: [
      {
        path: 'create',
        name: 'RestaurantCreate',
        component: RestaurantCreate
      },
      {
        path: ':resId',
        name: 'RestaurantView',
        component: RestaurantView
      },
      {
        path: 'modify/:resId',
        name: 'RestaurantModify',
        component: RestaurantModify
      },
      {
        path: '',
        name: 'RestaurantList',
        component: RestaurantList
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
