package modelo;

import java.sql.*;

import repo.Conexion;

public class ProductoDAOImpl implements ProductoDAO{
	@Override
	public Producto consultarP(Producto producto) {
		Statement stm = null;
		Connection conn = null;
		ResultSet rs = null;
		Producto p= new Producto();
		
		String sql = "select usercol from inventario.user where usercol= '"+ producto.getModelo()+"'; ";
		
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				p.setItem(rs.getInt(1));
			}
			stm.close();
			rs.close();
			conn.close();			
		} catch (SQLException e) {
			System.out.println("Error: No se Encontro el Modelo Buscado.");
			e.printStackTrace();
		}
		return p;
		
	}

	@Override
	public boolean registrarP(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validarP(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

}
