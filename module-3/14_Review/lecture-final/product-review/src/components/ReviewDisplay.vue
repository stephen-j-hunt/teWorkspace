<template>
  <div
    class="review"
    v-bind:class="{ favorited: review.favorited }"
    v-bind:key="review.id"
  >
    <h4>{{ review.reviewer }}</h4>
    <star-rating :rating="review.rating" size="medium" />
    <h3>{{ displayTitle }}</h3>
    <p>{{ review.review }}</p>
    <p>
      Favorite?
      <input
        type="checkbox"
        v-bind:checked="review.favorited"
        @change="onFavoritedChange()"
      />
    </p>
  </div>
</template>

<script>
import StarRating from "./StarRating.vue"; // step 1

export default {
  name: "review-display",
  components: {
    StarRating, // step 2
  },
  props: ["review"],
  methods: {
    onFavoritedChange() {
      this.$store.commit("FLIP_FAVORITED", this.review);
    },
  },
  computed: {
    displayTitle() {
      return this.review.title.substring(0, 10);
    },
  },
};
</script>

<style scoped>
div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}
</style>
