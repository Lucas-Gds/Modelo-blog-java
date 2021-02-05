package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.UsuarioDAL;
import Model.Usuario;


@WebServlet("/Cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Cadastrar() {
        super();
     
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario u = new Usuario();
		UsuarioDAL cDal = new UsuarioDAL();
		
		u.setEmail(request.getParameter("email"));
		u.setSenha(request.getParameter("senha"));
		u.setNome(request.getParameter("nome"));
		u.setTipo("visitante");
		u.setAtivo(true);
		// colocar metodo de envio por email, caso estivesse online.
		u = cDal.insert(u);
		
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		//response.sendRedirect(request.getContextPath() + "/ListarCliente.jsp");
		
	}

}
