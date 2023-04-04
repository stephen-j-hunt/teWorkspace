import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '../views/Product.vue'
import ProductDetail from '../views/ProductDetail.vue'
import NewReview from '../views/AddReview.vue'
Vue.use(VueRouter)

const routes = [
  { name: 'products', path: '/', component: Products },
  { name: 'product-detail', path: '/product-deets/:id', component: ProductDetail },
  { name: 'add-review', path: '/products/:id/new-review', component: NewReview }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
