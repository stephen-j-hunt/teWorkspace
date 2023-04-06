<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>
  </div>
</template>

<script>
import boardService from "../services/BoardService";

export default {
  name: "card-detail",
  data() {
    return {
      card: {
        title: "",
        description: "",
        status: "",
        comments: [],
      },
    };
  },
  created() {
    const boardId = this.$route.params.boardID;
    const cardId = this.$route.params.cardID;
    boardService.getCard(boardId, cardId).then((card) => (this.card = card));
  },
};
</script>
