<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Spring Boot Form Submit Using Spring Forms</h2>
	<form:form action="dataPage" modelAttribute="sample">
		Enter Name : <form:input path="name"/> <br>
		Enter Email : <form:input path="email"/> <br>
		Enter MobNo : <form:input path="mobileNo"/> <br>
		<form:button name="submit" value="submit">Submit</form:button>	
	</form:form>
</body>
</html>