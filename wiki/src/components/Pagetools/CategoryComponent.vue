<template>
  <body class="root">
  <div class="aside">
    <AsideTool/>
  </div>
  <div class="main">
    <div class="tab">
      <TabTool />
    </div>

    <div class="book-detail" v-for="book in books" v-bind:key="book.id">
      <h1>
        {{ book.title }}
        <router-link :to="{ name: 'BookReader',params:{ebookId:book.id}}">阅读全文 </router-link>
      </h1>
      <p><strong>作者:</strong> {{ book.author }}</p>
      <div class="book-image">
        <img :src="getFullPath(book.bookCover)" alt="Book Cover" />
      </div>

      <p class="label">内容简介</p>
      <p> {{ book.bookOutline }}</p>
      <p class="label">作者简介</p>
      <p>{{book.authorOutline}} </p>
      <p class="label">章节</p>
      <div v-for="chapter in chapters" :key="chapter.id">
        <p> {{chapter.content}}</p>
      </div>

    </div>
  </div>

  </body>

</template>

<script>
import AsideTool from "@/components/Pagetools/AsideTool.vue";
import TabTool from "@/components/Pagetools/TabTool.vue";

export default {
  components: {TabTool,  AsideTool},
  props: ['categoryId'],
  data() {
    return {
      categoryName: '',
      books: [],
    };
  },
  created() {
    this.fetchBooksByCategory(this.categoryId);
  },
  methods: {
    getFullPath(coverpath) {
      return `/bookcover/${coverpath}`;
    },
    fetchBooksByCategory(categoryId) {
      // 这里使用实际的API调用获取相应类别的书籍
      this.$axios.get(`/book/category/${categoryId}`)
          .then(response => {
            this.books = response;
            this.categoryName = this.getCategoryName(categoryId); // 获取类别名称
          })
          .catch(error => {
            console.error("Failed to load books:", error);
          });
    },
    getCategoryName(categoryId) {
      // 根据categoryId获取对应的类别名称
      const categoryNames = {
        '1': '小说文学',
        '2': '经济管理',
        // 其他类别的名称
      };
      return categoryNames[categoryId] || '未知类别';
    }
  },
  // watch: {
  //   // 监听路由参数变化，当切换类别时重新加载书籍
  //   categoryId(newCategoryId) {
  //     this.fetchBooksByCategory(newCategoryId);
  //   }
  // }
};
</script>

<style scoped>
/* 根据需要设置样式 */
.label {
  text-align: left;
  background-color: #cccccc;
}
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
</style>
