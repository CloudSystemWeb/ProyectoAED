package principal;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Component;

import javax.swing.Box;

import java.awt.Dimension;

import javax.swing.JDesktopPane;

import clases.Cliente;
import arraylist.ArregloCliente;
import java.awt.Toolkit;
import java.awt.Panel;
import javax.swing.JPanel;
import java.awt.ScrollPane;

public class Clientes extends JDialog implements ActionListener {

	ArregloCliente c = new ArregloCliente("Cliente.txt");
	int contador;

	private JLabel lblCdigo;
	private JLabel lblNombre;
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
	private JTextField txtNac;
	private JTextField txtTelefono;
	private JTextField txtDNI;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasea;
	private JTextField txtContraseña;
	private JLabel lblNaci;
	private JLabel lblafili;
	private JTextField txtafili;
	private JLabel lblDni;
	private JLabel lblTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
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
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/imagenes/CDC.jpg")));
		getContentPane().setForeground(new Color(106, 90, 205));
		getContentPane().setBackground(Color.WHITE);
		setTitle("REGISTRO DE LOS CLIENTES");
		setBounds(100, 100, 1020, 730);
		getContentPane().setLayout(null);

		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(new Color(0, 0, 0));
			lblCdigo.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(20, 105, 78, 14);
			getContentPane().add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBackground(Color.PINK);
			lblNombre.setForeground(Color.PINK);
			lblNombre.setBounds(20, 139, 46, 14);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido");
			lblApellido.setBackground(Color.PINK);
			lblApellido.setForeground(Color.PINK);
			lblApellido.setBounds(20, 178, 46, 14);
			getContentPane().add(lblApellido);
		}
		{
			lblTeléfono = new JLabel("Direccion");
			lblTeléfono.setForeground(Color.PINK);
			lblTeléfono.setBounds(20, 213, 67, 14);
			getContentPane().add(lblTeléfono);
		}
		{
			lblEstado = new JLabel("Estado Civil");
			lblEstado.setForeground(Color.PINK);
			lblEstado.setBounds(20, 299, 67, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBackground(Color.WHITE);
			txtCodigo.setBounds(108, 102, 86, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setText("" + c.codigoMayor(contador));
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBackground(Color.WHITE);
			txtNombre.addActionListener(this);
			txtNombre.setBounds(72, 136, 156, 20);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
			SLetras(txtNombre);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBackground(Color.WHITE);
			txtApellido.addActionListener(this);
			txtApellido.setBounds(72, 175, 156, 20);
			getContentPane().add(txtApellido);
			txtApellido.setColumns(10);
			SLetras(txtApellido);
		}
		{
			txtDirec = new JTextField();
			txtDirec.setBackground(Color.WHITE);
			txtDirec.addActionListener(this);
			txtDirec.setBounds(72, 206, 156, 20);
			getContentPane().add(txtDirec);
			txtDirec.setColumns(10);
			SNumeros(txtDirec);
		}
		{
			cbbEstado = new JComboBox();
			cbbEstado.setForeground(new Color(160, 82, 45));
			cbbEstado.setModel(new DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Viudo", "Divorsiado" }));
			cbbEstado.setBounds(94, 295, 134, 22);
			getContentPane().add(cbbEstado);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setForeground(Color.PINK);
			lblOpciones.setBounds(20, 440, 75, 14);
			getContentPane().add(lblOpciones);
		}
		{
			cbbOpciones = new JComboBox();
			cbbOpciones.setBackground(new Color(169, 169, 169));
			cbbOpciones.setForeground(new Color(128, 0, 0));
			cbbOpciones.addActionListener(this);
			cbbOpciones.setModel(new DefaultComboBoxModel(
					new String[] { "Ingresar", "Consultar", "Modificar", "Eliminar", "Listar" }));
			cbbOpciones.setBounds(94, 437, 134, 22);
			getContentPane().add(cbbOpciones);
		}
		{
			btnProcesar = new JButton("");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar.setBackground(new Color(169, 169, 169));
			btnProcesar.setForeground(new Color(0, 0, 205));
			btnProcesar.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/procesar.png")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(10, 604, 115, 47);
			getContentPane().add(btnProcesar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(361, 61, 625, 452);
			getContentPane().add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
				txtS.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
				txtS.setBackground(new Color(253, 245, 230));
			}
		}
		{
			btnSalir = new JButton("");
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSalir.setBackground(new Color(169, 169, 169));
			btnSalir.setForeground(new Color(0, 0, 205));
			btnSalir.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/cancelar.png")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(208, 604, 115, 47);
			getContentPane().add(btnSalir);
		}

		txtNac = new JTextField();
		txtNac.setColumns(10);
		txtNac.setBackground(Color.WHITE);
		txtNac.setBounds(72, 238, 156, 20);
		getContentPane().add(txtNac);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(72, 324, 156, 20);
		getContentPane().add(txtTelefono);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);
		txtDNI.setBounds(72, 352, 156, 20);
		getContentPane().add(txtDNI);
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setForeground(Color.PINK);
			lblUsuario.setBounds(20, 383, 67, 14);
			getContentPane().add(lblUsuario);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setColumns(10);
			txtUsuario.setBackground(Color.WHITE);
			txtUsuario.setBounds(72, 383, 156, 20);
			getContentPane().add(txtUsuario);
		}
		{
			lblContrasea = new JLabel("Clave");
			lblContrasea.setForeground(Color.PINK);
			lblContrasea.setBounds(20, 411, 63, 14);
			getContentPane().add(lblContrasea);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setColumns(10);
			txtContraseña.setBackground(Color.WHITE);
			txtContraseña.setBounds(72, 408, 156, 20);
			getContentPane().add(txtContraseña);
		}
		{
			lblNaci = new JLabel("Fec-Nac");
			lblNaci.setForeground(Color.PINK);
			lblNaci.setBounds(10, 241, 46, 14);
			getContentPane().add(lblNaci);
		}
		{
			lblafili = new JLabel("Fec-afil");
			lblafili.setForeground(Color.PINK);
			lblafili.setBounds(20, 270, 46, 14);
			getContentPane().add(lblafili);
		}

		txtafili = new JTextField();
		txtafili.setBackground(Color.WHITE);
		txtafili.setBounds(72, 269, 156, 20);
		getContentPane().add(txtafili);
		txtafili.setColumns(10);
		{
			lblDni = new JLabel("DNI");
			lblDni.setForeground(Color.PINK);
			lblDni.setBounds(16, 355, 46, 14);
			getContentPane().add(lblDni);
		}
		{
			lblTelefono = new JLabel("Telefono");
			lblTelefono.setForeground(Color.PINK);
			lblTelefono.setBounds(20, 324, 46, 14);
			getContentPane().add(lblTelefono);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/registrocliente.png")));
		lblNewLabel.setBounds(0, 0, 1004, 692);
		getContentPane().add(lblNewLabel);
		
		
		
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

	void ingresar() {
		if (leerNombre().equals("") || leerApellido().equals("") || leerTelefo().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Cliente clien = c.buscar(leerCod());
			if (clien == null) {
				clien = new Cliente(leerCod(), leerNombre(), leerApellido(), leerDireccion(), leerFecNac(),
						leerFecAfil(), leerEstadoCivil(), leerTelefo(), leerDNI(), leerUsuario(), leerContraseña());
				c.adicionar(clien);

				listar();
				txtCodigo.setText("" + c.codigoMayor(contador));

				// mensaje de confirmación
				JOptionPane.showMessageDialog(this, "Cliente Ingresado", "ALERTA", JOptionPane.WARNING_MESSAGE);

			} else
				mensaje("Código  ya existe");
		}
	}

	public void actulizaciones() {

		if (c.existeCliente()) {
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
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS CLIENTES " + "\n");
				imprimir(
						"Código \t Nombres \t Apellidos \t Direccion \t Fecha Nac \t Fecha Afil \t Estado Civil \tTeléfono \t DNI \t Usuario \t Contraseña");
				imprimir("");
				for (int i = 0; i < c.tamaño(); i++) {
					Cliente clien = c.obtener(i);
					imprimir(clien.getCodCliente() + "\t" + rellena(clien.getNombreCliente()) + "\t"
							+ clien.getApellidoCliente() + "\t" + clien.getDirrecion() + "\t"
							+ clien.getFechaNacimiento() + "\t" + clien.getFechaAfiliacion() + "\t"
							+ clien.getEstadoCivil() + "\t" + clien.getTelefono() + "\t" + clien.getDNI() + "\t"
							+ clien.getUsuario() + "\t" + clien.getContraseña());
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
		Cliente clien = c.buscar(leerCod());
		if (clien != null) {
			imprimir();
			imprimir(" \t REGISTRO DE DATOS" + "\n");
			imprimir(" a) Código          : " + clien.getCodCliente());
			imprimir(" b) Nombre Cliente     : " + clien.getNombreCliente());
			imprimir(" c) Apellido Cliente  : " + clien.getApellidoCliente());
			imprimir(" d) Direccion Cliente  : " + clien.getDirrecion());
			imprimir(" e) Fecha Nacimiento   : " + clien.getFechaNacimiento());
			imprimir(" f) Fecha Afiliacion  : " + clien.getFechaAfiliacion());
			imprimir(" g) Estado Civil      : " + clien.getEstadoCivil());
			imprimir(" h) Teléfono Cliente  : " + clien.getTelefono());
			imprimir(" i) DNI Cliente  : " + clien.getDNI());
			imprimir(" j) Usuario  : " + clien.getUsuario());
			imprimir(" k) Contraseña  : " + clien.getContraseña());

		} else
			JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	void modificar() {
		if (leerNombre().equals("") || leerApellido().equals("") || leerTelefo().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Cliente clien = c.buscar(leerCod());
			if (clien != null) {
				clien.setNombreCliente(leerNombre());
				clien.setApellidoCliente(leerApellido());
				clien.setDirrecion(leerDireccion());
				clien.setEstadoCivil(leerEstadoCivil());
				clien.setFechaNacimiento(leerFecNac());
				clien.setFechaAfiliacion(leerFecAfil());
				clien.setTelefono(leerTelefo());
				clien.setUsuario(leerUsuario());
				clien.setContraseña(leerContraseña());

				listar();
				// mensaje que muestre que el cliente ha sido modificado
				JOptionPane.showMessageDialog(null, "Cliente Modificado", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
	}

	void eliminar() {
		Cliente clien = c.buscar(leerCod());
		if (clien != null) {
			c.eliminar(clien);
			listar();
			// mensaje que muestre que el cliente ha sido eliminado
			JOptionPane.showMessageDialog(null, "Cliente Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

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

	public String leerNombre() {
		return (txtNombre.getText().toString());
	}

	public String leerApellido() {
		return (txtApellido.getText().toString());
	}

	public String leerDireccion() {
		return (txtDirec.getText().toString());
	}

	public int leerEstadoCivil() {
		return cbbEstado.getSelectedIndex();
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

	public String leerContraseña() {
		return (txtContraseña.getText().toString());
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
			lblNombre.setVisible(true);
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
			txtContraseña.setVisible(true);
			lblUsuario.setVisible(true);
			lblEstado.setVisible(true);
			lblContrasea.setVisible(true);
			lblUsuario.setVisible(true);
			lblNaci.setVisible(true);
			lblafili.setVisible(true);
			txtafili.setVisible(true);
			lblDni.setVisible(true);
			lblTelefono.setVisible(true);

		} else if (opcion == 1 || opcion == 3) {
			lblNombre.setVisible(false);
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
			txtContraseña.setVisible(false);
			lblUsuario.setVisible(false);
			lblContrasea.setVisible(false);
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
			lblNombre.setVisible(false);
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
			txtContraseña.setVisible(false);
			lblUsuario.setVisible(false);
			lblContrasea.setVisible(false);
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
