<template>
  <div class="rating">
    <img
      src="../assets/star.png"
      v-bind:title="rating + ' Star Review'"
      class="ratingStar"
      v-for="n in rating"
      v-bind:key="n"
      :class="imageClass"
    />
  </div>
</template>

<script>
export default {
  name: "star-rating",
  props: ["rating", "size"], // size=small,medium,large
  computed: {
    imageClass() {
      return {
        small: !this.size || this.size === "small",
        medium: this.size === "medium",
      };
    },
  },
  methods: {
    foo() {
      console.log("do nothing");
    },
  },
};
</script>

<style scoped>
.rating {
  display: flex;
}

.ratingStar.small {
  height: 1rem;
}

.ratingStar.medium {
  height: 3rem;
}
</style>