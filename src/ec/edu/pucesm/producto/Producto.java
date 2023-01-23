package ec.edu.pucesm.producto;

public class Producto {
	
	private String codigo;
	private int cantidad;
	private String descripcion;
	private float precio;
	
	public Producto() {}
	
	public Producto(String codigo, int cantidad, String descripcion, float precio) {
		this.setCodigo(codigo);
		this.setCantidad(cantidad);
		this.setDescripcion(descripcion);
		this.setPrecio(precio);
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public float precioFinal() {
		float precioFinal = this.getCantidad() * this.getPrecio();
		return precioFinal;		
	}
}

