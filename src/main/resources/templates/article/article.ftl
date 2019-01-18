<!doctype html>
<html>
<head>
<#include "/common/base_meta.ftl"/>
<#include "/common/base_css.ftl"/>
<style type="text/css">
.article {
    width: 800px;
    margin: 0 auto;
}
.article img {
    width: 100%;
}
</style>
</head>
<body data-type="index">
    <div class="tpl-page-container">
        <div class="article">
            <p>标题：${article.title}</p>
            <p>来源：${article.source}</p>
            <p>发布时间：<#if article.pubTime??>${article.pubTime?string('yyyy-MM-dd hh:mm')}</#if></p>
            <p><a target="_blank" href="${article.url}">原文链接</a></p>
            ${article.content} 
        </div>
    </div>

    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/amazeui.min.js"></script>
    <script type="text/javascript">
    
    </script>
</body>

</html>