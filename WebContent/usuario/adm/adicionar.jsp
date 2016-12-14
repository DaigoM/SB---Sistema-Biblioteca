<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar itens: livros, revistas, jornais...</title>
</head>
<body>
	<form action="adicionarItem" method="post" >
		Título: <input type="text" name="titulo" />
		Autor:	<input type="text" name="autor" />
		Tipo de livro:	<input type="text" name="tipo" />
		<input type="hidden" name="disponivel" value="true" />
		<input type="submit" value="adicionar"> 
	</form>
</body>
</html>