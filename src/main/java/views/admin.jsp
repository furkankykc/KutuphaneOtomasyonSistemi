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


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form name="gettingtext" action="admin" method="POST">
<ul>
    <li><label>Kitap Adı:</label> <input type='text' name='ad' />
    <label>Kitap Yazarı:</label> <input type='text' name='yazar' />
    <label>&nbsp;</label> <input name="add" action="add"  type="submit" value="Ekle" class="btn">
    <label>&nbsp;</label> <input name="del" action="del" type="submit" value="Sil" class="btn"></li>
</ul>
</form:form>
${user }
</body>
</html>