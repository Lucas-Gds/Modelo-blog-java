<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="javax.servlet.http.*,Model.*, java.lang.*, java.util.*, DAL.*"  %>
      <%
      	
     		
      		Conteudo u = (Conteudo)request.getAttribute("Conteudo");
      	
      %> 
<!DOCTYPE html>
      <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog Senac</title>
</head>
<body>
<div class="container">
<h1 class="text-center"><%=u.getTitulo() %></h1>
<p><%= u.getTexto() %></p>
</div>
<h3>Comentarios</h3>
<button type="button" id="comentario" class="btn btn-info">Comentar</button>
<form id="caixademensagem" method="post" name="caixademensagem" action="enviarmsg">
<textarea id="caixademsg"></textarea> <br>
<button type="submit" class="btn btn-primary">Enviar</button>
<button id="fechar" type="button" class="btn btn-primary">Cancelar</button>
</form>
<table class="table">
		<thead>
		<% 
			ArrayList<Comentario> ce = new ComentarioDAL().listAll();
			for(Comentario ca : ce) {
		%>
		<tr>
			<td><%=ca.getId() %></td>
			<td><%=ca.getTexto() %></td>
		</tr>
		<% } %>
		</thead>
	</table>
</body>
<script type="text/javascript">

$(document).ready(function(){
    $("#caixademensagem").hide();
    $("#comentario").click(function(e) {
        $("#caixademensagem").show();
        $("#comentario").hide();
       
    });
});
$(document).ready(function(){

	$("#fechar").click(function(e) {
	    $("#caixademensagem").hide();
	    $("#comentario").show();
       
    });
});


</script>
</html>