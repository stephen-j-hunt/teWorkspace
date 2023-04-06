<template>
  <div class="my-books">
    <reading-list />
    <nav>
      <router-link :to="{ name: 'new-book' }"> New Book Form </router-link>
    </nav>
  </div>
</template>

<script>
import ReadingList from "../components/ReadingList.vue";
export default {
  name: "books-view",
  components: {
    ReadingList,
  },
};
</script>

<style>
</style>