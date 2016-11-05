package clases;

public class Pelicula {
	
	private int codPelicula;
	private  String tituloDistri;
	private String tituloOri;
	private String fechEstreno;
	private String genero;
	private String paisOri;
	private String Sinopsis;
	public String getSinopsis() {
		return Sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		Sinopsis = sinopsis;
	}

	private String Duracion;
	private String recaudacion;

	

	private int tipoProye;
	private int EstadoProyec;
	private int tipoCensura;
	public int getCodPelicula() {
		return codPelicula;
	}
	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}
	public String getTituloDistri() {
		return tituloDistri;
	}
	public void setTituloDistri(String tituloDistri) {
		this.tituloDistri = tituloDistri;
	}
	public String getTituloOri() {
		return tituloOri;
	}
	public void setTituloOri(String tituloOri) {
		this.tituloOri = tituloOri;
	}
	public String getFechEstreno() {
		return fechEstreno;
	}
	public void setFechEstreno(String fechEstreno) {
		this.fechEstreno = fechEstreno;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPaisOri() {
		return paisOri;
	}
	public void setPaisOri(String paisOri) {
		this.paisOri = paisOri;
	}

	public String getDuracion() {
		return Duracion;
	}
	public void setDuracion(String duracion) {
		Duracion = duracion;
	}
	public String getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(String recaudacion) {
		this.recaudacion = recaudacion;
	}

	public Pelicula(int codPelicula, String tituloDistri, String tituloOri, String fechEstreno, String genero,
			String paisOri, String sinopsis, String duracion, String recaudacion, int tipoProye, int estadoProyec,
			int tipoCensura) {
		super();
		this.codPelicula = codPelicula;
		this.tituloDistri = tituloDistri;
		this.tituloOri = tituloOri;
		this.fechEstreno = fechEstreno;
		this.genero = genero;
		this.paisOri = paisOri;
		Sinopsis = sinopsis;
		Duracion = duracion;
		this.recaudacion = recaudacion;
		this.tipoProye = tipoProye;
		EstadoProyec = estadoProyec;
		this.tipoCensura = tipoCensura;
	}
	public int getTipoProye() {
		return tipoProye;
	}
	public void setTipoProye(int tipoProye) {
		this.tipoProye = tipoProye;
	}
	public int getEstadoProyec() {
		return EstadoProyec;
	}
	public void setEstadoProyec(int estadoProyec) {
		EstadoProyec = estadoProyec;
	}
	public int getTipoCensura() {
		return tipoCensura;
	}
	public void setTipoCensura(int tipoCensura) {
		this.tipoCensura = tipoCensura;
	}
	
	
	public 	String EstadoTipoProyeccion() {
		String mens = "";
		if (tipoProye == 0) {
			mens = "Estreno";
		}

		else if (tipoProye == 1) {
			mens = "Fuera de Estreno";
		}

		return mens;
	}
	
	public String EstadoTipoCensura() {
		String mens = "";
		if (tipoCensura == 0) {
			mens = "Apata_para_Todos";
		}

		else if (tipoCensura == 1) {
			mens = "Mayores_14";
		}
		
		else if (tipoCensura == 1) {
			mens = "Mayores_18";
		}
		return mens;
	}
	
	public String EstadoProyeccion() {
		String mens = "";
		if (EstadoProyec == 0) {
			mens = "En_Cartelera";
		}

		else if (EstadoProyec == 1) {
			mens = "Fuera_cartelera";
		}

		return mens;
	}

}
