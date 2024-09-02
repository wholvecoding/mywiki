
import HomePage from '../components/HomePage.vue'
import { createRouter, createWebHistory } from 'vue-router';


import XSPage from "@/components/Pages/XSPage.vue";
import ComputerPage from "@/components/Pages/ComputerPage.vue";
import BookDetail from "@/components/Pagetools/BookDetail.vue";
import BookReader from "@/components/Pagetools/BookReader.vue";
import BookPage from "@/components/Pagetools/BookPage.vue";




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
    },
    {
        path:'/book/:ebookId',
        component: BookDetail,
        props:true

    },
    {
        path: '/book/:ebookId/read',
        name: 'BookReader',
        component: BookReader,
        props:true
    },
    {
        path:'/book/:ebookId/read/:chapterId',
        name:"BookPage",
        component: BookPage,
        props:true
    }

]

const router =createRouter({
    history:createWebHistory(),
    routes
});

export default router; // 导出路由实例
