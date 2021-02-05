package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.*;

@WebServlet("/Del")
public class Del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Del() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAL cDal = new UsuarioDAL();
		
		String par = request.getParameter("id").toString();
		int numero = Integer.parseInt(par);
		
		
		cDal.delete(numero);
		
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
		
	}

}
