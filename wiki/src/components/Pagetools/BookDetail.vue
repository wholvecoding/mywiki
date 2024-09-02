<template>
  <body class="root">
  <div class="aside">
    <AsideTool/>
  </div>
  <div class="main">
    <div class="tab">
      <TabTool />
    </div>
    <div class="book-detail">
      <h1>
        {{ book.title }}
      <router-link :to="{ name: 'BookReader',params:{ebookId:this.ebookId}}">阅读全文 </router-link>
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
import TabTool from "@/components/Pagetools/TabTool.vue";
import AsideTool from "@/components/Pagetools/AsideTool.vue";

export default {
  components: { AsideTool, TabTool},
  props: ['ebookId'], // 接收从路由传来的书籍 ID
  data() {
    return {
      book: {}, // 将书籍详细信息存储在这里
      chapters:null
    };
  },
  created() {
    this.fetchBookById(this.id); // 在创建组件时根据ID获取书籍详细信息
    this.fetchChapterByBookId(this.id);
  },

  methods: {
    fetchBookById(  ) {
      // 在这里使用实际的API调用，下面是模拟数据
      this.$axios.get(`/book/${this.ebookId}`)
          .then(response=>{
            this.book = response
          })

    },
    fetchChapterByBookId(){
      this.$axios.get(`/books/${this.ebookId}/chapters`)
          .then(response=>{
            this.chapters  =response
          })
    },
    getFullPath(coverpath) {
      return `/bookcover/${coverpath}`;
    }
  }
}
</script>

<style scoped>
.label {
  text-align: left;
  background-color: #cccccc;
}

.outline {
}
.book-detail {
  margin: 20px;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.book-image img {
  width: 400px;
 height: 100%;
  object-fit: cover;
  margin-bottom: 20px;
}

h1 {
  font-size: 2em;
  margin-bottom: 20px;
}
h3
{
  margin: 40px 0 0;
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
.filter{
  background-color: rgb(116, 109, 98);
}
ul
{
  list-style-type: none;
  padding: 0;
}

li
{
  display: inline-block;
  margin: 0 10px;
}

a
{
  color: #42b983;
}
</style>
