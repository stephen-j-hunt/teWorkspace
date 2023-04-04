<template>
  <div id="app" class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
      <router-link :to="{ name: 'products' }"> Back to Products </router-link>
      <router-link :to="{ name: 'add-review', params: { id: product.id } }">
        AddReview
      </router-link>
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
import AverageSummary from "../components/AverageSummary.vue";
import StarSummary from "../components/StarSummary.vue";
import ReviewList from "../components/ReviewList.vue";

export default {
  name: "product-detail-view",
  created() {
    // after component is initialized but before being mounted to the DOM
    const productId = this.$route.params.id;
    console.log(this.$route);
    this.$store.commit("SET_ACTIVE_PRODUCT", productId);
  },
  computed: {
    product() {
      return this.$store.getters.product;
    },
  },
  components: {
    AverageSummary,
    StarSummary,
    ReviewList,
    
  },
};
</script>

<style scoped>
</style>









