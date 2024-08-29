
import HomePage from '../components/HomePage.vue'
import { createRouter, createWebHistory } from 'vue-router';


import XSPage from "@/components/Pages/XSPage.vue";
import ComputerPage from "@/components/Pages/ComputerPage.vue";




const routes = [
    {
        path: '/',
        component: HomePage


    },

    {
        path: '/XS',
        component: XSPage
    },
    {
        path:'/cp',
        component: ComputerPage
    }

]

const router =createRouter({
    history:createWebHistory(),
    routes
});

export default router; // 导出路由实例
