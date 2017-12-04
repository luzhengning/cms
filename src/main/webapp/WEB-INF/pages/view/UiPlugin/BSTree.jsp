<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Apricot 1.3</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="../static/Tree/BootstarpTree/css/default.css">
<link href="../static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
.htmleaf-header {
	margin-bottom: 15px;
	font-family: "Segoe UI", "Lucida Grande", Helvetica, Arial,
		"Microsoft YaHei", FreeSans, Arimo, "Droid Sans",
		"wenquanyi micro hei", "Hiragino Sans GB", "Hiragino Sans GB W3",
		"FontAwesome", sans-serif;
}

.htmleaf-icon {
	color: #fff;
}
</style>
</head>
<body>
	<div class="modal fade" id="modal-container-385581" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="editForm">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">菜单名称：</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="name" name="name" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">url路径：</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="url" name="url">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">角色：</label>
							<div class="checkbox col-sm-7" id="rolesCheckbox"></div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">排序：</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="sort_num"
									name="sort_num">
							</div>
							<h5 class="col-sm-3" style="font-family:"微软雅黑";">越少越靠前</h5>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">创建时间：</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="create_time"
									name="create_time">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">设为首页：</label>
							<div class="col-sm-7">
								<label><input type="checkbox" value="select"
									id="editMenuSelect" name="index_select"></input>设为首页</label>
							</div>
						</div>
						<input type="text" class="form-control" id=parent_id
							name="parent_id" style="display: none;"> <input
							type="text" class="form-control" id="editMenuId" name="id"
							style="display: none;">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>

		</div>

	</div>
	<div class="col-xs-12 column">
		<div class="tabbable" id="tabs-869427">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#panel-627835" data-toggle="tab">Section
						1</a></li>
				<li><a href="#panel-885641" data-toggle="tab">Section 2</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="panel-627835">
					<div class="col-sm-4">
						<h2>Collapsed</h2>
						<div id="treeview2" class=""></div>
					</div>
				</div>
				<div class="tab-pane" id="panel-885641">
					<p>Howdy, I'm in Section 2.</p>
				</div>
			</div>
		</div>
	</div>

	<script src="../static/jQuery/jquery-2.2.4.min.js"></script>
	<script src="../static/Tree/BootstarpTree/js/bootstrap-treeview.js"></script>
	<script src="../static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript">

        loadData("0","-1");
        //查询菜单列表
		function loadData(parentId,depthNum){
			$.ajax({
	    		url:'<%=request.getContextPath() %>/sysmenu/loadBsTree',
	    		data:{"parentId":parentId,"depthNum":depthNum},
	    		async: false,
	    		success:function(resultData){
	    			$('#treeview2').treeview({
	    		          levels: 1,
	    		          showTags: true,
	    		          data: resultData
	    		        });
	    		},
	    		error:function(data){
					alert("error");
				}
	    	});
		}
        //编辑
        function editBtn(obj){
        	var str=$(obj).attr("value").split(",");
			if(str[0]!=null)$("#name").val(str[0]);else $("#name").val("");
			if(str[1]!=null)$("#url").val(str[1]);else $("#url").val("");
			if(str[3]!=null)$("#sort_num").val(str[3]);else $("#sort_num").val("");
			if(str[6]!=null)$("#create_time").val(str[6]);else $("#create_time").val("");
			if(str[5]!=null)$("#parent_id").val(str[5]);else $("#parent_id").val("");
			if(str[4]!=null)$("#editMenuId").val(str[4]);else $("#editMenuId").val("");
			if("1"==str[7]){
				$("#editMenuSelect").attr("checked", true);
			}else{
				$("#editMenuSelect").attr("checked", false);
			}
			//用户角色数组
			var rolesArray=str[2].split("@");
			//setEditRoles(rolesArray);
			//$("#editSubmitTitle").attr("class","");
			//$("#editSubmitTitle").text("");
        }
        //添加子菜单
        function addBtn(id){
        	alert(id);
        }
        //删除菜单
        function deleteBtn(id){
        	alert(id);
        }


	  	</script>
</body>
</html>