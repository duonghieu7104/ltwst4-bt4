<a href="<c:url value='/admin/category/add'></c:url>">Add Category</a>
<br>

<hr>

<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Images</th>
		<th>Category name</th>
		<th>Status</th>
		<th>Action</th>
	</tr>

	<c:forEach items="${listcate}" var="cate" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>

			<c:if
				test="${cate.images != null && cate.images.substring(0,5).equals('https')}">
				<c:url value="${cate.images}" var="imgUrl"></c:url>
			</c:if>

			<c:if
				test="${cate.images != null && !cate.images.substring(0,5).equals('https')}">
				<c:url value='/image?fname=${cate.images}' var="imgUrl"></c:url>
			</c:if>

			<td><img height="150" width="200" src="${imgUrl}" /></td>
			<td>${cate.categoryname }</td>
			<td><c:if test="${cate.status==1}">Hoạt động</c:if> <c:if
					test="${cate.status!=1}">Khóa</c:if></td>
			<td><a
				href="<c:url value='/admin/category/edit?id=${cate.categoryid}'></c:url>">Sửa</a>
				| <a
				href="<c:url value='/admin/category/delete?id=${cate.categoryid}'></c:url>">Xóa</a>
			</td>
		</tr>
	</c:forEach>
</table>
