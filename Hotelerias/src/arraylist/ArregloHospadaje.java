package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Hospedajes;

public class ArregloHospadaje {
	ArrayList<Hospedajes> hosp;
	private String archivo;

	public ArregloHospadaje(String archivo) {
		hosp = new ArrayList<Hospedajes>();
		this.archivo = archivo;
		cargarHospedaje();
	}

	public void adicionar(Hospedajes o) {
		hosp.add(o);
	}

	public void eliminar(Hospedajes o) {
		hosp.remove(o);
	}

	public Hospedajes obtener(int pos) {
		return hosp.get(pos);
	}

	public int tamano() {
		return hosp.size();
	}

	public Hospedajes buscar(int codigo) {
		for (Hospedajes o : hosp)
			if (o.getCodigoHospedaje() == codigo)
				return o;
		return null;
	}

	public Hospedajes buscarRecep(int codigo) {
		for (Hospedajes o : hosp)
			if (o.getCodigoRecepcionista() == codigo)
				return o;
		return null;
	}

	public Hospedajes buscarHabit(int codigo) {
		for (Hospedajes o : hosp)
			if (o.getCodigoHabitacion() == codigo)
				return o;
		return null;
	}

	public int codigoMayor(int cod) {
		int co = 100;
		for (Hospedajes c : hosp) {
			if (c.getCodigoHospedaje() > cod)
				co = c.getCodigoHospedaje() + 1;
		}
		return co;
	}

	public Hospedajes costo(double costo) {
		for (Hospedajes c : hosp)
			if (c.getCosto() == costo)
				return c;

		return null;

	}

	///////////////////////////////////////////////////////// 7
	public void cargarHospedaje() {
		try {
			BufferedReader c;
			String linea, s[], fechaRegistro;
			int codigoHosp, codigoReserva, codigoCliente, numeroHabitacion, CodigoRecepcionista, tipo, estado;
			double costo;
			Hospedajes nuevo;
			c = new BufferedReader(new FileReader(archivo));
			while ((linea = c.readLine()) != null) {
				s = linea.split(";");
				codigoHosp = Integer.parseInt(s[0].trim());

				codigoReserva = Integer.parseInt(s[1].trim());
				codigoCliente = Integer.parseInt(s[2].trim());
				numeroHabitacion = Integer.parseInt(s[3].trim());
				CodigoRecepcionista = Integer.parseInt(s[4].trim());
				tipo = Integer.parseInt(s[5].trim());
				fechaRegistro = s[6].trim();
				estado = Integer.parseInt(s[7].trim());
				costo = Double.parseDouble(s[8].trim());

				nuevo = new Hospedajes(codigoHosp, codigoReserva, codigoCliente, numeroHabitacion, CodigoRecepcionista,
						tipo, fechaRegistro, estado, costo);
				adicionar(nuevo);
			}
			c.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void grabarHospedaje() {
		try {
			PrintWriter pw;
			String linea;
			Hospedajes x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamano(); i++) {
				x = obtener(i);
				linea = x.getCodigoHospedaje() + ";" + x.getCodigoReserva() + ";" + x.getCodigoCliente() + ";"
						+ x.getCodigoHabitacion() + ";" + x.getCodigoRecepcionista() + ";" + x.getTipoHospedaje() + ";"
						+ x.getFechaRegistro() + ";" + x.getEstado() + ";" + x.getCosto();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public String getHospedaje() {
		return archivo;
	}

	public void eliminarTodo() {
		if (tamano() > 0)
			hosp.clear();
	}

	public boolean existeHospedaje() {
		File f = new File(archivo);
		return f.exists();
	}
}
