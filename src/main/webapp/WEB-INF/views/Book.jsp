<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book</title>
</head>
<body> 
<!--  th:action="@{/greeting}" th:object="${greeting}"  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form name="gettingtext" action="" method="POST">
<ul>
    <li><label>Kitap Adı:</label> <input type='text' name='bookName' />
    <label>Yazarı:</label> <input type='int' name='author_id' />
    <label>Sayfa Sayısı</label> <input type='int' name='bookPage' />
    <label>Kategori</label> <input type='int' name='category_id' />
    <label>Yayıncı</label> <input type='int' name='publisher_id' />
    
    <label>&nbsp;</label> <input name="add" action="add"  type="submit" value="Ekle" class="btn">
    </ul>
</form:form><dl>

  <table border="1">
        <tr>
        	<td>Id</td>
         	<td>KİTAP ADI</td>
            <td>YAZARI</td>
            <td>KATEGORİ</td>
            <td>YAYIMCI</td>
            <td>SAYFA SAYISI</td>
        </tr>
        
        
<c:forEach items="${books}" var="book">
			<tr>
			<td>${book.getId()} </td>
			<td>${book.getBookName()} </td>	
			<td>${book.getAuthor().getFirstName()}</td>
			<td>${book.getCategory().getName()}</td>
			<td>${book.getPublisher().getName()}</td>
			<td>${book.getBookPage()}</td>
			
<form:form method="POST" action="Book">
			<input type="hidden" value="${book.getId()}" name="id">
			
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			
	 </form:form>
			</tr>
			
	</c:forEach>
</tr>
</dl>
</body>
</html>