<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela de login</title>
<link rel="StyleSheet" type="text/css" href="css/estilo.css"/>

</head>
<body>
	<header>
		<hgroup>
		<h1>
			<span style="text-decoration: underline;">
				Sistema Web para biblioteca
			</span>
		</h1>
		<h2>Pagina de Login - Usuário</h2>
		</hgroup>
	</header>
	<center>
	<form action="efetuarLogin" method="post" class="login">
		Login: <input type="text" name="login" /></br>
		Senha: <input type="password" name="senha" /> </br>
		<input type="submit" value="Entrar nas tarefas" />
	</form>
	</center>
<footer>
<p>Copyright&copy; 2016 </p>
</footer>
</body>
</html>