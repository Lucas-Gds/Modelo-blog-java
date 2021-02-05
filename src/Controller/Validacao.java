package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;


@WebServlet("/Validacao")
public class Validacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
public Validacao() {  super();  }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        	Usuario u =(Usuario)session.getAttribute("usuario");  
        	request.setAttribute("Usuario", u);
        	request.getRequestDispatcher("logado.jsp").include(request, response);
        }  
        else{  
            response.sendRedirect("index.jsp");
        }  
		
		
	}

}
