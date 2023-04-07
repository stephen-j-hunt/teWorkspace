<template>
  <div>
    <div>
      <h1>{{ movie.title }}</h1>
      <p class="overview">{{ movie.overview }}</p>
      <div>
        <label for="release-date">Release Date</label>
        <input
          type="date"
          id="release-date"
          v-model="movie.releaseDate"
          disabled
        />
      </div>
      <h2>Cast</h2>
      <ul>
        <li v-for="person in movie.cast" :key="person.id">{{ person.name }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import movieService from "../services/MovieService.js";

export default {
  name: "movie-details-view",
  data() {
    return {
      movie: {},
    };
  },
  created() {
    movieService.getById(this.movieId).then((movie) => (this.movie = movie));
  },
  computed: {
    movieId() {
      return this.$route.params.id;
    },
  },
};
</script>

<style scoped>
p.overview {
  font-size: 1.15rem;
}
</style>