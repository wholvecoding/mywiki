
import  {createApp} from 'vue'
import HomePage from '../components/HomePage.vue'
import { createRouter, createWebHistory } from 'vue-router';


import App from './../App.vue'

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

const router =createRouter({
    history:createWebHistory(),
    routes
});
const app = createApp(App);
app.use(router);
app.mount('#app');

