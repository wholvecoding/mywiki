  <template>
    <div id="app">
      <router-view/> <!-- 动态渲染与当前路由匹配的组件 -->
    </div>
  </template>

<script>


export default {

  name: 'App',
};
</script>
<style>
#app
{
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: beige;
}
</style>