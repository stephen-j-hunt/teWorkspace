import Vue from 'vue'
import App from './App.vue'//root component 

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
