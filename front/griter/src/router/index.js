import Vue from 'vue'
// import Vuex from 'vuex';
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PostsView from '@/views/PostsView.vue'
import PostsList from '@/components/posts/PostsList.vue'
import UserView from '@/views/UserView.vue'
import UsersLogin from '@/components/users/UsersLogin.vue'
import UsersRegister from '@/components/users/UsersRegister.vue'
import UsersInfo from '@/components/users/UsersInfo.vue'
import UsersFollows from '@/components/users/UsersFollows.vue'


Vue.use(VueRouter)
// Vue.use(Vuex)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
  },
  {
    path: '/posts',
    component: PostsView,
    children: [
      {
        path: "",
        name: 'PostsList',
        component: PostsList,
      },
    ]
  },
  {
    path: '/users',
    component: UserView,
    children: [
      {
        path: "login",
        name: 'login',
        component: UsersLogin,
      },
      {
        path: "register",
        name: 'register',
        component: UsersRegister,
      },
      {
        path: "follows",
        name: 'follows',
        component: UsersFollows,
      },
      {
        path: ":nickname",
        name: 'userInfo',
        component: UsersInfo,
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
