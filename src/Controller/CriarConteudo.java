package Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 import Model.*;
 import DAL.*;


@WebServlet("/CriarConteudo")
public class CriarConteudo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CriarConteudo() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conteudo c = new Conteudo();
		ConteudoDAL cDal = new ConteudoDAL();
		
		String par = request.getParameter("idcat").toString();
		int numero = Integer.parseInt(par);
		String pare = request.getParameter("iduser").toString();
		int numero2 = Integer.parseInt(pare);
		Date data_publicacao = new java.sql.Date(System.currentTimeMillis());
		c.setData_publicacao(data_publicacao);
		c.setId(numero2);
		c.setIdCg(numero);
		c.setTitulo(request.getParameter("titulo"));
		c.setTexto(request.getParameter("texto"));
		c.setAtivo(true);
		
		c = cDal.insert(c);

		response.sendRedirect(request.getContextPath() + "/criarCont.jsp");
	}

}
