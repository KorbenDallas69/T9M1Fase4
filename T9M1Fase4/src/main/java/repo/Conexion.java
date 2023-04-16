package repo;

import java.sql.*;

public class Conexion {
	
	private static String usuario = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://localhost:3306/inventario";
	
	public static Connection conectar() {
		Connection conn=null;
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, usuario, password);
			if (conn != null) {
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error de Conexion");
		} catch (ClassNotFoundException e) {
			System.out.println("Error de Driver");
			e.printStackTrace();
		}
		return conn;
	}

}