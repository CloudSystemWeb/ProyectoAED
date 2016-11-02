package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import clases.Cliente;
import clases.Reservas;
import arraylist.ArregloReserva;

public class CodigoReserva extends JDialog implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();

	ArregloReserva a = new ArregloReserva("Reserva.txt");
	private JButton btnListar;
	private JButton btnSalir;
	public DefaultTableModel dtm;
	String cabecera[] = { "Código Reserva", "Fecha Registro", "Fecha Ingreso ", "Fecha Salida", "Código Cliente",
			"Número Habitación", "Código Cajera", "Código Recepcionista ", " Estado Reserva " };
	private JTable table;
	private JTextField txtCodigo;
	int posicion;
	private JLabel lblCdigo;
	private JButton btnBuscar;
	private JTextField txtCodigoCliente;
	private JLabel lblCCliente;
	private JTextField txtCodigoRecep;
	private JLabel lblCRecepcionista;
	private JLabel lblNHabitacin;
	private JTextField txtNumero;
	private JLabel label;

	/**
	 * imprimir(" \t \t \t\t \t\t \t \t\t \t \t"); Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CodigoReserva dialog = new CodigoReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CodigoReserva() {
		setTitle("CÓDIGO DE LAS RESERVAS");
		setBounds(100, 100, 1081, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 55, 1045, 227);
			contentPanel.add(scrollPane);
			{
				dtm = new DefaultTableModel(null, cabecera);
				table = new JTable();
				table.setModel(dtm);
				scrollPane.setViewportView(table);
			}
		}
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setBounds(10, 11, 89, 23);
			contentPanel.add(btnListar);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(966, 11, 89, 23);
			contentPanel.add(btnSalir);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(109, 12, 104, 20);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setBackground(Color.WHITE);
			SNumeros(txtCodigo);
		}
		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(Color.WHITE);
			lblCdigo.setBounds(180, 15, 58, 14);
			contentPanel.add(lblCdigo);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBackground(Color.LIGHT_GRAY);
			btnBuscar.setForeground(Color.BLACK);
			btnBuscar.setBounds(212, 11, 82, 22);
			contentPanel.add(btnBuscar);
		}
		{
			txtCodigoCliente = new JTextField();
			txtCodigoCliente.setBackground(Color.WHITE);
			txtCodigoCliente.setEditable(false);
			txtCodigoCliente.setBounds(395, 14, 86, 20);
			contentPanel.add(txtCodigoCliente);
			txtCodigoCliente.setColumns(10);
		}
		{
			lblCCliente = new JLabel("C. Cliente");
			lblCCliente.setForeground(Color.WHITE);
			lblCCliente.setBounds(312, 15, 73, 14);
			contentPanel.add(lblCCliente);
		}
		{
			txtCodigoRecep = new JTextField();
			txtCodigoRecep.setBackground(Color.WHITE);
			txtCodigoRecep.setEditable(false);
			txtCodigoRecep.setBounds(614, 12, 86, 20);
			contentPanel.add(txtCodigoRecep);
			txtCodigoRecep.setColumns(10);
		}
		{
			lblCRecepcionista = new JLabel("C. Recepcionista");
			lblCRecepcionista.setForeground(Color.WHITE);
			lblCRecepcionista.setBounds(501, 15, 113, 14);
			contentPanel.add(lblCRecepcionista);
		}
		{
			lblNHabitacin = new JLabel("N. Habitaci\u00F3n");
			lblNHabitacin.setForeground(Color.WHITE);
			lblNHabitacin.setBounds(736, 15, 89, 14);
			contentPanel.add(lblNHabitacin);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setEditable(false);
			txtNumero.setBackground(Color.WHITE);
			txtNumero.setBounds(824, 12, 86, 20);
			contentPanel.add(txtNumero);
			txtNumero.setColumns(10);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(CodigoReserva.class.getResource("/imagenes/CDC.jpg")));
			label.setBounds(0, 0, 1065, 293);
			contentPanel.add(label);
		}
		table.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnListar) {
			do_btnListar_actionPerformed(arg0);
		}
	}

	protected void do_btnListar_actionPerformed(ActionEvent arg0) {
		listar();
	}

	void listar() {
		if (a.tamano() > 0) {
			for (int i = 0; i < a.tamano(); i++) {
				Reservas reser = a.obtener(i);
				Object datos[] = { reser.getCodigoReserva(), reser.getFechaRegistro(), reser.getFechaIngreso(),
						reser.getFechaSalida(), reser.getCodigoCliente(), reser.getCodigoCajero(),
						reser.getNumeroHabitacion(), reser.getCodigoRecepcionista(), reser.estado() };
				dtm.addRow(datos);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay Reservas", "MENSAJE", JOptionPane.ERROR_MESSAGE);
		}

	}

	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	void consultar() {
		try {
			Reservas reser = a.buscar(leerCodigo());
			if (reser != null) {
				Object datos[] = { reser.getCodigoReserva(), reser.getFechaRegistro(), reser.getFechaIngreso(),
						reser.getFechaSalida(), reser.getCodigoCliente(), reser.getCodigoCajero(),
						reser.getNumeroHabitacion(), reser.getCodigoRecepcionista(), reser.estado() };
				dtm.addRow(datos);

				mensaje("Reserva Econtrada");
				txtCodigo.requestFocus();
			}

			else {
				JOptionPane.showMessageDialog(null, "No hay Reservas", "MENSAJE", JOptionPane.ERROR_MESSAGE);
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		} catch (Exception e) {

		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		try {
			String dato;
			dato = txtCodigo.getText();
			Hospedaje.txtCodigoReserva.setText(dato);

			String dato1 = txtCodigoCliente.getText();
			Hospedaje.txtCodigoCliente.setText(dato1);

			String dato2 = txtCodigoRecep.getText();
			Hospedaje.txtCodigoRecep.setText(dato2);

			String dato3 = txtNumero.getText();
			Hospedaje.txtCodigoHabi.setText(dato3);

			this.dispose();
		} catch (Exception e) {
			this.dispose();
		}
	}

	void selecionarRegistro() {
		posicion = table.getSelectedRow();
		txtCodigo.setText(String.valueOf(table.getValueAt(posicion, 0)));
		txtCodigoCliente.setText(String.valueOf(table.getValueAt(posicion, 4)));
		txtCodigoRecep.setText(String.valueOf(table.getValueAt(posicion, 7)));
		txtNumero.setText(String.valueOf(table.getValueAt(posicion, 5)));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			selecionarRegistro();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		if (txtCodigo.getText().equals("")) {
			mensaje("Ingrese Un Código");
			txtCodigo.requestFocus();
		} else {
			consultar();
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

	void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
}
