<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página Inicial - Sistema Biblioteca</title>

<link rel="StyleSheet" type="text/css" href="usuario/css/estilo.css"/>
</head>
<body>
	<header>
		<hgroup>
		<h1>
			<span style="text-decoration: underline;">
				Sistema Web para biblioteca
			</span>
		</h1>
		<h2>Pagina inicial</h2>
		</hgroup>
	</header>
</br>
<hgroup>
<h2>Links para tipos de logins</h2>
<hr>
<h3 id="login">
	<figure class="foto-link">
			<a href="login.jsp">
			<img src="usuario/imagens/aluno.png"/></br>
			Usuários
			<figcaption>
				Login para alunos e professores
			</figcaption>
			</a> 
	</figure>
	<figure class="foto-link">
		<a href="loginAdm.jsp" target="_blank">
		<img src="usuario/imagens/adm.jpeg" /></br>
		Funcionários
		<figcaption class="foto-link">
			Login para bibliotecarios
		</figcaption>
		</a>
	</figure>
Ainda nao e cadastrado?<a href="cadastro.jsp">Cadastre-se!</a>
</h3>

<hr>
</br>
</br>
</br>
</br>
<footer>
<p>Copyright&copy; 2016 </p>
</footer>
</body>
</html>