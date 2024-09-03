
import HomePage from '../components/HomePage.vue'
import { createRouter, createWebHistory } from 'vue-router';


import XSPage from "@/components/Pages/XSPage.vue";
import ComputerPage from "@/components/Pages/ComputerPage.vue";
import BookDetail from "@/components/Pagetools/BookDetail.vue";
import BookReader from "@/components/Pagetools/BookReader.vue";
import BookPage from "@/components/Pagetools/BookPage.vue";
import CategoryComponent from "@/components/Pagetools/CategoryComponent.vue";




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
    },
    {
        path: '/category/:categoryId',
        name: 'CategoryPage',
        component: CategoryComponent,
        props: true, // 将route.params作为props传递给组件
    },

]

const router =createRouter({
    history:createWebHistory(),
    routes
});

export default router; // 导出路由实例
