<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

<form:form method="POST" action="Book">
  <table border="0">
        <tr>
        <td><input type="checkbox" class="chkCheckBoxId" value="asd" name = "kitapId"/></td>
         <td> ADI</td>
            <td>YAZARI</td>
            <td>YAZARI</td>
            <td>YAZARI</td>
            <td>YAZARI</td>
            <td>YAZARI</td>
        </tr>
        
        
<c:forEach items="${kitaplar}" var="kitap">
			<tr>
			<td><input type="checkbox" class="chkCheckBoxId" value="${kitap.getBookName()}" name = "kitapId"/></td>
			
			<td>${kitap.getBookName()} </td>
			<td>${kitap.getBookPage()}</td>
			<td>${kitap.getAuthor_id()}</td>
			<td>${kitap.getCategory_id()}</td>
			<td>${kitap.getPublisher_id()}</td>
			</tr>
	</c:forEach>
	<label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "remove" class = "btn">
 </form:form>
</tr>
</dl>
</body>
</html>