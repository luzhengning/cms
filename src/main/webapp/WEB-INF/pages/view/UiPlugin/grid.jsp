<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="../static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../static/bootstrap-3.3.7-dist/css/bootstrap-theme.css" />

<!-- <link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" /> -->


<style>
	.form-control{
		width: auto;
	}
	#menu-list{
		list-style: none;
    display: -webkit-inline-box;
    padding: 0;
    line-height: 3;
    margin: 0;
	}
	.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
	    padding: 4px;
	    line-height: 1.42857143;
	    vertical-align: top;
	    border-top: 1px solid #ddd;
	    color: #333;
	    font-size: 13;
	}
	table{
		font-family: 微软雅黑;
	}
	table thead tr th{
		/* text-align: center; */
		background-color: #f5fafe;
		font-family: 微软雅黑;
	}
	table tbody tr td a span{
		display: -webkit-inline-box;
	}
</style>
</head>

<body>
<div class="modal fade" id="modal-container-385582" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="width: 700px;">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								查询
							</h4>
						</div>
						<div class="modal-body col-md-12" id="dislogForm">
							<form action="" class="col-md-12" id="SerachForm">
										<div class="col-md-3">
											<select name="columnName"
												class="form-control" id="columnName">
													 <c:forEach items="${column }" var="list">
									                    <option value="${list.columnEnTitle }" class="${list.columnClzTitle }">${list.columnCnTitle }</option>
									                 </c:forEach>
											</select>
										</div>
										<div class="col-md-2">
											<select name="condition"
												class="form-control" id="condition">
													<option value="=">=</option>
													<option value="<"><</option>
													<option value="<="><=</option>
													<option value=">">></option>
													<option value=">=">>=</option>
													<option value="!=">!=</option>
													<option value="LIKE">like</option>
											</select>
										</div>
										<div class="col-md-4">
											<input type="email" class="form-control" id="searchValue" name="searchValue" />
										</div>
										<div class="col-md-2">
											<select name="searchOrWith"
												class="form-control" id="searchOrWith">
													<option value="or">或</option>
													<option value="and">与</option>
											</select>
										</div>
										<div class="col-md-1" style="padding: 10px 0px 0px 0px;cursor: pointer;"; onclick="removeCondition(this)">
									          <span class="glyphicon glyphicon-minus"></span>
										</div>
								</form>
								
						</div>
						<div class="col-md-12" style="margin-left:30px;cursor: pointer;">
							<a href="#" class="btn btn-info btn-lg" onclick="addCondition()">
					          <span class="glyphicon glyphicon-plus"></span> 添加条件
					        </a>
						</div>
						<div class="modal-footer" >
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary" onclick="tiaojianQuery()">搜索</button>
						</div>
					</div>
					
				</div>
				
			</div>
			<div class="modal fade" id="modal-container-385588" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="width: 70%;height: 80%;">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="push()">×</button>
							<h4 class="modal-title" id="myModalLabelAddEdit">
	                            编辑
	                        </h4>
	                    </div>
	                   <div style="width:100%" id="iframeDilog"></div>
	                   <div class="modal-footer">
	                         <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="push()">关闭</button>
	                    </div>
					</div>
					
				</div>
				
			</div>
			<div class="modal fade" id="modal-container-385581" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">
                            删除提示
                        </h4>
                    </div>
                    <h2 class="deleteInfo glyphicon glyphicon-remove" id="deleteInfo" style="margin-left:10px">确认删除吗？</h2>
                    <div class="modal-footer">
                         <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true" id="deleteNavFormCancel">取消</button>
                         <button type="button" class="btn btn-danger" onClick="deleteSubmit()">删除</button>
                    </div>
					</div>
					
				</div>
				
			</div>
