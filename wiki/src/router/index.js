import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../components/HomePage.vue'
import XSPage from '../components/Pages/XSPage.vue'

const routes = [
    {
        path: '/',
        component: HomePage
    },
    {
        path: '/XS',
        component: XSPage
    }
]
const router = createRouter({
    history: createWebHistory(),
    routes
  });
export default router;