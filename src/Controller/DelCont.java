package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.ConteudoDAL;


@WebServlet("/DelCont")
public class DelCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DelCont() {
        super();
     
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConteudoDAL cDal = new ConteudoDAL();
		String par = request.getParameter("id").toString();
		int numero = Integer.parseInt(par);
		
		cDal.delete(numero);
		
		response.sendRedirect(request.getContextPath() + "/criarCont.jsp");
		
	}

}
