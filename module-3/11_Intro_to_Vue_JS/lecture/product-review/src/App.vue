<template>
  <div id="app">
    <product-review></product-review>
  </div>
</template>

<script>
//this is the model

import ProductReview from "./components/ProductReview.vue";

export default {
  //this is exported with different properties below
  name: "App",
  components: {
    //child components go here
    ProductReview,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
