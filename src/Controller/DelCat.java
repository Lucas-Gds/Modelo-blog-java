package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAL.*;

@WebServlet("/DelCat")
public class DelCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DelCat() {
        super();

    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaDAL cDal = new CategoriaDAL();
		String par = request.getParameter("id").toString();
		int numero = Integer.parseInt(par);
		
		cDal.delete(numero);
		
		response.sendRedirect(request.getContextPath() + "/criarCont.jsp");
	}

}
