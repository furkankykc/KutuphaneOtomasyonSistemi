<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Publisher</title>
</head>
<body> 
<!--  @author furkankykc -->
 
<!--  th:action="@{/greeting}" th:object="${greeting}"  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form commandName="PublisherBean" action="" method="POST">
 <li><label>Name</label> <input type='text' name='name' />
<form:select path="address_id" id="address_id">
					  
					  
					  <c:forEach items="${address}" var="c">
					  
					  <form:option name="address_id" value="${c.getId()}" label="${c.getName() }" />
				       
	</c:forEach>
				       </form:select>
				<form:errors path="address_id" cssStyle="color: #ff0000;" />
		
				<input name="add" action="add"  type="submit" value="Ekle" class="btn">
	
</form:form>
		<div style="color: red">${msg}</div>




<%-- <form:form method="POST" commandName="colour"> --%>
<%-- <form:select name="colourName" path="colourName"> --%>
					  
					  
<%-- 					  <c:forEach items="${address}" var="c"> --%>
					  
<%-- 					  <form:option name="colourName" value="${c.getName()}" label="${c.getName() }" /> --%>
				       
<%-- 	</c:forEach> --%>
<%-- 				       </form:select> --%>
<%-- 				<form:errors path="colourName" cssStyle="color: #ff0000;" /> --%>
		
<!-- 				<input name="add" action="add"  type="submit" value="Ekle" class="btn"> -->
			
<%-- </form:form> --%>


	
<%-- 	<form:form path="yayım" commandName="yayım" action="" method="POST"> --%>
<!--     <li><label>Name</label> <input type='text' name='name' /> -->
<%-- 	<form:select commandName="address_id" path="address_id" > --%>
	
<%-- 	<c:forEach items="${address}" var="adrs">	 --%>
<%-- 		<form:option name="yayım.address_id" value="${adrs.getId()}" label="${adrs.getName() }" /> --%>
<%-- 	</c:forEach> --%>
<%--     </form:select> --%>
    
 

<!--  <input name="add" action="add"  type="submit" value="Ekle" class="btn"> -->
   
<%-- 	</form:form> --%>
<%--     <form:select path="address"> --%>
<%-- 					  <form:option value="" label="...." /> --%>
<%-- 					  <form:options items="${address}"  /> --%>
<%-- 				       </form:select> --%>
                            
    
     </ul>

  <table border="1">
   <td> Publisher</td>
        <tr>
        
         	<td>Id</td>
            <td>Name</td>
            <td>Address</td>
        </tr>
        
        
<c:forEach items="${publishers}" var="pbls">
			<tr>
			<td>${pbls.getId()} </td>
			<td>${pbls.getName()}</td>
			<td>${pbls.getAddress().getName()}</td>
<form:form method="POST" action="Publisher">
			<input type="hidden" value="${pbls.getId()}" name="id">
			<input type="hidden" value="${pbls.getName()}" name="name">
			<input type="hidden" value="${pbls.getAddress_id()}" name="address_id">
			<td><label>&nbsp;</label> <input type="submit" name ="details" action ="details" value = "details" class = "btn"></td>
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