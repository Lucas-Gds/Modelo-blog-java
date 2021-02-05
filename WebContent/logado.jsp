<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="cp1252"%>
    
<%@ page import="javax.servlet.http.*,Model.*, java.lang.*"  %>
<!doctype html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>Blog Senac</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/jumbotron/">
<link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="apple-touch-icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon.ico">
<meta name="msapplication-config" content="https://getbootstrap.com/docs/4.4/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    <link href="https://getbootstrap.com/docs/4.4/examples/jumbotron/jumbotron.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="#">Blog Senac</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <%
      		HttpSession s = request.getSession(false);  
      		Usuario u = (Usuario)s.getAttribute("usuario");
      		
      %>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
    
  
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Menu</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
        <a class="dropdown-item" href="categoria.jsp">Categorias</a>
        <% if(u.getTipo().equals("admin")) { %>
          <a class="dropdown-item" href="criarCont.jsp">CriarConteudo</a>
          <% } else { %>
          <a class="dropdown-item" href="#">Desativado</a>
    		<% } %>
          
          

        </div>
      </li>
      </ul>
      <ul class="navbar-nav justify-content-end">
      <li class="nav-item dropdown">
      
      	<a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%=u.getEmail()%></a>
      	<div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="EditarUsuario?id=<%=u.getId()%>">Editar</a>
          <a class="dropdown-item" href="Logout">Logout</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Pesquisar" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
    </form>
  </div>
</nav>

<main role="main">

  <div class="jumbotron">
    <div class="container">
    	<h1></h1>
      <h1 class="display-3">Ola! <%= u.getNome() %></h1>
      <p>Veja nosso ambiente de Categorias e Conteudos</p>
      <p><a class="btn btn-primary btn-lg" href="categoria.jsp" role="button">Ver Mais &raquo;</a></p>
    </div>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-md-4">
      
      	<h2>
      		
        <h2>Cursos</h2>
        <p>Veja os nossos principais Cursos online.</p>
        <p><a class="btn btn-secondary" href="#" role="button">Ver detalhes &raquo;</a></p>
      </div>
      <div class="col-md-4">
        <h2>Tutoriais</h2>
        <p>Veja os nossos Tutoriais online.</p>
        <p><a class="btn btn-secondary" href="#" role="button">Ver detalhes &raquo;</a></p>
      </div>
      <div class="col-md-4">
        <h2>Forum</h2>
        <p>Converse, Debata, traga suas ideias</p>
        <p><a class="btn btn-secondary" href="#" role="button">Ver detalhes &raquo;</a></p>
      </div>
    </div>

    <hr>

</main>
</body>
<footer class="container">
  <p>&copy; Company 2017-2020</p>
</footer>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
      <script>
      	window.jQuery || document.write('<script src="https://getbootstrap.com/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')
      	</script>
      	
      	<script src="https://getbootstrap.com/docs/4.4/dist/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous">
      </script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script>
      
      		tipagem = "<%=u.getTipo() %>";
      
     		if(tipagem == "admin"){
     			
    			metodo = "Criar Conteudo";
    		 	metodo2 = "criarCont.jsp";
    		 
    		} else {
    			
    			metodo = "Desativado";
    			metodo2 = "#";
    		} 
    		
    		var tipo = document.getElementById("tipo");  	
      		tipo.innerHTML = metodo;
      		var tipo2 = document.getElementById("tipo2");  	
      		tipo2.innerHTML = metodo2;
	
	
	
</script>
</html>
