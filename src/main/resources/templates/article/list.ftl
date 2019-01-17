<!doctype html>
<html>
<head>
<#include "/common/base_meta.ftl"/>
<#include "/common/base_css.ftl"/>
</head>
<body data-type="index">
    <div class="tpl-page-container">
        <table>
            <thead>
                <tr>共计：${list?size}</tr>
                <tr>
                    <th width="800px"style="text-overflow: ellipsis;">标题</th>
                    <th width="">来源</th>
                    <th width="">发布日期</th>
                    <th width="">作者</th>
                </tr>
            </thead>
            <tbody>
                <#list list as it>
                <tr>
                    <td><a target="_blank" href="/crawl/article/${it.id}" title="${it.title}">${it.title}</a></td>
                    <td>${it.source}</td>
                    <td><#if it.pubTime??>${it.pubTime?date}</#if></td>
                    <td><a target="_blank" href="${it.blog}">${it.author}</td>
                </tr>
                </#list>
            </tbody>
            
        </table>
    </div>

    <#include "/common/base_js.ftl"/>
    <script src="/static/js/echarts.min.js"></script>
    <script type="text/javascript">
    
    </script>
</body>

</html>