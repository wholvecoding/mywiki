import Vue from 'vue'
import HomePage from '../components/HomePage.vue'

Vue.use(VueRouter)
const routes = [
    {
        path: '/',
        component: HomePage,
        children: [

        ]
    }
]
