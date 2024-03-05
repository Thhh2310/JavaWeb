<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
<body>

	<section class="container">
		<h3>Edit Book</h3>
			<p style="color: red;">${errorString}</p>
		<c:if test="${empty book}">
			<a href="productList">Quay lại</a>
		</c:if>
		<c:if test="${not empty book}">
		<form method="POST" action="${pageContext.request.contextPath}/bookEdit">
			<table class="table table-bordered">
				<tr>
					<td>MaSach_2110900033</td>
					<td><input type="text" name="MaSach_msv" value="${book.MaSach_2110900033}" /></td>
				</tr>
				<tr>
					<td>TenSach_2110900033</td>
					<td><input type="text" name="TenSach_msv" value="${book.TenSach_2110900033}" /></td>
				</tr>
				<tr>
					<td>SoLuong_2110900033</td>
					<td><input type="text" name="SoLuong_msv" value="${book.SoLuong_2110900033}" /></td>
				</tr>
				<tr>
					<td>DonGia_2110900033</td>
					<td><input type="text" name="DonGia_msv" value="${book.DonGia_2110900033}" /></td>
				</tr>
				<tr>
					<td>Anh_2110900033</td>
					<td><input type="text" name="Anh_msv" value="${book.Anh_2110900033}" /></td>
				</tr>
				<tr>
					<td></td>
				<td>
					<input type="submit" value="Ghi lại" class="btn btn-success" />
					<a href="productList" class="btn btn-danger">Quay lại</a>
				</td>
				</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Ghi lại" class="btn-btn-success" />
			<a href="bookList" class="btn btn-danger">Quay lại</a>
			</td>
		</tr>
	</table>
	</form>
	</c:if>
	</section>
</body>
</html>