 package clases;
                                                                                           
public class Empleado {
	
	private int codEmpleado;
	private  String nombreEmpleado;
	private String apellidoEmpleado;
	private int tipoEmpleado;
	private String Usuario;
	private String Contrase�a;
	
	

 

	
	public Empleado(int codEmpleado, String nombreEmpleado, String apellidoEmpleado, int tipoEmpleado,
			String usuario, String contrase�a) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.tipoEmpleado = tipoEmpleado;
		Usuario = usuario;
		Contrase�a = contrase�a;
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






	public String getContrase�a() {
		return Contrase�a;
	}






	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
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
