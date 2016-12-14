<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de empréstimo - Lista de itens</title>
</head>
<body>

</br>
</br>

<h2>Itens</h2>
	<table border="2">
		<tr>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Tipo</th>
			<th>Disponivel</th>
		</tr>
		<c:forEach items="${itens}" var="item">
			<form action="confirmaEmprestimo" method="post">
			<tr>
				<td>${item.titulo }
				<input type="hidden" name="id_item" value="${item.id }"/>
				</td>
				<td>${item.autor }
				</td>
				<td>${item.tipo }
				<input type="hidden" name="tipoLivro" value="${item.tipo }"/>
				</td>
				<td>
				<c:if test="${item.disponivel}">
					disponivel
					<input type="hidden" name="status" value="${item.disponivel }"/>
					</td>
					<td>
						<input type="hidden" name="id_usuario" value="${usuarioLogado.id }"/>
						<input type="submit" value="Solicitar emprestimo"/>
					</td>
				</c:if>
				<c:if test="${not item.disponivel}">
					emprestado
				</c:if>
				</td>	
			</tr>
			</form>
		</c:forEach>
	</table>
	</br>
	<a href="menuUsuario">Voltar para o menu</a>
</body>
</html>