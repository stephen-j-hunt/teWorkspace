<template>
  <div id="app" class="main">
    <h1>Product Reviews for</h1>
    <p class="description"></p>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <add-review />
    <div>
      <label for="cards">Cards</label>
      <input type="radio" id="cards" value="cards" v-model="layout" />
      <label for="table">Table</label>
      <input type="radio" id="table" value="table" v-model="layout" />
    </div>
    <review-list v-if="layout === 'cards'" />
    <review-table v-else />
  </div>
</template>

<script>
import AverageSummary from "./components/AverageSummary.vue";
import StarSummary from "./components/StarSummary.vue";
import AddReview from "./components/AddReview.vue";
import ReviewList from "./components/ReviewList.vue";
import ReviewTable from "./components/ReviewTable.vue";

export default {
  name: "app",
  data() {
    return {
      layout: "cards", // 'cards' or 'table'
    };
  },
  components: {
    AverageSummary,
    StarSummary,
    AddReview,
    ReviewList,
    ReviewTable,
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
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

div.main div.well-display div.well {
  cursor: pointer;
}
</style>
