package clases;

public class Funcion {
	private int codFuncion;
	private int codCine;
	private int codSala;
	private int codPelicula;
	private String fecha;
	private String hora;
	
	public Funcion(int codFuncion, int codCine, int codSala, int codPelicula, String fecha, String hora) {
		super();
		this.codFuncion = codFuncion;
		this.codCine = codCine;
		this.codSala = codSala;
		this.codPelicula = codPelicula;
		this.fecha = fecha;
		this.hora = hora;
	}

	public int getCodFuncion() {
		return codFuncion;
	}

	public void setCodFuncion(int codFuncion) {
		this.codFuncion = codFuncion;
	}

	public int getCodCine() {
		return codCine;
	}

	public void setCodCine(int codCine) {
		this.codCine = codCine;
	}

	public int getCodSala() {
		return codSala;
	}

	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public int getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
}
