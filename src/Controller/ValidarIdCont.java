package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.CategoriaDAL;
import DAL.ConteudoDAL;
import Model.Categoria;
import Model.Conteudo;


@WebServlet("/ValidarIdCont")
public class ValidarIdCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ValidarIdCont() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Categoria c = new Categoria();
		ConteudoDAL cDal = new ConteudoDAL();
		String par = request.getParameter("id").toString();
		
		if(par != null || par.equals("")) { 
			c = new CategoriaDAL().get(Integer.parseInt(par.toString()));
		}
		
    	request.setAttribute("Categoria", c);
		request.getRequestDispatcher("categoriaconteudo.jsp").include(request, response);
		
		
		
	}

}
