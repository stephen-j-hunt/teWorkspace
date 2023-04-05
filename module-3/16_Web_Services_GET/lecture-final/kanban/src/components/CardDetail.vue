<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else>
      <h1>{{ card.title }}</h1>
      <p>{{ card.description }}</p>
      <comments-list :comments="card.comments" />
    </div>
    <div class="board-actions" v-if="!isLoading">
      <router-link
        :to="{ name: 'Board', params: { id: $route.params.boardID } }"
      >
        Back To Board
      </router-link>
    </div>
  </div>
</template>

<script>
import boardService from "../services/BoardService";
import CommentsList from "./CommentsList.vue";

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
      isLoading: true,
    };
  },
  created() {
    const boardId = this.$route.params.boardID;
    const cardId = this.$route.params.cardID;
    boardService.getCard(boardId, cardId).then((card) => {
      this.card = card;
      this.isLoading = false;
    });
  },
};
</script>
