<!doctype html>
<html>
<head>
<#include "/common/base_meta.ftl"/>
<#include "/common/base_css.ftl"/>
</head>
<body data-type="login">
    <div class="am-g myapp-login">
        <div class="myapp-login-logo-block  tpl-login-max">
            <div class="myapp-login-logo-text">
                <div class="myapp-login-logo-text">
                    ideveloper<span> @DemoLogin</span> <i class="am-icon-skyatlas"></i>
                </div>
            </div>

            <div class="login-font">
                <i>Log In </i> or <span> Sign Up</span>
            </div>
            
            <div class="am-u-sm-10 login-am-center">
                <form class="am-form">
                    <fieldset>
                        <div class="am-form-group">
                            <input type="text" id="doc-ipt-uname-1" placeholder="用户名">
                        </div>
                        <div class="am-form-group">
                            <input type="password" id="doc-ipt-pwd-1" placeholder="密码">
                        </div>
                        <p>
                            <button type="button" class="am-btn am-btn-default" onclick="login()">登录</button>
                        </p>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <#include "/common/base_js.ftl"/>
    <script type="text/javascript">
    	function login() {
    		var abc = $("#doc-ipt-uname-1").val();
    		var def = $("#doc-ipt-pwd-1").val();
    		if (abc != 'null') {
    			if (def != 'null') {
    				var jsonData = {"abc":abc,"def":def};
    				$.ajax({
    					url:'/login',
    					type:'post',
    					contentType:'application/json',
    					data:JSON.stringify(jsonData),
    					success:function(r){
    						window.parent.location.href="/home";
    					},
    					error:function(r){
    						alert(r);
    					}
    				})
    			}
    		}
    	}
    </script>
</body>

</html>