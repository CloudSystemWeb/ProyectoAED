package clases;

public class Hospedajes {
	private int codigoHospedaje;
	private int codigoReserva;
	private int codigoCliente;
	private int codigoHabitacion;
	private int codigoRecepcionista;
	private int tipoHospedaje;
	private String fechaRegistro;
	private int estado;
	private double costo;

	public Hospedajes(int codigoHospedaje, int codigoReserva, int codigoCliente, int codigoHabitacion,
			int codigoRecepcionista, int tipoHospedaje, String fechaRegistro, int estado, double costo) {

		this.codigoHospedaje = codigoHospedaje;
		this.codigoReserva = codigoReserva;
		this.codigoCliente = codigoCliente;
		this.codigoHabitacion = codigoHabitacion;
		this.codigoRecepcionista = codigoRecepcionista;
		this.tipoHospedaje = tipoHospedaje;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.costo = costo;
	}

	public int getCodigoHospedaje() {
		return codigoHospedaje;
	}

	public void setCodigoHospedaje(int codigoHospedaje) {
		this.codigoHospedaje = codigoHospedaje;
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoHabitacion() {
		return codigoHabitacion;
	}

	public void setCodigoHabitacion(int codigoHabitacion) {
		this.codigoHabitacion = codigoHabitacion;
	}

	public int getCodigoRecepcionista() {
		return codigoRecepcionista;
	}

	public void setCodigoRecepcionista(int codigoRecepcionista) {
		this.codigoRecepcionista = codigoRecepcionista;
	}

	public int getTipoHospedaje() {
		return tipoHospedaje;
	}

	public void setTipoHospedaje(int tipoHospedaje) {
		this.tipoHospedaje = tipoHospedaje;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String estado() {
		String m = null;
		if (tipoHospedaje == 0) {
			m = "Atendida";
		} else {
			m = "Anulada";
		}
		return m;
	}

}
