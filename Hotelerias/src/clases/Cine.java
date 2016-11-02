package clases;

public class Cine {

	private int codCine;
	private String nombre;
	private String departamento;
	private String provincia;
	private String distrito;
	private String fechaIniOper;
	private int estadoCine;

	public Cine(int codCine, String nombre, String departamento, String provincia, String distrito, String fechaIniOper,
			int estadoCine) {
		super();
		this.codCine = codCine;
		this.nombre = nombre;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.fechaIniOper = fechaIniOper;
		this.estadoCine = estadoCine;
	}

	public String EstadoCine() {
		String mens = "";
		if (estadoCine == 0) {
			mens = "Estandar";
		}

		else if (estadoCine == 1) {
			mens = "Prime";
		}

		return mens;
	}

	public int getCodCine() {
		return codCine;
	}

	public void setCodCine(int codCine) {
		this.codCine = codCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getFechaIniOper() {
		return fechaIniOper;
	}

	public void setFechaIniOper(String fechaIniOper) {
		this.fechaIniOper = fechaIniOper;
	}

	public int getEstadoCine() {
		return estadoCine;
	}

	public void setEstadoCine(int estadoCine) {
		this.estadoCine = estadoCine;
	}

}
