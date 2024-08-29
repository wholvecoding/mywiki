import  axios from 'axios'
import  store from '@/store'
import  qs from 'qs'
// 这部分是对axios的配置，主要用于实现拦截器和请求器
axios.defaults.baseURL =store.state.baseURL //这是所有页面的源地址，以这个开始
axios.interceptors.request.use(config=>{
    if(store.state.token){
        config.headers.Authorization = store.state.token
    }
    if(config.method==='post'||config.method==='put'||config.method==='get'){
        if(typeof(config.data)!=='string'){
            config.data = qs.stringify(config.data)
        }
    }
    return config
},error=>{
    return Promise.reject(error)
})
axios.interceptors.response.use(({data})=>{
    switch(data.code){
        case '10043':
            console.log("自定义状态")
            break
        default:
            break
    }
    return Promise.resolve(data)
},error=>{
    if(error.response){
        if(error.response.status===403){
            console.log("403没有权限")
        }
        if(error.response.status===500){
            console.log("500，服务器错误")
        }
        return Promise.reject(error.response.data)
    }
})
