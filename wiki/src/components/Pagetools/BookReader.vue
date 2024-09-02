<template>

  <div class="book-reader">
    <div class="sidebar">
      <h3>章节列表</h3>
      <ul>
        <li v-for="chapter in chapters" :key="chapter.id">
          <router-link
              :to="{ name: 'BookPage', params: { ebookId: ebookId, chapterId: chapter.chapterNumber   } }"
          >
            {{ chapter.title }}
          </router-link>
        </li>
      </ul>
    </div>
<!--    <div class="content">-->
<!--      &lt;!&ndash; 这里嵌套 BookPage 组件 &ndash;&gt;-->
      <BookPage :ebookId="ebookId" :chapterId="chapterId"  />
<!--&lt;!&ndash;      <div class="pagination-controls">&ndash;&gt;-->
<!--&lt;!&ndash;        <button @click="prevPage" :disabled="pageNumber <= 1">上一页</button>&ndash;&gt;-->
<!--&lt;!&ndash;        <button @click="nextPage" :disabled="!hasMoreContent">下一页</button>&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
    </div>
</template>

<script>


export default {


  props: ['ebookId','chapterId'], // 明确表示是电子书 ID
  data() {
    return {
      chapters: null,
      chapterTitle: '',
      pageContent: '',
      pageNumber: 1,
      hasMoreContent: true,
    };
  },
  created() {
    this.loadChapters(this.ebookId);
  },
  methods: {
    loadChapters(ebookId) {
      this.$axios.get(`/books/${ebookId}/chapters`)
          .then(response => {
            this.chapters = response; // 使用 response.data
            console.log(this.chapters);
          })
          .catch(error => {
            console.error("Failed to load chapters:", error);
          });
    },
    // nextPage() {
    //   if (this.hasMoreContent) {
    //     this.pageNumber++;
    //     this.loadPageContent();
    //   }
    // },
    // prevPage() {
    //   if (this.pageNumber > 1) {
    //     this.pageNumber--;
    //     this.loadPageContent();
    //   }
    // }
  }
};
</script>

<style scoped>
.book-reader {
  display: flex;
  max-width: 1000px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.sidebar {
  width: 250px;
  margin-right: 20px;
  border-right: 1px solid #ddd;
}

.content {
  flex-grow: 1;
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

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 10px;
}

router-link {
  color: #007BFF;
  text-decoration: none;
}

router-link:hover {
  text-decoration: underline;
}
</style>
