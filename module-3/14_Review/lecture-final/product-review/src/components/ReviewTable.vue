<template>
  <table>
    <thead>
      <tr>
        <th>Title</th>
        <th>Reviewer</th>
        <th>Review</th>
        <th>Rating</th>
        <th>Favorite</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="review in filteredReviews" :key="review.title">
        <td>{{ review.title }}</td>
        <td>{{ review.reviewer }}</td>
        <td>{{ review.review }}</td>
        <td>
          <star-rating v-bind:rating="review.rating" size="small" />
        </td>
        <td>{{ review.favorited }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import StarRating from "./StarRating.vue"; // step 1

export default {
  name: "review-table",
  components: {
    StarRating, // step 2
  },
  computed: {
    filteredReviews() {
      return this.$store.getters.filteredReviews;
    },
  },
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
.stars {
  display: flex;
}
</style>
