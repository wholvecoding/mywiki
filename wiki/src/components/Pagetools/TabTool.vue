
<script>


export default  {
    component: {

    }
}
</script>
<template>
    <div class="main_top">
        <ul class="clearfix">
            <li style="margin-left: 200px;"><a href="/" title="返回首页">首页</a></li>
            <li>
                <a title="最新热榜单">热榜<i class="icon-down"></i></a>
                <ul>
                    <li><a href="/new.html" title="新书推荐">新书推荐</a></li>
                    <li><a href="/hot.html" title="热门书籍">热门书籍</a></li>
                    <li><a href="/monthhot.html" title="月度热门">月度热门</a></li>
                    <li><a href="/top.html" title="高分书籍">高分书籍</a></li>
                </ul>
            </li>
            <li><a href="/all.html" title="最近更新">更新</a></li>
            <li><a href="/cover.html" title="随机找书">随机</a></li>
            <li><a href="/vedition/" title="V版書籍">V版</a></li>
            <li><a id="StranLink" class="mochu_cntw" href="javascript:StranBody()" title="点击以简体中文方式浏览">简体</a></li>
        </ul>
    </div>
</template>
<style>
<!--.为class选择器,#为id选择器-->
.clearfix{ 
    display: flex;
    justify-content: center;
    flex-direction: row;
    justify-content: center;
    margin-left:100px;
  
}
.clearfix li {
    
    font-size:20px;
    color: rgb(112, 105, 92); /* 默认字体颜色 */
   
}
.main_top li a {
    text-decoration: none;
    color:aliceblue /* 默认字体颜色 */
}
.main_top ul {
    display: flex;
    list-style-type: none; 
    
    margin: 0;
    padding: 0;
}

.main_top li {
    margin-right: 20px; /* 每个导航项之间增加间距 */
    margin-right:100px;
}

.main_top li ul {
    display: none; /* 初始状态下隐藏子菜单 */
    position: absolute; /* 使子菜单在主菜单下方浮动 */
  
    padding: 10px;
}

.main_top li:hover ul {
    display: block; /* 悬停时显示子菜单 */
}
</style>