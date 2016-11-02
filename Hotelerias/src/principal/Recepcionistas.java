package principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;

import clases.Recepcionista;
import arraylist.ArregloRecepcionista;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JDesktopPane;

public class Recepcionistas extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblTelfono;
	private JLabel lblApellido;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JLabel lblOpciones;
	private JComboBox cbbOpciones;
	private JLabel lblSexo;
	private JButton btnProcesar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblEstado;
	private JComboBox cbbEstado;

	int contador;
	ArregloRecepcionista r = new ArregloRecepcionista("Recepcionista.txt");
	private JComboBox cbbsexo;
	private JDesktopPane desktopPane;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Recepcionistas dialog = new Recepcionistas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Recepcionistas() {
		setTitle("RECEPCIONISTA");
		setBounds(100, 100, 637, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(new Color(255, 255, 255));
			lblCdigo.setIcon(new ImageIcon(Recepcionistas.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(10, 11, 79, 14);
			contentPanel.add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(new Color(255, 255, 255));
			lblNombre.setBounds(10, 53, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblTelfono = new JLabel("Tel\u00E9fono");
			lblTelfono.setForeground(new Color(255, 255, 255));
			lblTelfono.setBounds(268, 11, 58, 14);
			contentPanel.add(lblTelfono);
		}
		{
			lblApellido = new JLabel("Apellido");
			lblApellido.setForeground(new Color(255, 255, 255));
			lblApellido.setBounds(10, 93, 46, 14);
			contentPanel.add(lblApellido);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Candara", Font.ITALIC, 16));
			txtCodigo.setForeground(new Color(0, 0, 0));
			txtCodigo.addActionListener(this);
			txtCodigo.setBounds(99, 8, 86, 20);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
			SNumeros(txtCodigo);
			txtCodigo.setText("" + r.codigoMayor(contador));
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Candara", Font.ITALIC, 16));
			txtNombre.setForeground(new Color(0, 0, 0));
			txtNombre.addActionListener(this);
			txtNombre.setBounds(62, 50, 176, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
			SLetras(txtNombre);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setFont(new Font("Candara", Font.ITALIC, 16));
			txtApellido.setForeground(new Color(0, 0, 0));
			txtApellido.addActionListener(this);
			txtApellido.setBounds(62, 90, 176, 20);
			contentPanel.add(txtApellido);
			txtApellido.setColumns(10);
			SLetras(txtApellido);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setFont(new Font("Candara", Font.ITALIC, 16));
			txtTelefono.setForeground(new Color(0, 0, 0));
			txtTelefono.addActionListener(this);
			txtTelefono.setBounds(324, 8, 111, 20);
			contentPanel.add(txtTelefono);
			txtTelefono.setColumns(10);
			SNumeros(txtTelefono);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setForeground(Color.BLACK);
			lblOpciones.setBounds(443, 93, 58, 14);
			contentPanel.add(lblOpciones);
		}
		{
			cbbOpciones = new JComboBox();
			cbbOpciones.addActionListener(this);
			cbbOpciones.setModel(new DefaultComboBoxModel(
					new String[] { "Ingresar", "Consultar", "Modificar", "Eliminar", "Listar" }));
			cbbOpciones.setBounds(502, 90, 110, 20);
			contentPanel.add(cbbOpciones);
		}
		{
			lblSexo = new JLabel("Sexo");
			lblSexo.setForeground(new Color(255, 255, 255));
			lblSexo.setBounds(268, 53, 46, 14);
			contentPanel.add(lblSexo);
		}
		{
			btnProcesar = new JButton("      Procesar");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnProcesar.setForeground(Color.BLUE);
			btnProcesar.setBackground(new Color(245, 255, 250));
			btnProcesar.setIcon(new ImageIcon(Recepcionistas.class.getResource("/imagenes/procesar.gif")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(476, 4, 136, 38);
			contentPanel.add(btnProcesar);
		}
		{
			btnSalir = new JButton("");
			btnSalir.setBackground(Color.LIGHT_GRAY);
			btnSalir.setIcon(new ImageIcon(Recepcionistas.class.getResource("/imagenes/exit_button.gif")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(501, 53, 111, 33);
			contentPanel.add(btnSalir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 122, 601, 205);
			contentPanel.add(scrollPane);
			{
				txtS = new JTextArea();
				txtS.setForeground(new Color(0, 0, 0));
				txtS.setBackground(new Color(253, 245, 230));
				scrollPane.setViewportView(txtS);
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS RECEPCIONISTAS " + "\n");
			}
		}
		{
			lblEstado = new JLabel("Estado");
			lblEstado.setForeground(new Color(255, 255, 255));
			lblEstado.setBounds(268, 93, 46, 14);
			contentPanel.add(lblEstado);
		}
		{
			cbbEstado = new JComboBox();
			cbbEstado.addActionListener(this);
			cbbEstado.setForeground(new Color(160, 82, 45));
			cbbEstado.setModel(new DefaultComboBoxModel(new String[] { "Activo", "Anulado" }));
			cbbEstado.setBounds(324, 90, 111, 20);
			contentPanel.add(cbbEstado);
		}
		{
			cbbsexo = new JComboBox();
			cbbsexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
			cbbsexo.setBounds(324, 50, 111, 20);
			contentPanel.add(cbbsexo);
		}
		{
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(Color.RED);
			desktopPane.setBounds(245, 11, 12, 102);
			contentPanel.add(desktopPane);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(
					Recepcionistas.class.getResource("/imagenes/descarga-fondos-abstractos-de-colores-1.jpg")));
			label.setBounds(0, 0, 621, 338);
			contentPanel.add(label);
		}
		codigo();
		listar();

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cbbEstado) {
			do_cbbEstado_actionPerformed(arg0);
		}
		if (arg0.getSource() == txtTelefono) {
			do_txtTelefono_actionPerformed(arg0);
		}
		if (arg0.getSource() == txtApellido) {
			do_txtApellido_actionPerformed(arg0);
		}
		if (arg0.getSource() == txtNombre) {
			do_txtNombre_actionPerformed(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			do_txtCodigo_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == cbbOpciones) {
			do_cbbOpciones_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		limpieza();
	}

	protected void do_btnProcesar_actionPerformed(ActionEvent arg0) {
		procesar();

	}

	void procesar() {
		switch (cbbOpciones.getSelectedIndex()) {
		case 0:
			ingresar();
			Actualizaciones();
			break;
		case 1:
			consultar();
			break;
		case 2:
			modificar();
			break;
		case 3:
			eliminar();
			Actualizaciones();
		default:
			listar();
		}
	}

	void ingresar() {
		if (leerNombreRecep().equals("") || leerApellidoRecep().equals("") || leerTelefono().equals("")) {
			mensaje("Ingrese Datos Por Favor");
			System.out.println("Error : No se Ingresaron  los Datos En forma Correcta...........");
		} else {
			Recepcionista Recep = r.buscar(leerCodigo());
			if (Recep == null) {
				Recep = new Recepcionista(leerCodigo(), leerNombreRecep(), leerApellidoRecep(), leerTelefono(),
						leerEstado(), leerSexo());
				Recep.Tipo();
				r.adicionar(Recep);
				listar();
				txtCodigo.setText("" + r.codigoMayor(contador));
				mensaje();
			} else {
				mensajeError();
			}
		}
	}

	// actualizaciones

	public void Actualizaciones() {
		if (r.existeArchivo()) {
			int ok = 0;
			if (ok == 0) {
				r.grabarRecepcionista();
				r.getArchivo();
			} else
				r.getArchivo();
		} else {
			r.grabarRecepcionista();
		}
	}

	// mensajess
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void listar() {
		imprimir();
		if (r.tamaño() > 0) {
			txtS.setText("\t\t REGISTRO DE DATOS DE LOS RECEPCIONISTAS " + "\n");
			imprimir("Código \t Nombre \t Apellidos \t\t Teléfono  \t Estado \t Sexo \n");
			for (int i = 0; i < r.tamaño(); i++) {
				Recepcionista Recep = r.obtener(i);
				imprimir(
						Recep.getCodigo() + "\t"
								+ rellena(Recep.getNombreRecepcionista() + "\t" + Recep.getApellidoRecepcionista()
										+ "\t" + Recep.getTelefonoRecepcionista() + "\t" + Recep.Tipo() + "\t"
										+ Recep.Sexo()));

			}
			imprimir("");
			imprimir("Total de Recepcionistas : " + r.tamaño());

		} else
			imprimir("No hay Recepcionistas...................");

	}

	void modificar() {
		if (leerApellidoRecep().equals("") || leerApellidoRecep().equals("") || leerTelefono().equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtNombre.requestFocus();
		} else {
			Recepcionista Recep = r.buscar(leerCodigo());
			if (Recep != null) {
				Recep.setNombreRecepcionista(leerNombreRecep());
				Recep.setApellidoRecepcionista(leerApellidoRecep());
				Recep.setTelefonoRecepcionista(leerTelefono());
				Recep.setEstado(leerEstado());
				Recep.Tipo();
				Recep.Sexo();
				listar();
				JOptionPane.showMessageDialog(null, "Recepcionista Modificado", "ALERTA",
						JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Recepcionista no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
	}

	void consultar() {
		imprimir();
		Recepcionista recep = r.buscar(leerCodigo());
		if (recep != null) {
			txtS.setText("\t\t REGISTRO DE DATOS DE LOS RECEPCIONISTAS " + "\n");
			imprimir("Código          : " + recep.getCodigo());
			imprimir("Descripción de la Recepcionista  : " + recep.getNombreRecepcionista());
			imprimir("Apellido de la Recepcionista  : " + recep.getApellidoRecepcionista());
			imprimir("Telefono de la Recepcionista  : " + recep.getTelefonoRecepcionista());
			imprimir("Estado del Recepcionista  : " + recep.Tipo());
			imprimir("Genero del recepcionista : " + recep.Sexo());

			JOptionPane.showMessageDialog(null, "Recepcionista Encontrada", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Recepcionista no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	void eliminar() {
		Recepcionista recep = r.buscar(leerCodigo());
		if (recep != null) {
			r.eliminar(recep);
			txtS.setText("                                                                REGISTRO DE DATOS" + "\n");
			listar();
			JOptionPane.showMessageDialog(null, "Recepcionista Eliminada", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Recepcionista no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

	}

	// --------------------------------------------------------------------
	void mensajeError() {
		JOptionPane.showMessageDialog(this, "Codigo ya existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	String rellena(String cad) {
		int longitud = cad.length();
		for (int i = longitud; i < 15; i++)
			cad += " ";
		return cad;
	}

	void mensaje() {
		JOptionPane.showMessageDialog(this, "Recepcionista Ingresado", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
	}

	void imprimir() {
		txtS.setText("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	public int leerEstado() {
		return cbbEstado.getSelectedIndex();
	}

	public String leerNombreRecep() {
		return (txtNombre.getText().toString());
	}

	public String leerApellidoRecep() {
		return (txtApellido.getText().toString());
	}

	public String leerTelefono() {
		return txtTelefono.getText().toString();
	}

	public int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	public int leerSexo() {
		return cbbsexo.getSelectedIndex();
	}

	protected void do_cbbOpciones_actionPerformed(ActionEvent arg0) {
		codigo();
		mostrarIconos();
	}

	public void mostrarIconos() {
		if (cbbOpciones.getSelectedIndex() == 0 || cbbOpciones.getSelectedIndex() == 2) {
			lblCdigo.setVisible(true);
			txtCodigo.setVisible(true);
			lblApellido.setVisible(true);
			txtApellido.setVisible(true);
			lblNombre.setVisible(true);
			txtNombre.setVisible(true);
			lblTelfono.setVisible(true);
			txtTelefono.setVisible(true);
			lblEstado.setVisible(true);
			cbbEstado.setVisible(true);
			lblOpciones.setVisible(true);
			cbbOpciones.setVisible(true);
			lblSexo.setVisible(true);
			cbbsexo.setVisible(true);
		} else if (cbbOpciones.getSelectedIndex() == 1 || cbbOpciones.getSelectedIndex() == 3) {
			lblCdigo.setVisible(true);
			txtCodigo.setVisible(true);
			lblApellido.setVisible(false);
			txtApellido.setVisible(false);
			lblNombre.setVisible(false);
			txtNombre.setVisible(false);
			lblTelfono.setVisible(false);
			txtTelefono.setVisible(false);
			lblEstado.setVisible(false);
			cbbEstado.setVisible(false);
			lblOpciones.setVisible(true);
			cbbOpciones.setVisible(true);
			lblSexo.setVisible(false);
			cbbsexo.setVisible(false);
		}

		else {
			lblCdigo.setVisible(false);
			txtCodigo.setVisible(false);
			lblApellido.setVisible(false);
			txtApellido.setVisible(false);
			lblNombre.setVisible(false);
			txtNombre.setVisible(false);
			lblTelfono.setVisible(false);
			txtTelefono.setVisible(false);
			lblEstado.setVisible(false);
			cbbEstado.setVisible(false);
			lblOpciones.setVisible(true);
			cbbOpciones.setVisible(true);
			lblSexo.setVisible(false);
			cbbsexo.setVisible(false);
		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		int dato = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea Salir", "ALERTA",
				JOptionPane.WARNING_MESSAGE);
		if (dato == 0) {
			this.dispose();
		}
	}

	public void limpieza() {
		txtApellido.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		cbbEstado.setSelectedIndex(0);
		cbbsexo.setSelectedIndex(0);
	}

	void codigo() {
		if (cbbOpciones.getSelectedIndex() == 0) {
			txtCodigo.setEditable(false);
			cbbEstado.setEnabled(false);
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

	protected void do_txtCodigo_actionPerformed(ActionEvent arg0) {
		txtCodigo.requestFocus();
	}

	protected void do_txtNombre_actionPerformed(ActionEvent arg0) {
		txtNombre.requestFocus();
	}

	protected void do_txtApellido_actionPerformed(ActionEvent arg0) {
		txtApellido.requestFocus();
	}

	protected void do_txtTelefono_actionPerformed(ActionEvent arg0) {
		txtTelefono.requestFocus();
	}

	protected void do_cbbEstado_actionPerformed(ActionEvent arg0) {
		cbbEstado.requestFocus();
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
