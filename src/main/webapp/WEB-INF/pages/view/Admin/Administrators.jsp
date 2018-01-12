<html lang="en">
<head>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>首页</title>
<link href="../static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	title="" rel="stylesheet" />
<link title="" href="../static/admin/aliyunAdmin/css/style.css"
	rel="stylesheet" type="text/css" />
<link title="blue"
	href="../static/admin/aliyunAdmin/css/dermadefault.css"
	rel="stylesheet" type="text/css" />
<link title="green"
	href="../static/admin/aliyunAdmin/css/dermagreen.css" rel="stylesheet"
	type="text/css" disabled="disabled" />
<link title="orange"
	href="../static/admin/aliyunAdmin/css/dermaorange.css" rel="stylesheet"
	type="text/css" disabled="disabled" />
<script src="../static/jQuery/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script src="../static/admin/aliyunAdmin/script/jquery.cookie.js"
	type="text/javascript"></script>
<script src="../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript"></script>

<style>
#tab-header li a {
	padding: 5px 10px 5px 15px;
	display: -webkit-inline-box;
}

#tab-header li span {
	font-size: 10px;
	cursor: pointer;
}

.tab-content {
	height: calc(100% - 32px);
}

.tab-pane {
	height: 100%;
}

.topbar-nav-col a {
	cursor: pointer;
}
</style>
</head>

<body>
	<%! String path="110"; %>

	<nav class="nav navbar-default navbar-mystyle navbar-fixed-top">
		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand mystyle-brand"><span
				class="glyphicon glyphicon-home"></span></a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="li-border"><a class="mystyle-color" href="#">管理控制台<%=request.getContextPath()%><%=path%></a></li>
				<li class="dropdown li-border"><a href="#"
					class="dropdown-toggle mystyle-color" data-toggle="dropdown">站点与服务<span
						class="caret"></span></a>
					<div class="dropdown-menu topbar-nav-list">
						<!-- 顶部树形菜单 -->
					</div></li>
			</ul>

			<ul class="nav navbar-nav pull-right">
				<li class="li-border"><a href="#" class="mystyle-color"> <span
						class="glyphicon glyphicon-bell"></span> <span class="topbar-num">0</span>
				</a></li>
				<li class="li-border dropdown"><a href="#"
					class="mystyle-color" data-toggle="dropdown"> <span
						class="glyphicon glyphicon-search"></span> 搜索
				</a>
					<div class="dropdown-menu search-dropdown">
						<div class="input-group">
							<input type="text" class="form-control"> <span
								class="input-group-btn">
								<button type="button" class="btn btn-default">搜索</button>
							</span>
						</div>
					</div></li>
				<li class="dropdown li-border"><a href="#"
					class="dropdown-toggle mystyle-color" data-toggle="dropdown">帮助与文档<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">帮助与文档</a></li>
						<li class="divider"></li>
						<li><a href="#">论坛</a></li>
						<li class="divider"></li>
						<li><a href="#">博客</a></li>
					</ul></li>
				<li class="dropdown li-border"><a href="#"
					class="dropdown-toggle mystyle-color" data-toggle="dropdown">00000000@qq.com
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">退出</a></li>
					</ul></li>
				<li class="dropdown"><a href="#"
					class="dropdown-toggle mystyle-color" data-toggle="dropdown">换肤<span
						class="caret"></span></a>
					<ul class="dropdown-menu changecolor">
						<li id="blue"><a href="#">蓝色</a></li>
						<li class="divider"></li>
						<li id="green"><a href="#">绿色</a></li>
						<li class="divider"></li>
						<li id="orange"><a href="#">橙色</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<div class="down-main">
		<div class="left-main left-full">
			<div class="sidebar-fold">
				<span class="glyphicon glyphicon-menu-hamburger"></span>
			</div>
			<div class="subNavBox"></div>
		</div>
		<div class="tab right-product right-full" role="tabpanel">

			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist" id="tab-header">
				<li role="presentation" id="li11" class="active"><a
					href="#Section11" id="tab11" aria-controls="home" role="tab"
					data-toggle="tab">首页</a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="Section11">
					<iframe src="<%=request.getContextPath() %>/sysmenu/grid"
						width="100%" height="100%" frameborder="0"></iframe>
				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript">
	
	</script>
	<script type="text/javascript">
