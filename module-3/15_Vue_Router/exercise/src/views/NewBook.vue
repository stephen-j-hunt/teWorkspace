<template>
  <div class="new-book">
    <new-book-form />
  </div>
</template>

<script>
import NewBookForm from "../components/NewBookForm.vue";

export default {
  name: "new-book-form-view",
  components: {
    NewBookForm,
  },
};
</script>

<style>
</style>