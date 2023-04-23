package modelo;

public class Usuario {

	private int id;
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private int edad; 
	
	public Usuario (String usuario,  String nombre, String appellido, String password, String edad ) {
		this.usuario=usuario;
		this.password=password;
		this.nombre=nombre;
		this.apellido=appellido;
		this.edad=Integer.parseInt(edad);
		//this.id=Integer.parseInt(id); 
		
	}
	
	public Usuario() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario=usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad=edad;
	}

}
