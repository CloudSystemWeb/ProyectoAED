package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Butaca;

public class ArregloButaca {
	ArrayList<Butaca> butaca;
	private String Butaca;

	public ArregloButaca(String Butaca) {
		butaca = new ArrayList<Butaca>();
		this.Butaca = Butaca;
		cargarbutacate();
	}

	public void adicionar(Butaca c) {
		butaca.add(c);
	}

	public void eliminar(Butaca c) {
		butaca.remove(c);
	}

	public Butaca obtener(int pos) {
		return butaca.get(pos);
	}

	public Butaca buscar(int codigo) {
		for (Butaca c : butaca)
			if (c.getCodButaca() == codigo)
				return c;
		return null;
	}

	public int tamaño() {
		return butaca.size();
	}

	public int codigoMayor(int cod) {
		int co = 100001;
		for (Butaca c : butaca) {
			if (c.getCodButaca() > cod)
				co = c.getCodButaca() + 1;
		}
		return co;
	}

	// -------------------------------------
	// ----------------------------------------

	public boolean existebutacate() {
		File f = new File(Butaca);
		return f.exists();
	}

	public void cargarbutacate() {
		try {
			BufferedReader c;
			String linea, s[];
			int codButaca,codSala,numeroFilas,numeroColumna,estadoButaca;
			Butaca nuevo;
			c = new BufferedReader(new FileReader(Butaca));
			while ((linea = c.readLine()) != null) {
				s = linea.split(";");
				codButaca = Integer.parseInt(s[0].trim());
				codSala = Integer.parseInt(s[1].trim());
				numeroFilas = Integer.parseInt(s[2].trim());
				numeroColumna = Integer.parseInt(s[3].trim());
				estadoButaca = Integer.parseInt(s[4].trim());

				nuevo = new Butaca(codButaca, codSala, numeroFilas, numeroColumna, estadoButaca);
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
			Butaca x;
			pw = new PrintWriter(new FileWriter(Butaca));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodButaca() + ";" + x.getCodSala() + ";" + x.getNumeroFilas() + ";" + x.getNumeroColumna() + ";"
						+ x.getEstadoButaca();

				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public String getbutacate() {
		return Butaca;
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			butaca.clear();
	}

}
