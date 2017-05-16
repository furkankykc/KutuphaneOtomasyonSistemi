<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form commandName="Book" action="" method="POST">
    	<label>Kitap Adı:</label> <input value="${Book.getBookName() }" type='text' name='bookName' />
    	<label>Sayfa Sayısı</label> <input value="${Book.getBookPage() }"type='int' name='bookPage' />
    	<input type="hidden" value="${Book.getId()}" name="id">
    	<form:select path="author_id" id="author_id">
			<c:forEach items="${author}" var="c">
				<form:option name="author_id" value="${c.getId()}" label="${c.getFirstName() }" />
			</c:forEach>
		</form:select>
		<form:select path="category_id" id="category_id">
			<c:forEach items="${category}" var="c">
				<form:option name="category_id" value="${c.getId()}" label="${c.getName() }" />
			</c:forEach>
		</form:select>
		<form:select path="publisher_id" id="publisher_id">
			<c:forEach items="${publisher}" var="c">
				<form:option name="publisher_id" value="${c.getId()}" label="${c.getName() }" />
			</c:forEach>
		</form:select>
		<input name="update" action="update"  type="submit" value="Ekle" class="btn">
	
	</form:form>
		<div style="color: red">${msg}</div>



	${Book}
</body>
</html>