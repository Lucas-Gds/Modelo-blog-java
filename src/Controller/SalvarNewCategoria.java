package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import DAL.*;
@WebServlet("/SalvarNewCategoria")
public class SalvarNewCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SalvarNewCategoria() {
        super();
     
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categoria u = new Categoria();
		String par = request.getParameter("id").toString();
		int numero = Integer.parseInt(par);
		CategoriaDAL cDal = new CategoriaDAL();	
		
		u.setNome(request.getParameter("nome"));
		u.setAtivo(true);
		u.setIdCg(numero);
		u = cDal.update(u);
		
		response.sendRedirect(request.getContextPath() + "/criarCont.jsp");
	}

}
