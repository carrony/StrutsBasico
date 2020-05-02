package com.dred.struts.strutservlet;

import com.opensymphony.xwork2.ActionSupport;

public class ProductoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String descripcion;
	private double precio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
public void setPrecio(String cadPrecio) {
	double precio=-1;
	try {
		precio=Double.parseDouble(cadPrecio);
		if (precio >0) {
			this.setPrecio(precio);
		}
	} catch (NumberFormatException e) {
		this.setPrecio(-1);
	}
}

	public String execute() throws Exception {
		if (this.precio==-1) {
			return INPUT;
		}
		return SUCCESS;
	}
}
