package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import DAL.*;
@WebServlet("/CriarCategoria")
public class CriarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CriarCategoria() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categoria c = new Categoria();
		CategoriaDAL cDal= new CategoriaDAL();
		
		
		c.setNome(request.getParameter("nome"));
		c.setAtivo(false);
		c = cDal.insert(c);

		response.sendRedirect(request.getContextPath() + "/criarCont.jsp");
		
	}

}
