package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cine;

public class ArregloCine {
	ArrayList<Cine> clien;
	private String Cine;

	public ArregloCine(String Cine) {
		clien = new ArrayList<Cine>();
		this.Cine = Cine;
		cargarCliente();
	}

	public void adicionar(Cine c) {
		clien.add(c);
	}

	public void eliminar(Cine c) {
		clien.remove(c);
	}

	public Cine obtener(int pos) {
		return clien.get(pos);
	}

	public Cine buscar(int codigo) {
		for (Cine c : clien)
			if (c.getCodCine() == codigo)
				return c;
		return null;
	}

	public int tamaño() {
		return clien.size();
	}

	public int codigoMayor(int cod) {
		int co = 100001;
		for (Cine c : clien) {
			if (c.getCodCine() > cod)
				co = c.getCodCine() + 1;
		}
		return co;
	}

	// -------------------------------------
	public Cine buscarNombres(String nombre) {
		for (Cine c : clien)
			if (c.getNombre().equalsIgnoreCase(nombre))
				return c;
		return null;
	}
	// ----------------------------------------

	public boolean existeCliente() {
		File f = new File(Cine);
		return f.exists();
	}

	public void cargarCliente() {
		try {
			BufferedReader c;
			String linea, s[], nombre, departamento, provincia, distrito, fechaIni, fechaAfili, dni, usuario,
					contraseña;
			int codigo, estadoCivil;
			Cine nuevo;
			c = new BufferedReader(new FileReader(Cine));
			while ((linea = c.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());

				nombre = s[1].trim();
				departamento = s[2].trim();
				provincia = s[3].trim();
				distrito = s[4].trim();
				fechaIni = s[5].trim();
				estadoCivil = Integer.parseInt(s[6].trim());

				nuevo = new Cine(codigo, nombre, departamento, provincia, distrito, fechaIni, estadoCivil);
				adicionar(nuevo);
			}
			c.close();
		} catch (Exception e) {
		}
	}

	public void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cine x;
			pw = new PrintWriter(new FileWriter(Cine));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodCine() + ";" + x.getNombre() + ";" + x.getDepartamento() + ";" + x.getProvincia() + ";"
						+ x.getDistrito() + ";" + x.getFechaIniOper() + ";" + x.getEstadoCine();

				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public String getCliente() {
		return Cine;
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			clien.clear();
	}

}
