import { createApp } from 'vue'


import App from './App'
import router from './router'
import axios from "axios";
require('./http')

const app = createApp(App);
app.use(router);
app.mount('#app');
app.config.globalProperties.$axios = axios

