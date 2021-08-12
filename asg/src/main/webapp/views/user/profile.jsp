<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<div class="row">
		<br> <br>
		<div class="col-xs-12 col-sm-12 ">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title	">${ user.username }</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3 col-lg-3 " align="center">
							<img alt="User Pic"
								src="${user.photo }"
								class="img-circle img-responsive">
						</div>

						<div class=" col-md-9 col-lg-9 ">
							<table class="table table-user-information text-center" style="font-size: medium;">
								<tbody>
									<tr>
										<td class="col-sm-3">username:</td>
										<td class="col-sm-9"><input type="text" class="form-control" value="${ user.username }"></td>
									</tr>
									<tr>
										<td class="col-sm-3">Password:</td>
										<td class="col-sm-9"><input type="password" class="form-control" value="${ user.password }"></td>
									</tr>
									
									<tr>
										<td class="col-sm-3">Email:</td>
										<td class="col-sm-9"><input type="email" class="form-control" value="${ user.email }"></td>
									</tr>
<tr>
										<td class="col-sm-3">Photo:</td>
										<td class="col-sm-9"><input type="text" class="form-control" value="${ user.photo }"></td>
									</tr>

								</tbody>
							</table>

							<a href="#" class="btn btn-primary">Save Change</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>