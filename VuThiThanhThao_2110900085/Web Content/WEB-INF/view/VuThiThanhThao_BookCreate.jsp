<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Book</title>
<body>

	
	<section class="container">
		<h3>Create Book</h3>
			<p style="color: red;">${errorString}</p>
		<form method="POST" action="${pageContext.request.contextPath}/bookCreate">
			<table class="table table-bordered">
				<tr>
					<td>MaSach_msv</td>
					<td><input type="text" name="MaSach_msv" value="${book.MaSach_msv}" /></td>
				</tr>
				<tr>
					<td>TenSach_msv</td>
					<td><input type="text" name="TenSach_msv" value="${book.TenSach_msv}" /></td>
				</tr>
				<tr>
					<td>SoLuong_msv</td>
					<td><input type="text" name="SoLuong_msv" value="${book.SoLuong_msv}" /></td>
				</tr>
				<tr>
					<td>DonGia_msv</td>
					<td><input type="text" name="DonGia_msv" value="${book.DonGia_msv}" /></td>
				</tr>
				<tr>
					<td>Anh_msv</td>
					<td><input type="text" name="Anh_msv" value="${book.Anh_msv}" /></td>
				</tr>
				<tr>
					<td></td>
				<td>
					<input type="submit" value="Ghi lại" class="btn btn-success" />
					<a href="bookList" class="btn btn-danger">Quay lại</a>
				</td>
				</tr>
		</table>
	</form>
	
</section>

</body>
</html>