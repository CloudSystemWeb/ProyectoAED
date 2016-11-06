package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Sala;

public class ArregloSala {
	ArrayList<Sala> sala;
	private String archivo;

	public ArregloSala(String archivo) {
		sala = new ArrayList<Sala>();
		this.archivo = archivo;
		cargarSala();
	}

	public void adicionar(Sala o) {
		sala.add(o);
	}

	public void eliminar(Sala o) {
		sala.remove(o);
	}

	public Sala obtener(int pos) {
		return sala.get(pos);
	}

	public int tamano() {
		return sala.size();
	}

	public Sala buscar(int codigo) {
		for (Sala o : sala)
			if (o.getCodSala() == codigo)
				return o;
		return null;
	}

	public int codigoMayor(int cod) {
		int co = 100001;
		for (Sala c : sala) {
			if (c.getCodSala() > cod)
				co = c.getCodSala() + 1;
		}
		return co;
	}

	///////////////////////////////////////////////////////// 7
	public void cargarSala() {
		try {
			BufferedReader c;
			String linea, s[];
			int codSala, codCine, numeroSala, numeroFilas, numeroButacas;
			Sala nuevo;
			c = new BufferedReader(new FileReader(archivo));
			while ((linea = c.readLine()) != null) {
				s = linea.split(";");
				codSala = Integer.parseInt(s[0].trim());
				codCine = Integer.parseInt(s[1].trim());
				numeroSala = Integer.parseInt(s[2].trim());
				numeroFilas = Integer.parseInt(s[3].trim());
				numeroButacas = Integer.parseInt(s[4].trim());
				
				nuevo = new Sala(codSala, codCine, numeroSala, numeroFilas, numeroButacas);
				adicionar(nuevo);
			}
			c.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void grabarSala() {
		try {
			PrintWriter pw;
			String linea;
			Sala x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamano(); i++) {
				x = obtener(i);
				linea = x.getCodSala() + ";" + x.getCodCine() + ";" + x.getNumeroSala() + ";"
						+ x.getNumeroFilas() + ";" + x.getNumeroButacas();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public String getSala() {
		return archivo;
	}

	public void eliminarTodo() {
		if (tamano() > 0)
			sala.clear();
	}

	public boolean existeSala() {
		File f = new File(archivo);
		return f.exists();
	}
}
