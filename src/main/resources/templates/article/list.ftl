<!doctype html>
<html>
<head>
<#include "/common/base_meta.ftl"/>
<#include "/common/base_css.ftl"/>
<style type="text/css">
button {
	border: none;
    border-radius: 0 5px 5px 0;
    color: white;
}
input {
    border: none;
    border-radius: 5px 0 0 5px;
}
.search{
    color: #FF0000;
}
</style>
</head>
<body data-type="index">
    <div class="tpl-page-container">
        <input type="text" id="search" class=""><button type="button" onclick="search()">search</button>
        <div id="pageList">
        <#include "listFrag.ftl"/> 
        </div>  
    </div>

    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/amazeui.min.js"></script>
    <script type="text/javascript">
    	function ajaxList(page){
    		var search = $("#search").val();
    		if(search=='') {
    			search = "";
    		} else {
    			search = "&search="+search;
    		}
    		$.ajax({
    			url:'/crawl/article/ajaxList?pageNum='+page+search+'&pageSize='+$("#pageSize").val(),
    			success:function(data){
    				$("#pageList").html(data);
    			}
    		});
    	}
    	function search(){
    		var search = $("#search").val();
    		if(search=='') {
    			search = "";
    		} else {
    			search = "&search="+search;
    		}
    		$.ajax({
    			url:'/crawl/article/ajaxList?pageNum='+$("#pageNum").val()+search+'&pageSize='+$("#pageSize").val(),
    			success:function(data){
    				$("#pageList").html(data);
    			}
    		});
    	}
    </script>
</body>

</html>