package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;
import DAL.*;

@WebServlet("/Autenticacao")
public class Autenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Autenticacao() {
        super();
    
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		UsuarioDAL cDal = new UsuarioDAL();
		
		u.setEmail(request.getParameter("email"));
		u.setSenha(request.getParameter("senha"));
		u = cDal.autenticacao(u);
		
		if(u != null) {
			HttpSession session=request.getSession();  
	        session.setAttribute("usuario",u);  
	        
	        request.getRequestDispatcher("/Validacao").include(request, response);  
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
