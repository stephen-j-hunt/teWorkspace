<template>
  <div>
    <table>
      <thead>
        <th>Title</th>
        <th class="overview">Overview</th>
        <th>Release Date</th>
      </thead>
      <tbody>
        <tr v-for="movie in movies" :key="movie.id">
          <td>
            <router-link
              :to="{ name: 'movie-details', params: { id: movie.id } }"
            >
              {{ movie.title }}
            </router-link>
          </td>
          <td class="overview">{{ movie.overview }}</td>
          <td>{{ movie.releaseDate }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import movieService from "../services/MovieService.js";

export default {
  name: "movies-view",
  computed: {
    movies() {
      return this.$store.state.movies;
    },
  },
  created() {
    movieService.getAll().then((movies) => {
      this.$store.commit("SET_MOVIES", movies);
    });
  },
};
</script>

<style scoped>
table {
  width: 100%;
}

th,
td {
  width: 20%;
}

th.overview,
td.overview {
  width: 60%;
}

tr:nth-child(even) {
  background-color: cadetblue;
}
</style>