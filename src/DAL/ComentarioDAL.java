package DAL;

import java.sql.*;
import java.util.ArrayList;

import Model.*;


public class ComentarioDAL extends Conexao{
	public ComentarioDAL() {
		super();	
	}
	
public boolean insert(Comentario comentario) {
	        try {
	            super.abrir();
	            
	            PreparedStatement stmt= getCnn().prepareStatement("INSERT INTO comentario VALUES(null,?,?,?,?");
	            java.sql.Date g = new java.sql.Date(comentario.getData_publicacaod().getTime().getTime());
	            
	            stmt.setString(1, comentario.getTexto());
	            stmt.setDate(2, g);
	            stmt.setInt(5, comentario.getIdCt());
	            stmt.setInt(6, comentario.getId());
	            
	            stmt.executeUpdate(); 
	            ResultSet id = stmt.getGeneratedKeys();
	            if(id.next())
	                comentario.setIdCt(id.getInt(1));
	            	comentario.setId(id.getInt(1));
	              
	            return true;
	        } catch(Exception ex) {
	            System.out.println(ex.getMessage());
	            return false;
	        }
	        finally {
	            super.fechar();
	        }
}

public boolean update(Comentario comentario) {
    try {
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("UPDATE comentario SET texto = ?, data_publicacao = ?, conteudo_id = ?, usuario_id = ? WHERE id = ?");  
        java.sql.Date g = new java.sql.Date(comentario.getData_publicacaod().getTime().getTime());
        
        stmt.setString(1, comentario.getTexto());
        stmt.setDate(2, g);
        stmt.setInt(3, comentario.getIdCt());
        stmt.setInt(4, comentario.getId());
        stmt.setInt(5, comentario.getIdCm());
        
        stmt.executeUpdate(); 
        ResultSet id = stmt.getGeneratedKeys();
        if(id.next())
            comentario.setIdCt(id.getInt(1));
        	comentario.setId(id.getInt(1));
          
        return true;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    finally {
        super.fechar();
    }
}
public boolean delete(int id) {
    try {
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("DELETE FROM comentario WHERE id = ?");  
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
public ArrayList<Comentario> listAll() {
    try {
        ArrayList<Comentario> cm = new ArrayList<Comentario>();
        
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM comentario");  
       
        ResultSet rs = stmt.executeQuery(); 
       
        while(rs.next()) {
            Comentario ac = new Comentario();
            ac.setIdCm(rs.getInt("id"));
            ac.setData_publicacaod(rs.getInt("Dia"), rs.getInt("Mes"), rs.getInt("Ano"));
            ac.setTexto(rs.getString("texto"));

            cm.add(ac);
        }
        
        return cm;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}

}
