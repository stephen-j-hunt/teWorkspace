<template>
  <div class="Home">
    <new-releases-list />
    <best-seller-list />
  </div>
</template>

<script>
import NewReleasesList from "../components/NewReleasesList.vue";
import BestSellerList from "../components/BestSellerList.vue";

export default {
  name: "home-view",
  components: {
    NewReleasesList,
    BestSellerList,
  },
};
</script>

<style>
</style>