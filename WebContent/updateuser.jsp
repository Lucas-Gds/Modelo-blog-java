<html>
<%@ page import="Model.*"%>
<%@ page import="javax.servlet.http.*"  %>
<%@ page import="java.util.*"  %>
<%
 
	Usuario u = (Usuario)request.getAttribute("Usuario");
	
%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>Alterar dados de Usuário</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form method="post" action="Salvar?id=<%=u.getId()%>">
			  <div class="form-group">
				<input type="number" class="form-control" id="nome" name="nome" placeholder="Seu Nome" required value="<%=u.getNome()%>">
			  </div>
			  <div class="form-group">
			    <input type="email" class="form-control" id="email" name="email"  placeholder="Seu email" required value="<%=u.getEmail()%>">
			  </div>
			  <div class="form-group">
			    <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required>
			  </div>
			  <button type="submit" class="btn btn-primary">Alterar</button>
			</form>
			<div id="formFooter">
     	 	<p style="text-align: right;"><a class="underlineHover" href="Del?id=<%=u.getId()%>">Deletar Conta</a></p>
    		</div>
		</div>
	</div>
</div>
</html>