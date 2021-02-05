package DAL;

import java.sql.*;
import java.util.ArrayList;

import Model.*;


public class CategoriaDAL extends Conexao{
	public CategoriaDAL() {
		super();	
	}
	
public Categoria insert(Categoria categoria) {
	        try {
	            super.abrir();
	            
	            PreparedStatement stmt= getCnn().prepareStatement("INSERT INTO categoria VALUES(null,?,?)");
	            stmt.setString(1,categoria.getNome());  
	            stmt.setBoolean(2, categoria.isAtivo());
	           
	            stmt.executeUpdate(); 
	            ResultSet id = stmt.getGeneratedKeys();
	            if(id.next())
	                categoria.setId(id.getInt(1));
	              
	            return categoria;
	        } catch(Exception ex) {
	            System.out.println(ex.getMessage());
	            return null;
	        }
	        finally {
	            super.fechar();
	        }
}

public Categoria update(Categoria categoria) {
    try {
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("UPDATE categoria SET nome = ?, ativo = ? WHERE id = ?");  
        stmt.setString(1, categoria.getNome());  
        stmt.setBoolean(2, categoria.isAtivo());
        stmt.setInt(3, categoria.getIdCg());
       
        stmt.executeUpdate(); 
          
        return categoria;
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
        
        PreparedStatement stmt= getCnn().prepareStatement("DELETE FROM categoria WHERE id = ?");  
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
public ArrayList<Categoria> listAll() {
    try {
        ArrayList<Categoria> c = new ArrayList<Categoria>();
        
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM categoria");  
       
        ResultSet rs = stmt.executeQuery(); 
       
        while(rs.next()) {
            Categoria ab = new Categoria();
            ab.setIdCg(rs.getInt("id"));
            ab.setNome(rs.getString("nome"));     

            c.add(ab);
        }
        
        return c;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}

public Categoria get(int id) {
    try {
        Categoria c = new Categoria();
        
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM categoria WHERE id = ?");  
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery(); 
       
        if(rs.next()) {
            c.setIdCg(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setAtivo(rs.getBoolean("ativo"));
            
            
        }
        
        return c;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}

}
