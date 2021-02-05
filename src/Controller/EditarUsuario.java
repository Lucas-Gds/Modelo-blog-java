package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;
import DAL.*;

@WebServlet("/EditarUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditarUsuario() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		
		String par = request.getParameter("id").toString();
		
		if(par != null || par.equals("")) { 
			u = new UsuarioDAL().get(Integer.parseInt(par.toString()));
		}
    	request.setAttribute("Usuario", u);
		request.getRequestDispatcher("updateuser.jsp").include(request, response);
		
		
	}

}
