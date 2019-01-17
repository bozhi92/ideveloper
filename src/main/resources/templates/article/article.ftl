<!doctype html>
<html>
<head>
<#include "/common/base_meta.ftl"/>
<#include "/common/base_css.ftl"/>
</head>
<body data-type="index">
    <div class="tpl-page-container">
        <p>标题：${article.title} 来源：${article.source} 发布时间：<#if article.pubTime??>${article.pubTime?datetime}</#if> <a target="_blank" href="${article.url}">原文链接</a></p>
        ${article.content} 
    </div>

    <#include "/common/base_js.ftl"/>
    <script src="/static/js/echarts.min.js"></script>
    <script type="text/javascript">
    
    </script>
</body>

</html>