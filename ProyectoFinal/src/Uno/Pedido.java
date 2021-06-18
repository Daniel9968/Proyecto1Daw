package Uno;

import java.io.Serializable;

public class Pedido implements Serializable{
	
	private int id=0;
	private String nombreEmpleado;
	private String carrito;
	private String detalles;
	private double coste;

	public Pedido(int id, String nombreEmpleado, String carrito, String detalles, double coste) {
		this.id=id;
		this.nombreEmpleado=nombreEmpleado;
		this.carrito=carrito;
		this.detalles=detalles;
		this.coste=coste;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreEmpleado;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreEmpleado = nombreCliente;
	}

	public String getCarrito() {
		return carrito;
	}

	public void setCarrito(String carrito) {
		this.carrito = carrito;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}
	
	public String toString() {
		return 
	"ID: "+id+"\n"
	+"Empleado: "+nombreEmpleado+"\n"
	+"Carrito: "+"\n"
	+carrito+"\n"
	+"Detalles del pedido: "+"\n"+detalles+"\n"
	+"Coste: "+coste+"€";
	}
}
