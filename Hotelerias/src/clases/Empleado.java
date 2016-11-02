 package clases;
                                                                                           
public class Empleado {
	
	private int codEmpleado;
	private  String nombreEmpleado;
	private String apellidoEmpleado;
	private int tipoEmpleado;
	private String Usuario;
	private String Contraseña;
	
	

 

	
	public Empleado(int codEmpleado, String nombreEmpleado, String apellidoEmpleado, int tipoEmpleado,
			String usuario, String contraseña) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.tipoEmpleado = tipoEmpleado;
		Usuario = usuario;
		Contraseña = contraseña;
	}



	public int getCodEmpleado() {
		return codEmpleado;
	}



	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}






	public String getNombreEmpleado() {
		return nombreEmpleado;
	}






	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}






	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}






	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
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






	public int getTipoEmpleado() {
		return tipoEmpleado;
	}



	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}



	public String TipoEmpleado(){
		String mens="";
	if (tipoEmpleado==0)
	{ mens="Administrador";}
	
	else if  (tipoEmpleado==1)
	{mens= "Supervisor";}
	
	else if  (tipoEmpleado==2)
	{mens= "Cajero";}
	
	
	return mens;
	}
	
	
}
