<template>
  <body class="root">
  <div class="aside">
    <AsideTool/>
  </div>
  <div class="main">
    <div class="tab">
      <TabTool />
    </div>

    <div>
      <h1>{{ categoryName }} 的书籍</h1>
      <ul>
        <li v-for="book in books" :key="book.id">
          {{ book.title }}
        </li>
      </ul>
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
