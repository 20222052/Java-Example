<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Đăng Nhập</title>
  <!-- Nhúng Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
	<div class="row">
	<div class="col-3"></div>
	
		<div class="col-6 boder card p-4">
			<h1 class="text-center text-uppercase custom-text-color text-danger custom-bg">
	    		Đăng nhập
	 		</h1>
			<form action="Post" class=" form form-horizontal">
			<div class="form-group">
				<label class="text-left">Tên đăng nhập</label>
				<input type="text" class="form-control" placeholder="mời bạn nhập tên đăng nhập" name="username">
			</div>
			<div class="form-group">
				<label>Mật khẩu</label>
				<input type="text" class="form-control" placeholder="mời bạn nhập mật khẩu" name="username">
			</div>
			<br>
				<button class="btn btn-primary">Submit</button>
			</form>
			<p>Bạn chưa có tài khoản?</p><a href="#">Đăng kí.</a>
		</div>
		<div class="col-3"></div>
	</div>
</div>
</body>
</html>