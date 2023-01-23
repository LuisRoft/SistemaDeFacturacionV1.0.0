package ec.edu.pucesm.cliente;

public class Cliente {
	public Cliente () {}
	
	public Cliente(int cedula, String nombres, String direccion, int telefono, String email) {
		this.setCedula(cedula);
		this.setNombres(nombres);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setEmail(email);
	}
	
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private int cedula;
	private String nombres;
	private String direccion;
	private int telefono;
	private String email;
}
