<template>
  <!DOCTYPE html>
  <html >
  <body class="root">
    <div class="aside">
      <AsideTool/>
    </div>
    <div class="main">
      <div class="tab">
         <TabTool />
      </div>
      <button @click="TEST">load books</button>
      <div class="post" v-for="book in books" :key="book.id">
        <BookComponent :mybook="book"/>
      </div>
    </div>

  </body>

  </html>
</template>
<script>
import TabTool from './Pagetools/TabTool.vue'
import AsideTool from './Pagetools/AsideTool.vue'
import BookComponent from "@/components/Pagetools/BookComponent.vue";
export default {
  components: {
    TabTool,
    AsideTool,
    BookComponent
  },
  data() {
    return{
      books :   null,

    }

  },
  methods: {
    TEST() {
      this.$axios.get('/allbooks')
          .then(response => {

                 this.books = response
                  console.log("ok",this.books)
              }
          ).catch(() => {
            console.log("err")
          }
      )
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
