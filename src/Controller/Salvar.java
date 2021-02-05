package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.*;
import Model.*;


@WebServlet("/Salvar")
public class Salvar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Salvar() {   
    	
    	super();  
    	}
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario u = new Usuario();
		String par = request.getParameter("id").toString();
		int numero = Integer.parseInt(par);
		
		UsuarioDAL cDal = new UsuarioDAL();
		
		u.setEmail(request.getParameter("email"));
		u.setSenha(request.getParameter("senha"));
		u.setNome(request.getParameter("nome"));
		u.setTipo("visitante");
		u.setAtivo(true);
		u.setId(numero);
		u = cDal.update(u);
		
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		//response.sendRedirect(request.getContextPath() + "/ListarCliente.jsp");
		
		
		
	}
}
