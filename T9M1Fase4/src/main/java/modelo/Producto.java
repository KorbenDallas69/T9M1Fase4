package modelo;

public class Producto {
	
	private int item;  // equivale tambien al indice de la tabla producto
	private int qty;
	private String modelo;
	private String marca;
	private String descripcion;
	private String provdr;
	
	public Producto (int item, int qty, String modelo, String marca, String descripcion, String provdr) {
		
		this.item=item;
		this.qty=qty;
		this.modelo=modelo;
		this.marca=marca;
		this.descripcion=descripcion;
		this.provdr=provdr;
		
	}
	
	public Producto() {
		
	}
	
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item=item;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty=qty;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo=modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca=marca;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public String getProvdr() {
		return provdr;
	}
	public void setProvdr(String provdr) {
		this.provdr=provdr;
	}

}
