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

    
    
    <form:form commandName="BookBean" action="" method="POST">
    	<label>Kitap Adı:</label> <input type='text' name='bookName' />
    	<label>Sayfa Sayısı</label> <input type='int' name='bookPage' />
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
		<input name="add" action="add"  type="submit" value="Ekle" class="btn">
	
	</form:form>
		<div style="color: red">${msg}</div>


    
    

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
			<input type="hidden" value="${book.getBookName()}" name="bookName">
			<input type="hidden" value="${book.getBookPage()}" name="bookPage">
			<input type="hidden" value="${book.getAuthor_id()}" name="author_id">
			<input type="hidden" value="${book.getCategory_id()}" name="category_id">
			<input type="hidden" value="${book.getPublisher_id()}" name="publisher_id">
<%-- 			<input type="hidden" value="${book.getPrintingDate()}" name="printingDate"> --%>
			<td><label>&nbsp;</label> <input type="submit" name ="details" action ="details" value = "details" class = "btn"></td>
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			
	 </form:form>
			</tr>
			
	</c:forEach>
</tr>
</dl>
</body>
</html>