<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<div class="panel-body">
		<div class="container">
			<form:form class="form-horizontal" method="POST"
				modelAttribute="prod" action="/asg/admin/product}">
				<div class="row">
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
							<button class="btn btn-primary"
								formaction="/asg/admin/product/store">

								<span class="glyphicon glyphicon-floppy-save">Save</span>
							</button>
							<button class="btn btn-success"
								formaction="/asg/admin/product/clearcr">
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