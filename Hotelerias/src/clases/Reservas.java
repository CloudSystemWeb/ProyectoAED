package clases;

import javax.swing.JOptionPane;

public class Reservas {

	private int codigoReserva;
	private int codigoCliente;
	private int codigoCajero;
	private int CodigoRecepcionista;
	private int numeroHabitacion;
	private String fechaRegistro;
	private String fechaIngreso;
	private String fechaSalida;
	private int estado;

	public Reservas(int codigoReserva, int codigoCliente, int codigoCajero, int codigoRecepcionista,
			int numeroHabitacion, String fechaRegistro, String fechaIngreso, String fechaSalida, int estado) {

		this.codigoReserva = codigoReserva;
		this.codigoCliente = codigoCliente;
		this.codigoCajero = codigoCajero;
		this.CodigoRecepcionista = codigoRecepcionista;
		this.numeroHabitacion = numeroHabitacion;
		this.fechaRegistro = fechaRegistro;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estado = estado;

	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(int codigoReserva) {
		codigoReserva = codigoReserva;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoCajero() {
		return codigoCajero;
	}

	public void setCodigoCajero(int codigoCajero) {
		this.codigoCajero = codigoCajero;
	}

	public int getCodigoRecepcionista() {
		return CodigoRecepcionista;
	}

	public void setCodigoRecepcionista(int codigoRecepcionista) {
		CodigoRecepcionista = codigoRecepcionista;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String estado() {
		String m = null;
		if (estado == 0) {
			m = "INICIADA";
		} else if (estado == 1) {
			m = "ANULADA";
		} else {
			m = "ATENDIDA";
		}
		return m;
	}
}
