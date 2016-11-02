package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Empleado;
import clases.Recepcionista;

public class ArregloEmpleado {
	ArrayList<Empleado> emple;
	private String empleado;

	public ArregloEmpleado(String Empleado) {
		emple = new ArrayList<Empleado>();
		this.empleado = Empleado;
		cargarEmpleado();
	}

	public void adicionar(Empleado c) {
		emple.add(c);
	}

	public void eliminar(Empleado c) {
		emple.remove(c);
	}

	public Empleado obtener(int pos) {
		return emple.get(pos);
	}

	public Empleado buscar(int codigo) {
		for (Empleado c : emple)
			if (c.getCodEmpleado() == codigo)
				return c;
		return null;
	}

	public int tama�o() {
		return emple.size();
	}

	public int codigoMayor(int cod) {
		int co = 100;
		for (Empleado c : emple) {
			if (c.getCodEmpleado() > cod)
				co = c.getCodEmpleado() + 1;
		}
		return co;
	}

	// -------------------------------------
	public Empleado buscarNombres(String nombre) {
		for (Empleado c : emple)
			if (c.getNombreEmpleado().equalsIgnoreCase(nombre))
				return c;
		return null;
	}
	// ----------------------------------------

	public boolean existeEmpleado() {
		File f = new File(empleado);
		return f.exists();
	}

	public void cargarEmpleado() {
		try {
			BufferedReader c;
			String linea, s[], nombre, apellido, usuario, contrase�a;
			int codigo, tipoEmpleado;
			Empleado nuevo;
			c = new BufferedReader(new FileReader(empleado));

			while ((linea = c.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());

				nombre = s[1].trim();
				apellido = s[2].trim();
				tipoEmpleado = Integer.parseInt(s[4].trim());
				usuario = s[5].trim();
				contrase�a = s[6].trim();

				nuevo = new Empleado(codigo, nombre, apellido, tipoEmpleado, usuario, contrase�a);
				adicionar(nuevo);
			}
			c.close();
		} catch (Exception e) {
		}
	}

	public void grabarEmpleado() {
		try {
			PrintWriter pw;
			String linea;
			Empleado x;
			pw = new PrintWriter(new FileWriter(empleado));
			for (int i = 0; i < tama�o(); i++) {
				x = obtener(i);
				linea = x.getCodEmpleado() + ";" + x.getNombreEmpleado() + ";" + x.getApellidoEmpleado() + ";"
						+ x.getTipoEmpleado() + ";" + x.getUsuario() + ";" + x.getContrase�a();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public String getEmpleado() {
		return empleado;
	}

	public void eliminarTodo() {
		if (tama�o() > 0)
			emple.clear();
	}

}
