package modelo;

public interface ProductoDAO {
	public boolean registrar(Producto producto);
	public boolean validar(Producto producto);
	public Producto consultar(Producto producto);

}
