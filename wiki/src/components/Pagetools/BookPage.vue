<template>
  <body class="root">
  <div class="aside">
    <AsideTool/>
  </div>
  <div class="main">
    <div class="tab">
      <TabTool/>
    </div>
    <button @click="goBack">返回上一页</button>
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
  </div>
  </body>
</template>

<script>
import AsideTool from "@/components/Pagetools/AsideTool.vue";
import TabTool from "@/components/Pagetools/TabTool.vue";

export default {
  components: {TabTool, AsideTool},
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
    goBack() {
      history.back();
    },
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

.main{
  display: flex;
  flex-direction: column;
}
.root{
  display: flex;
  flex-direction: row;
  padding-left:20px;
  padding-right:20px;
}
.tab{
  background-color: rgb(116, 109, 98);


}
.aside {
  width:340.8px;
}
.book-reader {
  display: flex;
  flex-direction: column;
  justify-content: space-between; /* 确保内容和按钮之间保持空间 */
  width: 800px;
  height: 780px; /* 固定高度 */
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
  margin-top: 20px; /* 与内容之间的间距 */
  padding-top: 10px;
  border-top: 1px solid #ddd; /* 分隔线 */
  background-color: #f9f9f9; /* 选配的背景色 */
  padding: 10px;
}
</style>
