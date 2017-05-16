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

<form:form commandName="AuthorBean" action="" method="POST">

<li><label>First Name</label> <input type='text' name='firstName' />
    <label>Last Name</label> <input type='text' name='lastName' />
<form:select path="address_id" id="address_id">
					  
					  
					  <c:forEach items="${address}" var="c">
					  
					  <form:option name="address_id" value="${c.getId()}" label="${c.getName() }" />
				       
	</c:forEach>
				       </form:select>
				<form:errors path="address_id" cssStyle="color: #ff0000;" />
		
				<input name="add" action="add"  type="submit" value="Ekle" class="btn">
	
</form:form>
		<div style="color: red">${msg}</div>



  <table border="1">
  
         <td> AUTHOR</td>
        <tr>
         	<td>Id</td>
            <td>FIRST NAME</td>
            <td>LAST NAME</td>
            <td>ADDRESS</td>

        </tr>
        
        
<c:forEach items="${authors}" var="auth">
			<tr>
			<td>${auth.getId()} </td>
			<td>${auth.getFirstName()}</td>
			<td>${auth.getLastName()}</td>
			<td>${auth.getAddress().getName()}</td>
<form:form method="POST" action="Author">
			<input type="hidden" value="${auth.getId()}" name="id">
			<input type="hidden" value="${auth.getFirstName()}" name="firstName">
			<input type="hidden" value="${auth.getLastName()}" name="lastName">
			<input type="hidden" value="${auth.getAddress_id()}" name="address_id">
			<td><label>&nbsp;</label> <input type="submit" name ="details" action ="details" value = "details" class = "btn"></td>
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			
	 </form:form>
			</tr>
	</c:forEach>
</tr>
</dl>
</body>
</html>