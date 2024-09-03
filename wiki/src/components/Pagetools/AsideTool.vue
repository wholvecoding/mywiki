<template>
    <div class="sidebar">
	<div class="logo">
		<a href="/"><img src="../../assets/shuba.png" alt="书吧，PDF电子书学习下载站"></a>
		<h1><a href="/">-书吧-</a></h1>
	</div>
	<div class="subtitle">PDF电子书学习下载站</div>
	<div class="search">
		<form name="search" method="post" action="/e/search/index.php">
			<select name="tbname" data-enpassusermodified="yes" id="searchType" onchange="updateAction()">
			<option value="news">书籍</option>
			<option value="ask">求书</option>
			</select>
			<input type="text" id="bdcsMain" name="keyboard" placeholder="搜索：書名 / 作者" class="txt">
			<button type="submit" value="" class="btn"></button>
			<input type="hidden" name="show" value="title">
			<input type="hidden" name="tempid" value="1">
		</form>
	</div>
	<div class="user"><a href="https://yabook.org/e/member/login/" class="login"> 登入</a>&nbsp;&nbsp;<a href="https://yabook.org/e/member/register/" class="reg"> 注冊</a></div>
	<div class="menu">
		<ul>
  <li>
      <router-link :to="{ name: 'CategoryPage', params: { categoryId: 1 } }">
        小说文学
      </router-link>
  </li>
      <li>
        <router-link :to="{ name: 'CategoryPage', params: { categoryId: 1 } }">
         经济管理
        </router-link>
      </li>
		<li id="navbar-category-2"><a href="/lishi/" title="中国世界历史人物传记">历史人物</a></li>
      <li id="navbar-category-20">
        <router-link to="/cp" >计算机类</router-link>
      </li>
		<li id="navbar-category-4"><a href="/sheke/" title="社会科学语言文字名家作品集">社会科学</a></li>
		<li id="navbar-category-5"><a href="/xinli/" title="心理疗愈心理学性格色彩">心理科学</a></li>
		<li id="navbar-category-6"><a href="/lizhi/" title="成功励志心灵人际职场处世">成功励志</a></li>
		<li id="navbar-category-7"><a href="/kepu/" title="人类故事宇宙自然科普百科知识">科普百科</a></li>
		<li id="navbar-category-8"><a href="/shejiyishu/" title="建筑媒体绘画设计动漫艺术">设计艺术</a></li>
		<li id="navbar-category-9"><a href="/sheying/" title="摄影理论技法数码相机技教程">摄影数码</a></li>
		<li id="navbar-category-35"><a href="/manhua/" title="经典名著漫画绘画本动漫画集">绘本漫画</a></li>
		<li id="navbar-category-10"><a href="/zhexue/" title="哲学与人生宗教理伦术数命理">哲学宗教</a></li>
		<li id="navbar-category-11"><a href="/chuanli/" title="个人创业投资理财金融理论">投资理财</a></li>
		<li id="navbar-category-12"><a href="/shenghuo/" title="家庭亲子育儿生活饮食百科">生活百科</a></li>
		<li id="navbar-category-13"><a href="/yixue/" title="医学保健养生运动健康治疗">医学养生</a></li>
		<li id="navbar-category-14"><a href="/yingyu/" title="英语读物考试教学辅导">英语培训</a></li>
		<li id="navbar-category-15"><a href="/jiaofu/" title="教材辅助工具养育书籍类">教辅用书</a></li>
		<li id="navbar-category-16"><a href="/zhengzhi/" title="政治帝王领袖军事人物">政治军事</a></li>
		<li id="navbar-category-17"><a href="/falv/" title="刑法民法商法等法律法规类">法律法规</a></li>
		<li id="navbar-category-18"><a href="/keji/" title="科学技术建筑农林工业等">科技农工</a></li>
		<li id="navbar-category-19"><a href="/wenhua/" title="传统各类文化及古典古籍">文化古籍</a></li>
		<li id="navbar-category-32"><a href="/yingwen/" title="各种英文原版分类书籍">英文原版</a></li>
		<li id="navbar-category-34"><a href="/gangtai/" title="港台等繁体原版书籍">港台书籍</a></li>
		<li id="navbar-category-33"><a href="/citiao/" title="词条解析">词条解析</a></li>
		<li id="navbar-category-36"><a href="/say/" title="冷知识说">冷知识说</a></li>
		<li id="navbar-category-co"><a href="/collection/" title="套装合集">套装合集</a></li>
		</ul>
	</div>
	<!-- <div class="sns clear">
		<a href="/about.html" title="免责声明" class="about"></a>
		<a href="/tags.html" title="标签TAGS" class="tags"></a>
		<a href="javascript:;" class="weixin"><span><img src="/skin/Yabook/include/qremail.png" alt="联系邮箱"></span></a>
		<a href="/feed.php" title="订阅本站Feed" class="feed"></a>
		<a href="/sitemap.xml" target="_blank" title="网站地图Sitemap" class="sitemap"></a>
	</div>
	<div class="sidefoot">© 2024 YABOOK.ORG</div> -->
</div>
</template>
<style scoped>
.menu li {
    list-style-type: none; 
    flex: 0 0 50%; /* 每个列表项占据父容器宽度的 50% */
    box-sizing: border-box; /* 包括内边距和边框在内的宽度计算 */
    margin-bottom: 10px; /* 为每个列表项增加一些底部间距 */

} 
.menu ul{
    display: flex;
    flex-wrap: wrap; /* 允许子元素换行 */
    list-style-type: none;
    padding: 0;
    margin: 0;
}
.sidebar {
    width: 300px; /* 设置侧边栏宽度 */
    background-color: rgb(116, 109, 98); /* 设置侧边栏背景色 */
    
    padding: 20px; /* 添加内边距 */
    border-right: 1px solid #ddd; /* 侧边栏右侧边框 */
}

.logo {
    text-align: center;
    margin-bottom: 20px; /* 增加与下面内容的间距 */
}

.logo img {
    max-width: 100%; /* 使图片响应式 */
}

.subtitle {
    font-size: 14px;
    color: #666;
    text-align: center;
    margin-bottom: 20px;
}

.search {
    margin-bottom: 20px;
}

.search form {
    display: flex;
    align-items: center;
}

.search input[type="text"] {
    flex: 1;
    padding: 10px;
    margin-right: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

.search button {
    padding: 10px 20px;
    background-color: #42b983;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.search button:hover {
    background-color: #339966;
}

.user {
    text-align: center;
    margin-bottom: 20px;
}

.user a {
    color: #42b983;
    text-decoration: none;
    margin: 0 10px;
}

.user a:hover {
    text-decoration: underline;
}

.menu ul {
    list-style-type: none;
    padding: 0;
}

.menu li {
    margin-bottom: 10px; /* 为每个菜单项增加底部间距 */
}

.menu a {
    color: #333;
    text-decoration: none;
    font-weight: bold;
}

.menu a:hover {
    color: #42b983; /* 鼠标悬停时改变颜色 */
}

.sns {
    text-align: center;
    margin-top: 20px;
}

.sns a {
    display: inline-block;
    width: 40px;
    height: 40px;
    background-color: #ddd;
    margin: 0 5px;
    border-radius: 50%;
    text-align: center;
    line-height: 40px;
}

.sns a:hover {
    background-color: #42b983;
}

.sidefoot {
    text-align: center;
    margin-top: 30px;
    font-size: 12px;
    color: #999;
}

</style>
<script>


export default {
    setup() {
        
    },
}
</script>
