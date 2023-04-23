package modelo;

public interface ProductoDAO {
	public boolean registrarP(Producto producto);
	public boolean validarP(Producto producto);
	public Producto consultarP(Producto producto);

}
