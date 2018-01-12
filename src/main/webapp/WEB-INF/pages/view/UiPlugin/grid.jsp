<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="../static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../static/bootstrap-3.3.7-dist/css/bootstrap-theme.css" />
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
</style>
</head>

<body>
<div class="col-md-12 column">
		<ul class="breadcrumb">
				<li>
					 <a href="#">Home</a>
				</li>
				<li>
					 <a href="#">Library</a>
				</li>
				<li class="active">
					Data
				</li>
			</ul>
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
						  			<button type="button" class="btn btn-sm btn-primary"><em class="glyphicon glyphicon-search"></em>&nbsp;查询全部</button>
									<button type="button" class="btn btn-sm btn-success"><em class="glyphicon glyphicon-th-list"></em>&nbsp;多条件查询</button>
									<button type="button" class="btn btn-sm btn-info"><em class="glyphicon glyphicon-plus"></em>&nbsp;新增</button>
									<button type="button" class="btn btn-sm btn-warning"><em class="glyphicon glyphicon-refresh"></em>&nbsp;刷新</button>
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
					    	<div class="col-md-2">
						    	<span class="form-group" style="float:right;">
									 <label for="exampleInputEmail1">全文搜索</label>
									 <input type="email" class="form-control" id="exampleInputEmail1" placeholder="内容搜索" style="display: -webkit-inline-box;"/>
								</span>
					    	</div>
					    </div>
						<table class="table table-hover table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							产品
						</th>
						<th>
							交付时间
						</th>
						<th>
							状态
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
								<span class="label label-default">Default</span>
								<span class="label label-primary">Primary</span>
								<span class="label label-success">Success</span>
								<span class="label label-info">Info</span>
								<span class="label label-warning">Warning</span>
						</td>
					</tr>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<span class="label label-default">Default</span>
							<span class="label label-primary">Primary</span>
							<span class="label label-success">Success</span>
							<span class="label label-info">Info</span>
							<span class="label label-warning">Warning</span>
							<span class="label label-danger">Danger</span>
						</td>
					</tr>
					<tr>
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr>
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr>
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
						<ul class="pagination pagination-sm">
							<li>
								 <a href="#">上一页</a>
							</li>
							<li>
								 <a href="#">1</a>
							</li>
							<li>
								 <a href="#">2</a>
							</li>
							<li>
								 <a href="#">3</a>
							</li>
							<li>
								 <a href="#">4</a>
							</li>
							<li>
								 <a href="#">5</a>
							</li>
							<li>
								 <a href="#">下一页</a>
							</li>
						</ul>
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
<script src="../static/jQuery/jquery-2.2.4.min.js"></script>
<script src="../static/bootstrap-3.3.7-dist//js/bootstrap.min.js" type="text/javascript"></script>
</html>
