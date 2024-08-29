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
        <div id="filter">
            <FilterTool />
        </div>
      </div>
  
    </body>
  
    </html>
  </template>
  <script>
  import TabTool from '../Pagetools/TabTool.vue'
  import FilterTool from '../Pagetools/FilterTool.vue';
  import AsideTool from "@/components/Pagetools/AsideTool.vue";
  export default {
    components: {
      TabTool,
      FilterTool,
      AsideTool
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
  