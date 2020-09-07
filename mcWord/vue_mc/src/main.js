import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import axios from 'axios'
import './assets/scss/custom.scss';
import API from "./router/API";

import mavonEditor from 'mavon-editor'

Vue.prototype.$serverUrl = API;
Vue.config.productionTip = false;
Vue.prototype.$axios = axios;
Vue.use(mavonEditor);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
