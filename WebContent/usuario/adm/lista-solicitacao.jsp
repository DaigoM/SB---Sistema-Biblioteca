<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de solicitações</title>
</head>
<body>
	<h2>Solicitacao de Emprestimos</h2>
	<table border="2">
		<tr>
			<th>Id do Emprestimo</th>
			<th>Nome do Item</th>
			<th>Nome do Usuario</th>
			<th>Solicitacao</th>
			<th>dataEmprestimo</th>
			<th>dataDevolucao</th>
			<th>devolucao</th>
		</tr>
		<c:forEach items="${emprestimo}" var="emprestimo">
			<form action="detalhesSolicitacao" method="post">
			<tr>
				<td>
					${emprestimo.id }
					<input type="hidden" name="id" value="${emprestimo.id }">
				</td>
				<td>
					${emprestimo.item.titulo }
				</td>
				<td>
					${emprestimo.usuario.login }
				</td>
				<td>
					<c:if test="${emprestimo.solicitacao == false }">Nao validado
						<input type="hidden" name="solicitacao" value="${emprestimo.solicitacao }">
					</c:if>
					<c:if test="${emprestimo.solicitacao == true }">Validado
						<input type="hidden" name="solicitacao" value="${emprestimo.solicitacao }">
					</c:if>
				</td>
				<td> 
					<fmt:formatDate value="${emprestimo.dataEmprestimo.time }" pattern="dd/MM/yyyy" /> 
					<input type="hidden" name="dataEmprestimo" value="<fmt:formatDate value="${emprestimo.dataEmprestimo.time }" pattern="dd/MM/yyyy" /> ">
				</td>
				<td> 
					<fmt:formatDate value="${emprestimo.dataDevolucao.time }" pattern="dd/MM/yyyy" /> 
					<input type="hidden" name="dataDevolucao" value="<fmt:formatDate value="${emprestimo.dataDevolucao.time }" pattern="dd/MM/yyyy" /> ">
				</td>
				<td>
					<c:if test="${emprestimo.devolucao ==false }">Nao devolvido
						<input type="hidden" name="devolucao" value="${emprestimo.devolucao }">
					</c:if>
					<c:if test="${emprestimo.devolucao ==true }">Devolvido
						<input type="hidden" name="devolucao" value="${emprestimo.devolucao }">
					</c:if>
				</td>
				<td>
					<c:if test="${emprestimo.solicitacao == false }" >
						<a href="validarSolicitacao?id=${emprestimo.id }">Validar</a>
					</c:if>
					<c:if test="${emprestimo.solicitacao == true }">
						
					</c:if>
				</td>
				<td>
					<c:if test="${emprestimo.devolucao == false }">
						<a href="registrarDevolucao?id=${emprestimo.id }">Registrar a devolucao</a>
					</c:if>
					<c:if test="${emprestimo.devolucao == true }">
						
					</c:if>
				</td>
				<!-- <td>
					<input type="submit" value="Ver detalhes da solicitacao"/>
				</td>
				 -->
			</tr>
			</form>
		</c:forEach>
	</table>
	</br>
	<a href="menuFuncionario">Voltar para o menu</a>
</body>
</html>