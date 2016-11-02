package clases;

public class Cajera {
	private int codigo;
	private String nombre;
	private String apellido;
	private int dni;
	private int sexo;
	
	public Cajera(int codigo, String nombre, String apellido, int dni, int sexo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sexo = sexo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public String sexoCajera(){
		String m=null;
		if(sexo==0){m="Masculino";}
		else{m="Femenino";}
		return m;
	}
}
