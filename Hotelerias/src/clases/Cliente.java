 package clases;
                                                                                           
public class Cliente {
	
	private int codCliente;
	private  String nombreCliente;
	private String apellidoCliente;
	private String dirrecion;
	private String fechaNacimiento;
	private String fechaAfiliacion;
	private int estadoCivil;
	private String DNI;
	private String Usuario;
	private String Contraseña;
	
	private String Telefono;
	private int sexo;
 
	public Cliente(int codCliente, String nombreCliente, String apellidoCliente, String dirrecion,
			String fechaNacimiento, String fechaAfiliacion, int estadoCivil, String dNI, String usuario,
			String contraseña, String telefono) {
		super();
		this.codCliente = codCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.dirrecion = dirrecion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAfiliacion = fechaAfiliacion;
		this.estadoCivil = estadoCivil;
		DNI = dNI;
		Usuario = usuario;
		Contraseña = contraseña;
		Telefono = telefono;

	}

	public String getDirrecion() {
		return dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}


	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public String Sexo(){
		String mens;
	if (sexo==0){ mens="Masculino";}
	else {mens= "Femenino";}
	return mens;
	}
	
	public String EstadoCivil(){
		String mens="";
	if (estadoCivil==0)
	{ mens="Soltero";}
	
	else if  (estadoCivil==1)
	{mens= "Casado";}
	
	else if  (estadoCivil==2)
	{mens= "Viudo";}
	
	else if  (estadoCivil==3)
	{mens= "Divorciado";}
	
	return mens;
	}
	
	
}
