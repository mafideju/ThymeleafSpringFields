<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="data" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Maven, Mafideju and Spring!</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<main>
		<div>
			<h2>Maven, Mafideju and Spring!</h2>
			<h3>Administração de Servidores de Dados</h3>
		</div>
		
		<div>
			<h1>Ratamahata</h1>
			<h6>VAMOS DETONAR ESSA PORRA, É PORRA!!</h6>
		</div>
		<div>
			<form:form action="${pageContext.request.contextPath}/" method="GET">
				<input type="submit" class="fadeIn fourth" value="Voltar">        					
			</form:form>
		</div>
	</main>

</body>
</html>