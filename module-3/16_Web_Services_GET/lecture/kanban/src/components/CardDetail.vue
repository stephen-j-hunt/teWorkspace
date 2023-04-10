<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>
  </div>
</template>

<div class="loading" v-if="isLoading">
        <img src="../assets/ping_pong_loader.gif" />
      </div>
<script>
import boardService from "../services/BoardService";
import CommentsList from "../components/CommentsList.vue";
export default {
  name: "card-detail",
  components: {
    CommentsList,
  },
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
