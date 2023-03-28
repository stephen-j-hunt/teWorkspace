<template>
  <div class="main">
    <h2>Product Review for {{ name }}</h2>
    <p class="description">{{ description }}</p>

    <div class="review" v-for="review in reviews" v-bind:key="review.id">
      <h4>{{ reviewer }}</h4>
      <div class="rating">
        <img src="../assets/star.png" alt="" class="ratingStar" />
      </div>
      <h3>{{ title }}</h3>
      <p>{{ review }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    /*this needs to return a data object*/
    return {
      name: "Cigar Parties",
      description: "Plan and host a cigar party for your friends",
      reviews: [
        {
          id: 1,
          reviewer: "stephen",
          title: "great read",
          review: "this is a horrible product",
          rating: 5,
        },
        {
          id: 2,
          reviewer: "mike",
          title: "bad read",
          review: "this is a great product",
          rating: 3,
        },
      ],
    };
  },
};
</script>

<style scoped>
/*dont forget to add scoped here*/
div.main {
  margin: 1rem 0;
}
</style>