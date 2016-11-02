package principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import clases.Cliente;
import clases.Habitacion;
import clases.Hospedajes;
import clases.Recepcionista;
import clases.Reservas;
import arraylist.ArregloCliente;
import arraylist.ArregloHabitacion;
import arraylist.ArregloHospadaje;
import arraylist.ArregloRecepcionista;
import arraylist.ArregloReserva;

import java.awt.Color;
import java.util.ArrayList;

public class Consultas extends JDialog implements ActionListener {

	ArregloHospadaje o = new ArregloHospadaje("Hospedaje.txt");
	ArregloRecepcionista r = new ArregloRecepcionista("Recepcionista.txt");
	ArregloHabitacion h = new ArregloHabitacion("Habitaciones.txt");
	ArregloReserva re = new ArregloReserva("Reserva.txt");

	private final JPanel contentPanel = new JPanel();
	private JLabel lblBusuqedaDeHospedaje;
	private JLabel lblCdigoRecepcionista;
	private JTextField txtCodigoRecep;
	private JLabel lblHistorialDeHospedaje;
	private JLabel lblCdigoHabitacin;
	private JTextField txtCodigoHabi;
	private JLabel lblBusquedaDeReserva;
	private JLabel lblIngresaFecha;
	private JLabel lblBusquedaDeHospedaje;
	private JLabel lblIngresaMonto;
	private JTextField txtMonto;
	private JScrollPane scrollPane;
	private JButton btnProcesar;
	private JButton btnSlir;
	private JComboBox cboOpcion;
	private JTextField txtFechaIngreso;
	private JTextArea txtS;
	private JLabel lblFechaSalida;
	private JTextField txtFechaSalida;
	private JLabel lblOpciones;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consultas dialog = new Consultas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Consultas() {
		setTitle("REPORTES Y CONSULTAS");
		setBounds(100, 100, 730, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblBusuqedaDeHospedaje = new JLabel(
					"1: Busqeda de Hospedaje por Recepcionista");
			lblBusuqedaDeHospedaje.setForeground(Color.CYAN);
			lblBusuqedaDeHospedaje.setBounds(24, 11, 257, 14);
			contentPanel.add(lblBusuqedaDeHospedaje);
		}
		{
			lblCdigoRecepcionista = new JLabel("C\u00F3digo Recepcionista");
			lblCdigoRecepcionista.setForeground(Color.CYAN);
			lblCdigoRecepcionista.setBounds(26, 46, 135, 14);
			contentPanel.add(lblCdigoRecepcionista);
		}
		{
			txtCodigoRecep = new JTextField();
			txtCodigoRecep.setEditable(false);
			txtCodigoRecep.addActionListener(this);
			txtCodigoRecep.setBounds(158, 43, 123, 20);
			contentPanel.add(txtCodigoRecep);
			txtCodigoRecep.setColumns(10);
			SNumeros(txtCodigoRecep);
		}
		{
			lblHistorialDeHospedaje = new JLabel(
					"2: Historial de Hospedaje por Habitaci\u00F3n");
			lblHistorialDeHospedaje.setForeground(Color.CYAN);
			lblHistorialDeHospedaje.setBounds(314, 43, 248, 14);
			contentPanel.add(lblHistorialDeHospedaje);
		}
		{
			lblCdigoHabitacin = new JLabel("C\u00F3digo Habitaci\u00F3n");
			lblCdigoHabitacin.setForeground(Color.CYAN);
			lblCdigoHabitacin.setBounds(324, 78, 135, 14);
			contentPanel.add(lblCdigoHabitacin);
		}
		{
			txtCodigoHabi = new JTextField();
			txtCodigoHabi.setEditable(false);
			txtCodigoHabi.setBounds(457, 75, 86, 20);
			contentPanel.add(txtCodigoHabi);
			txtCodigoHabi.setColumns(10);
			SNumeros(txtCodigoHabi);
		}
		{
			lblBusquedaDeReserva = new JLabel(
					"3: Busqueda de Reserva por Fecha");
			lblBusquedaDeReserva.setForeground(Color.CYAN);
			lblBusquedaDeReserva.setBounds(24, 85, 233, 14);
			contentPanel.add(lblBusquedaDeReserva);
		}
		{
			lblIngresaFecha = new JLabel("Ingresa Fecha");
			lblIngresaFecha.setForeground(Color.CYAN);
			lblIngresaFecha.setBounds(24, 117, 109, 14);
			contentPanel.add(lblIngresaFecha);
		}

		{
			lblBusquedaDeHospedaje = new JLabel(
					"4: Busqueda de Hospedaje por Monto");
			lblBusquedaDeHospedaje.setForeground(Color.CYAN);
			lblBusquedaDeHospedaje.setBounds(314, 122, 233, 14);
			contentPanel.add(lblBusquedaDeHospedaje);
		}
		{
			lblIngresaMonto = new JLabel("Ingresa Monto");
			lblIngresaMonto.setForeground(Color.CYAN);
			lblIngresaMonto.setBounds(328, 154, 109, 14);
			contentPanel.add(lblIngresaMonto);
		}
		{
			txtMonto = new JTextField();
			txtMonto.setEditable(false);
			txtMonto.setBounds(457, 151, 86, 20);
			contentPanel.add(txtMonto);
			txtMonto.setColumns(10);
			SNumeros(txtMonto);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 182, 694, 212);
			contentPanel.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnProcesar = new JButton("<html><h2>Procesar</h2><html>");
			btnProcesar.setForeground(Color.BLUE);
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(587, 42, 109, 50);
			contentPanel.add(btnProcesar);
		}
		{
			btnSlir = new JButton("");
			btnSlir.setIcon(new ImageIcon(Consultas.class
					.getResource("/imagenes/sal.gif")));
			btnSlir.setForeground(Color.BLUE);
			btnSlir.addActionListener(this);
			btnSlir.setBounds(587, 117, 109, 51);
			contentPanel.add(btnSlir);
		}
		{
			cboOpcion = new JComboBox();
			cboOpcion.addActionListener(this);
			cboOpcion.setModel(new DefaultComboBoxModel(new String[] {
					"Seleccione Opción", "1\u00B0 Opci\u00F3n",
					"2\u00B0 Opci\u00F3n", "3\u00B0 Opci\u00F3n",
					"4\u00B0 Opci\u00F3n" }));
			cboOpcion.setBounds(493, 8, 156, 20);
			contentPanel.add(cboOpcion);
		}
		{
			txtFechaIngreso = new JTextField();
			txtFechaIngreso.setEditable(false);
			txtFechaIngreso.setBounds(158, 114, 123, 20);
			contentPanel.add(txtFechaIngreso);
			txtFechaIngreso.setColumns(10);
			SNumeros(txtFechaIngreso);
		}
		{
			lblFechaSalida = new JLabel("Fecha Salida");
			lblFechaSalida.setForeground(new Color(0, 191, 255));
			lblFechaSalida.setBounds(24, 151, 115, 20);
			contentPanel.add(lblFechaSalida);
		}
		{
			txtFechaSalida = new JTextField();
			txtFechaSalida.setEditable(false);
			txtFechaSalida.setBounds(158, 151, 123, 20);
			contentPanel.add(txtFechaSalida);
			txtFechaSalida.setColumns(10);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setIcon(new ImageIcon(Consultas.class
					.getResource("/imagenes/procesar.gif")));
			lblOpciones.setForeground(new Color(0, 255, 255));
			lblOpciones.setBounds(374, 9, 109, 18);
			contentPanel.add(lblOpciones);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(
					Consultas.class
							.getResource("/imagenes/imagenes-de-pantalla-foto-fondo-de-escritorio-pc-windows-9.jpg")));
			label.setBounds(0, 0, 714, 405);
			contentPanel.add(label);
		}
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == cboOpcion) {
			do_cboOpcion_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSlir) {
			do_btnSlir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
	}

	protected void do_btnProcesar_actionPerformed(ActionEvent arg0) {
		procesar();
	}

	void procesar() {
		switch (cboOpcion.getSelectedIndex()) {
		case 0:
			condiciones();
			break;
		case 1:
			consultar();
			break;
		case 2:
			consultarDos();
			break;
		case 3:
      	listarFecha(); 
			break;
		case 4:
			consultarCosto();
			break;
		default:
			break;
		}
	}

	protected void do_btnSlir_actionPerformed(ActionEvent arg0) {
		int dato = JOptionPane.showConfirmDialog(rootPane,
				"Esta seguro que desea Salir", "ALERTA",
				JOptionPane.ERROR_MESSAGE);
		if (dato == 0) {
			this.dispose();
		}
	}

	protected void do_cboOpcion_actionPerformed(ActionEvent arg0) {
		condiciones();
	}

	void consultar() {
		try {
			imprimir();
			Hospedajes hosp = o.buscarRecep(leerCodigoRecep());
			if (hosp != null) {
				imprimir("Código Hospedaje \t Código Reserva \t Código Cliente \t Código habitación \t Código Recepci.\t Fecha Registro \t Estado Hospedaje. \t Costo");
				imprimir(hosp.getCodigoHospedaje() + "\t\t"
						+ hosp.getCodigoReserva() + "\t\t"
						+ hosp.getCodigoCliente() + "\t\t"
						+ hosp.getCodigoHabitacion() + "\t\t"
						+ hosp.getCodigoRecepcionista() + "\t\t"
						+ hosp.getFechaRegistro() + "\t\t" + hosp.estado()
						+ "\t\t" + hosp.getCosto());
				imprimir("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				mensaje("Hospedaje Encontrada");
				txtCodigoRecep.setText("");
			}
			if (hosp == null)
				mensaje("No existe Hospedaje de la Recepcionista \n por favor ingrese un Código válido.");
			txtCodigoRecep.setText("");
			txtCodigoRecep.requestFocus();
		} catch (Exception e) {
			mensaje("UD no ingresó un Código");
			txtCodigoRecep.requestFocus();
		}

	}

	void consultarDos() {
		try {
			imprimir();
			Hospedajes hosp = o.buscarHabit(leerCodigoHabitacion());
			if (hosp != null) {
				imprimir("Código Hospedaje \t Código Reserva \t Código Cliente \t Código habitación \t Código Recepci.\t Fecha Registro \t Estado Hospedaje. \t Costo"
						+ "\n");
				imprimir(hosp.getCodigoHospedaje() + "\t\t"
						+ hosp.getCodigoReserva() + "\t\t"
						+ hosp.getCodigoCliente() + "\t\t"
						+ hosp.getCodigoHabitacion() + "\t\t"
						+ hosp.getCodigoRecepcionista() + "\t\t"
						+ hosp.getFechaRegistro() + "\t\t" + hosp.estado()
						+ "\t\t" + hosp.getCosto());
				imprimir("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				mensaje("Hospedaje Encontrada");
				txtCodigoHabi.setText("");
			}

			if (hosp == null)
				mensaje("No existe Hospedaje de la Habitación \n por favor ingrese un Código válido.");
			txtCodigoHabi.setText("");
			txtCodigoHabi.requestFocus();
		} catch (Exception e) {
			mensaje("UD no ingresó un Código");
			txtCodigoHabi.requestFocus();
		}
	}

	// ///////////////////////////////////////////////////77777777
	void consultarCosto() {
		try {
			imprimir();
			Hospedajes hosp = o.costo(leerMonto());
			if (hosp != null) {
				imprimir("Código Hospedaje \t Código Reserva \t Código Cliente \t Código habitación \t Código Recepci.\t\t Fecha Registro \t Estado Hospedaje. \t Costo"
						+ "\n");
				imprimir(hosp.getCodigoHospedaje() + "\t\t"
						+ hosp.getCodigoReserva() + "\t\t"
						+ hosp.getCodigoCliente() + "\t\t"
						+ hosp.getCodigoHabitacion() + "\t\t"
						+ hosp.getCodigoRecepcionista() + "\t\t"
						+ hosp.getFechaRegistro() + "\t\t" + hosp.estado()
						+ "\t\t" + hosp.getCosto());
				imprimir("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				mensaje("Hospedaje Encontrada");
				txtCodigoHabi.setText("");
			}

			if (hosp == null)
				mensaje("No existe Hospedaje de con ningún monto.");
			txtCodigoHabi.setText("");
			txtCodigoHabi.requestFocus();
		} catch (Exception e) {
			mensaje("UD no ingresó un Código");
			txtCodigoHabi.requestFocus();
		}
	}

	void listarFecha() {
		if (leerFechaIngreso().equals("") || leerFechaSalida().equals("")) {
			mensaje("UD. No ingresó las Fechas");
			txtFechaIngreso.requestFocus();
		} else {
			Reservas reser = re.buscarFecha(leerFechaIngreso(),leerFechaSalida());
			if (reser != null) {
				imprimir();
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS CLIENTES " + "\n");
				imprimir("Código Reserva \t Código Cliente \t Código Cajera \t\t Código Recepci. \t Número Habita. \t Fecha Registro \t Fecha Ingreso \t\t Fecha Salida \t\t Estado Reser. ");
				imprimir("");
				imprimir(reser.getCodigoReserva() + "\t\t"
						+ reser.getCodigoCliente() + "\t\t"
						+ reser.getCodigoCajero() + "\t\t"
						+ reser.getNumeroHabitacion() + "\t\t"
						+ reser.getCodigoRecepcionista() + "\t\t"
						+ reser.getFechaRegistro() + "\t\t"
						+ reser.getFechaIngreso() + "\t\t"
						+ reser.getFechaSalida() + "\t\t" 
						+ reser.estado());

				mensaje("Reserva Econtrada");
			}
			if (reser == null) {
				mensaje("No existe Reserva de las Fechas Programadas \n por favor ingrese fechas válidas.");
				txtFechaIngreso.setText("");
				txtFechaSalida.setText("");
				txtFechaIngreso.requestFocus();
			}
		}
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void imprimir() {
		txtS.setText("");
	}

	public int leerCodigoHabitacion() {
		return Integer.parseInt(txtCodigoHabi.getText());
	}

	public int leerCodigoRecep() {
		return Integer.parseInt(txtCodigoRecep.getText());
	}

	public double leerMonto() {
		return Double.parseDouble(txtMonto.getText());
	}

	public String leerFechaIngreso() {
		return txtFechaIngreso.getText();
	}

	public String leerFechaSalida() {
		return txtFechaSalida.getText();
	}

	public int leerOpcion() {
		return cboOpcion.getSelectedIndex();
	}

	public void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	void condiciones() {
		switch (cboOpcion.getSelectedIndex()) {
		case 0:
			mensaje("Seleccione una Opción ");
			break;
		case 1:
			txtCodigoRecep.setEditable(true);
			txtCodigoHabi.setEditable(false);
			txtFechaIngreso.setEditable(false);
			txtMonto.setEditable(false);
			txtFechaSalida.setEditable(false);
			txtCodigoRecep.requestFocus();
			break;
		case 2:
			txtCodigoRecep.setEditable(false);
			txtCodigoHabi.setEditable(true);
			txtFechaIngreso.setEditable(false);
			txtMonto.setEditable(false);
			txtFechaSalida.setEditable(false);
			txtCodigoHabi.requestFocus();
			break;
		case 3:
			txtCodigoRecep.setEditable(false);
			txtCodigoHabi.setEditable(false);
			txtFechaIngreso.setEditable(true);
			txtMonto.setEditable(false);
			txtFechaSalida.setEditable(true);
			break;
		case 4:
			txtCodigoRecep.setEditable(false);
			txtCodigoHabi.setEditable(false);
			txtFechaIngreso.setEditable(false);
			txtMonto.setEditable(true);
			txtFechaSalida.setEditable(false);
			break;
		default:
			break;
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
