<template>
  <div class="book-reader">
    <div class="chapter-title">{{ chapterTitle }}</div>
    <div class="chapter-content">
      <p v-html="pageContent"></p>
    </div>
    <div class="pagination-controls">
      <button @click="prevPage" :disabled="pageNumber <= 1">上一页</button>
      <button @click="nextPage" :disabled="!hasMoreContent">下一页</button>
    </div>

  </div>
</template>

<script>
export default {
  props: ['ebookId', 'chapterId'], // 接收来自父组件的 props
  data() {
    return {
      pageNumber:1,
      chapterTitle: '',
      pageContent: '',
      hasMoreContent: true,
    };
  },
  created() {
    this.loadPageContent();
  },
  methods: {
    loadPageContent() {
      this.$axios.get(`/${this.ebookId}/${this.chapterId}/${this.pageNumber}`)
          .then(response => {
            const data = response; // 使用 response.data
            this.chapterTitle = `Chapter ${this.chapterId}`;
            this.pageContent = data.content;
            this.hasMoreContent = !!data.content;
          })
          .catch(error => {
            console.error("Failed to load page content:", error);
          });
    },
    nextPage() {
      if (this.hasMoreContent) {
        this.pageNumber++;
        this.loadPageContent();
      }
    },
    prevPage() {
      if (this.pageNumber > 1) {
        this.pageNumber--;
        this.loadPageContent();
      }
    }
  }
};
</script>

<style scoped>
.book-reader {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.chapter-title {
  font-size: 1.5em;
  font-weight: bold;
  margin-bottom: 20px;
}

.chapter-content {
  font-size: 1.2em;
  line-height: 1.6;
  margin-bottom: 20px;
}

.pagination-controls {
  display: flex;
  justify-content: space-between;
}
</style>
