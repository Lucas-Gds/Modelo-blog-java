package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.CategoriaDAL;
import DAL.ConteudoDAL;
import Model.Conteudo;


@WebServlet("/validaidconteudo")
public class validaidconteudo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public validaidconteudo() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conteudo u = new Conteudo();
		String par = request.getParameter("id").toString();
		
		if(par != null || par.equals("")) { 
			u = new ConteudoDAL().get(Integer.parseInt(par.toString()));
		}
		
		request.setAttribute("Conteudo", u);
		request.getRequestDispatcher("verconteudo.jsp").include(request, response);
		
	}

}
