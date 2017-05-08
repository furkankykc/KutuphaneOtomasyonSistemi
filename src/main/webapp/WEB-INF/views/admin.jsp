<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Paneli </title>
</head>
<a> Kütüphane Otomasyon Sistemi Admin Paneli</a>

<br>
</br>
<body> 
<!--  th:action="@{/greeting}" th:object="${greeting}"  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table border="1">

	<td>Book</td>
	
  <td>
  <form method="get" action="Book">
    <button type="submit">Ekle</button>	</form></td>
        <tr>
        	<td>ID</td>
         	<td>BookName</td>
            <td>Author</td>
            <td>Category</td>
            <td>Publisher</td>
            <td>PageNo</td>
        </tr>
        
        
<c:forEach items="${books}" var="book">
			<tr>
			<td>${book.getID()} </td>
			<td>${book.getBookName()} </td>	
			<td>${book.getAuthor().getFirstName()}</td>
			<td>${book.getCategory().getName()}</td>
			<td>${book.getPublisher().getName()}</td>
			<td>${book.getBookPage()}</td>
			
<form:form method="POST" action="Book">
			<input type="hidden" value="${book.getID()}" name="id">
			
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			
	 </form:form>
	 
			</tr>
			
	</c:forEach>
	</table>
	<table border="1">
  
         <td> Author</td>
         
  <td><form method="get" action="Author">
    <button type="submit">Ekle</button>	</td>
        <tr>
         	<td>ID</td>
            <td>FirstName</td>
            <td>LastName</td>
            <td>Address	</td>

        </tr> 
        
        
<c:forEach items="${authors}" var="auth">
			<tr>
			<td>${auth.getID()} </td>
			<td>${auth.getFirstName()}</td>
			<td>${auth.getLastName()}</td>
			<td>${auth.getAddress().getName()}</td>
<form:form method="POST" action="Author">
			<input type="hidden" value="${auth.getID()}" name="id">
			
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			
	 </form:form>
			</tr>
	</c:forEach>
	</table>
  <table border="1">
   <td> Category</td>
   
  <td><form method="get" action="Category">
    <button type="submit">Ekle</button>	</td>
        <tr>
        
         	<td>ID</td>
            <td>NAME</td>

        </tr>
        
        
<c:forEach items="${categories}" var="cat">
			<tr>
			<td>${cat.getID()} </td>
			<td>${cat.getName()}</td>
			
<form:form method="POST" action="Category">
			<input type="hidden" value="${cat.getID()}" name="id">
			
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			<!--<td> <button name="CurrentDelete" value="${cat.getID()}" type="submit">Delete</button></td>
			-->
			
 </form:form>
			</tr>
	</c:forEach>
	</table>
  <table border="1">
   <td>Publisher</td>
  <td><form method="get" action="Publisher">
    <button type="submit">Ekle</button>	</td>
</form>
        <tr>
        
         	<td>ID</td>
            <td>Name</td>
            <td>Address</td>
        </tr>
        
        
<c:forEach items="${publishers}" var="pbls">
			<tr>
			<td>${pbls.getID()} </td>
			<td>${pbls.getName()}</td>
			<td>${pbls.getAddress().getName()}</td>
<form:form method="POST" action="Publisher">
			<input type="hidden" value="${pbls.getID()}" name="id">
			
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			<!--<td> <button name="CurrentDelete" value="${cat.getID()}" type="submit">Delete</button></td>
			-->
 </form:form>
			</tr>
	</c:forEach>
	</table>
	  <table border="1">

   <td> Address</td>
   
  <td><form method="get" action="Address">
    <button type="submit">Ekle</button>	</td>
        <tr>
        
         	<td>ID</td>
            <td>Name</td>
            <td>Street</td>
            <td>Road</td>
            <td>Build No</td>

        </tr>
        
        
<c:forEach items="${addresses}" var="adrs">
			<tr>
			<td>${adrs.getID()} </td>
			<td>${adrs.getName()}</td>
			<td>${adrs.getStreet() }</td>
			<td>${adrs.getRoad() }</td>
			<td>${adrs.getBuildNo() }</td>
			
<form:form method="POST" action="Address">
			<input type="hidden" value="${cat.getID()}" name="id">
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			<!--<td> <button name="CurrentDelete" value="${cat.getID()}" type="submit">Delete</button></td>
			-->
 </form:form>
			</tr>
	</c:forEach>
	</table>
</body>
</html>