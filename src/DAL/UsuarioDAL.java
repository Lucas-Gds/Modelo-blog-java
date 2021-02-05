package DAL;

import java.sql.*;
import java.util.*;

import Model.*;


public class UsuarioDAL extends Conexao{
	public UsuarioDAL() {
		super();	
	}
	
public Usuario insert(Usuario usuario) {
	        try {
	            super.abrir();
	            
	            PreparedStatement stmt= getCnn().prepareStatement("INSERT INTO usuario VALUES(null,?,?,?,?,?)");  
	            stmt.setString(1,usuario.getNome());  
	            stmt.setString(2, usuario.getEmail());  
	            stmt.setString(3, usuario.getSenha());  
	            stmt.setString(4, usuario.getTipo());
	            stmt.setBoolean(5, usuario.isAtivo());
	           
	            stmt.executeUpdate(); 
	            ResultSet id = stmt.getGeneratedKeys();
	            if(id.next())
	                usuario.setId(id.getInt(1));
	              
	            return usuario;
	        } catch(Exception ex) {
	            System.out.println(ex.getMessage());
	            return null;
	        }
	        finally {
	            super.fechar();
	        }
}

public Usuario update(Usuario usuario) {
    try {
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("UPDATE usuario SET nome = ?, email = ? , senha = ?, tipo = ?, ativo = ? WHERE id = ?");  
        stmt.setString(1, usuario.getNome());  
        stmt.setString(2, usuario.getEmail());  
        stmt.setString(3, usuario.getSenha());  
        stmt.setString(4, usuario.getTipo());
        stmt.setBoolean(5, usuario.isAtivo());
        stmt.setInt(6, usuario.getId());
        
        stmt.executeUpdate();
          
        return usuario;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}
public boolean delete(int id) {
    try {
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("DELETE FROM usuario WHERE id = ?");  
        stmt.setInt(1, id);
        stmt.executeUpdate(); 
          
        return true;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    finally {
        super.fechar();
    }
}
public ArrayList<Usuario> listAll() {
    try {
        ArrayList<Usuario> u = new ArrayList<Usuario>();
        
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM usuario");  
       
        ResultSet rs = stmt.executeQuery(); 
       
        while(rs.next()) {
            Usuario ui = new Usuario();
            ui.setId(rs.getInt("id"));
            ui.setNome(rs.getString("nome"));
            ui.setEmail(rs.getString("email"));
            ui.setTipo(rs.getString("tipo"));     

            u.add(ui);
        }
        
        return u;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}
public Usuario autenticacao(Usuario ul) {
	try {

        super.abrir();
        

        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");  
        stmt.setString(1, ul.getEmail());
        stmt.setString(2, ul.getSenha());
       
        ResultSet rs = stmt.executeQuery(); 
       
        if(rs.next()) {
            ul.setId(rs.getInt("id"));
            ul.setNome(rs.getString("nome"));
            ul.setEmail(rs.getString("email"));
            ul.setSenha(rs.getString("senha"));
            ul.setTipo(rs.getString("tipo"));
            ul.setAtivo(rs.getBoolean("ativo"));
            
                
        } else {
        	return null;
        }
        
        return ul;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}
public Usuario get(int id) {
    try {
        Usuario u = new Usuario();
        
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM usuario WHERE id = ?");  
        stmt.setInt(1, id);
       
        ResultSet rs = stmt.executeQuery(); 
       
        if(rs.next()) {
            u.setId(rs.getInt("id"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));
            u.setNome(rs.getString("nome"));
            u.setTipo(rs.getString("tipo"));
            
            
            
        }
        
        return u;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}



}
