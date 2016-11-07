package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Funcion;

public class ArregloFuncion {
	ArrayList<Funcion> funcion;
	private String Funcion;

	public ArregloFuncion(String Butaca) {
		funcion = new ArrayList<Funcion>();
		this.Funcion = Butaca;
		cargarbutacate();
	}

	public void adicionar(Funcion c) {
		funcion.add(c);
	}

	public void eliminar(Funcion c) {
		funcion.remove(c);
	}

	public Funcion obtener(int pos) {
		return funcion.get(pos);
	}

	public Funcion buscar(int codigo) {
		for (Funcion c : funcion)
			if (c.getCodFuncion() == codigo)
				return c;
		return null;
	}

	public int tamaño() {
		return funcion.size();
	}

	public int codigoMayor(int cod) {
		int co = 100001;
		for (Funcion c : funcion) {
			if (c.getCodFuncion() > cod)
				co = c.getCodFuncion() + 1;
		}
		return co;
	}

	// -------------------------------------
	// ----------------------------------------

	public boolean existebutacate() {
		File f = new File(Funcion);
		return f.exists();
	}

	public void cargarbutacate() {
		try {
			BufferedReader c;
			String linea, s[];
			int codFuncion,codCine,codSala,codPelicula;
			String fecha,hora;
			Funcion nuevo;
			c = new BufferedReader(new FileReader(Funcion));
			while ((linea = c.readLine()) != null) {
				s = linea.split(";");
				codFuncion = Integer.parseInt(s[0].trim());
				codCine = Integer.parseInt(s[1].trim());
				codSala = Integer.parseInt(s[2].trim());
				codPelicula = Integer.parseInt(s[3].trim());
				fecha = s[4].trim();
				hora = s[5].trim();

				nuevo = new Funcion(codFuncion, codCine, codSala, codPelicula,fecha,hora);
				adicionar(nuevo);
			}
			c.close();
		} catch (Exception e) {
		}
	}

	public void grabarbutacates() {
		try {
			PrintWriter pw;
			String linea;
			Funcion x;
			pw = new PrintWriter(new FileWriter(Funcion));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodFuncion() + ";" + x.getCodCine() + ";" + x.getCodSala() + ";" + x.getCodPelicula() + ";"
						+ x.getFecha()+ ";"+x.getHora();

				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public String getfuncion() {
		return Funcion;
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			funcion.clear();
	}

}
