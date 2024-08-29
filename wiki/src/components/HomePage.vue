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
      <div class="post">
        <div class="postBlock">
      <div class="postTitle">

        <a href="../post/1.html"> test</a>
      </div>
          <button @click="TEST">load books</button>
          <li v-for="book in books" :key="book.id">{{book.id}} by {{book.author}}</li>
      <div class="postImage">

      </div>
      <div class="postDescription">

      </div>
        </div>
    </div>
    </div>

  </body>

  </html>
</template>
<script>
import TabTool from './Pagetools/TabTool.vue'
import AsideTool from './Pagetools/AsideTool.vue'
export default {
  components: {
    TabTool,
    AsideTool
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
  margin-left:200px;
  margin-right:200px;
}
.tab{
  background-color: rgb(116, 109, 98);
  
  height: 40px;;
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
