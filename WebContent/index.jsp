<%@ include file="inc/header.jsp" %>



<div class="wrapper fadeInDown">
  <div id="formContent">
    <form method="post" action="Autenticacao">
      <input type="text" id="email"  name="email" placeholder="email">
      <input type="password" id="senha"  name="senha" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>
    <div id="formFooter">
      <a class="underlineHover" href="Cadastrar.jsp">Cadastrar?</a>
    </div>
  </div>
</div>



<%@ include file="inc/footer.jsp" %>