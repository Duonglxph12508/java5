<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>
	<small>Users Page</small>
</h1>
<hr>

<div class="panel-group" id="accordion">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Username</th>
							<th>Password</th>
							<th>Email</th>
							<th>Photo</th>
							<th>Activated</th>
							<th>Role</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${page}">
							<tr>
								<td>${ user.username }</td>
								<td>${ user.password }</td>
								<td>${ user.email }</td>
								<td>
								<img alt="" src="${ user.photo }" width="100"
									height="100"></td>
								<td>${ user.activated == 1 ? 'Activated' : 'Not Activated' }</td>
								<td>${ user.admin == 1 ? 'ADMIN' : 'USER' }</td>
								<td><a
									href="${ pageContext.request.contextPath }/admin/users/edit/${user.id}"><button
											class="btn btn-warning open-formEdit">
											<span class="glyphicon glyphicon-pencil"></span>
										</button></a></td>
								<td><a
									href="${ pageContext.request.contextPath }/admin/users/delete/${user.id}"><button
											class="btn btn-danger">
											<span class="glyphicon glyphicon-trash"></span>
										</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pager">
					<li><a
						href="${ pageContext.request.contextPath }/admin/users?p=0"><span
							class="glyphicon glyphicon-fast-backward"></span></a></li>
					<li><a
						href="${ pageContext.request.contextPath }/admin/users?p=1"><span
							class="glyphicon glyphicon-backward"></span></a></li>
					<li><span class="badge"><b class="text-default"></b> </span></li>
					<li><a href="${ pageContext.request.contextPath }/admin/users"><span
							class="glyphicon glyphicon-forward"></span></a></li>
					<li><a href="${ pageContext.request.contextPath }/admin/users"><span
							class="glyphicon glyphicon-fast-forward"></span></a></li>
				</ul>
			</div>
		</div>
		<div class="panel-body">
			<div class="container">
				<form:form class="form-horizontal" method="POST"
					modelAttribute="userDTO"
					action="${ pageContext.request.contextPath }/admin/users/update/${userDTO.id }">
					<div class="row">
						<div class="col-xs-2">
							<img src="${userDTO.photo }" class="img-thumbnail" alt="image" width="300"
								height="400">
						</div>
						<div class="col-xs-10">
							<div class="form-group">
								<label for="username">Username *</label>
								<form:input class="form-control form-control-large"
									path="username" placeholder="Enter Username" disabled="" />
							</div>
						</div>
						<div class="col-xs-10">
							<div class="form-group">
								<label for="pwd">Password *</label>
								<form:input class="form-control form-control-small"
									path="password" placeholder="******" disabled="" />
							</div>
						</div>

						<div class="col-xs-10">
							<div class="form-group">
								<label for="photo">photo *</label>
								<form:input class="form-control form-control-small" path="photo"
									disabled="" />
							</div>
						</div>

						<div class="col-xs-2"></div>
						<div class="col-xs-10">
							<div class="form-group">
								<label for="email">Email *</label>
								<form:input class="form-control form-control-small" path="email"
									placeholder="Enter email" disabled="" />
							</div>
						</div>
						<div class="col-xs-5 ">
							<div class="form-group">
								<label for="admin">Role</label>
								<form:select path="admin" cssClass="form-control">
									<form:option value="1">Admin</form:option>
									<form:option value="0">Member</form:option>
								</form:select>
							</div>
						</div>

						<div class="col-xs-5">
							<div class="form-group">
								<label for="activated">activated</label>
								<form:select path="activated" cssClass="form-control">
									<form:option value="1">Đang hoạt động</form:option>
									<form:option value="0">Vô hiệu hóa</form:option>
								</form:select>
								<form:errors path="admin" element="span" cssClass="text-danger" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-primary">
									<span class="glyphicon glyphicon-floppy-save">Save</span>
								</button>
								<!-- 
								<button class="btn btn-success"
									formaction="/admin/users/clear">
									<span class="glyphicon glyphicon-refresh">Clear</span>
								</button> -->
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
