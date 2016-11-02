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
import clases.Empleado;
import arraylist.ArregloCliente;
import arraylist.ArregloEmpleado;

public class Empleados extends JDialog implements ActionListener {

	ArregloEmpleado c = new ArregloEmpleado("Empleado.txt");
	int contador;

	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTipoEmpleado;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JComboBox cbbEstado;
	private JLabel lblOpciones;
	private JComboBox cbbOpciones;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JButton btnSalir;
	// private JLabel lblFecNac1;

	private JTextArea txtS;
	private JDesktopPane desktopPane;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasea;
	private JTextField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleados dialog = new Empleados();
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
	public Empleados() {
		getContentPane().setForeground(new Color(106, 90, 205));
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("REGISTRO DE LOS CLIENTES CLIENTES");
		setBounds(100, 100, 651, 457);
		getContentPane().setLayout(null);

		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(new Color(0, 0, 0));
			lblCdigo.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(10, 11, 78, 14);
			getContentPane().add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBackground(Color.PINK);
			lblNombre.setForeground(Color.PINK);
			lblNombre.setBounds(10, 45, 46, 14);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido");
			lblApellido.setBackground(Color.PINK);
			lblApellido.setForeground(Color.PINK);
			lblApellido.setBounds(10, 84, 46, 14);
			getContentPane().add(lblApellido);
		}
		{
			lblTipoEmpleado = new JLabel("Estado Civil");
			lblTipoEmpleado.setForeground(Color.PINK);
			lblTipoEmpleado.setBounds(10, 253, 67, 14);
			getContentPane().add(lblTipoEmpleado);
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
			cbbEstado = new JComboBox();
			cbbEstado.setForeground(new Color(160, 82, 45));
			cbbEstado.setModel(new DefaultComboBoxModel(new String[] { "Administrador\t", "Supervisor\t", "Cajero" }));
			cbbEstado.setBounds(84, 249, 134, 22);
			getContentPane().add(cbbEstado);
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
			btnProcesar.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/procesar.gif")));
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
			btnSalir.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/exit_button.gif")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(139, 376, 122, 32);
			getContentPane().add(btnSalir);
		}

		{
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(Color.RED);
			desktopPane.setBounds(228, 11, 17, 361);
			getContentPane().add(desktopPane);
		}
		{
			lblUsuario = new JLabel("Usuario");
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
			lblContrasea = new JLabel("Clave");
			lblContrasea.setForeground(Color.PINK);
			lblContrasea.setBounds(10, 317, 63, 14);
			getContentPane().add(lblContrasea);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setColumns(10);
			txtContraseña.setBackground(Color.WHITE);
			txtContraseña.setBounds(62, 314, 156, 20);
			getContentPane().add(txtContraseña);
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

	void ingresar() {
		if (leerNombre().equals("") || leerApellido().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Empleado emple = c.buscar(leerCod());
			if (emple == null) {
				Empleado clien = new Empleado(leerCod(), leerNombre(), leerApellido(), leerEstadoCivil(), leerUsuario(),
						leerContraseña());
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

		if (c.existeEmpleado()) {
			int ok = 0;
			if (ok == 0) {
				c.grabarEmpleado();
			} else
				c.getEmpleado();
		} else {
			c.grabarEmpleado();
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
					Empleado clien = c.obtener(i);
					imprimir(clien.getCodEmpleado() + "\t" + rellena(clien.getNombreEmpleado()) + "\t"
							+ clien.getApellidoEmpleado() + "\t" + "\t" + clien.getUsuario() + "\t"
							+ clien.getContraseña());
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
		Empleado clien = c.buscar(leerCod());
		if (clien != null) {
			imprimir();
			imprimir(" \t REGISTRO DE DATOS" + "\n");
			imprimir(" a) Código          : " + clien.getCodEmpleado());
			imprimir(" b) Nombre Empleado     : " + clien.getNombreEmpleado());
			imprimir(" c) Apellido   : " + clien.getApellidoEmpleado());
			imprimir(" g) TipoEmpleado      : " + clien.getTipoEmpleado());
			imprimir(" j) Usuario  : " + clien.getUsuario());
			imprimir(" k) Contraseña  : " + clien.getContraseña());

		} else
			JOptionPane.showMessageDialog(null, "Cliente no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	void modificar() {
		if (leerNombre().equals("") || leerApellido().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Empleado clien = c.buscar(leerCod());
			if (clien != null) {
				clien.setNombreEmpleado(leerNombre());
				clien.setApellidoEmpleado(leerApellido());
				clien.setTipoEmpleado(leerEstadoCivil());
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
		Empleado clien = c.buscar(leerCod());
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

	public int leerEstadoCivil() {
		return cbbEstado.getSelectedIndex();
	}

	public String leerUsuario() {
		return (txtUsuario.getText().toString());
	}

	public String leerContraseña() {
		return (txtContraseña.getText().toString());
	}

	public int leerCod() {
		return Integer.parseInt(txtCodigo.getText());
	}

	public void limpiar() {
		txtApellido.setText("");
		txtNombre.setText("");
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

			lblTipoEmpleado.setVisible(true);
			txtNombre.setVisible(true);
			txtApellido.setVisible(true);
			cbbEstado.setVisible(true);
			lblCdigo.setVisible(true);

			txtCodigo.setVisible(true);

			txtUsuario.setVisible(true);
			txtContraseña.setVisible(true);
			lblUsuario.setVisible(true);
			lblTipoEmpleado.setVisible(true);
			lblContrasea.setVisible(true);
			lblUsuario.setVisible(true);

		} else if (opcion == 1 || opcion == 3) {
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);

			lblTipoEmpleado.setVisible(false);
			txtNombre.setVisible(false);
			txtApellido.setVisible(false);
			cbbEstado.setVisible(false);

			txtCodigo.setVisible(true);
			lblCdigo.setVisible(true);

			txtUsuario.setVisible(false);
			txtContraseña.setVisible(false);
			lblUsuario.setVisible(false);
			lblContrasea.setVisible(false);
			lblTipoEmpleado.setVisible(false);

			lblTipoEmpleado.setVisible(false);

		} else {
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);

			lblTipoEmpleado.setVisible(false);
			txtNombre.setVisible(false);
			txtApellido.setVisible(false);
			cbbEstado.setVisible(false);

			txtCodigo.setVisible(false);
			lblCdigo.setVisible(false);

			txtUsuario.setVisible(false);
			txtContraseña.setVisible(false);
			lblUsuario.setVisible(false);
			lblContrasea.setVisible(false);
			lblTipoEmpleado.setVisible(false);

			lblTipoEmpleado.setVisible(false);

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
