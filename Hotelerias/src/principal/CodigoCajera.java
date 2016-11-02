package principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.ImageIcon;

import clases.Cajera;
import clases.Cliente;
import arraylist.ArregloCajera;

import java.awt.Font;

public class CodigoCajera extends JDialog implements ActionListener, MouseListener {

	ArregloCajera p = new ArregloCajera("Cajero.txt");
	int contador;

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblSexo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCodigo;
	private JTextField txtDni;
	private JComboBox cboSexo;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JLabel lblOpciones;
	private JComboBox cboOpcion;

	private JScrollPane scrollPane;
	public DefaultTableModel dtm;
	String cabecera[] = { "Código", "Nombres", "Apellidos", "Teléfono", "Sexo" };
	private JTable table;
	int posicicon;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CodigoCajera dialog = new CodigoCajera();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CodigoCajera() {
		setTitle("Datos de las Cajeras (os)");
		setBounds(100, 100, 636, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(Color.WHITE);
			lblCdigo.setBounds(10, 11, 46, 14);
			contentPanel.add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setBounds(10, 49, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido");
			lblApellido.setForeground(Color.WHITE);
			lblApellido.setBounds(10, 89, 46, 14);
			contentPanel.add(lblApellido);
		}
		{
			lblDni = new JLabel("DNI");
			lblDni.setForeground(Color.WHITE);
			lblDni.setBounds(251, 11, 46, 14);
			contentPanel.add(lblDni);
		}
		{
			lblSexo = new JLabel("Sexo");
			lblSexo.setForeground(Color.WHITE);
			lblSexo.setBounds(251, 49, 46, 14);
			contentPanel.add(lblSexo);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(66, 46, 175, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
			SLetras(txtNombre);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(66, 86, 175, 20);
			contentPanel.add(txtApellido);
			txtApellido.setColumns(10);
			SLetras(txtApellido);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(63, 8, 86, 20);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setText("" + p.codigoMayor(contador));
			SNumeros(txtCodigo);
		}
		{
			txtDni = new JTextField();
			txtDni.setBounds(306, 8, 121, 20);
			contentPanel.add(txtDni);
			txtDni.setColumns(10);
			SNumeros(txtDni);
		}
		{
			cboSexo = new JComboBox();
			cboSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
			cboSexo.setBounds(306, 46, 121, 20);
			contentPanel.add(cboSexo);
		}
		{
			btnIngresar = new JButton("Procesar");
			btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnIngresar.setForeground(Color.BLUE);
			btnIngresar.addActionListener(this);
			btnIngresar.setBounds(476, 11, 89, 36);
			contentPanel.add(btnIngresar);
		}
		{
			btnSalir = new JButton("");
			btnSalir.setIcon(new ImageIcon(CodigoCajera.class.getResource("/imagenes/closelabel.gif")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(476, 62, 89, 41);
			contentPanel.add(btnSalir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 118, 600, 170);
			contentPanel.add(scrollPane);
			{
				dtm = new DefaultTableModel(null, cabecera);
				table = new JTable();
				table.setBackground(Color.PINK);
				table.setModel(dtm);
				scrollPane.setViewportView(table);
			}
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setForeground(Color.WHITE);
			lblOpciones.setBounds(251, 89, 58, 14);
			contentPanel.add(lblOpciones);
		}
		{
			cboOpcion = new JComboBox();
			cboOpcion.addActionListener(this);
			cboOpcion.setModel(new DefaultComboBoxModel(new String[] { "Ingresar", "Listar" }));
			cboOpcion.setBounds(306, 86, 121, 20);
			contentPanel.add(cboOpcion);
		}
		{
			label = new JLabel("");
			label.setForeground(Color.WHITE);
			label.setIcon(new ImageIcon(
					CodigoCajera.class.getResource("/imagenes/the-desktop-hd-Windows-7-Black-wallpapers (1).jpeg")));
			label.setBounds(0, 0, 620, 298);
			contentPanel.add(label);
		}
		table.addMouseListener(this);
		listar();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboOpcion) {
			do_cboOpcion_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
		limpiar();
	}

	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		switch (cboOpcion.getSelectedIndex()) {
		case 0:
			ingresar();
			actulizaciones();
			break;
		default:
			listar();
			break;
		}
	}

	void ingresar() {
		try {
			Cajera caje = p.buscar(leerCodigo());
			if (caje == null) {
				caje = new Cajera(leerCodigo(), leerNombre(), leerApellido(), leerDni(), leerSexo());
				p.adicionar(caje);
				listar();
				txtCodigo.setText("" + p.codigoMayor(contador));
				// mensaje de confirmación
				JOptionPane.showMessageDialog(this, "Cajero(a) Ingresado", "ALERTA", JOptionPane.WARNING_MESSAGE);

			} else
				mensaje("Código ya existe");
		} catch (Exception e) {
			mensaje("Ingrese Datos");
		}
	}

	//////////////////////////////////
	public void actulizaciones() {

		if (p.existeCajera()) {
			int ok = 0;
			if (ok == 0) {
				p.grabarCajera();
				p.getCajera();
			} else
				p.getCajera();
		} else {
			p.grabarCajera();
			p.getCajera();
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
	////////////////////////////////

	void listar() {
		try {
			if (p.tamano() > 0) {
				for (int i = 0; i < p.tamano(); i++) {
					Cajera caje = p.obtener(i);
					Object datos[] = { caje.getCodigo(), rellena(caje.getNombre()), caje.getApellido(), caje.getDni(),
							caje.sexoCajera() };
					dtm.addRow(datos);
				}
			} else
				mensaje("No hay Cajera(o)");
		} catch (Exception e) {
		}

	}

	String rellena(String cad) {
		int longitud = cad.length();
		for (int i = longitud; i < 15; i++)
			cad += " ";
		return cad;
	}

	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	String leerNombre() {
		return txtNombre.getText().toString();
	}

	String leerApellido() {
		return txtApellido.getText().toString();
	}

	int leerDni() {
		return Integer.parseInt(txtDni.getText());
	}

	int leerSexo() {
		return cboSexo.getSelectedIndex();
	}

	int leerOpciones() {
		return cboOpcion.getSelectedIndex();
	}

	void limpiar() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		cboSexo.setSelectedIndex(0);
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		try {
			String dato;
			dato = txtCodigo.getText();
			Reserva.txtCodigoCajera.setText(dato);

			this.dispose();
		} catch (Exception e) {
			this.dispose();
		}
	}

	void selecionarRegistro() {
		posicicon = table.getSelectedRow();
		txtCodigo.setText(String.valueOf(table.getValueAt(posicicon, 0)));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
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

	protected void do_cboOpcion_actionPerformed(ActionEvent arg0) {
		if (cboOpcion.getSelectedIndex() == 0) {
			txtCodigo.setEditable(true);
			txtNombre.setEditable(true);
			txtApellido.setEditable(true);
			txtDni.setEditable(true);
			cboSexo.setEnabled(true);

		} else {
			txtCodigo.setEditable(false);
			txtNombre.setEditable(false);
			txtApellido.setEditable(false);
			txtDni.setEditable(false);
			cboSexo.setEnabled(false);
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
