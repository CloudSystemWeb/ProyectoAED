package clases;

public class Sala {

	private int codSala;
	private int codCine;
	private int numeroSala;
	private int numeroFilas;
	private int numeroButacas;


	public Sala(int codSala, int codCine, int numeroSala, int numeroFilas, int numeroButacas) {
		super();
		this.codSala = codSala;
		this.codCine = codCine;
		this.numeroSala = numeroSala;
		this.numeroFilas = numeroFilas;
		this.numeroButacas = numeroButacas;
	}

	public int getCodSala() {
		return codSala;
	}


	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}


	public int getCodCine() {
		return codCine;
	}


	public void setCodCine(int codCine) {
		this.codCine = codCine;
	}


	public int getNumeroSala() {
		return numeroSala;
	}


	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}


	public int getNumeroFilas() {
		return numeroFilas;
	}


	public void setNumeroFilas(int numeroFilas) {
		this.numeroFilas = numeroFilas;
	}


	public int getNumeroButacas() {
		return numeroButacas;
	}


	public void setNumeroButacas(int numeroButacas) {
		this.numeroButacas = numeroButacas;
	}
	
}
