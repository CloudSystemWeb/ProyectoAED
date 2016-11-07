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


import clases.Empleado;

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
		setTitle("REGISTRO DE LOS EMPLEADOS");
		setBounds(100, 100, 1020, 730);
		getContentPane().setLayout(null);

		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCdigo.setForeground(new Color(0, 0, 0));
			lblCdigo.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(10, 131, 99, 14);
			getContentPane().add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNombre.setBackground(Color.PINK);
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setBounds(37, 167, 86, 14);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido");
			lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblApellido.setBackground(Color.PINK);
			lblApellido.setForeground(Color.BLACK);
			lblApellido.setBounds(37, 218, 99, 17);
			getContentPane().add(lblApellido);
		}
		{
			lblTipoEmpleado = new JLabel("Estado Civil");
			lblTipoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTipoEmpleado.setForeground(Color.BLACK);
			lblTipoEmpleado.setBounds(23, 264, 99, 18);
			getContentPane().add(lblTipoEmpleado);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtCodigo.setBackground(Color.WHITE);
			txtCodigo.setBounds(133, 128, 181, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setText("" + c.codigoMayor(contador));
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtNombre.setBackground(Color.WHITE);
			txtNombre.addActionListener(this);
			txtNombre.setBounds(133, 167, 181, 20);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
			SLetras(txtNombre);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtApellido.setBackground(Color.WHITE);
			txtApellido.addActionListener(this);
			txtApellido.setBounds(133, 215, 181, 20);
			getContentPane().add(txtApellido);
			txtApellido.setColumns(10);
			SLetras(txtApellido);
		}
		{
			cbbEstado = new JComboBox();
			cbbEstado.setFont(new Font("Tahoma", Font.PLAIN, 17));
			cbbEstado.setForeground(new Color(160, 82, 45));
			cbbEstado.setModel(new DefaultComboBoxModel(new String[] { "Administrador\t", "Supervisor\t", "Cajero" }));
			cbbEstado.setBounds(133, 260, 181, 22);
			getContentPane().add(cbbEstado);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblOpciones.setForeground(Color.BLACK);
			lblOpciones.setBounds(37, 400, 99, 18);
			getContentPane().add(lblOpciones);
		}
		{
			cbbOpciones = new JComboBox();
			cbbOpciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
			cbbOpciones.setBackground(new Color(169, 169, 169));
			cbbOpciones.setForeground(new Color(128, 0, 0));
			cbbOpciones.addActionListener(this);
			cbbOpciones.setModel(new DefaultComboBoxModel(
					new String[] { "Ingresar", "Consultar", "Modificar", "Eliminar", "Listar" }));
			cbbOpciones.setBounds(133, 398, 181, 22);
			getContentPane().add(cbbOpciones);
		}
		{
			btnProcesar = new JButton("");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar.setBackground(new Color(169, 169, 169));
			btnProcesar.setForeground(new Color(0, 0, 205));
			btnProcesar.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/procesar.png")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(53, 509, 115, 47);
			getContentPane().add(btnProcesar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(375, 110, 619, 554);
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
			btnSalir.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/cancelar.png")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(199, 509, 115, 47);
			getContentPane().add(btnSalir);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblUsuario.setForeground(Color.BLACK);
			lblUsuario.setBounds(37, 311, 99, 17);
			getContentPane().add(lblUsuario);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtUsuario.setColumns(10);
			txtUsuario.setBackground(Color.WHITE);
			txtUsuario.setBounds(133, 308, 181, 20);
			getContentPane().add(txtUsuario);
		}
		{
			lblContrasea = new JLabel("Clave");
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblContrasea.setForeground(Color.BLACK);
			lblContrasea.setBounds(36, 355, 87, 14);
			getContentPane().add(lblContrasea);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtContraseña.setColumns(10);
			txtContraseña.setBackground(Color.WHITE);
			txtContraseña.setBounds(133, 355, 181, 20);
			getContentPane().add(txtContraseña);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/registroempleado.png")));
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
				JOptionPane.showMessageDialog(this, "Empleado Ingresado", "ALERTA", JOptionPane.WARNING_MESSAGE);

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
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS EMPLEADOS " + "\n");
				imprimir(
						"Código \t Nombres \t Apellidos \t Tipo Empleado \t  Usuario \t Contraseña");
				imprimir("");
				for (int i = 0; i < c.tamaño(); i++) {
					Empleado clien = c.obtener(i);
					imprimir(clien.getCodEmpleado() + "\t" + rellena(clien.getNombreEmpleado()) + "\t"
							+ clien.getApellidoEmpleado() + "\t" + "\t" + clien.getUsuario() + "\t"
							+ clien.getContraseña());
				}
				imprimir("");
				imprimir("Total de Empleados : " + c.tamaño());
			} else
				imprimir("No hay Empleados.......");
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
			JOptionPane.showMessageDialog(null, "Empleado no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
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
				// mensaje que muestre que el empleado ha sido modificado
				JOptionPane.showMessageDialog(null, "Empleado Modificado", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Empleado no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
	}

	void eliminar() {
		Empleado clien = c.buscar(leerCod());
		if (clien != null) {
			c.eliminar(clien);
			listar();
			// mensaje que muestre que el Empleado ha sido eliminado
			JOptionPane.showMessageDialog(null, "Empleado Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Empleado no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

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
