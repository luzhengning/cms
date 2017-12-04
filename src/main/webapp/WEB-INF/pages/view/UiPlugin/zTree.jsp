<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	title="" rel="stylesheet" />
<link rel="stylesheet" href="../static/Plugin/zTree/css/demo.css"
	type="text/css">
<link rel="stylesheet"
	href="../static/Plugin/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="../static/jQuery/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="../static/jQuery/zTree/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="../static/jQuery/zTree/jquery.ztree.excheck.js"></script>
<script type="text/javascript"
	src="../static/jQuery/zTree/jquery.ztree.exedit.js"></script>
<script src="../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript"></script>
<!--  <script type="text/javascript" src="../../js/jquery.ztree.excheck.js"></script>
	  <script type="text/javascript" src="../../js/jquery.ztree.exedit.js"></script>-->
<SCRIPT type="text/javascript">
		
		var setting = {
			edit: {//启用编辑
				enable: true
			},
			view: {
				//显示添加按钮
				addHoverDom: addHoverDom,
				//隐藏添加按钮
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			check: {//启用多选按钮
				enable: true,
				//指定显示多选按钮
				nocheckInherit: true,
				//指定禁用多选按钮
				chkDisabledInherit: true
			},
			data: {
				key: {
					title:"t"
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick,
				onCheck: onCheck,
				//移动选项
				beforeDrag: beforeDrag,
				//移动选项
				beforeDrop: beforeDrop
			}
		};
		var zNodes1 =[
			{ name:"父节点1 - 展开", open:true,
				children: [
					{ name:"父节点11 - 折叠",
						children: [
							{ name:"叶子节点111",icon:"../../css/zTreeStyle/img/diy/2.png"},
							{ name:"叶子节点112"},
							{ name:"叶子节点113"},
							{ name:"叶子节点114"}
						]},
					{ name:"父节点12 - 折叠",
						children: [
							{ name:"叶子节点121"},
							{ name:"叶子节点122"},
							{ name:"叶子节点123"},
							{ name:"叶子节点124"}
						]},
					{ name:"父节点13 - 没有子节点", isParent:true}
				]},
			{ name:"父节点2 - 折叠",
				children: [
					{ name:"父节点21 - 展开", open:true,
						children: [
							{ name:"叶子节点211"},
							{ name:"叶子节点212"},
							{ name:"叶子节点213"},
							{ name:"叶子节点214"}
						]},
					{ name:"父节点22 - 折叠",
						children: [
							{ name:"叶子节点221"},
							{ name:"叶子节点222"},
							{ name:"叶子节点223"},
							{ name:"叶子节点224"}
						]},
					{ name:"父节点23 - 折叠",
						children: [
							{ name:"叶子节点231"},
							{ name:"叶子节点232"},
							{ name:"叶子节点233"},
							{ name:"叶子节点234"}
						]}
				]},
			{ name:"父节点3 - 没有子节点", isParent:true}

		];


		var zNodes2 =[
			{ id:1, pId:0, name:"展开、折叠 自定义图标不同", open:true, iconOpen:"../static/Plugin/zTree/css/zTreeStyle/img/diy/1_open.png", iconClose:"../../css/zTreeStyle/img/diy/1_close.png"},
			{ id:11, pId:1, name:"叶子节点1", icon:"../static/Plugin/zTree/css/zTreeStyle/img/diy/2.png"},
			{ id:12, pId:1, name:"叶子节点2", icon:"../static/Plugin/zTree/css/zTreeStyle/img/diy/3.png"},
			{ id:13, pId:1, name:"叶子节点3", icon:"../static/Plugin/zTree/css/zTreeStyle/img/diy/5.png"},
			{ id:2, pId:0, name:"展开、折叠 自定义图标相同", open:false, icon:"../static/Plugin/zTree/css/zTreeStyle/img/diy/4.png"},
			{ id:21, pId:2, name:"叶子节点1", icon:"../static/Plugin/zTree/css/zTreeStyle/img/diy/6.png"},
			{ id:22, pId:2, name:"叶子节点2", icon:"../static/Plugin/zTree/css/zTreeStyle/img/diy/7.png"},
			{ id:23, pId:2, name:"叶子节点3", icon:"../static/Plugin/zTree/css/zTreeStyle/img/diy/8.png"},
			{ id:3, pId:0, name:"不使用自定义图标", open:false, },
			{ id:31, pId:3, name:"叶子节点1",nocheck:true},//不显示多选按钮
			{ id:32, pId:3, name:"叶子节点2",checked:true},//选中状态
			{ id:33, pId:3, name:"叶子节点3",t:"我很普通，随便点我吧",chkDisabled:true}//禁用状态

		];
		//单击事件
		function beforeClick(treeId, treeNode, clickFlag) {
			//alert(treeNode.name );
			return (treeNode.click != false);
		}
		function onClick(event, treeId, treeNode, clickFlag) {
			//clickFlag:是否选中
			//alert(treeNode);
		}	
		//显示隐藏多选按钮
		function nocheckNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nocheck = e.data.nocheck,
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
				alert("请先选择一个节点");
			}

			for (var i=0, l=nodes.length; i<l; i++) {
				nodes[i].nocheck = nocheck;
				zTree.updateNode(nodes[i]);
			}
		}
	    //是否禁用多选按钮
		function disabledNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			disabled = e.data.disabled,
			nodes = zTree.getSelectedNodes(),
			inheritParent = false, inheritChildren = false;
			if (nodes.length == 0) {
				alert("请先选择一个节点");
			}
			if (disabled) {
				inheritParent = $("#py").attr("checked");
				inheritChildren = $("#sy").attr("checked");
			} else {
				inheritParent = $("#pn").attr("checked");
				inheritChildren = $("#sn").attr("checked");
			}

			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.setChkDisabled(nodes[i], disabled, inheritParent, inheritChildren);
			}
		}
		function onCheck(e, treeId, treeNode) {
			count();
		}
		function clearCheckedOldNodes() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getChangeCheckedNodes();
			for (var i=0, l=nodes.length; i<l; i++) {
				nodes[i].checkedOld = nodes[i].checked;
			}
		}
		//选中数量
		function count() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			checkCount = zTree.getCheckedNodes(true).length,
			nocheckCount = zTree.getCheckedNodes(false).length,
			changeCount = zTree.getChangeCheckedNodes().length;
			$("#checkCount").text(checkCount);
			$("#nocheckCount").text(nocheckCount);
			$("#changeCount").text(changeCount);

		}
		//移动选项
		function beforeDrag(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			return true;
		}
		//移动选项
		function beforeDrop(treeId, treeNodes, targetNode, moveType) {
			return targetNode ? targetNode.drop !== false : true;
		}
		
		function setEdit() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			remove = true,
			rename = true;
			zTree.setting.edit.showRemoveBtn = remove;
			zTree.setting.edit.showRenameBtn = rename;
			zTree.setting.edit.removeTitle = "删除";
			zTree.setting.edit.renameTitle = "修改";
			showCode(['setting.edit.showRemoveBtn = ' + remove, 'setting.edit.showRenameBtn = ' + rename,
				'setting.edit.removeTitle = "' + "删除" +'"', 'setting.edit.renameTitle = "' + "修改" + '"']);
		}
		function showCode(str) {
			
		}
		//显示添加按钮
		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				return false;
			});
		};
		//隐藏添加按钮
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes2);
			$.fn.zTree.init($("#treeDemo2"), setting);
			$("#nocheckTrue").bind("click", {nocheck: true}, nocheckNode);
			$("#nocheckFalse").bind("click", {nocheck: false}, nocheckNode);
			$("#disabledTrue").bind("click", {disabled: true}, disabledNode);
			$("#disabledFalse").bind("click", {disabled: false}, disabledNode);
			count();
			setEdit();
		});
		function submitDemo(){
			//获取对象
			var zTree = $.fn.zTree.getZTreeObj("treeDemo").getNodes();
			$("#demoHtml").html(JSON.stringify(zTree));
			$.each(zTree,function(index,tree1){
				//$("#demoHtml").html(JSON.stringify(tree1));
				//alert("id:"+tree1.pId+" name:"+tree1.name);
			});
		}
		
	</SCRIPT>
