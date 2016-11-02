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

import clases.Habitacion;
import arraylist.ArregloHabitacion;

import java.awt.Font;

public class CodigoHabitacion extends JDialog implements ActionListener, MouseListener {

	ArregloHabitacion h = new ArregloHabitacion("Habitaciones.txt");

	private final JPanel contentPanel = new JPanel();
	private JButton btnListar;
	private JButton btnSalir;

	public DefaultTableModel dtm;
	String cabecera[] = { "Código", "Descripción", "Ubicación", "Tipo Habitación", "Costo Habitación" };
	private JTable table;
	private JTextField txtCodigo;

	int posicion;
	private JButton btnBuscar;
	private JLabel lblCdigo;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CodigoHabitacion dialog = new CodigoHabitacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CodigoHabitacion() {
		setTitle("CÓDIGO DE LAS HABITACIONES");
		setBounds(100, 100, 600, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setBounds(42, 11, 89, 23);
			contentPanel.add(btnListar);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(446, 11, 89, 23);
			contentPanel.add(btnSalir);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(9, 48, 565, 223);
			contentPanel.add(scrollPane);
			{
				dtm = new DefaultTableModel(null, cabecera);
				table = new JTable();
				table.setModel(dtm);
				scrollPane.setViewportView(table);
			}
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(229, 12, 120, 20);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setBackground(Color.WHITE);
			SNumeros(txtCodigo);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBackground(Color.LIGHT_GRAY);
			btnBuscar.setBounds(347, 11, 80, 23);
			contentPanel.add(btnBuscar);
		}
		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCdigo.setForeground(Color.WHITE);
			lblCdigo.setBounds(173, 15, 59, 14);
			contentPanel.add(lblCdigo);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(CodigoHabitacion.class
					.getResource("/imagenes/the-desktop-hd-Windows-7-Black-wallpapers (1).jpeg")));
			label.setBounds(0, 0, 584, 282);
			contentPanel.add(label);
		}

		table.addMouseListener(this);
		txtCodigo.requestFocus();
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

	///////////////// 7método de listar
	void listar() {
		if (h.tamaño() > 0) {
			for (int i = 0; i < h.tamaño(); i++) {
				Habitacion habi = h.obtener(i);
				Object datos[] = { habi.getCodigoHabitacion(), habi.getDescripcion(), habi.getUbicacion(),
						habi.getTipo(), habi.getCosto() };
				dtm.addRow(datos);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No hay Habitaciones", "MENSAJE", JOptionPane.ERROR_MESSAGE);
		}
	}

	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	///////////////////////////
	void consultar() {
		try {
			Habitacion habi = h.buscar(leerCodigo());
			if (habi != null) {
				Object datos[] = { habi.getCodigoHabitacion(), habi.getDescripcion(), habi.getUbicacion(),
						habi.getTipo(), habi.getCosto() };
				dtm.addRow(datos);

				mensaje("Habitación Encontrado");
				txtCodigo.requestFocus();
			}

			else
				JOptionPane.showMessageDialog(null, "Habitación no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
			txtCodigo.requestFocus();
		} catch (Exception e) {

		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		try {
			String dato;
			dato = txtCodigo.getText();
			Reserva.txtCodigoHabitacion.setText(dato);

			this.dispose();
		} catch (Exception e) {
			this.dispose();
		}
	}

	void selecionarRegistro() {
		posicion = table.getSelectedRow();
		txtCodigo.setText(String.valueOf(table.getValueAt(posicion, 0)));
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
			mensaje("Ingrese un Código");
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
