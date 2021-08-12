<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>
	<small>Products Page</small>
</h1>
<hr>

<div class="panel-group" id="accordion">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Product Name</th>
							<th>Image</th>
							<th>Price</th>
							<th>CreateDate</th>
							<th>Available</th>
							<th>Category</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${page}">
							<tr>
								<td>${ item.id }</td>
								<td>${ item.name }</td>
								<td><img alt="photo" src="${ item.image }" width="100"
									height="100"></td>
								<td>${ item.price }</td>
								<td>${ item.create_date }</td>
								<td>${ item.available == 1 ? 'Available' : 'Not Available' }</td>
								<td>${ item.cate.name}</td>
								<td><a href="/asg/admin/product/edit/${item.id}"><button
											class="btn btn-warning open-formEdit">
											<span class="glyphicon glyphicon-pencil"></span>
										</button></a></td>
								<td><a href="/asg/admin/product/delete/${item.id}"><button
											class="btn btn-danger">
											<span class="glyphicon glyphicon-trash"></span>
										</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<%--<ul class="pager">
					<li><a href="/admin/product?p=0"><span
							class="glyphicon glyphicon-fast-backward"></span></a></li>
					<li><a
						href="/admin/product?p=${page.number == 0 ?  0 : page.number-1}"><span
							class="glyphicon glyphicon-backward"></span></a></li>
					<li><span class="badge"><b class="text-default">${page.number+1}</b>
					</span></li>
					<li><a
						href="/admin/product?p=${page.number == page.totalPages-1 ? page.totalPages-1 : page.number+1}"><span
							class="glyphicon glyphicon-forward"></span></a></li>
					<li><a href="/admin/product?p=${page.totalPages-1}"><span
							class="glyphicon glyphicon-fast-forward"></span></a></li>
				</ul> --%>
			</div>
		</div>
		<div class="panel-body">
			<div class="container">
				<form:form class="form-horizontal" method="POST"
					modelAttribute="prod" action="/asg/admin/product}">
					<div class="row">
						<div class="col-xs-2">
							<img src="${prod.image}" class="img-thumbnail" alt="image"
								width="200" height="300">
						</div>
						<div class="col-xs-10">
							<div class="form-group">
								<label for="id">ID *</label>
								<form:input class="form-control form-control-large" id="id"
									path="id" disabled="true" />
							</div>
						</div>
						<div class="col-xs-10">
							<div class="form-group">
								<label for="name">Product Name *</label>
								<form:input class="form-control form-control-large" id="name"
									path="name" placeholder="Enter Product Name" />
							</div>
						</div>
						<div class="col-xs-2"></div>
						<div class="col-xs-10">
							<div class="form-group">
								<label for="price">Price *</label>
								<form:input class="form-control form-control-small" id="price"
									path="price" placeholder="Enter Price" />
							</div>
						</div>
						<div class="col-xs-2"></div>
						<div class="col-xs-10">
							<div class="form-group">
								<label for="price">Image</label>
								<form:input class="form-control form-control-small" id="price"
									path="image" placeholder="Enter Price" />
							</div>
						</div>

						<div class="col-xs-2"></div>

						<div class="col-xs-3">
							<div class="form-group">
								<label for="cate">Category</label> <br>
								<form:select id="cate" path="cate" cssClass="form-control">
									<form:options items="${ categories }" itemValue="id"
										itemLabel="name" />
								</form:select>
							</div>
						</div>
						<div class="col-xs-3">
							<div class="form-group">
								<label for="available">available</label>
								<form:select path="available" cssClass="form-control">
									<form:option value="1">Đang hoạt động</form:option>
									<form:option value="0">Vô hiệu hóa</form:option>
								</form:select>
								<form:errors path="available" element="span"
									cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<button class="btn btn-primary" formaction="/asg/admin/product/update/${prod.id }">
									
									<span class="glyphicon glyphicon-floppy-save">Save</span>
								</button>
								<button class="btn btn-success"
									formaction="/asg/admin/product/clear">
									<span class="glyphicon glyphicon-refresh">Clear</span>
								</button>
							</div>
						</div>
					</div>
					<br>
					<br>
				</form:form>
			</div>
		</div>
	</div>
</div>


