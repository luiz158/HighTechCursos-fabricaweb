<%@ page import="br.com.fabricadeprogramador.persistencia.entidade.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:: Lista de Usuários</title>

<script type="text/javascript">
	function confirmaExclusao(id) {
		if (window.confirm('Tem certeza que deseja excluir?')) {
			location.href="usucontroller.do?acao=excluir&id=" + id;
		}
	}
</script>

</head>
<body>

<%
	List<Usuario> lista = (List<Usuario>)request.getAttribute("lista");
%>

	<table border="1">
	<tr>
	<th>Id</th>
	<th>Nome</th>
	<th>Login</th>
	<th>Ação</th>
	</tr>
	
<%
	for (Usuario u : lista) {
		out.print("<tr>");
		out.print("<td>" + u.getId() + "</td>");
		out.print("<td>" + u.getNome() + "</td>");
		out.print("<td>" + u.getLogin() + "</td>");
		out.print("<td>" + "<a href='javascript:confirmaExclusao(" + u.getId() + ")'>Excluir</a> | <a href='usucontroller.do?acao=alterar&id=" + u.getId() + "'>Alterar" + "</td>");
	}
%>

	</table>

</body>
</html>