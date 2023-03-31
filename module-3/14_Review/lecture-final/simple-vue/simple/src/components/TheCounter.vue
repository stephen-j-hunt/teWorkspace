<template>
  <div>
    <button @click="counter++">Increase</button>
    <h2>{{ counter }}</h2>
    <button @click="counter--">Decrease</button>
  </div>
</template>

<script>
export default {
  name: "the-counter",
  data() {
    return {
      counter: 0,
    };
  },
};
</script>

<style>
</style>