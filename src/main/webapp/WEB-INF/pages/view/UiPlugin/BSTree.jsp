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
#headerRoles span{
	display:inline-block;
	margin: 2;
	cursor: pointer;
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
								<input type="text" class="form-control" id="sortNum"
									name="sortNum">
							</div>
							<h5 class="col-sm-3" style="font-family:"微软雅黑";">越少越靠前</h5>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">创建时间：</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="createTime"
									name="createTime" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">是否启用：</label>
							<div class="col-sm-7">
								<label><input type="checkbox" value="select"
									id="isEnable" name="isEnable"></input>是否启用</label>
							</div>
						</div>
						<input type="text" class="form-control" id="parentId"
							name="parentId" style="display: none;"> <input
							type="text" class="form-control" id="editMenuId" name="id"
							style="display: none;">
					</form>
				</div>
				<div class="modal-footer">
					<span class="deleteInfo glyphicon glyphicon-refresh" style="float:left;font-size:20px;" id="editSubmitTitle">正在提交...</span>
					<button type="button" class="btn btn-default" data-dismiss="modal"  id="editCloseBtn">关闭</button>
					<button type="button" class="btn btn-primary" onClick="editSubmit()">保存</button>
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
					<div class="col-sm-6">
						<h2>Collapsed</h2>
						<div class="col-sm-2" id="headerRoles">
						</div>
						<div class="col-sm-10">
					          <p>
					             <a href="#modal-container-385581" data-toggle="modal" style="text-decoration:none;">
						        	<button type="button" class="btn btn-default" onclick="addParentBtn()">添加顶级节点</button>
						        </a>
						        <button type="button" class="btn btn-sm btn-primary">Primary</button>
						        <button type="button" class="btn btn-sm btn-success">Success</button>
						        <button type="button" class="btn btn-sm btn-info">Info</button>
						        <button type="button" class="btn btn-sm btn-warning">Warning</button>
						        <button type="button" class="btn btn-sm btn-danger">Danger</button>
						        <button type="button" class="btn btn-sm btn-link">Link</button>
						      </p>
				         </div>
						<div id="treeview2" class="col-sm-10"></div>
					</div>
				</div>
				<div class="tab-pane" id="panel-885641">
					<p>Howdy, I'm in Section 2.</p>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modal-container-385582" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
           <div class="modal-dialog" style="width:500px;">
               <div class="modal-content">
                   <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                       <h4 class="modal-title" id="myModalLabel">
                           删除提示
                       </h4>
                   </div>
                   <h2 class="deleteInfo glyphicon glyphicon-remove" id="deleteInfo" style="margin-left:10px">确认删除吗？</h2>
                   <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"  aria-hidden="true" id="deleteNavFormCancel">取消</button>
                        <button type="button" class="btn btn-danger" onClick="deleteSubmit()">删除</button>
                   </div>
               </div>
               
           </div>
       </div>
	<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
	<script src="../static/Tree/BootstarpTree/js/bootstrap-treeview.js"></script>
	<script src="../static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script src="../static/main/js/utils.js"></script>
	<script src="../static/main/webJs/SysMenuJs.js" type="text/javascript"></script>
	<script src="../static/main/webJs/JsonUtil.js" type="text/javascript"></script>
	<script type="text/javascript">
		//角色json对象
		var rolesResult;
		//角色id
		var roleId=null;
		//获取角色json
		rolesLoad();
		//加载数菜单
        setTreeView(SysMenuloadBsTreeData(null,${id },"-1",'<%=request.getContextPath() %>'));
        function setTreeView(datajson){
        	$('#treeview2').treeview({
		          levels: 1,
		          showTags: true,
		          data: datajson
		        });
        }
        //编辑
        function editBtn(obj){
        	var str=$(obj).attr("value").split(",");
        	if(str.length>1){
        		//编辑
				if(str[0]!=null)$("#name").val(str[0]);else $("#name").val("");
				if(str[1]!=null)$("#url").val(str[1]);else $("#url").val("");
				if(str[3]!=null)$("#sortNum").val(str[3]);else $("#sortNum").val("");
				if(str[6]!=null)$("#createTime").val(str[6]);else $("#createTime").val("");
				if(str[5]!=null)$("#parentId").val(str[5]);else $("#parentId").val("");
				//id
				if(str[4]!=null)$("#editMenuId").val(str[4]);else $("#editMenuId").val("");
				if("1"==str[7]){
					$("#isEnable").attr("checked", true);
				}else{
					$("#isEnable").attr("checked", false);
				}
				//用户角色数组
				var rolesArray=str[2].split("@");
				setEditRoles(rolesArray);
        	}else{
        		//添加
        		$("#name").val("");
				$("#url").val("");
				$("#sortNum").val("");
				$("#createTime").val(writeCurrentDate());
				$("#parentId").val(str);
				//id
				$("#editMenuId").val("");
				$("#isEnable").prop("checked", true);
				//用户角色数组
				setEditRoles("XXOO");
        	}
        	$("#editSubmitTitle").attr("class","");
			$("#editSubmitTitle").text("");
        }
        function addParentBtn(){
        	//添加
    		$("#name").val("");
			$("#url").val("");
			$("#sortNum").val("");
			$("#createTime").val(writeCurrentDate());
			$("#parentId").val(${id });
			//id
			$("#editMenuId").val("");
			$("#isEnable").attr("checked", true);
			//用户角色数组
			setEditRoles("XXOO");
			$("#editSubmitTitle").attr("class","");
			$("#editSubmitTitle").text("");
		}
        //添加子菜单
        function addBtn(id){
        	alert(id);
        }
      //页面删除按钮
		function deleteBtn(obj){
			navid=obj;
			$("#deleteInfo").attr("class","");
			$("#deleteInfo").text("确认删除吗？");
		}
		//删除提交
		function deleteSubmit(){
			$("#deleteInfo").attr("class","glyphicon glyphicon-refresh");
			$("#deleteInfo").text("正在删除...");
			var result=SysMenudeleteById(navid,'<%=request.getContextPath() %>');
			var datas=jsonFormat(result,false);
			if(!datas[0]=="0000"){
				$("#deleteInfo").attr("class","glyphicon glyphicon-remove");
				$("#deleteInfo").text(datas[1]);
				return;
			}
			else{
				setTreeView(SysMenuloadBsTreeData(roleId,${id },"-1",'<%=request.getContextPath() %>'));
				$("#deleteInfo").attr("class","glyphicon glyphicon-ok");
				$("#deleteInfo").text("删除成功!");
				$("#deleteNavFormCancel").trigger('click');
			}
		}
      //加载角色信息
		function rolesLoad(){
			$("#rolesCheckbox").empty();
			$.ajax({url:"<%=request.getContextPath() %>/role/load",
			success:function(result){
				rolesResult=jsonFormat(result,false)[3];
				$("#headerRoles").empty();
				$("#headerRoles").append("<span class=\"label label-success\" value=\"110\" onclick=\"queryRoleBtn(null)\">查询全部</span>");
				var rolesArray=new Array();
				rolesResult=JSON.parse(rolesResult);
				$.each(rolesResult, function(i, field){
					if(i=="list"){
						$.each(field, function(j, fieldd){
							rolesArray[0]=fieldd["id"];
							rolesArray[1]=fieldd["roleName"];
							$("#headerRoles").append("<span class=\"label label-danger\" value=\"110\" onclick=\"queryRoleBtn("+rolesArray[0]+")\">"+rolesArray[1]+"</span>");
						});
						
					}
				});
		    }});
		}
		//顶部角色查询按钮
		function queryRoleBtn(obj){
			roleId=obj;
			//加载数菜单
	        setTreeView(SysMenuloadBsTreeData(roleId,${id },"-1",'<%=request.getContextPath() %>'));
		}
		//设置复选框是否选中，编辑按钮调用，
		function setEditRoles(rolesIdArray){
			var select="";
			$("#rolesCheckbox").empty();
			var rolesArray=new Array();
			$.each(rolesResult, function(i, field){
				if(i=="list"){
					$.each(field, function(j, fieldd){
						rolesArray[0]=fieldd["id"];
						rolesArray[1]=fieldd["roleName"];
						select="";
						for(i=0;i<rolesIdArray.length;i++){
							if(rolesArray[0]==rolesIdArray[i]){
								select="checked=checked"
								break;
							}
						}
						$("#rolesCheckbox").append("<label><input type=\"checkbox\" "+select+" value="+rolesArray[0]+"  name=roleIds  ></input>"+rolesArray[1]+"</label>&nbsp;&nbsp;");
					});
				}
				
			});
		}
		//提交更新
		function editSubmit(){
			if(isNull($("#name"))){
				$("#editSubmitTitle").attr("class","glyphicon glyphicon-remove");
    			$("#editSubmitTitle").text("菜单名称不能为空!");
    			return;
			}
			if(isNull($("#sortNum"))){
				$("#editSubmitTitle").attr("class","glyphicon glyphicon-remove");
    			$("#editSubmitTitle").text("排序不能为空!");
    			return;
			}
			
			$("#editSubmitTitle").attr("class","glyphicon glyphicon-refresh");  
			$("#editSubmitTitle").text("正在提交...");
			var param=$('#editForm').serialize();
			var result=SysMenuedit(param,'<%=request.getContextPath() %>');
           	var datas=jsonFormat(result,false);
           	if("0000"==datas[0]){
           		//alert(roleId+"    "+${id });
           		setTreeView(SysMenuloadBsTreeData(roleId,${id },"-1",'<%=request.getContextPath() %>'));
           		$("#editSubmitTitle").attr("class","glyphicon glyphicon-ok");
       			$("#editSubmitTitle").text("修改成功");
       			$("#editCloseBtn").trigger('click'); 
           	}else{
           		$("#editSubmitTitle").attr("class","glyphicon glyphicon-remove");
       			$("#editSubmitTitle").text(datas[1]);
           	}
		}
		function isNull(obj){
			if(($.trim(obj.val())=="null")||($.trim(obj.val()).length==0))return true;
		}
		
	  	</script>
</body>
</html>