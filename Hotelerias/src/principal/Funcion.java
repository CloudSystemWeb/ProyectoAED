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

import arraylist.ArregloButaca;
import arraylist.ArregloFuncion;
import clases.Cine;


public class Funcion extends JDialog implements ActionListener {
	ArregloFuncion c = new ArregloFuncion("Funcion.txt");
	int contador;
 
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTeléfono;
	private JLabel lblHora;
	private JLabel lblEstado;
	static JTextField txtCodigoFuncion;
	static JTextField txtCodigoCine;
	static JTextField txtCodigoSala;
	static JTextField txtCodigoPelicula;
	private JLabel lblOpciones;
	private JComboBox cbbOpciones;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JButton btnSalir;
	// private JLabel lblFecNac1;

	private JTextArea txtS;
	private JDesktopPane desktopPane;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JButton btnCine;
	private JButton btnSala;
	private JButton btnPelicula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcion dialog = new Funcion();
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
	public Funcion() {
		getContentPane().setForeground(new Color(106, 90, 205));
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("REGISTRO DE LA FUNCION");
		setBounds(100, 100, 651, 457);
		getContentPane().setLayout(null);

		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(new Color(0, 0, 0));
			lblCdigo.setIcon(new ImageIcon(Funcion.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(10, 11, 78, 14);
			getContentPane().add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Codigo Cine");
			lblNombre.setBackground(Color.PINK);
			lblNombre.setForeground(Color.PINK);
			lblNombre.setBounds(10, 45, 78, 14);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("Codigo Sala");
			lblApellido.setBackground(Color.PINK);
			lblApellido.setForeground(Color.PINK);
			lblApellido.setBounds(10, 84, 78, 14);
			getContentPane().add(lblApellido);
		}
		{
			lblTeléfono = new JLabel("Codigo Pel\u00EDcula");
			lblTeléfono.setForeground(Color.PINK);
			lblTeléfono.setBounds(10, 119, 97, 14);
			getContentPane().add(lblTeléfono);
		}
		{
			lblEstado = new JLabel("Fecha");
			lblEstado.setForeground(Color.PINK);
			lblEstado.setBounds(10, 148, 67, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtCodigoFuncion = new JTextField();
			txtCodigoFuncion.setBackground(Color.WHITE);
			txtCodigoFuncion.setBounds(98, 8, 86, 20);
			getContentPane().add(txtCodigoFuncion);
			txtCodigoFuncion.setColumns(10);
			txtCodigoFuncion.setText("" + c.codigoMayor(contador));
		}
		{
			txtCodigoCine = new JTextField();
			txtCodigoCine.setEditable(false);
			txtCodigoCine.setBackground(Color.WHITE);
			txtCodigoCine.addActionListener(this);
			txtCodigoCine.setBounds(117, 42, 78, 20);
			getContentPane().add(txtCodigoCine);
			txtCodigoCine.setColumns(10);
			SNumeros(txtCodigoCine);
		}
		{
			txtCodigoSala = new JTextField();
			txtCodigoSala.setEditable(false);
			txtCodigoSala.setBackground(Color.WHITE);
			txtCodigoSala.addActionListener(this);
			txtCodigoSala.setBounds(117, 81, 78, 20);
			getContentPane().add(txtCodigoSala);
			txtCodigoSala.setColumns(10);
			SNumeros(txtCodigoSala);
		}
		{
			txtCodigoPelicula = new JTextField();
			txtCodigoPelicula.setEditable(false);
			txtCodigoPelicula.setBackground(Color.WHITE);
			txtCodigoPelicula.addActionListener(this);
			txtCodigoPelicula.setBounds(117, 112, 78, 20);
			getContentPane().add(txtCodigoPelicula);
			txtCodigoPelicula.setColumns(10);
			SNumeros(txtCodigoPelicula);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setForeground(Color.PINK);
			lblOpciones.setBounds(10, 346, 75, 14);
			getContentPane().add(lblOpciones);
		}
		{
			cbbOpciones = new JComboBox();
			cbbOpciones.setBackground(new Color(169, 169, 169));
			cbbOpciones.setForeground(new Color(128, 0, 0));
			cbbOpciones.addActionListener(this);
			cbbOpciones.setModel(new DefaultComboBoxModel(
					new String[] { "Ingresar", "Consultar", "Modificar", "Eliminar", "Listar" }));
			cbbOpciones.setBounds(84, 343, 134, 22);
			getContentPane().add(cbbOpciones);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar.setBackground(new Color(169, 169, 169));
			btnProcesar.setForeground(new Color(0, 0, 205));
			btnProcesar.setIcon(new ImageIcon(Funcion.class.getResource("/imagenes/procesar.gif")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(10, 376, 122, 32);
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
			btnSalir.setIcon(new ImageIcon(Funcion.class.getResource("/imagenes/exit_button.gif")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(139, 376, 122, 32);
			getContentPane().add(btnSalir);
		}

		{
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(Color.RED);
			desktopPane.setBounds(244, 11, 17, 361);
			getContentPane().add(desktopPane);
		}
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBackground(Color.WHITE);
		txtFecha.setBounds(117, 145, 101, 20);
		getContentPane().add(txtFecha);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBackground(Color.WHITE);
		txtHora.setBounds(117, 176, 101, 20);
		getContentPane().add(txtHora);
		
		lblHora = new JLabel("Hora");
		lblHora.setForeground(Color.PINK);
		lblHora.setBounds(10, 179, 67, 14);
		getContentPane().add(lblHora);
		{
			btnCine = new JButton("");
			btnCine.addActionListener(this);
			btnCine.setIcon(new ImageIcon(Funcion.class.getResource("/imagenes/lupa.png")));
			btnCine.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CodigoCine2  cine =new CodigoCine2();
					cine.setVisible(true);
				}
			});
			btnCine.setBounds(191, 41, 51, 22);
			getContentPane().add(btnCine);
		}
		{
			btnSala = new JButton("");
			btnSala.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CodigoSala2 cine = new CodigoSala2();
					cine.setVisible(true);
				}
			});
			btnSala.setIcon(new ImageIcon(Funcion.class.getResource("/imagenes/lupa.png")));
			btnCine.addActionListener(this);
			btnSala.setBounds(191, 80, 51, 22);
			getContentPane().add(btnSala);
		}
		{
			btnPelicula = new JButton("");
			btnPelicula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CodigoPelicula cine = new CodigoPelicula();
					cine.setVisible(true);
				}
			});
			btnPelicula.setIcon(new ImageIcon(Funcion.class.getResource("/imagenes/lupa.png")));
			btnPelicula.setBounds(191, 111, 51, 22);
			btnCine.addActionListener(this);
			getContentPane().add(btnPelicula);
		}
		codigo();
		listar();
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == this.btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.cbbOpciones) {
			do_cbbOpciones_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		
		/*if (arg0.getSource() == this.btnSala) {
			do_btnSala_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.btnPelicula) {
			do_btnPelicula_actionPerformed(arg0);
		}*/
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

	void ingresar() {
		if (String.valueOf(leerCod()).equals("") && String.valueOf(leerCodigoCine()).equals("")
				&& String.valueOf(leerCodigoSala()).equals("") 
				&& String.valueOf(leerCodigoPelicula()).equals("")
				&& leerFecha().equals("") && leerHora().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtCodigoCine.requestFocus();
		} else {
			clases.Funcion clien = c.buscar(leerCod());
			if (clien == null) {
				//int codButaca, int codSala, int numeroFilas, int numeroColumna, int estadoButaca)
				clien = new clases.Funcion(leerCod(), leerCodigoCine(), leerCodigoSala(), leerCodigoPelicula(),
						leerFecha(),leerHora());
				c.adicionar(clien);
				listar();
				txtCodigoFuncion.setText("" + c.codigoMayor(contador));

				// mensaje de confirmación
				JOptionPane.showMessageDialog(this, "Funcion Ingresado", "ALERTA", JOptionPane.WARNING_MESSAGE);

			} else
				mensaje("Código  ya existe");
		}
	}

	public void actulizaciones() {

		if (c.existebutacate()) {
			int ok = 0;
			if (ok == 0) {
				c.grabarbutacates();
			} else
				c.getfuncion();
		} else {
			c.grabarbutacates();
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
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS FUNCION " + "\n");
				imprimir(
						"Código \t Cine \t Sala \t Pelícuala \t Fecha \t Hora");
				imprimir("");
				for (int i = 0; i < c.tamaño(); i++) {
					clases.Funcion clien = c.obtener(i);
					imprimir(clien.getCodFuncion() + "\t" + clien.getCodCine() + "\t"
							+ clien.getCodSala() + "\t" + clien.getCodPelicula() + "\t\t"
							+ clien.getFecha() + "\t\t" + clien.getHora()) ;
				imprimir("");
				if(c.tamaño()-1 == i){
					imprimir("Total de Función : " + c.tamaño());	
				}
				}
			} else
				imprimir("No hay Función.......");
		} catch (Exception e) {
			mensaje("Ingrese Datos");
		}
	}

	void consultar() {
		clases.Funcion clien = c.buscar(leerCod());
		if (clien != null) {
			imprimir();
			imprimir(" \t REGISTRO DE DATOS" + "\n");
			imprimir(" a) Código          : " + clien.getCodFuncion());
			imprimir(" b) Cisne      : " + clien.getCodCine());
			imprimir(" c) Sala  : " + clien.getCodSala());
			imprimir(" d) Película   : " + clien.getCodPelicula());
			imprimir(" e) Fecha    : " + clien.getFecha());
			imprimir(" e) Hora    : " + clien.getHora());
		
			

		} else
			JOptionPane.showMessageDialog(null, "Función no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	void modificar() {
		if (String.valueOf(leerCod()).equals("") && String.valueOf(leerCodigoCine()).equals("")
				&& String.valueOf(leerCodigoSala()).equals("") 
				&& String.valueOf(leerCodigoPelicula()).equals("")
				&& leerFecha().equals("") && leerHora().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtCodigoCine.requestFocus();
		} else {
			clases.Funcion clien = c.buscar(leerCod());
			if (clien != null) {
				clien.setCodFuncion(leerCod());
				clien.setCodCine(leerCodigoCine());
				clien.setCodSala(leerCodigoSala());
				clien.setCodPelicula(leerCodigoPelicula());
				clien.setFecha(leerFecha());
				clien.setHora(leerHora());
				
				listar();
				// mensaje que muestre que el cliente ha sido modificado
				JOptionPane.showMessageDialog(null, "Función Modificado", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Función no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
	}

	void eliminar() {
		clases.Funcion clien = c.buscar(leerCod());
		if (clien != null) {
			c.eliminar(clien);
			listar();
			// mensaje que muestre que el cliente ha sido eliminado
			JOptionPane.showMessageDialog(null, "Función Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Función no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

	}

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

	public int leerCodigoCine() {
		return Integer.parseInt(txtCodigoCine.getText().toString());
	}
	
	public int leerCodigoSala() {
		return Integer.parseInt(txtCodigoSala.getText().toString());
	}

	public int leerCodigoPelicula() {
		return Integer.parseInt(txtCodigoPelicula.getText().toString());
	}

	public String leerFecha() {
		return txtFecha.getText().toString();
	}
	public String leerHora() {
		return txtHora.getText().toString();
	}

	public int leerCod() {
		return Integer.parseInt(txtCodigoFuncion.getText());
	}

	public void limpiar() {
		txtCodigoSala.setText("");
		txtCodigoCine.setText("");
		txtCodigoPelicula.setText("");
		txtFecha.setText("");
		txtHora.setText("");
		txtCodigoCine.requestFocus();
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
			lblNombre.setVisible(true);
			lblApellido.setVisible(true);
			lblTeléfono.setVisible(true);
			lblEstado.setVisible(true);
			txtCodigoCine.setVisible(true);
			txtCodigoSala.setVisible(true);
			lblCdigo.setVisible(true);
			txtCodigoPelicula.setVisible(true);
			txtCodigoFuncion.setVisible(true);
			lblEstado.setVisible(true);
			lblHora.setVisible(true);
			txtFecha.setVisible(true);
			txtHora.setVisible(true);
			btnCine.setVisible(true);
			btnSala.setVisible(true);
			btnPelicula.setVisible(true);
		

		} else if (opcion == 1 || opcion == 3) {
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtCodigoCine.setVisible(false);
			txtCodigoSala.setVisible(false);
			txtCodigoPelicula.setVisible(false);
			txtCodigoFuncion.setVisible(true);
			lblCdigo.setVisible(true);
	
			lblEstado.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtFecha.setVisible(false);
			txtHora.setVisible(false);
			lblHora.setVisible(false);
			btnCine.setVisible(false);
			btnSala.setVisible(false);
			btnPelicula.setVisible(false);
		

		} else {
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtCodigoCine.setVisible(false);
			txtCodigoSala.setVisible(false);
			txtCodigoPelicula.setVisible(false);
			txtCodigoFuncion.setVisible(false);
			lblCdigo.setVisible(false);
			
			lblEstado.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			btnCine.setVisible(false);
			btnSala.setVisible(false);
			btnPelicula.setVisible(false);

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
			txtCodigoFuncion.setEditable(false);
		} else if (cbbOpciones.getSelectedIndex() == 1) {
			txtCodigoFuncion.setEditable(true);
		} else if (cbbOpciones.getSelectedIndex() == 2) {
			txtCodigoFuncion.setEditable(true);
		} else if (cbbOpciones.getSelectedIndex() == 3) {
			txtCodigoFuncion.setEditable(true);
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
