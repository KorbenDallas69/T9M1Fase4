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
		
		String sql = "select * from inventario.producto where modeloc= '"+ producto.getModelo()+"'; ";
		
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				p.setItem(rs.getInt(1));
				p.setQty(rs.getInt(2));
				p.setModelo(rs.getString(3));
				p.setMarca(rs.getString(4));
				p.setDescripcion(rs.getString(5));
				p.setProvdr(rs.getString(6));
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
		boolean validar = false;
		Statement stm = null;
		Connection conn = null;
		ResultSet rs=null;
		Producto p= new Producto();
		
		String sql = "select * from inventario.producto where modeloc= '"+ producto.getModelo()+"'; ";
		
		try {			
			conn = Conexion.conectar();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				p.setModelo(producto.getModelo());
				validar=true;
			}
			stm.close();
			rs.close();
			conn.close();			
		} catch (SQLException e) {
			System.out.println("Error: No se pudo validar si el producto existe.");
			e.printStackTrace();
		}
		return validar;
	}

}
