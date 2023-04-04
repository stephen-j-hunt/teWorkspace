<template>
  <div class="products">
    <h1>Products</h1>
    <product-list />
  </div>
</template>
<script>
import ProductList from "../components/ProductsList.vue";

export default {
  name: "products-view",
  components: {
    ProductList,
  },
};
</script>

 <style scoped>
</style>