package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;

import javax.swing.JSeparator;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Color;

import javax.swing.JList;

import java.awt.Font;

import javax.swing.SwingConstants;

import clases.*;
import arraylist.ArregloReserva;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Reserva extends JFrame implements ActionListener {

	ArregloReserva a = new ArregloReserva("Reserva.txt");

	private JLabel lblCdigoReserva;
	private JLabel lblCdigoCliente;
	private JLabel lblCdigoCajerao;
	private JLabel lblCdigoHabitacin;
	private JLabel lblFechaRegistro;
	private JLabel lblFechaSalida;
	private JLabel lblFechaIngreso;
	private JTextField txtCodigoReserva;
	static JTextField txtCodigoCliente;
	static JTextField txtCodigoEmpleado;
	static JTextField txtCodigoFuncion;
	private JButton btnProcesar;
	private JButton btnSalir;
	private JButton btnBuscar_1;
	private JButton btnBuscar_2;
	private JButton btnBuscar_3;
	private JLabel lblOpciones;
	private JComboBox cboOpciones;
	private JScrollPane scrollPane;
	private JTextField txtFechaRegistro;
	private JComboBox cboDias;
	private JComboBox cboMeses;
	private JComboBox cboAnos;
	private JTextArea txtS;

	int contador;
	private JTextField txtHoraReserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva frame = new Reserva();
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
	public Reserva() {
		setTitle("RESERVA");
		setBounds(100, 100, 736, 393);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		{
			lblCdigoReserva = new JLabel("C\u00F3digo Reserva");
			lblCdigoReserva.setForeground(Color.RED);
			lblCdigoReserva.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/password.png")));
			lblCdigoReserva.setBounds(10, 11, 115, 14);
			getContentPane().add(lblCdigoReserva);
		}
		{
			lblCdigoCliente = new JLabel("C\u00F3digo Cliente");
			lblCdigoCliente.setForeground(Color.RED);
			lblCdigoCliente.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/password.png")));
			lblCdigoCliente.setBounds(10, 44, 115, 14);
			getContentPane().add(lblCdigoCliente);
		}
		{
			lblCdigoCajerao = new JLabel("C\u00F3digo Cajera (o)");
			lblCdigoCajerao.setForeground(Color.RED);
			lblCdigoCajerao.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/password.png")));
			lblCdigoCajerao.setBounds(10, 73, 129, 14);
			getContentPane().add(lblCdigoCajerao);
		}
		{
			lblCdigoHabitacin = new JLabel("C\u00F3digo Funci\u00F3n");
			lblCdigoHabitacin.setForeground(Color.RED);
			lblCdigoHabitacin.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/password.png")));
			lblCdigoHabitacin.setBounds(10, 106, 129, 14);
			getContentPane().add(lblCdigoHabitacin);
		}
		{
			lblFechaRegistro = new JLabel("Fecha Registro");
			lblFechaRegistro.setForeground(Color.RED);
			lblFechaRegistro.setBounds(283, 14, 87, 14);
			getContentPane().add(lblFechaRegistro);
		}
		{
			lblFechaSalida = new JLabel("Hora");
			lblFechaSalida.setForeground(Color.RED);
			lblFechaSalida.setBounds(283, 78, 87, 14);
			getContentPane().add(lblFechaSalida);
		}
		{
			lblFechaIngreso = new JLabel("Fecha");
			lblFechaIngreso.setForeground(Color.RED);
			lblFechaIngreso.setBounds(283, 47, 87, 14);
			getContentPane().add(lblFechaIngreso);
		}
		{
			txtCodigoReserva = new JTextField();
			txtCodigoReserva.setBounds(135, 8, 86, 20);
			getContentPane().add(txtCodigoReserva);
			txtCodigoReserva.setColumns(10);
			txtCodigoReserva.setText("" + a.codigoMayor(contador));
			txtCodigoReserva.setEditable(false);
			txtCodigoReserva.setBackground(Color.WHITE);
			SNumeros(txtCodigoReserva);
		}
		{
			txtCodigoCliente = new JTextField();
			txtCodigoCliente.setBackground(Color.WHITE);
			txtCodigoCliente.setBounds(135, 41, 86, 20);
			getContentPane().add(txtCodigoCliente);
			txtCodigoCliente.setColumns(10);
			txtCodigoCliente.setEditable(false);
			SNumeros(txtCodigoCliente);
		}
		{
			txtCodigoEmpleado = new JTextField();
			txtCodigoEmpleado.setBackground(Color.WHITE);
			txtCodigoEmpleado.setBounds(135, 70, 86, 20);
			getContentPane().add(txtCodigoEmpleado);
			txtCodigoEmpleado.setColumns(10);
			txtCodigoEmpleado.setEditable(false);
			SNumeros(txtCodigoEmpleado);
		}
		{
			txtCodigoFuncion = new JTextField();
			txtCodigoFuncion.setBackground(Color.WHITE);
			txtCodigoFuncion.setBounds(135, 103, 86, 20);
			getContentPane().add(txtCodigoFuncion);
			txtCodigoFuncion.setColumns(10);
			txtCodigoFuncion.setEditable(false);
			txtCodigoFuncion.setEditable(false);
			SNumeros(txtCodigoFuncion);
		}
		{
			btnProcesar = new JButton("<html><p>Procesar</p></html>");
			btnProcesar.setForeground(Color.BLUE);
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnProcesar.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/procesar.gif")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(595, 11, 115, 45);
			getContentPane().add(btnProcesar);
		}
		{
			btnSalir = new JButton("");
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSalir.setForeground(Color.BLUE);
			btnSalir.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/exit_button.gif")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(595, 73, 115, 47);
			getContentPane().add(btnSalir);
		}
		{
			btnBuscar_1 = new JButton("");
			btnBuscar_1.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/lupa.png")));
			btnBuscar_1.addActionListener(this);
			btnBuscar_1.setBounds(220, 40, 51, 22);
			getContentPane().add(btnBuscar_1);
		}
		{
			btnBuscar_2 = new JButton("");
			btnBuscar_2.addActionListener(this);
			btnBuscar_2.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/lupa.png")));
			btnBuscar_2.setBounds(220, 69, 50, 22);
			getContentPane().add(btnBuscar_2);
		}
		{
			btnBuscar_3 = new JButton("");
			btnBuscar_3.addActionListener(this);
			btnBuscar_3.setIcon(new ImageIcon(Reserva.class.getResource("/imagenes/lupa.png")));
			btnBuscar_3.setBounds(220, 102, 52, 22);
			getContentPane().add(btnBuscar_3);
		}
		{
			lblOpciones = new JLabel("Estado");
			lblOpciones.setForeground(Color.RED);
			lblOpciones.setBounds(283, 109, 87, 14);
			getContentPane().add(lblOpciones);
		}
		{
			cboOpciones = new JComboBox();
			cboOpciones.addActionListener(this);
			cboOpciones.setModel(new DefaultComboBoxModel(new String[] { "Reservada", "Reserva Usada", "Reserva Cancelada","Reserva Caducada" }));
			cboOpciones.setBounds(410, 106, 118, 20);
			getContentPane().add(cboOpciones);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(13, 174, 697, 169);
			getContentPane().add(scrollPane);
			{
				txtS = new JTextArea();
				txtS.setBackground(new Color(255, 250, 240));
				scrollPane.setViewportView(txtS);
			}
		}
		{
			txtFechaRegistro = new JTextField();
			txtFechaRegistro.setBackground(Color.WHITE);
			txtFechaRegistro.setEditable(false);
			txtFechaRegistro.setBounds(410, 11, 118, 20);
			getContentPane().add(txtFechaRegistro);
			txtFechaRegistro.setColumns(10);
			txtFechaRegistro.setText("" + fechaactual());
			SNumeros(txtFechaRegistro);

		}
		{
			cboDias = new JComboBox();
			cboDias.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "04", "06", "07", "08",
					"09", "01", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
					"25", "26", "27", "28", "29", "30", "31" }));
			cboDias.setBounds(380, 44, 51, 20);
			getContentPane().add(cboDias);
		}
		{
			cboMeses = new JComboBox();
			cboMeses.setModel(new DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril ", "Mayo",
					"Juni ", "Julio", "Agosto", "Agosto", "Septiembre", "Octubre", "Diciembre" }));
			cboMeses.setBounds(431, 44, 87, 20);
			getContentPane().add(cboMeses);
		}
		{
			cboAnos = new JComboBox();
			cboAnos.setModel(
					new DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
			cboAnos.setBounds(518, 44, 68, 20);
			getContentPane().add(cboAnos);
		}
		{
			txtHoraReserva = new JTextField();
			txtHoraReserva.setText("06/11/2016");
			txtHoraReserva.setEditable(false);
			txtHoraReserva.setBackground(Color.WHITE);
			txtHoraReserva.setBounds(410, 70, 118, 20);
			getContentPane().add(txtHoraReserva);
			txtHoraReserva.setColumns(10);
			
		}
		listar();
	}

	public void actionPerformed(ActionEvent arg0) {
		/*if (arg0.getSource() == cboOpciones) {
			do_cboOpciones_actionPerformed(arg0);
		}*/
		if (arg0.getSource() == btnBuscar_3) {
			do_btnBuscar_3_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnBuscar_2) {
			do_btnBuscar_2_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnBuscar_1) {
			do_btnBuscar_1_actionPerformed(arg0);
		}
		limpiarFechas();
	}

	void limpiarFechas() {
		cboAnos.setSelectedIndex(0);
		cboDias.setSelectedIndex(0);
		cboMeses.setSelectedIndex(0);
	}

	protected void do_btnBuscar_1_actionPerformed(ActionEvent arg0) {
		CodigoCliente cliente = new CodigoCliente();
		cliente.setVisible(true);
	}

	protected void do_btnProcesar_actionPerformed(ActionEvent arg0) {
		procesar();
		limpiar();
	}

	void procesar() {
		switch (cboOpciones.getSelectedIndex()) {
		case 0:
			ingresar();
			break;
		case 1:
			anulacion();
			actulizaciones();
			break;
		default:
			listar();
		}
	}

	public void ingresar() {
		try {
			Reservas reser = a.buscar(leerCodigoReserva());
			if (reser == null) {
				reser = new Reservas(leerCodigoReserva(), leerCodigoCliente(), leerCodigoEmpleado(),
						leerCodigoFuncion(), leerFechaReserva(), leerHoraReserva(), leerEstado());
				a.adicionar(reser);
				listar();
				txtCodigoReserva.setText("" + a.codigoMayor(contador));

				mensaje("Reserva Ingresada");
				actulizaciones();
			} else {
				mensaje("Codigo ya existe");
			}
		} catch (Exception e) {
			mensaje("Ingrese Datos");
			System.out.println("Error : Ingrese Datos \t" + e.getMessage());
		}

	}

	public void actulizaciones() {

		if (a.existeReserva()) {
			int ok = 0;
			if (ok == 0) {
				a.grabarReservas();
				a.getReserva();
			} else
				a.getReserva();
		} else {
			a.grabarReservas();
			a.getReserva();
		}
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	void listar() {
		imprimir();
		if (a.tamano() > 0) {
			txtS.setText("\t\t REGISTRO DE DATOS DE LOS RESERVA " + "\n");
			imprimir(
					"Código Reserva \t Código Cliente \t Código Cajera \t\t Código Recepci. \t Número Habita. \t Fecha Registro \t Fecha Ingreso \t\t Fecha Salida \t\t Estado Reser. ");
			for (int i = 0; i < a.tamano(); i++) {
				Reservas reser = a.obtener(i);
				imprimir(reser.getCodigoReserva() + "\t\t" + reser.getCodigoCliente() + "\t\t" + reser.getCodigoEmpleado()
						+ "\t\t" + reser.getCodigoEmpleado() + "\t\t" + reser.getFechaReserva() + "\t\t"
						+ reser.getHoraIngreso() + "\t\t" + reser.getEstado());
			}
			imprimir("");
			imprimir("Total de Reservas : " + a.tamano());
		} else
			imprimir("El Arraylist Reservas está Vasio..................");
	}

	////////// 77mensaje
	void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	///////////// 77rellenar
	String rellena(String cad) {
		int longitud = cad.length();
		for (int i = longitud; i < 15; i++)
			cad += " ";
		return cad;
	}

	/////// metodos de imprimir
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void imprimir() {
	}

	////// lectura de mis variables
	public int leerCodigoReserva() {
		return Integer.parseInt(txtCodigoReserva.getText());
	}

	public int leerCodigoFuncion() {
		return Integer.parseInt(txtCodigoFuncion.getText());
	}

	public int leerCodigoCliente() {
		return Integer.parseInt(txtCodigoCliente.getText());
	}

	public int leerCodigoEmpleado() {
		return Integer.parseInt(txtCodigoEmpleado.getText());
	}

	public String leerFechaReserva() {
		txtFechaRegistro.getText();
		return fechaactual();
	}
	
	public String leerHoraReserva() {
		return txtHoraReserva.getText();
	}

	public int leerEstado(){
		return cboOpciones.getSelectedIndex();
	}
	
	public int leerOpciones() {
		return cboOpciones.getSelectedIndex();
	}

	///// los combosss de fecha



	public String leerDia1() {
		return cboDias.getSelectedItem().toString();
	}

	public String leerMes1() {
		return cboMeses.getSelectedItem().toString();
	}

	public String leerAno1() {
		return cboAnos.getSelectedItem().toString();
	}


	public String leerFechaSalida() {
		String m = null;
		m = leerDia1() + "/" + leerMes1() + "/" + leerAno1();
		return m;
	}

	public static String fechaactual() {
		Date fecha = new Date();
		SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");

		return formatofecha.format(fecha);

	}

	void anulacion() {
		Reservas reser = a.buscar(leerCodigoReserva());
		if (reser != null) {
			a.eliminar(reser);
			listar();
			// mensaje que muestre que el cliente ha sido eliminado
			JOptionPane.showMessageDialog(null, "Reserva Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else

			JOptionPane.showMessageDialog(null, "Reserva no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

	}

	void limpiar() {
		txtCodigoEmpleado.setText("");
		txtCodigoFuncion.setText("");
		txtCodigoCliente.setText("");
		txtCodigoCliente.requestFocus();
		cboOpciones.setSelectedIndex(0);

	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		int dato = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea Salir", "ALERTA",
				JOptionPane.INFORMATION_MESSAGE);
		if (dato == 0) {
			this.dispose();
		}
	}

	protected void do_btnBuscar_2_actionPerformed(ActionEvent arg0) {
		CodigoCajera cajera = new CodigoCajera();
		cajera.setVisible(true);

	}

	protected void do_btnBuscar_3_actionPerformed(ActionEvent arg0) {
		CodigoFuncion cajera = new CodigoFuncion();
		cajera.setVisible(true);
	}

	private void anular() {
		if (cboOpciones.getSelectedIndex() == 0) {
			btnBuscar_1.setEnabled(true);
			btnBuscar_2.setEnabled(true);
			btnBuscar_3.setEnabled(true);
			cboOpciones.setEnabled(true);
			cboAnos.setEnabled(true);
			cboMeses.setEnabled(true);
			cboDias.setEnabled(true);
		} else if (cboOpciones.getSelectedIndex() == 1) {
			txtCodigoReserva.setEditable(true);
			btnBuscar_1.setEnabled(false);
			btnBuscar_2.setEnabled(false);
			btnBuscar_3.setEnabled(false);
			cboOpciones.setEnabled(false);
			cboAnos.setEnabled(false);
			cboMeses.setEnabled(false);
			cboDias.setEnabled(false);
		} else {
			txtCodigoReserva.setEditable(false);
			btnBuscar_1.setEnabled(false);
			btnBuscar_2.setEnabled(false);
			btnBuscar_3.setEnabled(false);
			cboOpciones.setEnabled(false);
			cboAnos.setEnabled(false);
			cboMeses.setEnabled(false);
			cboDias.setEnabled(false);
			listar();
		}
	}

	protected void do_cboOpciones_actionPerformed(ActionEvent arg0) {
		anular();
	}

	/*void restricicon() {
		if (leerCodigoHabitacion() == leerCodigoHabitacion()) {
			mensaje("Habitación ya esta reservada");
		}
	}*/

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
}
