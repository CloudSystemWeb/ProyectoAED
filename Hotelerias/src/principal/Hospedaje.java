package principal;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;

import clases.Cliente;
import clases.Habitacion;
import clases.Hospedajes;
import arraylist.ArregloCliente;
import arraylist.ArregloHabitacion;
import arraylist.ArregloHospadaje;

public class Hospedaje extends JFrame implements ActionListener {

	ArregloHospadaje o = new ArregloHospadaje("Hospedaje.txt");

	private JLabel lblCdigoHospedaje;
	private JLabel lblCdigoReserva;
	private JLabel lblCdigoCliente;
	private JLabel lblCdigoHabitacin;
	private JLabel lblCdigoRecepcionista;
	private JLabel lblTipoHospedaje;
	private JLabel lblFechaRegistro;
	private JLabel lblEstado;
	private JTextField txtCodigoHos;
	static JTextField txtCodigoReserva;
	static JTextField txtCodigoCliente;
	static JTextField txtCodigoHabi;
	static JTextField txtCodigoRecep;
	private JComboBox cboTipo;
	private JComboBox cboEstado;
	private JLabel lblOpciones;
	private JComboBox cboOpciones;
	private JButton button;
	private JButton btnProcesar;
	private JButton btnSalir;
	private JButton btnProcesar_1;
	private JTextField txtFechaRegistro;
	private JTextArea txtS;
	private JTable tableHabitacion;
	private JScrollPane scrollPane;
	private JTable tablaRecepcionista;
	int posicion;
	int posicionDos;
	int contador;
	String fecha;
	public DefaultTableModel dtm;
	String cabecera[] = { "Código", "Nombres" };
	private JMenu mnNewMenu;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel lblCosto;
	private JTextField txtCosto;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospedaje frame = new Hospedaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Hospedaje() {
		setTitle("HOSPEDAJES");
		setBounds(100, 100, 785, 438);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		{
			lblCdigoHospedaje = new JLabel("C\u00F3digo Hospedaje");
			lblCdigoHospedaje.setForeground(new Color(255, 255, 255));
			lblCdigoHospedaje.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/icono139.gif")));
			lblCdigoHospedaje.setBounds(0, 38, 143, 14);
			getContentPane().add(lblCdigoHospedaje);
		}
		{
			lblCdigoReserva = new JLabel("C\u00F3digo Reserva");
			lblCdigoReserva.setForeground(new Color(255, 255, 255));
			lblCdigoReserva.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/password.png")));
			lblCdigoReserva.setBounds(10, 74, 133, 14);
			getContentPane().add(lblCdigoReserva);
		}
		{
			lblCdigoCliente = new JLabel("C\u00F3digo Cliente");
			lblCdigoCliente.setForeground(new Color(255, 255, 255));
			lblCdigoCliente.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/password.png")));
			lblCdigoCliente.setBounds(10, 115, 116, 14);
			getContentPane().add(lblCdigoCliente);
		}
		{
			lblCdigoHabitacin = new JLabel("C\u00F3digo Habitaci\u00F3n");
			lblCdigoHabitacin.setForeground(new Color(255, 255, 255));
			lblCdigoHabitacin.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/password.png")));
			lblCdigoHabitacin.setBounds(10, 157, 133, 14);
			getContentPane().add(lblCdigoHabitacin);
		}
		{
			lblCdigoRecepcionista = new JLabel("C\u00F3digo Recepcionista");
			lblCdigoRecepcionista.setForeground(new Color(255, 255, 255));
			lblCdigoRecepcionista.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/password.png")));
			lblCdigoRecepcionista.setBounds(276, 35, 144, 14);
			getContentPane().add(lblCdigoRecepcionista);
		}
		{
			lblTipoHospedaje = new JLabel("Tipo Hospedaje");
			lblTipoHospedaje.setForeground(new Color(255, 255, 255));
			lblTipoHospedaje.setBounds(298, 71, 110, 14);
			getContentPane().add(lblTipoHospedaje);
		}
		{
			lblFechaRegistro = new JLabel("Fecha Registro");
			lblFechaRegistro.setForeground(new Color(255, 255, 255));
			lblFechaRegistro.setBounds(301, 112, 107, 14);
			getContentPane().add(lblFechaRegistro);
		}
		{
			lblEstado = new JLabel("Estado Hospedaje");
			lblEstado.setForeground(new Color(255, 255, 255));
			lblEstado.setBounds(298, 154, 116, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtCodigoHos = new JTextField();
			txtCodigoHos.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtCodigoHos.setBounds(153, 35, 86, 20);
			getContentPane().add(txtCodigoHos);
			txtCodigoHos.setColumns(10);
			txtCodigoHos.setText("" + o.codigoMayor(contador));
			SNumeros(txtCodigoHos);
		}
		{
			txtCodigoReserva = new JTextField();
			txtCodigoReserva.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtCodigoReserva.setBounds(153, 71, 86, 20);
			getContentPane().add(txtCodigoReserva);
			txtCodigoReserva.setColumns(10);
			SNumeros(txtCodigoReserva);
		}
		{
			txtCodigoCliente = new JTextField();
			txtCodigoCliente.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtCodigoCliente.setBounds(153, 112, 86, 20);
			getContentPane().add(txtCodigoCliente);
			txtCodigoCliente.setColumns(10);
			SNumeros(txtCodigoCliente);
		}
		{
			txtCodigoHabi = new JTextField();
			txtCodigoHabi.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtCodigoHabi.setBounds(153, 154, 86, 20);
			getContentPane().add(txtCodigoHabi);
			txtCodigoHabi.setColumns(10);
			SNumeros(txtCodigoHabi);
		}
		{
			txtCodigoRecep = new JTextField();
			txtCodigoRecep.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtCodigoRecep.setBounds(425, 32, 108, 20);
			getContentPane().add(txtCodigoRecep);
			txtCodigoRecep.setColumns(10);
			SNumeros(txtCodigoRecep);
		}
		{
			cboTipo = new JComboBox();
			cboTipo.addActionListener(this);
			cboTipo.setModel(new DefaultComboBoxModel(new String[] {
					"Con Reserva", "Sin Reserva" }));
			cboTipo.setBounds(417, 68, 116, 20);
			getContentPane().add(cboTipo);
		}
		{
			cboEstado = new JComboBox();
			cboEstado.setModel(new DefaultComboBoxModel(new String[] {
					"Atendida", "Anulada" }));
			cboEstado.setBounds(421, 151, 112, 20);
			getContentPane().add(cboEstado);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setForeground(new Color(255, 255, 255));
			lblOpciones.setBounds(550, 157, 67, 14);
			getContentPane().add(lblOpciones);
		}
		{
			cboOpciones = new JComboBox();
			cboOpciones.addActionListener(this);
			cboOpciones.setModel(new DefaultComboBoxModel(new String[] {
					"Ingreso", "Listado" }));
			cboOpciones.setBounds(647, 151, 110, 23);
			getContentPane().add(cboOpciones);
		}
		{
			button = new JButton("");
			button.addActionListener(this);
			button.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/icono_buscar.gif")));
			button.setBounds(238, 70, 46, 22);
			getContentPane().add(button);
		}
		{
			btnSalir = new JButton("");
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSalir.setForeground(new Color(0, 0, 205));
			btnSalir.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/exit_button.gif")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(645, 108, 112, 32);
			getContentPane().add(btnSalir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 192, 749, 187);
			getContentPane().add(scrollPane);
			{
				txtS = new JTextArea();
				txtS.setBackground(new Color(230, 230, 250));
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnProcesar_1 = new JButton("Procesar");
			btnProcesar_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar_1.setForeground(new Color(0, 0, 205));
			btnProcesar_1.addActionListener(this);
			btnProcesar_1.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/procesar.gif")));
			btnProcesar_1.setBounds(629, 63, 128, 32);
			getContentPane().add(btnProcesar_1);
		}
		{
			txtFechaRegistro = new JTextField();
			txtFechaRegistro.setEditable(false);
			txtFechaRegistro.setBounds(418, 109, 115, 20);
			getContentPane().add(txtFechaRegistro);
			txtFechaRegistro.setColumns(10);
			txtFechaRegistro.setText("" + fechaactual());
		}
		{
			mnNewMenu = new JMenu(
					"Bienvenidos Al centro de Reservas de Hospedajes");
			mnNewMenu.setBackground(new Color(60, 179, 113));
			mnNewMenu.setForeground(new Color(205, 133, 63));
			mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnNewMenu.setBounds(0, 2, 420, 22);
			getContentPane().add(mnNewMenu);
		}
		{
			button_1 = new JButton("");
			button_1.addActionListener(this);
			button_1.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/icono_buscar.gif")));
			button_1.setBounds(238, 111, 46, 22);
			getContentPane().add(button_1);
		}
		{
			button_2 = new JButton("");
			button_2.addActionListener(this);
			button_2.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/icono_buscar.gif")));
			button_2.setBounds(238, 152, 46, 22);
			getContentPane().add(button_2);
		}
		{
			button_3 = new JButton("");
			button_3.addActionListener(this);
			button_3.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/icono_buscar.gif")));
			button_3.setBounds(533, 31, 46, 22);
			getContentPane().add(button_3);
		}
		{
			lblCosto = new JLabel("Costo");
			lblCosto.setForeground(Color.WHITE);
			lblCosto.setBackground(Color.WHITE);
			lblCosto.setBounds(603, 32, 46, 14);
			getContentPane().add(lblCosto);
		}
		{
			txtCosto = new JTextField();
			txtCosto.setBounds(659, 32, 98, 20);
			getContentPane().add(txtCosto);
			txtCosto.setColumns(10);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(Hospedaje.class
					.getResource("/imagenes/CDC.jpg")));
			label.setBounds(0, 2, 769, 397);
			getContentPane().add(label);
		}
		tipoHos();
		edicion();
		listar();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button_3) {
			do_button_3_actionPerformed(arg0);
		}
		if (arg0.getSource() == button_2) {
			do_button_2_actionPerformed(arg0);
		}
		if (arg0.getSource() == button_1) {
			do_button_1_actionPerformed(arg0);
		}
		if (arg0.getSource() == cboOpciones) {
			do_cboOpciones_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnProcesar_1) {
			do_btnProcesar_1_actionPerformed(arg0);
		}
		if (arg0.getSource() == button) {
			do_button_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == cboTipo) {
			do_comboBox_actionPerformed(arg0);
		}

	}

