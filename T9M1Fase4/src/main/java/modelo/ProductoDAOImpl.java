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
		boolean registrarp=false;
		Statement stm = null;
		Connection conn = null;
		ResultSet rs = null;

		String sql = "insert into inventario.producto (item,qtyc,modeloc,marcac,descripcionc,proveedorc)"+
		"values(null,'"+producto.getQty()+"', '"+producto.getModelo()+"','"+producto.getMarca()+"','"+producto.getDescripcion()+"','"+producto.getProvdr()+"');";
		
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			stm.execute(sql);
			registrarp=true;
			stm.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: No se pudo registrar el producto.");
			e.printStackTrace();
		}
		
		return registrarp;
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
