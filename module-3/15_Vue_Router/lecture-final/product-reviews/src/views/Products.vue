<template>
  <div class="products">
    <h1>Products</h1>
    <!-- step 3 -->
    <product-list />
  </div>
</template>

<script>
import ProductList from "../components/ProductsList.vue"; // step 1

export default {
  name: "products-view",
  components: {
    ProductList, // step 2
  },
};
</script>

<style scoped>
</style>