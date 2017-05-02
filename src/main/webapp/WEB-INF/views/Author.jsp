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
    <li><label>First Name</label> <input type='text' name='firstName' />
    <label>Last Name</label> <input type='text' name='lastName' />
    <label>address</label> <input type='int' name='address_id' />
    
    <label>&nbsp;</label> <input name="add" action="add"  type="submit" value="Ekle" class="btn">
    </ul>
</form:form><dl>

<form:form method="POST" action="Book">
  <table border="1">
        <tr>
         <td> AUTHOR</td>
         	<td>ID</td>
            <td>FIRST NAME</td>
            <td>LAST NAME</td>
            <td>ADDRESS</td>

        </tr>
        
        
<c:forEach items="${author}" var="auth">
			<tr>
			<td>${auth.getId()} </td>
			<td>${auth.getFirstName()}</td>
			<td>${auth.getLastName()}</td>
			<td>${auth.getaddress_id()}</td>
			</tr>
	</c:forEach>
	<label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "remove" class = "btn">
 </form:form>
</tr>
</dl>
</body>
</html>