<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="javax.servlet.http.*,Model.*, java.lang.*, DAL.*, java.util.*"  %>
<!DOCTYPE html>
 <%
      		HttpSession s = request.getSession(false);  
      		Usuario u = (Usuario)s.getAttribute("usuario");
      		
      %>
      <% 
      if(u.getTipo().equals("visitante")){
    	  response.sendRedirect("logado.jsp");
      
      } else { } %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog Senac</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<div class="container">
	<div class="row">
	
		<div class="col-md-12">
		<a class="btn btn-primary" href="logado.jsp" role="button">Voltar Inicio</a>
			<h1>Cadastrar Categoria</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form method="post" action="CriarCategoria">
			  <div class="form-group">
				<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome da nova Categoria">
			  </div>
			  <button type="submit" class="btn btn-primary">Criar</button>
			</form>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>Lista de Categorias</h1>
		</div>
	</div>
	<table class="table">
		<thead>
		<tr>
			<th scope="col">Categoria</th>
			<th scope="col">ID</th>
		</tr>
		<% 
			ArrayList<Categoria> cl = new CategoriaDAL().listAll();
			for(Categoria c : cl) {
		%>
		<tr>
			<td><%= c.getNome() %></td>
			<td><%= c.getIdCg() %></td>
			<td><a href="EditarCategoria?id=<%= c.getIdCg() %>">Editar</a></td>
		</tr>
		<% } %>
		</thead>
	</table>
	<div class="row">
		<div class="col-md-12">
			<h1>Cadastrar Conteudo em categoria</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form method="post" action="CriarConteudo">
			 <div class="form-group">
				<input type="text" class="form-control" id="idcat" name="idcat" placeholder="id Da Categoria">
			  </div>
			  <div class="form-group">
				<input type="text" class="form-control" id="titulo" name="titulo" placeholder="Nome do novo Conteudo">
			  </div>
			  <div class="form-group">
				<input type="text" class="form-control" id="texto" name="texto" placeholder="texto do conteudo">
			  </div>
			  <input type="hidden" id="iduser" name="iduser" value="<%=u.getId()%>">
			  <button type="submit" class="btn btn-primary">Criar</button>
			</form>
		</div>
	</div>

<div class="row">
		<div class="col-md-12">
			<h1>Lista de Conteudos por categoria</h1>
		</div>
	</div>
	<table class="table">
		<thead>
		<tr>
			<th scope="col">Conteudo</th>
			<th scope="col">ID</th>
			<th scope="col">ID Categoria</th>
		</tr>
		<% 
			ArrayList<Conteudo> cc = new ConteudoDAL().listAll();
			for(Conteudo a : cc) {  
			
		%>
		<tr>
			<td><%= a.getTitulo() %></td>
			<td><%= a.getIdCt() %></td>
			<td><%=a.getIdCg() %></td>
			
			<td><a href="Editarconteudo?id=<%= a.getIdCt() %>">Editar</a></td>
		</tr>
		<% } %>
		</thead>
	</table>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>