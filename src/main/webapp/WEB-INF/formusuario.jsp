<%@ page import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:: Form</title>
</head>
<body>

<%@include file="menu.jsp" %>
<br />
<br />
<%
	Usuario usuario = (Usuario)request.getAttribute("usu");
%>

	<form action="usucontroller.do" method="post">
		Id:		<input type="text" name="id" value="<%=usuario.getId()%>" readonly />
		Nome:	<input type="text" name="nome" value="<%=usuario.getNome()%>" placeholder="Digite o seu nome" />
		Login:	<input type="text" name="login" value="<%=usuario.getLogin()%>" placeholder="Crie um nome de usuário" />
		Senha:	<input type="password" name="senha" value="<%=usuario.getSenha()%>" placeholder="Defina sua senha" />
		
		<input type="submit" value="Salvar" />
	</form>
	
</body>
</html>