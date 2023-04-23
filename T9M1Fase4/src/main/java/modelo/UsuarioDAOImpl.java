package modelo;

import java.sql.*;

import repo.Conexion;

public class UsuarioDAOImpl implements UsuarioDAO{
	@Override
	public boolean registrar(Usuario usuario) {
		boolean registrar = false;
		Statement stm = null;
		Connection conn = null;  
		String sql = "insert into inventario.user (iduser, usercol, paswordc, nombrec)" + 
		"values(null,'"+usuario.getUsuario()+"','"+usuario.getPassword()+"','"+usuario.getNombre()+
		"');";
		
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: No se pudo registrar el usuario.");
			e.printStackTrace();
		}
		return registrar;
	}
	@Override 
	public  boolean validar(Usuario usuario) {
		boolean validar = false;
		Statement stm = null;
		Connection conn = null;
		ResultSet rs=null;
		Usuario u= new Usuario();
		
		String sql = "select usercol, paswordc  from inventario.user where usercol='"+ usuario.getUsuario()+ "' and paswordc = '"+ usuario.getPassword()+"'; ";
		
		try {			
			conn = Conexion.conectar();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				u.setUsuario(usuario.getUsuario());
				validar=true;
			}
			stm.close();
			rs.close();
			conn.close();			
		} catch (SQLException e) {
			System.out.println("Error: No se pudo validar si el usuario existe.");
			e.printStackTrace();
		}
		
		return validar;	
	}
	@Override
	public Usuario consultar(Usuario usuario) {
		Statement stm = null;
		Connection conn = null;
		ResultSet rs = null;
		Usuario u= new Usuario();
		
		String sql = "select usercol from inventario.user where usercol= '"+ usuario.getUsuario()+"'; ";
		
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				u.setId(rs.getInt(1));
			}
			stm.close();
			rs.close();
			conn.close();			
		} catch (SQLException e) {
			System.out.println("Error: No se pudo validar si el usuario existe.");
			e.printStackTrace();
		}
		return u;
		
	}

}
