<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>	
		<link rel="stylesheet" href="/static/css/core.css" />
		<link rel="stylesheet" href="/static/css/menu.css" />
		<link rel="stylesheet" href="/static/css/amazeui.css" />
		<link rel="stylesheet" href="/static/css/component.css" />
		<link rel="stylesheet" href="/static/css/page/form.css" />
		<script src="/static/js/jquery-2.1.0.js" type="text/javascript"></script>
		<script>
			$(function () {
				$("#login").on("click", function () {
					var userName = $("input[name='username']").val();
					var password = $("input[name='password']").val();
					$.post("/userLogin", {'userName': userName, 'password': password}, function () {
						window.location.href = "/index";
					});
				});
			})
		</script>
	</head>

	<body>
		<div class="account-pages">
			<div class="wrapper-page">
				<div class="text-center">
	                <a href="/jsp/index" class="logo"><span>Admin<span>to</span></span></a>
	            </div>
	            
	            <div class="m-t-40 card-box">
	            	<div class="text-center">
	                    <h4 class="text-uppercase font-bold m-b-0">Sign In</h4>
	                </div>
	                <div class="panel-body">
	                	<form class="am-form">
	                		<div class="am-g">
	                			<div class="am-form-group">
								  <input type="text" class="am-radius"  placeholder="Username" name="username">
							    </div>
							
							    <div class="am-form-group form-horizontal m-t-20">
							      <input type="password" class="am-radius"  placeholder="Password" name="password">
							    </div>
							    
							    <div class="am-form-group ">
		                           	<label style="font-weight: normal;color: #999;">
								        <input type="checkbox" class="remeber"> Remember me
								    </label>
		                        </div>
		                        
		                        <div class="am-form-group ">
		                        	<button type="button" id="login" class="am-btn am-btn-primary am-radius" style="width: 100%;height: 10%;">登录</button>
		                        </div>
		                        
		                        <div class="am-form-group ">
		                        <a href="page-recoverpw.html" class="text-muted"><i class="fa fa-lock m-r-5"></i>忘记密码?</a>
		                        </div>
	                		</div>

	                	</form>
							
	                </div>
	            </div>
			</div>
		</div>
	</body>
</html>
