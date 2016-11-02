package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cajera;
import clases.Cliente;

public class ArregloCajera {

	ArrayList<Cajera> caje;
	private String archivo;

	public ArregloCajera(String archivo) {
		caje = new ArrayList<Cajera>();
		this.archivo = archivo;
		cargarCajera();
	}

	public void adicionar(Cajera p) {
		caje.add(p);
	}

	public void eliminar(Cajera p) {
		caje.remove(p);
	}

	public Cajera obtener(int pos) {
		return caje.get(pos);
	}

	public Cajera buscar(int codigo) {
		for (Cajera p : caje)
			if (p.getCodigo() == codigo)
				return p;
		return null;
	}

	public int codigoMayor(int cod) {
		int co = 100;
		for (Cajera c : caje) {
			if (c.getCodigo() > cod)
				co = c.getCodigo() + 1;
		}
		return co;
	}

	public int tamano() {
		return caje.size();
	}

	public boolean existeCajera() {
		File f = new File(archivo);
		return f.exists();
	}

	public void cargarCajera() {
		try {
			BufferedReader c;
			String linea, s[], nombre, apellido;
			int codigo, dni, sexo;
			Cajera nuevo;
			c = new BufferedReader(new FileReader(archivo));
			while ((linea = c.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());

				nombre = s[1].trim();
				apellido = s[2].trim();

				dni = Integer.parseInt(s[3].trim());
				sexo = Integer.parseInt(s[4].trim());

				nuevo = new Cajera(codigo, nombre, apellido, dni, sexo);
				adicionar(nuevo);
			}
			c.close();
		} catch (Exception e) {
		}
	}

	public void grabarCajera() {
		try {
			PrintWriter pw;
			String linea;
			Cajera x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamano(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" + x.getNombre() + ";" + x.getApellido() + ";" + x.getDni() + ";"
						+ x.getSexo();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public String getCajera() {
		return archivo;
	}

	public void eliminarTodo() {
		if (tamano() > 0)
			caje.clear();
	}
}
