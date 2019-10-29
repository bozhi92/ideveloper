<table>
    <thead>
        <tr>
            <th width="800px"style="text-overflow: ellipsis;">标题</th>
            <th width="100px">来源</th>
            <th width="150px">发布日期</th>
            <th width="">作者</th>
        </tr>
    </thead>
    <tbody>
        <#list pageInfo.list as it>
            <tr>
                <td><a target="_blank" href="/crawl/article/${it.id}" title="${it.title}">${it.title}</a></td>
                <td>${it.source}</td>
                <td><#if it.pubTime??>${it.pubTime?string('yyyy-MM-dd HH:mm')}</#if></td>
                <td><a target="_blank" href="${it.blog}">${it.author}</td>
            </tr>
        </#list>
    </tbody>
</table>
<p>
    <a href="javascript:" onclick="ajaxList('${pageInfo.prePage}')">上一页</a>
    <a href="javascript:" onclick="ajaxList('${pageInfo.nextPage}')">下一页</a>
    <input type="hidden" id="pageNum" value="${pageInfo.pageNum}">
    <span>当前 ${pageInfo.pageNum}页</span>
    <span>共${pageInfo.pages}页</span>
    <span>找到${pageInfo.total}条记录</span>
    <select onchange="search()" id="pageSize">
        <option value="10"<#if (pageInfo.pageSize == 10)>selected="selected"</#if>>10</option>
        <option value="20" <#if (pageInfo.pageSize == 20)>selected="selected"</#if>>20</option>
        <option value="30" <#if (pageInfo.pageSize == 30)>selected="selected"</#if>>30</option>
    </select>
</p>


