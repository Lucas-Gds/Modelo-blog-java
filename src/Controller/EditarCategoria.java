package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import DAL.*;

@WebServlet("/EditarCategoria")
public class EditarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EditarCategoria() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Categoria c = new Categoria();
		
		String par = request.getParameter("id").toString();
		
		if(par != null || par.equals("")) { 
			c = new CategoriaDAL().get(Integer.parseInt(par.toString()));
		}
    	request.setAttribute("Categoria", c);
		request.getRequestDispatcher("editarCont.jsp").include(request, response);
		
		
	}

}
