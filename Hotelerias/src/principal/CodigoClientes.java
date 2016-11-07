package principal;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.SpringLayout;

import java.awt.Choice;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import clases.Cliente;
import arraylist.ArregloCliente;

import java.awt.SystemColor;

public class CodigoClientes extends JDialog implements ActionListener, MouseListener {

	ArregloCliente c = new ArregloCliente("Cliente.txt");

	private JButton btnListar;
	private JButton btnSalir;
	private JScrollPane scrollPane;

	public DefaultTableModel dtm;
	String cabecera[] = { "Código", "Nombres", "Apellidos", "Teléfono", "Sexo", "Estado" };
	private JTable tabla;
	private JTextField txtCodigo;

	int posicion;
	private JButton btnBuscar;
	private JLabel lblBuscar;
	private JComboBox cboOpcion;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnBuscar_1;
	private JLabel lblCdigo;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CodigoCliente dialog = new CodigoCliente();
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
	public CodigoClientes() {
		setTitle("C\u00D3DIGOS DE LOS CLIENTES");
		setBounds(100, 100, 589, 302);
		{
			btnListar = new JButton("Listar");
			btnListar.setBounds(461, 43, 89, 23);
			btnListar.addActionListener(this);
			getContentPane().setLayout(null);
			getContentPane().add(btnListar);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.setIcon(new ImageIcon(CodigoCliente.class.getResource("/imagenes/exit_button.gif")));
			btnSalir.setBounds(461, 12, 102, 23);
			btnSalir.addActionListener(this);
			getContentPane().add(btnSalir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 76, 553, 185);
			getContentPane().add(scrollPane);
			{
				dtm = new DefaultTableModel(null, cabecera);
				tabla = new JTable();
				tabla.setModel(dtm);
				scrollPane.setViewportView(tabla);
			}
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(251, 14, 125, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setBackground(Color.WHITE);
			SNumeros(txtCodigo);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setForeground(SystemColor.desktop);
			btnBuscar.setEnabled(false);
			btnBuscar.setBackground(SystemColor.activeCaption);
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(373, 12, 78, 23);
			getContentPane().add(btnBuscar);
		}
		{
			lblBuscar = new JLabel("Buscar");
			lblBuscar.setForeground(SystemColor.inactiveCaptionBorder);
			lblBuscar.setBounds(10, 15, 46, 14);
			getContentPane().add(lblBuscar);
		}
		{
			cboOpcion = new JComboBox();
			cboOpcion.addActionListener(this);
			cboOpcion.setModel(new DefaultComboBoxModel(new String[] { "Por C\u00F3digo", "Por Nombre" }));
			cboOpcion.setBounds(55, 13, 109, 20);
			getContentPane().add(cboOpcion);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(SystemColor.inactiveCaptionBorder);
			lblNombre.setBounds(10, 46, 59, 14);
			getContentPane().add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBackground(Color.WHITE);
			txtNombre.setForeground(Color.BLACK);
			txtNombre.setEditable(false);
			txtNombre.setBounds(72, 43, 152, 20);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
			SLetras(txtNombre);
		}
		{
			btnBuscar_1 = new JButton("Buscar");
			btnBuscar_1.addActionListener(this);
			btnBuscar_1.setEnabled(false);
			btnBuscar_1.setBounds(222, 42, 88, 23);
			getContentPane().add(btnBuscar_1);
		}
		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(SystemColor.inactiveCaptionBorder);
			lblCdigo.setBounds(195, 12, 46, 23);
			getContentPane().add(lblCdigo);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(
					CodigoCliente.class.getResource("/imagenes/the-desktop-hd-Windows-7-Black-wallpapers (1).jpeg")));
			label.setBounds(0, 0, 573, 263);
			getContentPane().add(label);
		}
		tabla.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar_1) {
			do_btnBuscar_1_actionPerformed(arg0);
		}
		if (arg0.getSource() == cboOpcion) {
			do_cboOpcion_actionPerformed(arg0);
		}
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
		if (c.tamaño() > 0) {
			for (int i = 0; i < c.tamaño(); i++) {
				Cliente clien = c.obtener(i);
				Object datos[] = { clien.getCodCliente(), clien.getNombreCliente(), clien.getApellidoCliente(),
						clien.getDirrecion(), clien.getFechaNacimiento(), clien.getFechaAfiliacion(),
						clien.getEstadoCivil(), clien.getTelefono(), clien.getDNI(), clien.getUsuario(),
						clien.getContraseña() };
				dtm.addRow(datos);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay Clientes", "MENSAJE", JOptionPane.ERROR_MESSAGE);
		}
	}

	void consultar() {
		try {
			Cliente clien = c.buscar(leerCodigo());
			if (clien != null) {
				Object datos[] = { clien.getCodCliente(), clien.getNombreCliente(), clien.getApellidoCliente(),
						clien.getDirrecion(), clien.getFechaNacimiento(), clien.getFechaAfiliacion(),
						clien.getEstadoCivil(), clien.getTelefono(), clien.getDNI(), clien.getUsuario(),
						clien.getContraseña() };
				dtm.addRow(datos);

				mensaje("Cliente Encontrado");
				txtCodigo.requestFocus();
			} else
				JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
			txtCodigo.requestFocus();
		} catch (Exception e) {
			mensaje("Ingrese Un Código");
		}
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		try {
			String dato;
			dato = txtCodigo.getText();
			Hospedaje.txtCodigoCliente.setText(dato);
			this.dispose();
		} catch (Exception e) {
			this.dispose();
		}

	}

	void selecionarRegistro() {
		posicion = tabla.getSelectedRow();
		txtCodigo.setText(String.valueOf(tabla.getValueAt(posicion, 0)));
		txtNombre.setText(String.valueOf(tabla.getValueAt(posicion, 1)));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tabla) {
			selecionarRegistro();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		try {
			consultar();
		} catch (Exception h) {
			txtCodigo.requestFocus();
		}
	}

	protected void do_cboOpcion_actionPerformed(ActionEvent arg0) {
		seleccion();
	}

	void seleccion() {
		if (cboOpcion.getSelectedIndex() == 0) {
			txtNombre.setEditable(false);
			txtCodigo.setEditable(true);
			btnBuscar.setEnabled(true);
			btnBuscar_1.setEnabled(false);
			txtCodigo.setText("");
			txtNombre.setText("");
			txtCodigo.requestFocus();
		} else {
			txtNombre.setEditable(true);
			txtCodigo.setEditable(false);
			btnBuscar.setEnabled(false);
			btnBuscar_1.setEnabled(true);
			txtCodigo.setText("");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
	}

	// ---------------------------------------
	String leerNombre() {
		return txtNombre.getText().toString();
	}

	// --------------------------------------
	void consultarNombre() {
		Cliente clien = c.buscarNombres(leerNombre());
		if (clien != null) {
			Object datos[] = { clien.getCodCliente(), clien.getNombreCliente(), clien.getApellidoCliente(),
					clien.getDirrecion(), clien.getFechaNacimiento(), clien.getFechaAfiliacion(),
					clien.getEstadoCivil(), clien.getTelefono(), clien.getDNI(), clien.getUsuario(),
					clien.getContraseña() };
			dtm.addRow(datos);

			JOptionPane.showMessageDialog(null, "Cliente Encontrada", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			txtNombre.requestFocus();
		} else
			JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		txtNombre.requestFocus();
	}
	// ---------------------------------------------

	protected void do_btnBuscar_1_actionPerformed(ActionEvent arg0) {
		if (txtNombre.getText().equals("")) {
			mensaje("Ingrese Un Nombre");
			txtNombre.requestFocus();
		} else {
			consultarNombre();
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
