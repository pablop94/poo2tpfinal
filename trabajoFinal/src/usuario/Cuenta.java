package usuario;

public abstract class Cuenta {

	private String nombreCompleto;
	private String direccionDeMail;
	private String telefono;
	
	public Cuenta(String nombre, String mail, String numeroTelefono) {
		this.nombreCompleto=nombre;
		this.direccionDeMail=mail;
		this.telefono=numeroTelefono;
	}
	
	
	public String obtenerNombre() {
		return nombreCompleto;
	}
	
	
	public String obtenerMail() {
		return direccionDeMail;
	}
	
	
	public String obtenerTelefono() {
		return telefono;
	}	
	
}

