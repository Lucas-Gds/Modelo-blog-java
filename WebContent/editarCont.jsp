<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*,Model.*, java.lang.*, java.util.*, DAL.*"  %>
     <%
      	
     		
      		Categoria c = (Categoria)request.getAttribute("Categoria");
      		
      %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>Alterar Nome Categoria</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form method="post" action="SalvarNewCategoria?id=<%=c.getIdCg()%>">
			  <div class="form-group">
				<input type="text" class="form-control" id="nome" name="nome" value="<%=c.getNome() %>">
			  </div>
			  <button type="submit" class="btn btn-primary">Alterar</button>
			</form>
		</div>
	</div>
		<div id="formFooter">
     	 	<p style="text-align: right;"><a class="underlineHover" href="DelCat?id=<%=c.getIdCg()%>">Deletar Categoria</a></p>
    		</div>
</div>
</body>
</html>