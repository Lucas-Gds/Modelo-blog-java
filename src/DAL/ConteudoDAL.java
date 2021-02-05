package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Model.*;


public class ConteudoDAL extends Conexao{
	public ConteudoDAL() {
		super();	
	}
	
public Conteudo insert(Conteudo conteudo) {
	        try {
	            super.abrir();
	            
	            PreparedStatement stmt= getCnn().prepareStatement("INSERT INTO conteudo VALUES(null,?,?,?,?,?,?)");
	            
	            stmt.setDate(1, (Date) conteudo.getData_publicacao());
	            stmt.setString(2, conteudo.getTitulo());
	            stmt.setString(3, conteudo.getTexto());
	            stmt.setBoolean(4, conteudo.isAtivo());
	            stmt.setInt(5, conteudo.getIdCg());
	            stmt.setInt(6, conteudo.getId());
	            
	            stmt.executeUpdate(); 
	            
	              
	            return conteudo;
	        } catch(Exception ex) {
	            System.out.println(ex.getMessage());
	            return null;
	        }
	        finally {
	            super.fechar();
	        }
}

public Conteudo update(Conteudo conteudo) {
    try {
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("UPDATE conteudo SET data_publicacao = ?, titulo = ?, texto = ?, ativo = ? categoria_id = ?, usuario_id = ? WHERE id = ?");  
        
        stmt.setDate(1, (Date) conteudo.getData_publicacao());
        stmt.setString(2, conteudo.getTitulo());
        stmt.setString(3, conteudo.getTexto());
        stmt.setBoolean(4, conteudo.isAtivo());
        stmt.setInt(5, conteudo.getIdCg());
        stmt.setInt(6, conteudo.getId());
        
        stmt.executeUpdate(); 
        ResultSet id = stmt.getGeneratedKeys();
        if(id.next())
            conteudo.setIdCg(id.getInt(1));
        	conteudo.setId(id.getInt(1));
           
          
        return conteudo;
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
        
        PreparedStatement stmt= getCnn().prepareStatement("DELETE FROM conteudo WHERE id = ?");  
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
public ArrayList<Conteudo> listAll() {
    try {
        ArrayList<Conteudo> co = new ArrayList<Conteudo>();
        
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM conteudo");  
       
        ResultSet rs = stmt.executeQuery(); 
       
        while(rs.next()) {
            Conteudo ac = new Conteudo();
            ac.setIdCt(rs.getInt("id"));
           // ac.setData_publicacao("data_publicacao");
            ac.setTitulo(rs.getString("titulo"));
            ac.setTexto(rs.getString("texto"));
            ac.setIdCg(rs.getInt("categoria_id"));
            ac.setId(rs.getInt("usuario_id"));

            co.add(ac);
        }
        
        return co;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}
public ArrayList<Conteudo> listAe(int id) {
    try {
        ArrayList<Conteudo> co = new ArrayList<Conteudo>(id);
        
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM conteudo WHERE categoria_id = ? ");  
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery(); 
       
        while(rs.next()) {
            Conteudo ac = new Conteudo();
            ac.setIdCt(rs.getInt("id"));
           // ac.setData_publicacao("data_publicacao");
            ac.setTitulo(rs.getString("titulo"));
            ac.setTexto(rs.getString("texto"));
            ac.setIdCg(rs.getInt("categoria_id"));
            ac.setId(rs.getInt("usuario_id"));

            co.add(ac);
        }
        
        return co;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}

public Conteudo get(int id) {
    try {
        Conteudo ce = new Conteudo();
        
        super.abrir();
        
        PreparedStatement stmt= getCnn().prepareStatement("SELECT * FROM Conteudo WHERE id = ?");  
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery(); 
       
        if(rs.next()) {
             ce.setAtivo(rs.getBoolean("ativo"));
             ce.setIdCt(rs.getInt("id"));
            ce.setIdCg(rs.getInt("categoria_id"));
            ce.setId(rs.getInt("usuario_id"));
            ce.setTitulo(rs.getString("titulo"));
            ce.setTexto(rs.getString("texto"));
            
        }
        
        return ce;
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    finally {
        super.fechar();
    }
}

}
