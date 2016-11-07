package clases;

public class Reservas {

	private int codigoReserva;
	private int codigoCliente;
	private int codigoEmpleado;
	private int codigoFuncion;
	private String fechaReserva;
	private String HoraIngreso;
	private int estado;
	
	
	
	public Reservas(int codigoReserva, int codigoCliente, int codigoEmpleado, int codigoFuncion, String fechaReserva,
			String horaIngreso, int estado) {
		super();
		this.codigoReserva = codigoReserva;
		this.codigoCliente = codigoCliente;
		this.codigoEmpleado = codigoEmpleado;
		this.codigoFuncion = codigoFuncion;
		this.fechaReserva = fechaReserva;
		HoraIngreso = horaIngreso;
		this.estado = estado;
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



	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}



	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}



	public int getCodigoFuncion() {
		return codigoFuncion;
	}



	public void setCodigoFuncion(int codigoFuncion) {
		this.codigoFuncion = codigoFuncion;
	}



	public String getFechaReserva() {
		return fechaReserva;
	}



	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}



	public String getHoraIngreso() {
		return HoraIngreso;
	}



	public void setHoraIngreso(String horaIngreso) {
		HoraIngreso = horaIngreso;
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
