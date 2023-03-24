<template>
  <div class="main">
    <h2>Product Review for {{ name }}</h2>
    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>
      <div class="well" v-for="x in 5" v-bind:key="x">
        <span class="amount">{{ countReviewWithRating(x) }}</span>
        {{ x }} Star Ratings
      </div>
    </div>

    <!-- show below here -->
    <div
      class="review"
      v-bind:class="{ favorited: review.favorited === true }"
      v-for="review in reviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          alt="image of a star"
          class="ratingStar"
          v-for="x in review.rating"
          v-bind:key="x"
          v-bind:title="review.rating + ' star review'"
        />
      </div>
      <h3>{{ review.title }}</h3>
      <p>{{ review.review }}</p>
      <p>Favorite? <input type="checkbox" v-model="review.favorited" /></p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties",
      description: "Plan and host a cigar party for your friend",
      reviews: [
        {
          id: 1,
          reviewer: "mike",
          title: "awesome read",
          review: "now I know how to throw a party",
          rating: 5,
          favorited: false,
        },
        {
          id: 2,
          reviewer: "chris",
          title: "meh",
          review: "nothing nwe",
          rating: 3,
          favorited: false,
        },
      ],
    };
  },
  computed: {
    averageRating() {
      const sum = this.reviews.reduce(
        (acc, review) => (acc += review.rating),
        0
      );
      return sum / this.reviews.length;
    },
  },
  methods: {
    countReviewWithRating(rating) {
      return this.reviews.filter((review) => review.rating === rating).length;
    },
  },
};
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}
div.main div.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
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

div.main div.review.favorited {
  background-color: lightyellow;
}
</style>