	private void procesar() {
		switch (cboOpciones.getSelectedIndex()) {
		case 0:
			ingresar();
			break;
		case 1:
			listar();
		default:
			listar();
			break;
		}
	}

	public void ingresar() {
		try {
			Hospedajes hosp = o.buscar(leerCodigoHospedaje());
			if (hosp == null) {
				hosp = new Hospedajes(leerCodigoHospedaje(),
						leerCodigoReserva(), leerCodigoCliente(),
						leerCodigoHabitacion(), leerCodigoRecepcionista(),
						leerTipo(), leerFechaRegistro(), leerEstado(),
						leerCosto());
				o.adicionar(hosp);
				listar();
				txtCodigoHos.setText("" + o.codigoMayor(contador));
				mensaje("Hospedaje Ingresada");
				actulizaciones();
			} else {
				mensaje("Codigo ya existe");
			}
		} catch (Exception e) {
			mensaje("Ingrese Datos Por Favor");
			System.out.println("Error : Ingrese Datos \t" + e.getMessage());
		}
	}

	public void actulizaciones() {

		if (o.existeHospedaje()) {
			int ok = 0;
			if (ok == 0) {
				o.grabarHospedaje();
				o.getHospedaje();
			} else
				o.getHospedaje();
		} else {
			o.grabarHospedaje();
			o.getHospedaje();
		}
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	void listar() {
		imprimir();
		if (o.tamano() > 0) {
			imprimir("\t\t\t\t \t \t REGISTRO \t  DE DATOS  \t \t  DE LOS\t CLIENTES ");
			imprimir("Código Hospedaje \t Código Reserva \t Código Cliente \t Código habitación \t Código Recepci. \t tipo \t\t Fecha Registro \t Estado Hospedaje. \t Costo ");
			imprimir("");
			for (int i = 0; i < o.tamano(); i++) {
				Hospedajes hosp = o.obtener(i);
				imprimir(hosp.getCodigoHospedaje()
						+ "\t\t"
						+ rellena(hosp.getCodigoReserva() + "\t\t"
								+ hosp.getCodigoCliente() + "\t\t"
								+ hosp.getCodigoHabitacion() + "\t\t"
								+ hosp.getCodigoRecepcionista() + "\t\t"
								+ tipoHosp() + "\t\t" + hosp.getFechaRegistro()
								+ "\t\t" + hosp.estado() + "\t\t"
								+ hosp.getCosto()));
			}
			imprimir("");
			imprimir("Total de Hospedajes : " + o.tamano());
		} else {
			JOptionPane.showMessageDialog(null, "No hay Hospedajes", "MENSAJE",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// ///////////77rellenar
	String rellena(String cad) {
		int longitud = cad.length();
		for (int i = longitud; i < 15; i++)
			cad += " ";
		return cad;
	}

	public String tipoHosp() {
		String m = null;
		if (cboEstado.getSelectedIndex() == 0) {
			m = "Con reserva";
		} else {
			m = "Sin Reserva";
		}
		return m;
	}

	// /////metodos de imprimir
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void imprimir() {
		txtS.setText("");
	}

	// ////lectura de mis variables
	public int leerCodigoReserva() {
		return Integer.parseInt(txtCodigoReserva.getText());
	}

	public int leerCodigoHabitacion() {
		return Integer.parseInt(txtCodigoHabi.getText());
	}

	public int leerCodigoRecepcionista() {
		return Integer.parseInt(txtCodigoRecep.getText());
	}

	public int leerCodigoCliente() {
		return Integer.parseInt(txtCodigoCliente.getText());
	}

	public int leerCodigoHospedaje() {
		return Integer.parseInt(txtCodigoHos.getText());
	}

	public String leerFechaRegistro() {
		return txtFechaRegistro.getText();
	}

	public int leerEstado() {
		return cboEstado.getSelectedIndex();
	}

	public int leerOpciones() {
		return cboOpciones.getSelectedIndex();
	}

	public int leerTipo() {
		return cboTipo.getSelectedIndex();
	}

	public double leerCosto() {
		return Double.parseDouble(txtCosto.getText());
	}

	public static String fechaactual() {
		Date fecha = new Date();
		SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");

		return formatofecha.format(fecha);

	}

	void limpiar() {
		txtCodigoCliente.setText("");
		txtCodigoHabi.setText("");
		txtCodigoRecep.setText("");
		txtCodigoReserva.setText("");
		txtCodigoReserva.requestFocus();
		cboTipo.setSelectedIndex(0);
	}

	protected void do_comboBox_actionPerformed(ActionEvent arg0) {
		tipoHos();
	}

	void tipoHos() {
		if (cboTipo.getSelectedIndex() == 0) {
			txtCodigoReserva.setText("");
			button_1.setVisible(false);
			button_2.setVisible(false);
			button_3.setVisible(false);
			button.setVisible(true);
			txtCodigoCliente.setText("");
			txtCodigoHabi.setText("");
			txtCodigoRecep.setText("");
		} else {
			txtCodigoReserva.setText("-1");
			button.setVisible(false);
			button_1.setVisible(true);
			button_2.setVisible(true);
			button_3.setVisible(true);
			txtCodigoCliente.setText("");
			txtCodigoHabi.setText("");
			txtCodigoRecep.setText("");
		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		int dato = JOptionPane.showConfirmDialog(rootPane,"Esta seguro que desea Salir", "ALERTA",JOptionPane.ERROR_MESSAGE);
		if (dato == 0) {
			this.dispose();
		}
	}

	protected void do_button_actionPerformed(ActionEvent arg0) {
		new CodigoReserva().setVisible(true);
	}

	protected void do_btnProcesar_1_actionPerformed(ActionEvent arg0) {
		procesar();
		limpiar();
	}

	void edicion() {
		txtCodigoHos.setEditable(false);
		txtCodigoHos.setBackground(Color.WHITE);
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.setBackground(Color.WHITE);
		txtCodigoHabi.setEditable(false);
		txtCodigoHabi.setBackground(Color.WHITE);
		txtCodigoRecep.setEditable(false);
		txtCodigoRecep.setBackground(Color.WHITE);
		txtCodigoReserva.setEditable(false);
		txtCodigoReserva.setBackground(Color.WHITE);
	}

	protected void do_cboOpciones_actionPerformed(ActionEvent arg0) {
		if (cboOpciones.getSelectedIndex() == 0) {
			button.setEnabled(true);
			cboEstado.setEnabled(true);
			cboTipo.setEnabled(true);
			txtFechaRegistro.setEditable(false);
		} else {
			button.setEnabled(false);
			cboEstado.setEnabled(false);
			cboTipo.setEnabled(false);
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

	protected void do_button_1_actionPerformed(ActionEvent arg0) {
		new CodigoClientes().setVisible(true);

	}

	protected void do_button_2_actionPerformed(ActionEvent arg0) {
		new CodigoHabitaciones().setVisible(true);
	}

	protected void do_button_3_actionPerformed(ActionEvent arg0) {
		new CodigoRecepcionistas().setVisible(true);
	}
}
