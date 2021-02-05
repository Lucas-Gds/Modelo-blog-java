<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="javax.servlet.http.*,Model.*, java.lang.*, java.util.*, DAL.*"  %>
      <%
      	
     		
      		Categoria c = (Categoria)request.getAttribute("Categoria");
      	
      %>      
<!DOCTYPE html>
<html>
<head>
      <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Blog Senac</title>
</head>
<body>
<table class="table">
		<thead>
		<tr>
			<th scope="col"><%= c.getNome() %></th>
		</tr>
		<% 
			ArrayList<Conteudo> ce = new ConteudoDAL().listAe(c.getIdCg());
			for(Conteudo ca : ce) {
		%>
		<tr>
			<td><%=ca.getTitulo() %></td>
			<td><%=ca.getTexto() %></td>
			<td><a href="validaidconteudo?id=<%= ca.getIdCt() %>">ver</a></td>
		</tr>
		<% } %>
		</thead>
	</table>


</body>
</html>