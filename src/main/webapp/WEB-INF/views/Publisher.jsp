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
    <li><label>Name</label> <input type='text' name='name' />
    <label>Address</label> <input type='text' name='address_id' />
    
    
    <label>&nbsp;</label> <input name="add" action="add"  type="submit" value="Ekle" class="btn">
    </ul>
</form:form><dl>

  <table border="1">
   <td> Publisher</td>
        <tr>
        
         	<td>ID</td>
            <td>Name</td>
            <td>Address</td>
        </tr>
        
        
<c:forEach items="${publishers}" var="pbls">
			<tr>
			<td>${pbls.getId()} </td>
			<td>${pbls.getName()}</td>
			<td>${pbls.getAddress_id()}</td>
<form:form method="POST" action="Publisher">
			<input type="hidden" value="${pbls.getId()}" name="id">
			
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			<!--<td> <button name="CurrentDelete" value="${cat.getId()}" type="submit">Delete</button></td>
			-->
 </form:form>
			</tr>
	</c:forEach>
	
</tr>
</dl>
</body>
</html>