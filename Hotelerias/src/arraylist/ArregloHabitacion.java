package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Habitacion;

public class ArregloHabitacion {

	ArrayList<Habitacion> habi;
	private String archivo;

	public ArregloHabitacion(String archivo) {
		habi = new ArrayList<Habitacion>();
		this.archivo = archivo;
		cargarHabitacion();
	}

	public void adicionar(Habitacion h) {
		habi.add(h);
	}

	public void eliminar(Habitacion h) {
		habi.remove(h);
	}

	public Habitacion obtener(int pos) {
		return habi.get(pos);
	}

	public Habitacion buscar(int codigo) {
		for (Habitacion h : habi)
			if (h.getCodigoHabitacion() == codigo)
				return h;
		return null;
	}

	public int tamaño() {
		return habi.size();
	}

	public int codigoMayor(int cod) {
		int co = 100;
		for (Habitacion c : habi) {
			if (c.getCodigoHabitacion() > cod)
				co = c.getCodigoHabitacion() + 1;
		}
		return co;
	}

	public double mayorPrecio() {
		double max = habi.get(0).getCosto();
		for (int i = 1; i < habi.size(); i++)
			if (habi.get(i).getCosto() > max)
				max = habi.get(i).getCosto();

		return max;
	}

	public double menorPrecio() {
		double min = habi.get(0).getCosto();
		for (int i = 1; i < habi.size(); i++)
			if (habi.get(i).getCosto() < min)
				min = habi.get(i).getCosto();

		return min;
	}

	public boolean existeHabitacion() {
		File f = new File(archivo);
		return f.exists();
	}

	public String getArchivo() {
		return archivo;
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			habi.clear();
	}

	public void cargarHabitacion() {
		try {
			BufferedReader br;
			String linea, s[], descripcion, ubicacion, tipo;
			int codigo;
			double costo;
			Habitacion nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				descripcion = s[1].trim();
				tipo = s[2].trim();
				ubicacion = s[3].trim();
				costo = Double.parseDouble(s[4].trim());
				nuevo = new Habitacion(codigo, descripcion, ubicacion, tipo, costo);
				adicionar(nuevo);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void grabarHabitacion() {
		try {
			PrintWriter pw;
			String linea;
			Habitacion x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoHabitacion() + ";" + x.getDescripcion() + ";" + x.getUbicacion() + ";" + x.getTipo()
						+ ";" + x.getCosto();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

}
