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

import clases.Cine;
import arraylist.ArregloCine;


public class Cines extends JDialog implements ActionListener {
	ArregloCine c = new ArregloCine("Cine.txt");
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
	private JLabel lblNaci;
	private JLabel lblafili;
	private JTextField txtafili;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cines dialog = new Cines();
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
	public Cines() {
		getContentPane().setForeground(new Color(106, 90, 205));
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("REGISTRO DE LOS CINES");
		setBounds(100, 100, 1020, 730);
		getContentPane().setLayout(null);

		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCdigo.setForeground(new Color(0, 0, 0));
			lblCdigo.setIcon(new ImageIcon(Cines.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(24, 181, 101, 14);
			getContentPane().add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNombre.setBackground(Color.PINK);
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setBounds(24, 224, 101, 14);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("Departamento");
			lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblApellido.setBackground(Color.PINK);
			lblApellido.setForeground(Color.BLACK);
			lblApellido.setBounds(24, 265, 115, 14);
			getContentPane().add(lblApellido);
		}
		{
			lblTeléfono = new JLabel("Provincia");
			lblTeléfono.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTeléfono.setForeground(Color.BLACK);
			lblTeléfono.setBounds(24, 302, 101, 14);
			getContentPane().add(lblTeléfono);
		}
		{
			lblEstado = new JLabel("Tipo");
			lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblEstado.setForeground(Color.BLACK);
			lblEstado.setBounds(24, 414, 101, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtCodigo.setBackground(Color.WHITE);
			txtCodigo.setBounds(164, 181, 156, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setText("" + c.codigoMayor(contador));
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtNombre.setBackground(Color.WHITE);
			txtNombre.addActionListener(this);
			txtNombre.setBounds(164, 224, 156, 20);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
			SLetras(txtNombre);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtApellido.setBackground(Color.WHITE);
			txtApellido.addActionListener(this);
			txtApellido.setBounds(164, 265, 156, 20);
			getContentPane().add(txtApellido);
			txtApellido.setColumns(10);
			SLetras(txtApellido);
		}
		{
			txtDirec = new JTextField();
			txtDirec.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtDirec.setBackground(Color.WHITE);
			txtDirec.addActionListener(this);
			txtDirec.setBounds(164, 302, 156, 20);
			getContentPane().add(txtDirec);
			txtDirec.setColumns(10);
			SNumeros(txtDirec);
		}
		{
			cbbEstado = new JComboBox();
			cbbEstado.setFont(new Font("Tahoma", Font.PLAIN, 17));
			cbbEstado.setForeground(new Color(160, 82, 45));
			cbbEstado.setModel(new DefaultComboBoxModel(new String[] {"Estandar", "Prime"}));
			cbbEstado.setBounds(164, 413, 156, 22);
			getContentPane().add(cbbEstado);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblOpciones.setForeground(Color.BLACK);
			lblOpciones.setBounds(24, 451, 101, 14);
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
			cbbOpciones.setBounds(164, 450, 156, 22);
			getContentPane().add(cbbOpciones);
		}
		{
			btnProcesar = new JButton("");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar.setBackground(new Color(169, 169, 169));
			btnProcesar.setForeground(new Color(0, 0, 205));
			btnProcesar.setIcon(new ImageIcon(Cines.class.getResource("/imagenes/procesar.png")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(24, 550, 115, 47);
			getContentPane().add(btnProcesar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(357, 123, 637, 558);
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
			btnSalir.setIcon(new ImageIcon(Cines.class.getResource("/imagenes/cancelar.png")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(205, 550, 115, 47);
			getContentPane().add(btnSalir);
		}

		txtNac = new JTextField();
		txtNac.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNac.setColumns(10);
		txtNac.setBackground(Color.WHITE);
		txtNac.setBounds(164, 338, 156, 20);
		getContentPane().add(txtNac);
		{
			lblNaci = new JLabel("Distrito");
			lblNaci.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNaci.setForeground(Color.BLACK);
			lblNaci.setBounds(24, 344, 111, 14);
			getContentPane().add(lblNaci);
		}
		{
			lblafili = new JLabel("Fecha-Ini");
			lblafili.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblafili.setForeground(Color.BLACK);
			lblafili.setBounds(24, 373, 101, 14);
			getContentPane().add(lblafili);
		}

		txtafili = new JTextField();
		txtafili.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtafili.setBackground(Color.WHITE);
		txtafili.setBounds(164, 373, 156, 20);
		getContentPane().add(txtafili);
		txtafili.setColumns(10);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Cines.class.getResource("/imagenes/registrocine.png")));
			lblNewLabel.setBounds(0, 0, 1004, 692);
			getContentPane().add(lblNewLabel);
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
		if (leerNombre().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Cine clien = c.buscar(leerCod());
			if (clien == null) {
				clien = new Cine(leerCod(), leerNombre(), leerDepartamento(), leerProvincia(),
						leerDistri(),leerFechaAfiliacion(), leerEstadoCivil());
				c.adicionar(clien);

				listar();
				txtCodigo.setText("" + c.codigoMayor(contador));

				// mensaje de confirmación
				JOptionPane.showMessageDialog(this, "Cine Ingresado", "ALERTA", JOptionPane.WARNING_MESSAGE);

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
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS CINES " + "\n");
				imprimir(
						"Código \t Nombres \t Departamento \t Provincia \t Distrito \t Fecha  \t Estado");
				imprimir("");
				for (int i = 0; i < c.tamaño(); i++) {
					Cine clien = c.obtener(i);
					imprimir(clien.getCodCine() + "\t" + rellena(clien.getNombre()) + "\t"
							+ clien.getDepartamento() + "\t" + clien.getProvincia() + "\t"
							+ clien.getDistrito() + "\t" + clien.getFechaIniOper() + "\t"
							+ clien.getEstadoCine()) ;
				imprimir("");
				imprimir("Total de Cines : " + c.tamaño());
				}
			} else
				imprimir("No hay Cines.......");
		} catch (Exception e) {
			mensaje("Ingrese Datos");
		}
	}

	void consultar() {
		Cine clien = c.buscar(leerCod());
		if (clien != null) {
			imprimir();
			imprimir(" \t REGISTRO DE DATOS" + "\n");
			imprimir(" a) Código          : " + clien.getCodCine());
			imprimir(" b) Nombre      : " + clien.getNombre());
			imprimir(" c) Departament  : " + clien.getDepartamento());
			imprimir(" d) Provincia   : " + clien.getProvincia());
			imprimir(" e) Distrito    : " + clien.getDistrito());
			imprimir(" f) Fecha   : " + clien.getFechaIniOper());
			imprimir(" g) Estado      : " + clien.getEstadoCine());
		
			

		} else
			JOptionPane.showMessageDialog(null, "Cine no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	void modificar() {
		if (leerNombre().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Cine clien = c.buscar(leerCod());
			if (clien != null) {
				clien.setNombre(leerNombre());
				clien.setDepartamento(leerDepartamento());
				clien.setProvincia(leerProvincia());
				clien.setDistrito(leerDistri());
				clien.setFechaIniOper(leerFechaAfiliacion());
				clien.setEstadoCine(leerEstadoCivil());
			
				listar();
				// mensaje que muestre que el cliente ha sido modificado
				JOptionPane.showMessageDialog(null, "Cine Modificado", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Cine no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
	}

	void eliminar() {
		Cine clien = c.buscar(leerCod());
		if (clien != null) {
			c.eliminar(clien);
			listar();
			// mensaje que muestre que el cliente ha sido eliminado
			JOptionPane.showMessageDialog(null, "Cine Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Cine no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

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

	public String leerDepartamento() {
		return (txtApellido.getText().toString());
	}

	public String leerProvincia() {
		return (txtDirec.getText().toString());
	}

	public int leerEstadoCivil() {
		return cbbEstado.getSelectedIndex();
	}

	public String leerDistri() {
		return (txtNac.getText().toString());
	}

	public String leerFechaAfiliacion() {
		return (txtafili.getText().toString());
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
		
			
			txtNac.setVisible(true);
		
			lblEstado.setVisible(true);
			
			lblNaci.setVisible(true);
			lblafili.setVisible(true);
			txtafili.setVisible(true);
		

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
			
			txtNac.setVisible(false);
			
			lblEstado.setVisible(false);
			txtNac.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);

			lblNaci.setVisible(false);
			lblafili.setVisible(false);
			txtafili.setVisible(false);
		

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
		
			txtNac.setVisible(false);
			
			lblEstado.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);

			lblNaci.setVisible(false);
			lblafili.setVisible(false);
			txtafili.setVisible(false);
		

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