<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}
</style>
</HEAD>

<BODY>
	<h1>自定义图标 -- icon 属性</h1>
	<h6>[ 文件路径: core/custom_icon.html ]</h6>
	<div class="content_wrap">
		<div class="zTreeDemoBackground left">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		<div class="right">
			<ul id="treeDemo2" class="ztree"></ul>
		</div>
		<div class="right">
			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="nocheckTrue" href="#"
				title="set checkbox to be hidden." onclick="return false;">指定隐藏多选按钮</a>
			] &nbsp;&nbsp;&nbsp;&nbsp;[ <a id="nocheckFalse" href="#"
				title="set checkbox to be show." onclick="return false;">指定显示多选按钮</a>
			] <br /> &nbsp;&nbsp;&nbsp;&nbsp;[ <a id="disabledTrue" href="#"
				title="set checkbox to be disabled." onclick="return false;">禁用</a>
			] &nbsp;&nbsp;&nbsp;&nbsp;[ <a id="disabledFalse" href="#"
				title="set checkbox to be abled." onclick="return false;">取消禁用</a> ]
			<li><p>
					去勾选 checkbox 比较下面的数字变化：<br />
				<ul id="log" class="log" style="height: 110px;">
					<li>当前被勾选的节点共 <span id="checkCount" class="highlight_red"></span>
						个
					</li>
					<li>当前未被勾选的节点共 <span id="nocheckCount" class="highlight_red"></span>
						个
					</li>
					<li>勾选状态对比规则：<input type="radio" id="init" name="stateType"
						class="radio first" checked /><span>与 zTree 初始化时对比</span><br /> <input
						type="radio" id="last" name="stateType" class="radio first"
						style="margin-left: 108px;" /><span>与上一次勾选后对比</span></li>
					<li>当前被修改勾选状态的节点共 <span id="changeCount" class="highlight_red"></span>
						个
					</li>
				</ul>
				</p></li>

			<button name="name" type="button" onClick="submitDemo()">提交</button>
			<div id="demoHtml"></div>
		</div>
	</div>
</BODY>
</HTML>