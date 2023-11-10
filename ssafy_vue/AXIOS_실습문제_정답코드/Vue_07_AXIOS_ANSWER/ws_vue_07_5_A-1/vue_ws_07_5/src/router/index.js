import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import BoardView from '../views/board/BoardView.vue'
import ArticleView from '../views/article/ArticleView.vue'
import UserLoginView from '../views/user/UserLoginView.vue'
import UserSignupView from '../views/user/UserSignupView.vue'
import UserMyPageView from '../views/user/UserMyPageView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: UserLoginView
    },
    {
      path: '/signup',
      name: 'signup',
      component: UserSignupView
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: UserMyPageView,
      meta: { requiresAuth: true }
    },
    {
      path: '/user/modify',
      name: 'user-modify',
      component: () => import('../views/user/UserModifyView.vue'),
      meta: { requiresAuth: true }
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      redirect: '/board/',
      children: [
        {
          path: '',
          name: 'board-list',
          component: () => import('../views/board/BoardListView.vue')
        },
        {
          path: 'create',
          name: 'board-create',
          component: () => import('../views/board/BoardCreateView.vue'),
          meta: { requiresAuth: true }
        },
        {
          path: 'detail/:id',
          name: 'board-detail',
          component: () => import('../views/board/BoardDetailView.vue')
        }
      ]
    },
    {
      path: '/article',
      name: 'article',
      component: ArticleView,
      children: [
        {
          path: 'detail/:id',
          name: 'article-detail',
          component: () => import('../views/article/ArticleDetailView.vue'),
          meta: { requiresAuth: true }
        },
        {
          path: 'write/:boardId',
          name: 'article-write',
          component: () => import('../views/article/ArticleWriteView.vue'),
          meta: { requiresAuth: true }
        }
      ]
    }
  ]
})

router.beforeEach((to, from, next) => {
  // requiresAuth 메타 필드를 체크
  const requiresAuth = to.matched.some((record) => record.meta.requiresAuth)
  // loginUser 가져오기
  const loginUser = localStorage.getItem('loginUser')

  if (!requiresAuth) {
    next()
    return
  }

  if (loginUser) {
    next()
  } else {
    next({ name: 'login' })
  }
})

export default router
