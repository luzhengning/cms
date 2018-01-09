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
					    
						  <ul id="menu-list" >
						  	<li>
						  		<p>
						  			<button type="button" class="btn btn-sm btn-default">Default</button>
									<button type="button" class="btn btn-sm btn-primary">Primary</button>
									<button type="button" class="btn btn-sm btn-success">Success</button>
									<button type="button" class="btn btn-sm btn-info">Info</button>
									<button type="button" class="btn btn-sm btn-warning">Warning</button>
									<button type="button" class="btn btn-sm btn-danger">Danger</button>
									<button type="button" class="btn btn-sm btn-link">Link</button>
						  		</p>
						  	</li>
						  	<li>
						  		<span class="form-group">
									 <label for="exampleInputEmail1">Email address</label>
									 <input type="email" class="form-control" id="exampleInputEmail1" style="display: -webkit-inline-box;"/>
								</span>
						  	</li>
						  	<li>
						  		<div class="btn-group">
									 <button class="btn btn-default">Action</button> <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"><span class="caret"></span></button>
									<ul class="dropdown-menu">
										<li>
											 <a href="#">操作</a>
										</li>
										<li class="disabled">
											 <a href="#">另一操作</a>
										</li>
										<li class="divider">
										</li>
										<li>
											 <a href="#">其它</a>
										</li>
									</ul>
								</div>
						  	</li>
						  </ul>
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
							<h6>
								<span class="label label-default">Default</span>
								<span class="label label-primary">Primary</span>
								<span class="label label-success">Success</span>
								<span class="label label-info">Info</span>
								<span class="label label-warning">Warning</span>
								<span class="label label-danger">Danger</span>
							  </h6>
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
							<h6>
								<span class="label label-default">Default</span>
								<span class="label label-primary">Primary</span>
								<span class="label label-success">Success</span>
								<span class="label label-info">Info</span>
								<span class="label label-warning">Warning</span>
								<span class="label label-danger">Danger</span>
							  </h6>
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
								 <a href="#">Prev</a>
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
								 <a href="#">Next</a>
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
<script src="../static/js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../static/bootstrap-3.3.7-dist//js/bootstrap.min.js" type="text/javascript"></script>
</html>