<div class="col-md-12 column">
			<div class="tabbable" id="tabs-725838">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-526586" data-toggle="tab">Section 1</a>
					</li>
					<li>
						 <a href="#panel-990630" data-toggle="tab">Section 2</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-526586">
					<h3 style="margin-top:8;padding:0;font-family: 微软雅黑;">${title }</h3>
					<hr style="FILTER: alpha(opacity=100,finishopacity=0,style=3);margin-top: 10px;margin-bottom: 10px;" width="100%" color="#987cb9" size="3">
					    	
					    <div class="row">
					    	<div class="col-md-5">
					    		<p>
					    			<button type="button" class="btn btn-sm">
										<label style="margin:0px;"><input style="margin:0px;" type="checkbox" name="checkBoxAllBtn" onclick="checkBoxAll(this)">全选</label>
									</button>
						  			<button type="button" class="btn btn-sm btn-primary" onclick="queryAll()"><em class="glyphicon glyphicon-search"></em>&nbsp;查询全部</button>
						  			<a id="modal-385582" href="#modal-container-385582" role="button"  data-toggle="modal">
										<button type="button" class="btn btn-sm btn-success"><em class="glyphicon glyphicon-th-list"></em>&nbsp;多条件查询</button>
									</a>
									<a id="modal-385588" href="#modal-container-385588" role="button"  data-toggle="modal">
												<button type="button" class="btn btn-sm btn-info" onclick="add()"><em class="glyphicon glyphicon-plus"></em>&nbsp;新增</button>
											</a>
									
									<button type="button" class="btn btn-sm btn-warning" onclick="push()"><em class="glyphicon glyphicon-refresh"></em>&nbsp;刷新</button>
						  		</p>
					    	</div>
					    	<div class="col-md-3">
					    			
								<!-- <div class="form-group">
									<select class="form-control input-sm">
										<option value="">.input-sm1</option>
										<option value="">.input-sm2</option>
										<option value="">.input-sm3</option>
										<option value="">.input-sm4</option>
									</select>
								</div> -->
					    	</div>
					    	<div class="col-md-2">
								<button type="button" class="btn btn-sm btn-default"><em class="glyphicon glyphicon-print"></em>&nbsp;打印</button>
								<button type="button" class="btn btn-sm btn-default"><em class="glyphicon glyphicon-log-out"></em>&nbsp;导出EXCEL</button>
					    	</div>
					    	<!-- <div class="col-md-2">
						    	<span class="form-group" style="float:right;">
									 <label for="exampleInputEmail1">全文搜索</label>
									 <input type="email" class="form-control" id="exampleInputEmail1" placeholder="内容搜索" style="display: -webkit-inline-box;"/>
								</span>
					    	</div> -->
					    </div>
						<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive dataTable no-footer" role="grid" aria-describedby="DataTables_Table_0_info">
							<thead>
								<tr>
									<th></th>
									<c:forEach items="${column }" var="list">
					                    <th>${list.columnCnTitle }</th>
					                 </c:forEach>
					                 <th>操作</th>
								</tr>
							</thead>
							<tbody id="gridList">
								
							</tbody>
						</table>
						<div id="pageBtn-menu">
							<ul class="pagination pagination-sm" id="paginationPage">
							</ul>
						</div>
					</div>
					<div class="tab-pane" id="panel-990630">
						<p>
							Howdy, I'm in Section 2.
						</p>
					</div>
				</div>
			</div>
		</div>
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"
	type="text/javascript"></script>
	<script src="../static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../static/main/js/afterPage.js"></script>

