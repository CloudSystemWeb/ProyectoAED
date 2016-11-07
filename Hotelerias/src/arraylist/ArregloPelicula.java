package arraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Pelicula;

public class ArregloPelicula {
	ArrayList<Pelicula>clien;
	private String   Pelicula;	
	
	
	public ArregloPelicula(String Pelicula){
		clien = new ArrayList<Pelicula>();
		this.Pelicula = Pelicula;
		cargarPelicula();
	}
	public void adicionar(Pelicula c){
		clien.add(c);
	}
	public void eliminar(Pelicula c){
		clien.remove(c);
	}
	public Pelicula obtener(int pos){
		return clien.get(pos);
	}

	public Pelicula buscar(int codigo){
		for(Pelicula c:clien)
			if(c.getCodPelicula()==codigo)
				return c;
		return null;
	}

	public int tamaño(){
		return clien.size();
	}
	
	public int codigoMayor(int cod){
		int co=100001;
		for (Pelicula c: clien){
			if (c.getCodPelicula()>cod)
				co=c.getCodPelicula()+1;
		}
		return co;
	}
	
	//-------------------------------------
	public Pelicula buscarNombres(String nombre){
		for(Pelicula c:clien)
			if(c.getTituloOri().equalsIgnoreCase(nombre))
				return c;
		return null;
	}
	//----------------------------------------

	
	public boolean existePelicula() {
		File  f = new File(Pelicula);
		return f.exists();
	}
	
	
	public void cargarPelicula() {
			try {
				BufferedReader  c;
				String          linea, s[], tituloDistri,tituloOri,fechEstreno,genero,paisOri,duracion,recaudacion,sinopsis;
				int             codigo,estadoProyec,tipoCensura,tipoProye;
				Pelicula         nuevo;
				c = new BufferedReader(new FileReader(Pelicula));
				while ((linea = c.readLine()) != null) {
					s = linea.split(";");
					codigo = Integer.parseInt(s[0].trim());
					tituloDistri = s[1].trim();
					tituloOri = s[2].trim();
					fechEstreno = s[3].trim();
					genero = s[4].trim();
					paisOri = s[5].trim();
					sinopsis = s[6].trim();
					duracion = s[7].trim();
					recaudacion = s[8].trim();
					tipoProye = Integer.parseInt(s[9].trim());
					estadoProyec = Integer.parseInt(s[10].trim());
					tipoCensura = Integer.parseInt(s[10].trim());
					
					
					nuevo = new Pelicula(codigo,tituloDistri,tituloOri,fechEstreno,genero,paisOri,sinopsis, duracion,recaudacion,tipoProye,estadoProyec ,tipoCensura );
					adicionar(nuevo);
				}
				c.close();
			}
			catch(Exception e) {
			}
		}
	
	public void grabarClientes() {
		try {
			PrintWriter  pw;
			String       linea;
			Pelicula       x;
			pw = new PrintWriter(new FileWriter(Pelicula));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodPelicula() + ";" +
				        x.getTituloDistri() + ";" +
				        x.getTituloOri() + ";" +
				        x.getFechEstreno() + ";" +
				        x.getTipoProye() + ";" +
				        x.getGenero() + ";" +
				        x.getPaisOri() + ";" +
				        x.getSinopsis() + ";" +
				        x.getDuracion() + ";" +
				        x.getTipoCensura() + ";" +
				        x.getEstadoProyec()+";"+
				        x.getRecaudacion();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e) {
		}
	}
	
	public String getCliente() {
	return Pelicula; 
	}
	
	public void eliminarTodo() {
		if (tamaño() > 0)
	    	clien.clear();
	}
	
	}


