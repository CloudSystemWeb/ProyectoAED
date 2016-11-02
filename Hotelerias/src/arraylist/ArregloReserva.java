package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Hospedajes;
import clases.Reservas;

public class ArregloReserva {

	ArrayList<Reservas> reser;
	private String archivo;

	public ArregloReserva(String archivo) {
		reser = new ArrayList<Reservas>();
		this.archivo = archivo;
		cargarReserva();
	}

	public void adicionar(Reservas a) {
		reser.add(a);
	}

	public void eliminar(Reservas a) {
		reser.remove(a);
	}

	public Reservas obtener(int pos) {
		return reser.get(pos);
	}

	public int tamano() {
		return reser.size();
	}

	public Reservas buscar(int codigo) {
		for (Reservas a : reser)
			if (a.getCodigoReserva() == codigo)
				return a;
		return null;
	}

	public ArrayList<String> buscarFech(String fecha1, String fecha2) {
		ArrayList<String> arregloTemporal = new ArrayList<String>();
		for (Reservas c : reser) {
			if (c.getFechaIngreso().equalsIgnoreCase(fecha1) && c.getFechaSalida().equalsIgnoreCase(fecha2)) {
				arregloTemporal.add(archivo);
			}
		}
		return arregloTemporal;
	}

	public Reservas buscarFecha(String fecha1, String fecha2) {
		for (Reservas c : reser) {
			if (c.getFechaIngreso().equalsIgnoreCase(fecha1) && c.getFechaSalida().equalsIgnoreCase(fecha2))
				return c;
		}
		return null;
	}

	public int codigoMayor(int cod) {
		int co = 100;
		for (Reservas c : reser) {
			if (c.getCodigoReserva() > cod)
				co = c.getCodigoReserva() + 1;
		}
		return co;
	}

	public void cargarReserva() {
		try {
			BufferedReader c;
			String linea, s[], fechaRegistro, fechaIngreso, fechaSalida;
			int codigoReserva, codigoCliente, codigoCajero, CodigoRecepcionista, numeroHabitacion, estado;
			Reservas nuevo;
			c = new BufferedReader(new FileReader(archivo));
			while ((linea = c.readLine()) != null) {
				s = linea.split(";");
				codigoReserva = Integer.parseInt(s[0].trim());

				codigoCliente = Integer.parseInt(s[1].trim());
				codigoCajero = Integer.parseInt(s[2].trim());
				CodigoRecepcionista = Integer.parseInt(s[3].trim());
				numeroHabitacion = Integer.parseInt(s[4].trim());
				fechaRegistro = s[5].trim();
				fechaIngreso = s[6].trim();
				fechaSalida = s[7].trim();

				estado = Integer.parseInt(s[8].trim());

				nuevo = new Reservas(codigoReserva, codigoCliente, codigoCajero, CodigoRecepcionista, numeroHabitacion,
						fechaRegistro, fechaIngreso, fechaSalida, estado);
				adicionar(nuevo);
			}
			c.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void grabarReservas() {
		try {
			PrintWriter pw;
			String linea;
			Reservas x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamano(); i++) {
				x = obtener(i);
				linea = x.getCodigoReserva() + ";" + x.getCodigoCliente() + ";" + x.getCodigoCajero() + ";"
						+ x.getCodigoRecepcionista() + ";" + x.getNumeroHabitacion() + ";" + x.getFechaRegistro() + ";"
						+ x.getFechaIngreso() + ";" + x.getFechaSalida() + ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public String getReserva() {
		return archivo;
	}

	public void eliminarTodo() {
		if (tamano() > 0)
			reser.clear();
	}

	public boolean existeReserva() {
		File f = new File(archivo);
		return f.exists();
	}
}
