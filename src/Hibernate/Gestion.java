package Hibernate;
// Generated 18-nov-2018 18:36:45 by Hibernate Tools 3.5.0.Final

/**
 * Gestion generated by hbm2java
 */
public class Gestion implements java.io.Serializable {

	private GestionId id;
	private Piezas piezas;
	private Proyectos proyectos;
	private Proveedores proveedores;
	private Float cantidad;

	public Gestion() {
	}

	public Gestion(GestionId id, Piezas piezas, Proyectos proyectos) {
		this.id = id;
		this.piezas = piezas;
		this.proyectos = proyectos;
	}

	public Gestion(GestionId id, Piezas piezas, Proyectos proyectos, Float cantidad) {
		this.id = id;
		this.piezas = piezas;
		this.proyectos = proyectos;
		this.cantidad = cantidad;
	}

	public GestionId getId() {
		return this.id;
	}

	public void setId(GestionId id) {
		this.id = id;
	}

	public Piezas getPiezas() {
		return this.piezas;
	}

	public void setPiezas(Piezas piezas) {
		this.piezas = piezas;
	}

	public Proyectos getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Proyectos proyectos) {
		this.proyectos = proyectos;
	}

	public Proveedores getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	public Float getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

}
