<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Spring MVC dropdown box</title>
</head>

<body>
	<h2>What's your favourite colour?</h2>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<form:form method="POST" commandName="colour">
		<table>
			<tr>
				<td>Please select:</td>
				<td><form:select path="colourName">
					  
					  
					  
					  <form:option value="" label="...." />
					  <c:forEach items="${colours}" var="c">
					  
					  
					  <form:option name="colourName" value="${c.getColourName()}" label="${c.getColourName() }" />
				       
	</c:forEach>
				       
				       
				       
				       </form:select>
                                </td>
				<td><form:errors path="colourName" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>


<form:form method="POST" commandName="colour">
<form:select name="colourName" path="colourName">
					  
					  
					  <c:forEach items="${address}" var="c">
					  
					  <form:option name="colourName" value="${c.getId()}" label="${c.getName() }" />
				       
	</c:forEach>
				       </form:select>
				<form:errors path="colourName" cssStyle="color: #ff0000;" />
		
				<input name="add" action="add"  type="submit" value="Ekle" class="btn">
			
</form:form>
</body>
</html>