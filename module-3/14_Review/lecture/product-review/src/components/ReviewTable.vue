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
        <td>{{ review.rating }}</td>
        <td>{{ review.favorited }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "review-table",
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
