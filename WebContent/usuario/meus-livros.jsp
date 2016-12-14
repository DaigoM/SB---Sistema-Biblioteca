<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Meus emprestimos</h2>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Solicitacao</th>
			<th>devolucao</th>
			<th>Item</th>
			<th>Tipo do item</th>
			<th>dataDevolucao</th>
			<th>dataEmprestimo</th>
		</tr>
		<c:forEach items="${emprestimo}" var="emprestimo">
			<tr>
				<td>${emprestimo.id }</td>
				<td>${emprestimo.solicitacao }</td>
				<td>${emprestimo.devolucao }</td>
				<td>${emprestimo.item.titulo }</td>
				<td>${emprestimo.item.tipo }</td>
				<td> <fmt:formatDate value="${emprestimo.dataDevolucao.time }"   pattern="dd/MM/yyyy" /> </td>
				<td> <fmt:formatDate value="${emprestimo.dataEmprestimo.time }"   pattern="dd/MM/yyyy" /> </td>
			</tr>
		</c:forEach>
	</table>
	</br>
	<a href="menuUsuario">Voltar para o menu</a>
</body>
</html>