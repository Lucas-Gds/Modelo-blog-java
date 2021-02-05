package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.ConteudoDAL;
import Model.Conteudo;

@WebServlet("/Editarconteudo")
public class Editarconteudo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Editarconteudo() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Conteudo a = new Conteudo();
		
		String par = request.getParameter("id").toString();
		
		if(par != null || par.equals("")) { 
			a = new ConteudoDAL().get(Integer.parseInt(par.toString()));
		}
    	request.setAttribute("Conteudo", a);
		request.getRequestDispatcher("conteupdate.jsp").include(request, response);
		
	}

}
