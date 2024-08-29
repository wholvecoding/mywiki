
<script>


export default  {
    component: {

    }
}
</script>
<template>
    <div class="main_top">
        <ul class="clearfix">
            <li style="margin-left: 80px;"><a href="/" title="返回首页">首页</a></li>
            <li>
                <a title="最新热榜单">热榜<i ></i></a>
                <ul class="icon-down"> 
                    <li><a href="/new.html" title="新书推荐">新书推荐</a></li>
                    <li><a href="/hot.html" title="热门书籍">热门书籍</a></li>
                    <li><a href="/monthhot.html" title="月度热门">月度热门</a></li>
                    <li><a href="/top.html" title="高分书籍">高分书籍</a></li>
                </ul>
            </li>
            <li><a href="/all.html" title="最近更新">更新</a></li>
            <li><a href="/cover.html" title="随机找书">随机</a></li>
        </ul>
    </div>
</template>
<style>
<!--.为class选择器,#为id选择器-->
.clearfix{ 
    display: flex;
    justify-content: center;
    margin-left:100px;
  
}
.clearfix>li {
    /* 每个导航项之间增加间距 */
    margin-right:100px;
    font-size:20px;
    color: rgb(112, 105, 92); /* 默认字体颜色 */
   
}
.main_top li a {
    text-decoration: none;
    writing-mode: horizontal-tb;
    color:aliceblue /* 默认字体颜色 */
}
.main_top ul {
    display: flex;
    list-style-type: none; 
    
    margin: 0;
    padding: 0;
}

.icon-down{
    
    background-color: rgb(112, 105, 92); /* 默认字体颜色 */
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