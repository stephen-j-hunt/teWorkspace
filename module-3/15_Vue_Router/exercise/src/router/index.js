import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue'
import MyBooks from '../views/MyBooks.vue'
import NewBookForm from '../views/NewBook.vue'


Vue.use(VueRouter);

const routes = [
  { name: 'home', path: '/', component: Home },
  { name: 'my-books', path: '/myBooks', component: MyBooks },
  { name: 'new-book', path: '/addBook', component: NewBookForm }


];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
