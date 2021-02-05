<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*,Model.*, java.lang.*, java.util.*, DAL.*"  %>
     <%
      	
     		Conteudo a = (Conteudo)request.getAttribute("Conteudo");
      		
      		
      %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
<div class="row">
		<div class="col-md-12">
			<form method="post" action="upgradeConteudo?id=">
			 <div class="form-group">
			 	<label for="idcat">ID da Categoria</label>
				<input type="text" class="form-control" id="idcat" name="idcat" value="<%=a.getIdCg()%>">
			  </div>
			  <div class="form-group">
				<input type="text" class="form-control" id="titulo" name="titulo" value="<%=a.getTitulo()%>">
			  </div>
			  <div class="form-group">
				<input type="text" class="form-control" id="texto" name="texto" value="<%=a.getTexto()%>">
			  </div>
			  <input type="hidden" id="iduser" name="iduser" value="<%=a.getId()%>">
			  <button type="submit" class="btn btn-primary">Alterar</button>
			</form>
		</div>
		
	</div>
	<div id="formFooter">
     	 	<p style="text-align: right;"><a class="underlineHover" href="DelCont?id=<%=a.getIdCt()%>">Deletar Conteudo</a></p>
    		</div>
</div>
</body>
</html>