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

<form:form name="gettingtext" action="admin" method="POST">
<ul>
    <li><label>Kitap Adı:</label> <input type='text' name='ad' />
    <label>Kitap Yazarı:</label> <input type='text' name='yazar' />
    <label>&nbsp;</label> <input name="add" action="add"  type="submit" value="Ekle" class="btn">
    <label>&nbsp;</label> <input name="del" action="del" type="submit" value="Sil" class="btn"></li>
</ul>
</form:form><dl>

<form:form method="POST" action="admin">
  <table border="0">
        <tr>
        <td><input type="checkbox" class="chkCheckBoxId" value="asd" name = "kitapId"/></td>
         <td> ADI</td>
            <td>YAZARI</td>
        </tr>
        
        
<c:forEach items="${kitaplar}" var="kitap">
			<tr>
			<td><input type="checkbox" class="chkCheckBoxId" value="${kitap.getId()}" name = "kitapId"/></td>
			
			<td>${kitap.getAd()} </td><td>${kitap.getYazar()}</td>
			</tr>
	</c:forEach>
	<label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "remove" class = "btn">
 </form:form>
</tr>
</dl>
</body>
</html>