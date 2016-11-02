package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Recepcionista;

public class ArregloCliente {
	ArrayList<Cliente>clien;
	private String   Cliente;	
	
	public ArregloCliente(String Cliente){
		clien = new ArrayList<Cliente>();
		this.Cliente = Cliente;
		cargarCliente();
	}
	public void adicionar(Cliente c){
		clien.add(c);
	}
	public void eliminar(Cliente c){
		clien.remove(c);
	}
	public Cliente obtener(int pos){
		return clien.get(pos);
	}

	public Cliente buscar(int codigo){
		for(Cliente c:clien)
			if(c.getCodCliente()==codigo)
				return c;
		return null;
	}

	public int tamaño(){
		return clien.size();
	}
	
	public int codigoMayor(int cod){
		int co=100001;
		for (Cliente c: clien){
			if (c.getCodCliente()>cod)
				co=c.getCodCliente()+1;
		}
		return co;
	}
	
	//-------------------------------------
	public Cliente buscarNombres(String nombre){
		for(Cliente c:clien)
			if(c.getNombreCliente().equalsIgnoreCase(nombre))
				return c;
		return null;
	}
	//----------------------------------------

	
	public boolean existeCliente() {
		File  f = new File(Cliente);
		return f.exists();
	}
	
	public void cargarCliente() {
			try {
				BufferedReader  c;
				String          linea, s[], nombre,apellido,telefono,direccion,fechaNa,fechaAfili,dni,usuario,contraseña;
				int             codigo,estadoCivil;
				Cliente         nuevo;
				c = new BufferedReader(new FileReader(Cliente));
				while ((linea = c.readLine()) != null) {
					s = linea.split(";");
					codigo = Integer.parseInt(s[0].trim());
					
					nombre = s[1].trim();
					apellido = s[2].trim();
					direccion = s[3].trim();
					fechaNa = s[4].trim();
					fechaAfili = s[5].trim();
					estadoCivil = Integer.parseInt(s[6].trim());
					telefono = s[7].trim();
					dni = s[8].trim();
					usuario = s[9].trim();
					contraseña = s[10].trim();
					

	
					nuevo = new Cliente(codigo,nombre,apellido,direccion,fechaNa,fechaAfili,estadoCivil,telefono, dni,usuario, contraseña );
					adicionar(nuevo);
				}
				c.close();
			}
			catch(Exception e) {
			}
		}
	
	public void grabarClientes() {
		try {
			PrintWriter  pw;
			String       linea;
			Cliente       x;
			pw = new PrintWriter(new FileWriter(Cliente));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodCliente() + ";" +
				        x.getNombreCliente() + ";" +
				        x.getApellidoCliente() + ";" +
				        x.getDirrecion() + ";" +
				        x.getFechaNacimiento() + ";" +
				        x.getFechaAfiliacion() + ";" +
				        x.getEstadoCivil() + ";" +
				        x.getTelefono() + ";" +
				        x.getDNI() + ";" +
				        x.getUsuario() + ";" +
				        x.getContraseña();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e) {
		}
	}
	
	public String getCliente() {
	return Cliente; 
	}
	
	public void eliminarTodo() {
		if (tamaño() > 0)
	    	clien.clear();
	}
	
	}


