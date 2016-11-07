package principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import arraylist.ArregloPelicula;
import clases.Cliente;
import clases.Pelicula;

public class Peliculas extends JDialog implements ActionListener {

	ArregloPelicula c = new ArregloPelicula("Pelicula.txt");
	int contador;

	private JLabel lblCdigo;
	private JLabel lblDis;
	private JLabel lblApellido;
	private JLabel lblTeléfono;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDirec;
	private JComboBox cbbEstado;
	private JLabel lblOpciones;
	private JComboBox cbbOpciones;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JButton btnSalir;
	// private JLabel lblFecNac1;

	private JTextArea txtS;
	private JDesktopPane desktopPane;
	private JTextField txtNac;
	private JTextField txtTelefono;
	private JTextField txtDNI;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblNaci;
	private JLabel lblafili;
	private JTextField txtafili;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JComboBox cboCensura;
	private JComboBox cboCartelera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Peliculas dialog = new Peliculas();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Peliculas() {
		getContentPane().setForeground(new Color(106, 90, 205));
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("REGISTRO DE LOS CLIENTES CLIENTES");
		setBounds(100, 100, 651, 516);
		getContentPane().setLayout(null);

		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(new Color(0, 0, 0));
			lblCdigo.setIcon(new ImageIcon(Peliculas.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(10, 11, 78, 14);
			getContentPane().add(lblCdigo);
		}
		{
			lblDis = new JLabel("TituloDis");
			lblDis.setBackground(Color.PINK);
			lblDis.setForeground(Color.PINK);
			lblDis.setBounds(10, 45, 46, 14);
			getContentPane().add(lblDis);
		}
		{
			lblApellido = new JLabel("TituloOri");
			lblApellido.setBackground(Color.PINK);
			lblApellido.setForeground(Color.PINK);
			lblApellido.setBounds(10, 84, 46, 14);
			getContentPane().add(lblApellido);
		}
		{
			lblTeléfono = new JLabel("FechaE");
			lblTeléfono.setForeground(Color.PINK);
			lblTeléfono.setBounds(10, 115, 67, 14);
			getContentPane().add(lblTeléfono);
		}
		{
			lblEstado = new JLabel("T_proyec");
			lblEstado.setForeground(Color.PINK);
			lblEstado.setBounds(10, 205, 67, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBackground(Color.WHITE);
			txtCodigo.setBounds(98, 8, 86, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setText("" + c.codigoMayor(contador));
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBackground(Color.WHITE);
			txtNombre.addActionListener(this);
			txtNombre.setBounds(62, 42, 156, 20);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
			SLetras(txtNombre);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBackground(Color.WHITE);
			txtApellido.addActionListener(this);
			txtApellido.setBounds(62, 81, 156, 20);
			getContentPane().add(txtApellido);
			txtApellido.setColumns(10);
			SLetras(txtApellido);
		}
		{
			txtDirec = new JTextField();
			txtDirec.setBackground(Color.WHITE);
			txtDirec.addActionListener(this);
			txtDirec.setBounds(62, 112, 156, 20);
			getContentPane().add(txtDirec);
			txtDirec.setColumns(10);
			SNumeros(txtDirec);
		}
		{
			cbbEstado = new JComboBox();
			cbbEstado.setForeground(Color.RED);
			cbbEstado.setModel(new DefaultComboBoxModel(new String[] {"Estreno", "Fuera Estreno"}));
			cbbEstado.setBounds(84, 201, 134, 22);
			getContentPane().add(cbbEstado);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setForeground(Color.PINK);
			lblOpciones.setBounds(10, 405, 75, 14);
			getContentPane().add(lblOpciones);
		}
		{
			cbbOpciones = new JComboBox();
			cbbOpciones.setBackground(new Color(169, 169, 169));
			cbbOpciones.setForeground(Color.RED);
			cbbOpciones.addActionListener(this);
			cbbOpciones.setModel(new DefaultComboBoxModel(
					new String[] { "Ingresar", "Consultar", "Modificar", "Eliminar", "Listar" }));
			cbbOpciones.setBounds(84, 401, 134, 22);
			getContentPane().add(cbbOpciones);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar.setBackground(new Color(169, 169, 169));
			btnProcesar.setForeground(new Color(0, 0, 205));
			btnProcesar.setIcon(new ImageIcon(Peliculas.class.getResource("/imagenes/procesar.gif")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(10, 434, 122, 32);
			getContentPane().add(btnProcesar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(271, 11, 354, 327);
			getContentPane().add(scrollPane);
			{
				txtS = new JTextArea();
				txtS.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
				txtS.setBackground(new Color(253, 245, 230));
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnSalir = new JButton("");
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSalir.setBackground(new Color(169, 169, 169));
			btnSalir.setForeground(new Color(0, 0, 205));
			btnSalir.setIcon(new ImageIcon(Peliculas.class.getResource("/imagenes/exit_button.gif")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(139, 434, 122, 32);
			getContentPane().add(btnSalir);
		}

		{
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(Color.RED);
			desktopPane.setBounds(228, 11, 17, 408);
			getContentPane().add(desktopPane);
		}

		txtNac = new JTextField();
		txtNac.setColumns(10);
		txtNac.setBackground(Color.WHITE);
		txtNac.setBounds(62, 144, 156, 20);
		getContentPane().add(txtNac);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(62, 230, 156, 20);
		getContentPane().add(txtTelefono);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);
		txtDNI.setBounds(62, 258, 156, 20);
		getContentPane().add(txtDNI);
		{
			lblUsuario = new JLabel("Recaud.");
			lblUsuario.setForeground(Color.PINK);
			lblUsuario.setBounds(10, 289, 67, 14);
			getContentPane().add(lblUsuario);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setColumns(10);
			txtUsuario.setBackground(Color.WHITE);
			txtUsuario.setBounds(62, 286, 156, 20);
			getContentPane().add(txtUsuario);
		}
		{
			lblNaci = new JLabel("Genero");
			lblNaci.setForeground(Color.PINK);
			lblNaci.setBounds(0, 147, 46, 14);
			getContentPane().add(lblNaci);
		}
		{
			lblafili = new JLabel("PaisOri");
			lblafili.setForeground(Color.PINK);
			lblafili.setBounds(10, 180, 46, 14);
			getContentPane().add(lblafili);
		}

		txtafili = new JTextField();
		txtafili.setBackground(Color.WHITE);
		txtafili.setBounds(62, 175, 156, 20);
		getContentPane().add(txtafili);
		txtafili.setColumns(10);
		{
			lblDni = new JLabel("Duracion");
			lblDni.setForeground(Color.PINK);
			lblDni.setBounds(6, 261, 46, 14);
			getContentPane().add(lblDni);
		}
		{
			lblTelefono = new JLabel("Sinopsis");
			lblTelefono.setForeground(Color.PINK);
			lblTelefono.setBounds(10, 230, 46, 14);
			getContentPane().add(lblTelefono);
		}
		
		JLabel lblTipoDeCencura = new JLabel("Tipo de Cencura");
		lblTipoDeCencura.setForeground(Color.PINK);
		lblTipoDeCencura.setBounds(10, 342, 78, 14);
		getContentPane().add(lblTipoDeCencura);
		
		JLabel lblEstadoDePro = new JLabel("Estado de Pro.");
		lblEstadoDePro.setForeground(Color.PINK);
		lblEstadoDePro.setBounds(10, 373, 95, 14);
		getContentPane().add(lblEstadoDePro);
		{
			cboCensura = new JComboBox();
			cboCensura.setModel(new DefaultComboBoxModel(new String[] {"AptaTodos", "Mayores14", "Mayores18"}));
			cboCensura.setForeground(Color.RED);
			cboCensura.setBounds(115, 338, 103, 22);
			getContentPane().add(cboCensura);
		}
		{
			cboCartelera = new JComboBox();
			cboCartelera.setModel(new DefaultComboBoxModel(new String[] {"En cartelera", "Fuera Cartelera"}));
			cboCartelera.setForeground(Color.RED);
			cboCartelera.setBounds(98, 369, 107, 22);
			getContentPane().add(cboCartelera);
		}
		codigo();
		listar();
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == this.btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.cbbEstado) {
			do_cbbEstado_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.cbbOpciones) {
			do_cbbOpciones_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		limpiar();
	}

	protected void do_btnProcesar_actionPerformed(ActionEvent arg0) {
		procesar();
	}

	void procesar() {
		switch (cbbOpciones.getSelectedIndex()) {

		case 0:
			ingresar();
			actulizaciones();
			break;
		case 1:
			consultar();
			break;
		case 2:
			modificar();
			break;
		case 3:
			eliminar();
			actulizaciones();
			break;
		default:
			listar();
			break;
		}
	}
	
	void eliminar() {
		Pelicula clien = c.buscar(leerCod());
		if (clien != null) {
			c.eliminar(clien);
			listar();
			// mensaje que muestre que el cliente ha sido eliminado
			JOptionPane.showMessageDialog(null, "Película Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Película no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

	}

	void ingresar() {
		if (leerNombre().equals("") || leerApellido().equals("") || leerTelefo().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Pelicula clien = c.buscar(leerCod());
			if (clien == null) {
				clien = new Pelicula(leerCod(), leerNombre(), leerApellido(), leerDireccion(), leerFecNac(),
						leerFecAfil(), leerTelefo(), leerDNI(), leerUsuario(), leerECensura(),leerEstadoProyec(), leerEstreno());
				c.adicionar(clien);

				listar();
				txtCodigo.setText("" + c.codigoMayor(contador));

				// mensaje de confirmación
				JOptionPane.showMessageDialog(this, "Película Ingresado", "ALERTA", JOptionPane.WARNING_MESSAGE);

			} else
				mensaje("Código  ya existe");
		}
	}

	public void actulizaciones() {

		if (c.existePelicula()) {
			int ok = 0;
			if (ok == 0) {
				c.grabarClientes();
			} else
				c.getCliente();
		} else {
			c.grabarClientes();
		}
	}

	/*
	 * mensajesss
	 */
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void listar() {
		try {
			imprimir();
			if (c.tamaño() > 0) {
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS Película " + "\n");
				imprimir(
						"Código \t Nombres \t Apellidos \t Direccion \t Fecha Nac \t Fecha Afil \t Estado Civil \tTeléfono \t DNI \t Usuario \t Contraseña");
				imprimir("");
				for (int i = 0; i < c.tamaño(); i++) {
					Pelicula clien = c.obtener(i);
					imprimir(clien.getCodPelicula() + "\t" + rellena(clien.getTituloDistri()) + "\t"
							+ clien.getTituloOri() + "\t" + clien.getFechEstreno() + "\t"
							+ clien.getGenero() + "\t" + clien.getPaisOri() + "\t"
							+ clien.getPaisOri() + "\t" + clien.getSinopsis() + "\t" + clien.getDuracion() + "\t"
							+ clien.getTipoCensura() + "\t" + clien.getEstadoProyec());
				}
				imprimir("");
				imprimir("Total de Clientes : " + c.tamaño());
			} else
				imprimir("No hay Clientes.......");
		} catch (Exception e) {
			mensaje("Ingrese Datos");
		}
	}

	void consultar() {
		Pelicula clien = c.buscar(leerCod());
		if (clien != null) {
			imprimir();
			imprimir(" \t REGISTRO DE DATOS" + "\n");
			imprimir(" a) Código          : " + clien.getCodPelicula());
			imprimir(" b) Titulo de distribuiciom     : " + clien.getTituloDistri());
			imprimir(" c) Titulo original : " + clien.getTituloOri());
			imprimir(" d) Fecha Edtreno  : " + clien.getFechEstreno());
			imprimir(" e) Tipo de proyeccion   : " + clien.getTipoProye());
			imprimir(" f) Genero  : " + clien.getGenero());
			imprimir(" g) Pais       : " + clien.getPaisOri());
			imprimir(" h) Duracion  : " + clien.getDuracion());
			imprimir(" i) Censura  : " + clien.getTipoCensura());
			imprimir(" j) Estado proyecto  : " + clien.getEstadoProyec());
			

		} else
			JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	void modificar() {
		if (leerNombre().equals("") || leerApellido().equals("") || leerTelefo().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Pelicula clien = c.buscar(leerCod());
			if (clien != null) {
				clien.setTituloDistri(leerNombre());
				clien.setTituloOri(leerApellido());
				clien.setFechEstreno(leerDireccion());
				clien.setGenero(leerFecNac());
				clien.setPaisOri(leerFecNac());
				clien.setSinopsis(leerTelefo());
				clien.setDuracion(leerDNI());
				clien.setRecaudacion(leerUsuario());
				clien.setTipoCensura(leerEstadoProyec());
		

				listar();
				// mensaje que muestre que el cliente ha sido modificado
				JOptionPane.showMessageDialog(null, "Cliente Modificado", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
	}
/*
	void eliminar() {
		Cliente clien = c.buscar(leerCod());
		if (clien != null) {
			c.eliminar(clien);
			listar();
			// mensaje que muestre que el cliente ha sido eliminado
			JOptionPane.showMessageDialog(null, "Cliente Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

	}*/

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void imprimir() {
		txtS.setText("");
	}

	String rellena(String cad) {
		int longitud = cad.length();
		for (int i = longitud; i < 15; i++)
			cad += " ";
		return cad;
	}

	public String leerNombre() {
		return (txtNombre.getText().toString());
	}

	public String leerApellido() {
		return (txtApellido.getText().toString());
	}

	public String leerDireccion() {
		return (txtDirec.getText().toString());
	}

	public int leerEstreno() {
		return cbbEstado.getSelectedIndex();
	}
	
	public int leerECensura() {
		return cboCensura.getSelectedIndex();
	}
	public int leerEstadoProyec() {
		return cboCartelera.getSelectedIndex();
	}
	
	public String leerFecNac() {
		return (txtNac.getText().toString());
	}

	public String leerFecAfil() {
		return (txtafili.getText().toString());
	}

	public String leerDNI() {
		return (txtDNI.getText().toString());
	}

	public String leerUsuario() {
		return (txtUsuario.getText().toString());
	}



	public String leerTelefo() {
		String tele = null;
		try {
			tele = txtTelefono.getText().toString();
		} catch (Exception e) {
			tele = "-1";
		}
		return tele;
	}

	public int leerCod() {
		return Integer.parseInt(txtCodigo.getText());
	}

	public void limpiar() {
		txtApellido.setText("");
		txtNombre.setText("");
		txtDirec.setText("");
		txtNombre.requestFocus();
	}

	protected void do_cbbOpciones_actionPerformed(ActionEvent arg0) {
		codigo();
		seleccionar();

	}

	protected void do_cbbEstado_actionPerformed(ActionEvent arg0) {
		codigo();
		seleccionar();

	}

	void seleccionar() {
		int opcion = cbbOpciones.getSelectedIndex();
		if (opcion == 0 || opcion == 2) {
			lblDis.setVisible(true);
			lblApellido.setVisible(true);
			lblTeléfono.setVisible(true);
			lblEstado.setVisible(true);
			txtNombre.setVisible(true);
			txtApellido.setVisible(true);
			cbbEstado.setVisible(true);
			lblCdigo.setVisible(true);
			txtDirec.setVisible(true);
			txtCodigo.setVisible(true);
			txtDNI.setVisible(true);
			txtTelefono.setVisible(true);
			txtNac.setVisible(true);
			txtUsuario.setVisible(true);
			
			lblUsuario.setVisible(true);
			lblEstado.setVisible(true);
		
			lblUsuario.setVisible(true);
			lblNaci.setVisible(true);
			lblafili.setVisible(true);
			txtafili.setVisible(true);
			lblDni.setVisible(true);
			lblTelefono.setVisible(true);

		} else if (opcion == 1 || opcion == 3) {
			lblDis.setVisible(false);
			lblApellido.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtNombre.setVisible(false);
			txtApellido.setVisible(false);
			cbbEstado.setVisible(false);
			txtDirec.setVisible(false);
			txtCodigo.setVisible(true);
			lblCdigo.setVisible(true);
			txtDNI.setVisible(false);
			txtTelefono.setVisible(false);
			txtNac.setVisible(false);
			txtUsuario.setVisible(false);
		
			lblUsuario.setVisible(false);
			
			lblEstado.setVisible(false);
			txtNac.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);

			lblNaci.setVisible(false);
			lblafili.setVisible(false);
			txtafili.setVisible(false);
			lblDni.setVisible(false);
			lblTelefono.setVisible(false);

		} else {
			lblDis.setVisible(false);
			lblApellido.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtNombre.setVisible(false);
			txtApellido.setVisible(false);
			cbbEstado.setVisible(false);
			txtDirec.setVisible(false);
			txtCodigo.setVisible(false);
			lblCdigo.setVisible(false);
			txtDNI.setVisible(false);
			txtTelefono.setVisible(false);
			txtNac.setVisible(false);
			txtUsuario.setVisible(false);
			
			lblUsuario.setVisible(false);
			
			lblEstado.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);

			lblNaci.setVisible(false);
			lblafili.setVisible(false);
			txtafili.setVisible(false);
			lblDni.setVisible(false);
			lblTelefono.setVisible(false);

		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		int dato = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea Salir", "ALERTA",
				JOptionPane.INFORMATION_MESSAGE);
		if (dato == 0) {
			this.dispose();
		}
	}

	void codigo() {
		if (cbbOpciones.getSelectedIndex() == 0) {
			txtCodigo.setEditable(false);
			cbbEstado.setEnabled(true);
			cbbEstado.setSelectedIndex(0);
		} else if (cbbOpciones.getSelectedIndex() == 1) {
			txtCodigo.setEditable(true);
			cbbEstado.setEnabled(true);
		} else if (cbbOpciones.getSelectedIndex() == 2) {
			txtCodigo.setEditable(true);
			cbbEstado.setEnabled(true);
		} else if (cbbOpciones.getSelectedIndex() == 3) {
			txtCodigo.setEditable(true);
			cbbEstado.setEnabled(true);
		}
	}

	public void SNumeros(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					e.consume();
					getToolkit().beep();
					mensaje("Solo Ingrese Números");
				}
			}
		});
	}

	public void SLetras(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
					mensaje("Solo Ingrese Letras");
				}
			}
		});
	}
}
