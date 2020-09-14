import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'    // 添加登录拦截
import './plugins/element.js'
import axios from 'axios'
import './assets/scss/custom.scss';
import API from "./router/API";

import mavonEditor from 'mavon-editor'

Vue.prototype.$serverUrl = API;
Vue.config.productionTip = false;
Vue.prototype.$axios = axios;
Vue.use(mavonEditor);

import Vditor from 'vditor'

new Vue({
  router,
  store,  // 添加登录拦截
  render: h => h(App)
}).$mount('#app');



// 添加登录拦截
router.beforeEach((to ,from ,next ) =>{

  if (to.meta.requireAuth){
    if (store.state.user.username){
      next()
    }
    else{ 
      next(
        {
          path: 'LoginIn',
          query :{redirect:to.fullPath}
        }
      )
    }
  }
  else{
    next()
  }
}


)