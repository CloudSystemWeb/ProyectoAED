package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Recepcionista;

public class ArregloRecepcionista {
	private ArrayList<Recepcionista> Recep;
	private String archivo;

	public ArregloRecepcionista(String archivo) {
		Recep = new ArrayList<Recepcionista>();
		this.archivo = archivo;
		cargarRecepcionista();
	}

	public String getArchivo() {
		return archivo;
	}

	public void adicionar(Recepcionista x) {
		Recep.add(x);
	}

	public void eliminar(Recepcionista x) {
		Recep.remove(x);
	}

	public Recepcionista obtener(int pos) {
		return Recep.get(pos);
	}

	public Recepcionista buscar(int codRecep) {
		for (Recepcionista p : Recep)
			if (p.getCodigo() == codRecep)
				return p;
		return null;
	}

	// -------------------------------------
	public Recepcionista buscarNombres(String nombre) {
		for (Recepcionista p : Recep)
			if (p.getNombreRecepcionista().equalsIgnoreCase(nombre))
				return p;
		return null;
	}
	// ----------------------------------------

	public int tamaño() {
		return Recep.size();
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			Recep.clear();
	}
	// Operaciones

	public boolean existeArchivo() {
		File f = new File(archivo);
		return f.exists();
	}

	public int codigoMayor(int cod) {
		int co = 100;
		for (Recepcionista r : Recep) {
			if (r.getCodigo() > cod)
				co = r.getCodigo() + 1;
		}
		return co;
	}

	public void cargarRecepcionista() {
		try {
			BufferedReader br;
			String linea, s[], apellido, nombre, telefono;
			int codRecep, estado, sexo;
			Recepcionista nuevo;

			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");

				codRecep = Integer.parseInt(s[0].trim());

				nombre = s[1].trim();
				apellido = s[2].trim();
				telefono = s[3].trim();
				estado = Integer.parseInt(s[4].trim());
				sexo = Integer.parseInt(s[5].trim());

				nuevo = new Recepcionista(codRecep, nombre, apellido, telefono, estado, sexo);
				adicionar(nuevo);

			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void grabarRecepcionista() {
		try {
			PrintWriter pw;
			String linea;
			Recepcionista x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" + x.getNombreRecepcionista() + ";" + x.getApellidoRecepcionista() + ";"
						+ x.getTelefonoRecepcionista() + ";" + x.getEstado() + ";" + x.getSexo();
				pw.println(linea);

			}
			pw.close();
		} catch (Exception e) {
		}
	}
}
