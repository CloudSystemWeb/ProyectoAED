package clases;

public class Recepcionista {
	
	private int codigo;
	private int estado;
	private String apellidoRecepcionista;
	private String nombreRecepcionista;
	private String telefonoRecepcionista;
	private int sexo;
	
	public Recepcionista(int codigo, String nombreRecepcionista, String apellidoRecepcionista, String telefonoRecepcionista, int estado, int sexo) {
	
		this.codigo = codigo;
		this.estado = estado;
		this.apellidoRecepcionista = apellidoRecepcionista;
		this.nombreRecepcionista = nombreRecepcionista;
		this.telefonoRecepcionista = telefonoRecepcionista;
		this.sexo=sexo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getApellidoRecepcionista() {
		return apellidoRecepcionista;
	}

	public void setApellidoRecepcionista(String apellidoRecepcionista) {
		this.apellidoRecepcionista = apellidoRecepcionista;
	}

	public String getNombreRecepcionista() {
		return nombreRecepcionista;
	}

	public void setNombreRecepcionista(String nombreRecepcionista) {
		this.nombreRecepcionista = nombreRecepcionista;
	}

	public String getTelefonoRecepcionista() {
		return telefonoRecepcionista;
	}

	public void setTelefonoRecepcionista(String telefonoRecepcionista) {
		this.telefonoRecepcionista = telefonoRecepcionista;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String Tipo(){
		String mens;
	if (estado==0){ mens="ACTIVO";}
	else {mens= "NO ACTIVO";}
	return mens;
	}
	
	public String Sexo(){
		String mens;
	if (sexo==0){ mens="Masculino";}
	else {mens= "Femenino";}
	return mens;
	}

}
