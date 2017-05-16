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
<form:form commandName="author" action="" method="POST">
 <label>First Name</label> <input value="${author.getFirstName() }" type='text' name='firstName' />
 <label>Last Name</label> <input value="${author.getLastName() }" type='text' name='lastName' />
 <input type="hidden" value="${author.getId()}" name="id">
<form:select path="address_id" id="address_id">
					  
					 <c:forEach items="${address}" var="c">
					  
					  <form:option name="address_id" value="${c.getId()}" label="${c.getName() }" />
				       
	</c:forEach>
				       </form:select>
				<form:errors path="address_id" cssStyle="color: #ff0000;" />
				
				<input name="update" action="update"  type="submit" value="Update" class="btn">
	
</form:form>
		<div style="color: red">${msg}</div>



</body>
</html>