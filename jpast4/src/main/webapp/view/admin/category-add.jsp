<form action="<c:url value='/admin/category/insert'></c:url>"
	method="post" enctype="multipart/form-data">

	<label for="categoryname">Category name:</label><br> <input
		type="text" id="categoryname" name="categoryname"><br> <label
		for="images">Link images:</label><br> <input type="text"
		id="images" name="images"><br> <label for="images1">Upload
		images:</label><br> <input type="file" id="images1" name="images1"
		accept="image/*"><br> <label for="ston">Status:</label><br>
	<input type="radio" id="ston" name="status" value="1"> <label
		for="ston">Hoạt động</label><br> <input type="radio" id="stoff"
		name="status" value="0"> <label for="stoff">Khóa</label><br>

	<br> <input type="submit" value="Insert">

</form>