$(function(){
/*换肤*/
$(".dropdown .changecolor li").click(function(){
	var style = $(this).attr("id");
    $("link[title!='']").attr("disabled","disabled"); 
	$("link[title='"+style+"']").removeAttr("disabled"); 

	$.cookie('mystyle', style, { expires: 7 }); // 存储一个带7天期限的 cookie 
})
var cookie_style = $.cookie("mystyle"); 
if(cookie_style!=null){ 
    $("link[title!='']").attr("disabled","disabled"); 
	$("link[title='"+cookie_style+"']").removeAttr("disabled"); 
} 
/*左侧导航栏缩进功能*/
$(".left-main .sidebar-fold").click(function(){

	if($(this).parent().attr('class')=="left-main left-full")
	{
		$(this).parent().removeClass("left-full");
		$(this).parent().addClass("left-off");
		
		$(this).parent().parent().find(".right-product").removeClass("right-full");
		$(this).parent().parent().find(".right-product").addClass("right-off");
		
		}
	else
	{
		$(this).parent().removeClass("left-off");
		$(this).parent().addClass("left-full");
		
		$(this).parent().parent().find(".right-product").removeClass("right-off");
		$(this).parent().parent().find(".right-product").addClass("right-full");
		
		}
	})	
 
  /*左侧鼠标移入提示功能*/
		$(".sBox ul li").mouseenter(function(){
			if($(this).find("span:last-child").css("display")=="none")
			{$(this).find("div").show();}
			}).mouseleave(function(){$(this).find("div").hide();})	
})
</script>
	<script type="text/javascript">
		//初始化
	    init();
	    var data=null;
		//查询菜单列表
		function loadMenuData(parentId,depthNum){
			data=null;
			$.ajax({
	    		url:'<%=request.getContextPath() %>/sysmenu/load',
	    		data:{"parentId":parentId,"depthNum":depthNum},
	    		async: false,//禁止异步查询
	    		success:function(resultData){
	    			data=resultData;
	    		},
	    		error:function(data){
					alert("error");
				}
	    	});
		}
		//设置顶部站点与服务菜单列表
		function setSiteMenu(dataJson){
			$(".topbar-nav-list").empty();
			var doc1="";
			var doc2="";
			var doc3="";
			$.each(JSON.parse(dataJson), function(i, field){ 
				doc1="<div class='topbar-nav-col'>";
                doc2+="<div class=''><p class='topbar-nav-item-title'>"+field.name+"</p><ul>"+setSiteChild(field.childMenu)+"</ul></div>";
                //alert((i%2));
                if(i!=0){
	                if((i%2)==0){
	                	doc3="</div>";	
	              		$(".topbar-nav-list").append(doc1+doc2+doc3);
	              		doc1="";
	              		doc2="";
	              		doc3="";
	                }
                }
			});
			$(".topbar-nav-list").append(doc1+doc2+doc3);
		}
		//设置顶部站点与服务菜单 子 列表
		function setSiteChild(childMenu){
			//alert(JSON.stringify(childMenu));
			var doc="";
				$.each(childMenu,function(j,fielld){
					doc+="<li><a onClick=openChrild('"+fielld.id+"')>"
                    +"<span class='glyphicon glyphicon-road'></span> "
                    +"<span class=''>"+fielld.name+"</span> "
                    +"</a>"
                    +"</li>";
				});
				return doc;
			}
		//初始化
		function init(){
			//初始化站点列表
			loadMenuData("0","2");
			//显示站点列表
			setSiteMenu(data);
			//重新设置左侧菜单的单击显示隐藏事件
			setSubNavShowHide();
		}
		//站点列表点击事件
		function openChrild(parentid){
			loadMenuData(parentid,2);
			setLeftTreeMenu();
		}
		//设置左侧菜单列表
		function setLeftTreeMenu(){
			$(".subNavBox").empty();
			$.each(JSON.parse(data),function(j,fielld){
				var menu1="<div class='sBox'>"
			        +"<div class='subNav sublist-up'><span class='title-icon glyphicon glyphicon-chevron-up'></span><span class='sublist-title'>"+fielld.name+"</span></div>"
			        +"<ul class='navContent' style='display:none'>";
			        var menu2=setLeftTreeMenuChirld(fielld.childMenu);
			        var menu3="</ul></div>";
			        $(".subNavBox").append(menu1+menu2+menu3);
			});
			//重新设置左侧菜单的单击显示隐藏事件
			setSubNavShowHide();
			//设置左侧菜单的单击事件
			setLeftMenuClick();
		}
		function setLeftTreeMenuChirld(menuChrild){
			if(menuChrild==null)return "";
			var doc="";
			$.each(menuChrild,function(j,fielld){
				doc+="<li class=''>"
				        +"<a href='#'  id='"+fielld.id+"' name='"+fielld.url+"'><span class='sublist-icon glyphicon glyphicon-user'></span><span class='sub-title'>"+fielld.name+"</span></a>" 
		        	+"</li>";
			});
			return doc;
		}
		
		function setSubNavShowHide(){
		/*左侧导航栏显示隐藏功能*/
		$(".subNav").click(function(){			
			$(this).removeClass("sublist-down");
			$(this).removeClass("sublist-up");
					/*显示*/
					if($(this).find("span:first-child").attr('class')=="title-icon glyphicon glyphicon-chevron-down")
					{
						$(this).find("span:first-child").removeClass("glyphicon-chevron-down");
					    $(this).find("span:first-child").addClass("glyphicon-chevron-up");
					    $(this).removeClass("sublist-down");
						$(this).addClass("sublist-up");
					}
					/*隐藏*/
					else
					{
						$(this).find("span:first-child").removeClass("glyphicon-chevron-up");
						$(this).find("span:first-child").addClass("glyphicon-chevron-down");
						$(this).removeClass("sublist-up");
						$(this).addClass("sublist-down");
					}	
				// 修改数字控制速度， slideUp(500)控制卷起速度
			    $(this).next(".navContent").slideToggle(300).siblings(".navContent").slideUp(300);
			})
		}
		var zindex=999;
		//左侧菜单点击事件
		function setLeftMenuClick(){
			//左侧菜单点击事件 
			$(".navContent li a").click(function(){
				$(".navContent li").removeClass("active");
				$(this).parent().addClass("active");
				//id
				var id=$(this).attr("id");
				//url
				var url=$(this).attr("name");
				//标题
				var menuName=$(this).text();
				//
				var tabid="#tab"+id;
				//该菜单是否已经打开
				if(null!=$(tabid).html()){
					//已经打开，直接显示
					$(tabid).trigger("click");
					return;
				}
				zindex=(zindex-1);
				//新建窗口显示,添加选项卡
				$("#tab-header").append("<li role='presentation' id='li"+id+"' style='z-index:"+zindex+"'>"
										+"<a href='#Section"+id+"'  id='tab"+id+"' aria-controls='messages' role='tab' data-toggle='tab'>"
											+menuName
										+"&nbsp;&nbsp;<span class='glyphicon glyphicon-remove' onClick='closeForm("+id+")'></span></a></li>");
				//添加页面
				$(".tab-content").append("<div role='tabpanel' class='tab-pane' id='Section"+id+"'>"
											+"<iframe src='"+'<%=request.getContextPath() %>/'+url+"' width='100%' height='100%' frameborder='0'></iframe>"
										+"</div>");
				$(tabid).trigger("click");
			});
		}
		function closeForm(obj){
		    var isActive=null;
			//判断窗体是否激活
			if($("#li"+obj).attr("class")=='active'){
				isActive='active';
			}
			//获取当前窗体的上一个窗体和下一个窗体
			var prev=$("#li"+obj).prev();
			var next=$("#li"+obj).next();
			//关闭当前窗口
			$("#li"+obj).remove();
			$("#Section"+obj).remove();
			//当前的窗体是否激活
			if(isActive!=null){
				if(null!=next.html()){
					$(next).find("a").trigger("click");
					//显示上一个窗口
					$("#tab"+obj).trigger("click");
				}else{
					//显示下一个窗口
					$(prev).find("a").trigger("click");
				}
			}
		}

	</script>





</body>
</html>
