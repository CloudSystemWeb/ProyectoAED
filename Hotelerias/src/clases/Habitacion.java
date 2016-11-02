package clases;

public class Habitacion {
    
	private int   codigoHabitacion;
	private String descripcion,tipo;
	private String ubicacion;
	private double costo;
	

	public Habitacion( int codigoHabitacion, String descripcion,String tipo, String ubicacion, double costo) {
		
		this.codigoHabitacion = codigoHabitacion;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}




	public int getCodigoHabitacion() {
		return codigoHabitacion;
	}


	public void setCodigoHabitacion(int codigoHabitacion) {
		this.codigoHabitacion = codigoHabitacion;
	}


	public double getCosto() {
		return costo;
	}


	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public String ubicacion(){
		String m=null;
		if(ubicacion=="Primer Piso"){m="Primer Piso";}
		else if (ubicacion=="Segundo Piso"){m="Segundo Piso";}
		else if (ubicacion=="Tercer Piso"){m="Tercer Piso";}
		else if (ubicacion=="Cuarto Piso"){m="Cuarto Piso";}
		else {m="Quinto Piso";}
		return m;
	}
    
}