<script type="text/javascript">
    //分页参数
     totalPage=${page.totalPage };
     totalRow=${page.totalRow };
     pageRow=${page.pageRow };
     currentNum=${page.currentNum };
    statrNum=${page.statrNum };
    //分页json
    pageJsonData=${pageJsonData };
    pageBtn='requestSplit296';
    pageUrl='<%=request.getContextPath() %>${loadJsonUrl }';
    
    //列名
	var columnNameArray=[];
	//条件
	var conditionNameArray=[];
	//查询参数
	var searchValueArray=[];
	//或与
	var orWithArray=[];
	
    //获取查询的条件
	conditionList=[];
    
    requestSplit296('1');
    function requestSplit296(obj){
    	
    	//初始化列表
        var resultData=pageLoadJson($("#paginationPage"),obj,pageUrl,columnNameArray,conditionNameArray,searchValueArray,orWithArray);
    	//结果处理
        setTable(resultData);
    }
   
    function isLike(obj){
    	for(var j=0;j<conditionList.length;j++){
    		if(obj==conditionList[j])return true;
    	}
    	return false;
    }
    function tiaojianQuery(){
    	conditionList=[];
    	//获取查询的列名
    	var columnNameList=$("select[name='columnName']");
    	for(var i=0;i<columnNameList.length;i++){
    		columnNameArray.push($(columnNameList[i]).val()+"");
    	}
    	//获取查询的条件
    	var conditionNameList=$("select[name='condition']");
    	for(var i=0;i<conditionNameList.length;i++){
    		conditionNameArray.push($(conditionNameList[i]).val()+"");
    		if($(conditionNameList[i]).val()=="LIKE"){
    			conditionList.push(i);
    		}
    	}
    	//获取查询的参数
    	var searchValueList=$("input[name='searchValue']");
    	for(var i=0;i<searchValueList.length;i++){
    		if(isLike(i)==true){
    			searchValueArray.push("%"+$(searchValueList[i]).val()+"%");
    		}else{
    			searchValueArray.push($(searchValueList[i]).val()+"");
    		}
    	}
    	//获取查询的或与
    	var searchOrWithList=$("select[name='searchOrWith']");
    	for(var i=0;i<searchOrWithList.length;i++){
    		orWithArray.push($(searchOrWithList[i]).val()+"");
    	}
    	requestSplit296('1');
    }
    //结果显示到表格
    function setTable(obj){
    	$("#gridList").empty();
		var rolesArray=new Array();
		var nowpagenum=0;
		$.each(obj, function(i, field){
			if(i=="list"){
				$.each(field, function(j, field2){
					$("#gridList").append("<tr>"
							+"<td><input type=\"checkbox\" name=\"rowCheckbox\"  value="+field2["id"]+"  /> </td>"
		                    +getRowData(field2)
		                    +"<td data-value=\"2\">"
		                    +"<a id=\"modal-385588\" href=\"#modal-container-385588\" role=\"button\"  data-toggle=\"modal\"><span class=\"label label-primary\" onclick='editBtn("+field2["id"]+")'>编辑</span></a>"
		                    +"&nbsp;<a id=\"modal-385581\" href=\"#modal-container-385581\" role=\"button\"  data-toggle=\"modal\"><span class=\"label label-danger\" onclick='deleteBtn("+field2["id"]+")'>删除</span></a>"
		                    +"</td>"
		             +"</tr>");
				});
			}
		});
    }
    //处理一行数据
    function getRowData(obj){
    	var str="";
    	var columnNameList=$("#columnName");
    	columnNameList=$(columnNameList).children("option");
    	$(columnNameList).each(function(){  //遍历所有option  
	          if($(this).attr('class')!=''){  
	              str+="<td>"+obj[$(this).attr('class')]+"</td>";
	          }  
	     })
	     return str;
    }
    //选择复选框
    function jqchk(){ //jquery获取复选框值 
    	var chk_value =[]; 
    	$('input[id="rowCheckbox"]:checked').each(function(){ 
    		chk_value.push($(this).val()); 
    	}); 
    	alert(chk_value.length==0 ?'你还没有选择任何内容！':chk_value); 
   	} 
    //添加查询条件
    function addCondition(){
    	$("#SerachForm").clone(true).appendTo("#dislogForm");  
    }
    //移除查询条件
    function removeCondition(obj){
    	if($("form[id='SerachForm']").size()==1)return;//:not(:first)
    	//删除当前查询
    	$(obj).parent().remove();
    }
    //查询全部
    function queryAll(){
    	$("form[id='SerachForm']:not(:first)").remove();
    	$("#searchValue").val("");
    	//列名
    	columnNameArray=[];
    	//条件
    	conditionNameArray=[];
    	//查询参数
    	searchValueArray=[];
    	//或与
    	orWithArray=[];
    	requestSplit296('1');
    }
    //第一列checkBOx全选或反选
    function checkBoxAll(obj){
    	 if($('input[name="checkBoxAllBtn"]:checked').val()=="on"){
    		$("input[name='rowCheckbox']").prop("checked",true);
    		return;
    	}else{
    		$("input[name='rowCheckbox']").prop("checked",false); 
    		return;
    	} 
    	/* var chk_value =[]; 
    	$('input[id="rowCheckbox"]:checked').each(function(){ 
    		chk_value.push($(this).val()); 
    	}); 
    	alert(chk_value.length==0 ?'你还没有选择任何内容！':chk_value);  */
    }
    var deleteId="";
    function deleteBtn(obj){
    	$("#deleteInfo").text("确认删除吗？");
    	deleteId="";
    	deleteId=obj;
    }
    function deleteSubmit(){
    	$.ajax({
    		url:'<%=request.getContextPath() %>${deleteUrl }',
    		data:{"id":deleteId},
    		async: false,
    		success:function(resultData){
    			var jsondatas=jsonFormat(resultData,false);
    			if(jsondatas[0]=='0000'){
    				$("#deleteInfo").text(jsondatas[1]);
    				requestSplit296(currentNum);
    				$("#deleteNavFormCancel").click();
    			}else{
    				$("#deleteInfo").text(jsondatas[1]);
    			}
    		}
    	});
    }
    function editBtn(obj){
    	$("#myModalLabelAddEdit").text("编辑");
    	var url='<%=request.getContextPath() %>${editUrl }?id='+obj;
    	$("#iframeDilog").empty();
    	$("#iframeDilog").append("<iframe frameborder='0' src="+url+" width='100%' height='100%' scrolling='yes' />");
    }
    //刷新
    function push(){
    	requestSplit296(currentNum);
    }
    function add(){
    	<%-- $("#menuTab2").click();
    	var url='<%=request.getContextPath() %>${editUrl }';
    	$("#panel-885641").empty();
    	$("#panel-885641").append("<iframe frameborder='0' src="+url+" width='100%' height='100%' scrolling='yes' />"); --%>
    	$("#myModalLabelAddEdit").text("新增");
    	var url='<%=request.getContextPath() %>${editUrl }';
    	$("#iframeDilog").empty();
    	$("#iframeDilog").append("<iframe frameborder='0' src="+url+" width='100%' height='100%' scrolling='yes' />");
    }
    //$("#modal-container-385588").hide(function(){alert("adf");});
        function say(obj){
        	columnNameArray.splice(0,columnNameArray.length);//清空数组 
        	conditionNameArray.splice(0,conditionNameArray.length);//清空数组 
        	searchValueArray.splice(0,searchValueArray.length);//清空数组 
        	orWithArray.splice(0,orWithArray.length);//清空数组 
    		
        	columnNameArray.push(obj[0]);
    		conditionNameArray.push(obj[1]);
    		searchValueArray.push(obj[2]);
    		orWithArray.push(obj[3]);
    		requestSplit296("1");
        }
        function callParent(){
            parent.say();
        }
    </script>
    
</html>
