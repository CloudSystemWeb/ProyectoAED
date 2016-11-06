package clases;

public class Butaca {
	private int codButaca;
	private int codSala;
	private int numeroFilas;
	private int numeroColumna;
	private int estadoButaca;
	public Butaca(int codButaca, int codSala, int numeroFilas, int numeroColumna, int estadoButaca) {
		super();
		this.codButaca = codButaca;
		this.codSala = codSala;
		this.numeroFilas = numeroFilas;
		this.numeroColumna = numeroColumna;
		this.estadoButaca = estadoButaca;
	}
	public int getCodButaca() {
		return codButaca;
	}
	public void setCodButaca(int codButaca) {
		this.codButaca = codButaca;
	}
	public int getCodSala() {
		return codSala;
	}
	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}
	public int getNumeroFilas() {
		return numeroFilas;
	}
	public void setNumeroFilas(int numeroFilas) {
		this.numeroFilas = numeroFilas;
	}
	public int getNumeroColumna() {
		return numeroColumna;
	}
	public void setNumeroColumna(int numeroColumna) {
		this.numeroColumna = numeroColumna;
	}
	public int getEstadoButaca() {
		return estadoButaca;
	}
	public void setEstadoButaca(int estadoButaca) {
		this.estadoButaca = estadoButaca;
	}
	
}
