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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import clases.Recepcionista;
import arraylist.ArregloRecepcionista;

import java.awt.Font;

public class CodigoRecepcionista extends JDialog implements ActionListener, MouseListener {

	ArregloRecepcionista r = new ArregloRecepcionista("Recepcionista.txt");

	private final JPanel contentPanel = new JPanel();
	private JButton btnListar;
	private JButton btnSalir;

	public DefaultTableModel dtm;
	String cabecera[] = { "Código", "Nombres", "Apellidos", "Teléfono", " Estado ", " Sexo " };
	private JTable table;
	int posicion;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JLabel lblCdigo;
	private JTextField txtNombre;
	private JButton btnBuscarr;
	private JLabel lblNombre;
	private JLabel lblOpciones;
	private JComboBox cboOpcion;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CodigoRecepcionista dialog = new CodigoRecepcionista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CodigoRecepcionista() {
		setTitle("Lista De Códigos de Los Recepcionistas");
		setBounds(100, 100, 603, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 91, 567, 184);
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
			btnListar.setIcon(new ImageIcon(CodigoRecepcionista.class.getResource("/imagenes/procesar.gif")));
			btnListar.setForeground(Color.BLUE);
			btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnListar.addActionListener(this);
			btnListar.setBounds(460, 6, 99, 33);
			contentPanel.add(btnListar);
		}
		{
			btnSalir = new JButton("");
			btnSalir.setIcon(new ImageIcon(CodigoRecepcionista.class.getResource("/imagenes/exit_button.gif")));
			btnSalir.setForeground(Color.BLUE);
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(460, 50, 99, 33);
			contentPanel.add(btnSalir);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(247, 12, 108, 22);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
			SNumeros(txtCodigo);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setEnabled(false);
			btnBuscar.setBackground(Color.LIGHT_GRAY);
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(354, 11, 83, 23);
			contentPanel.add(btnBuscar);
		}
		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setBounds(191, 16, 46, 14);
			contentPanel.add(lblCdigo);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBackground(Color.WHITE);
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(90, 51, 108, 22);
			contentPanel.add(txtNombre);
			SLetras(txtNombre);
		}
		{
			btnBuscarr = new JButton("Buscar");
			btnBuscarr.addActionListener(this);
			btnBuscarr.setEnabled(false);
			btnBuscarr.setBackground(Color.LIGHT_GRAY);
			btnBuscarr.setBounds(197, 50, 83, 23);
			contentPanel.add(btnBuscarr);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(25, 57, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblOpciones = new JLabel("Opci\u00F3n");
			lblOpciones.setBounds(10, 11, 61, 14);
			contentPanel.add(lblOpciones);
		}
		{
			cboOpcion = new JComboBox();
			cboOpcion.addActionListener(this);
			cboOpcion.setModel(new DefaultComboBoxModel(new String[] { "Por C\u00F3digo", "Por Nombre" }));
			cboOpcion.setBounds(58, 12, 108, 20);
			contentPanel.add(cboOpcion);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(
					CodigoRecepcionista.class.getResource("/imagenes/Crisis-S\u00ED-pero-no-para-todos.jpg")));
			label.setBounds(0, 0, 587, 286);
			contentPanel.add(label);
		}

		table.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscarr) {
			do_btnBuscarr_actionPerformed(arg0);
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
		if (r.tamaño() > 0) {
			for (int i = 0; i < r.tamaño(); i++) {
				Recepcionista recep = r.obtener(i);
				Object datos[] = { recep.getCodigo(), recep.getNombreRecepcionista(), recep.getApellidoRecepcionista(),
						recep.getTelefonoRecepcionista(), recep.Tipo(), recep.Sexo() };
				dtm.addRow(datos);
			}

		} else
			JOptionPane.showMessageDialog(null, "No hay Recepcionistas", "MENSAJE", JOptionPane.ERROR_MESSAGE);
	}

	public int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	void consultar() {
		try {
			Recepcionista recep = r.buscar(leerCodigo());
			if (recep != null) {
				Object datos[] = { recep.getCodigo(), recep.getNombreRecepcionista(), recep.getApellidoRecepcionista(),
						recep.getTelefonoRecepcionista(), recep.Tipo(), recep.Sexo() };
				dtm.addRow(datos);

				JOptionPane.showMessageDialog(null, "Recepcionista Encontrada", "ALERTA",
						JOptionPane.INFORMATION_MESSAGE);
				txtCodigo.requestFocus();
			} else
				JOptionPane.showMessageDialog(null, "Recepcionista no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
			txtCodigo.requestFocus();
		} catch (Exception e) {
			mensaje("Ingrese Un Código");
			txtCodigo.requestFocus();
		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		try {
			String dato;
			dato = txtCodigo.getText();
			Reserva.txtCodigoRecepcionista.setText(dato);

			this.dispose();
		} catch (Exception e) {
			this.dispose();
		}
	}

	void selecionarRegistro() {
		posicion = table.getSelectedRow();
		txtCodigo.setText(String.valueOf(table.getValueAt(posicion, 0)));
		txtNombre.setText(String.valueOf(table.getValueAt(posicion, 1)));
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
		try {
			consultar();
		} catch (Exception h) {
			txtCodigo.requestFocus();
		}
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	protected void do_cboOpcion_actionPerformed(ActionEvent arg0) {
		seleccion();
	}

	void seleccion() {
		if (cboOpcion.getSelectedIndex() == 0) {
			txtNombre.setEditable(false);
			txtCodigo.setEditable(true);
			btnBuscar.setEnabled(true);
			btnBuscarr.setEnabled(false);
			txtCodigo.setText("");
			txtNombre.setText("");
		} else {
			txtNombre.setEditable(true);
			txtCodigo.setEditable(false);
			btnBuscar.setEnabled(false);
			btnBuscarr.setEnabled(true);
			txtCodigo.setText("");
			txtNombre.setText("");
		}
	}

	String leerNombre() {
		return txtNombre.getText().toString();
	}

	// -------------------------------------
	void consultarNombre() {
		Recepcionista recep = r.buscarNombres(leerNombre());
		if (recep != null) {
			Object datos[] = { recep.getCodigo(), recep.getNombreRecepcionista(), recep.getApellidoRecepcionista(),
					recep.getTelefonoRecepcionista(), recep.Tipo(), recep.Sexo() };
			dtm.addRow(datos);

			JOptionPane.showMessageDialog(null, "Recepcionista Encontrada", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			txtNombre.requestFocus();
		} else
			JOptionPane.showMessageDialog(null, "Recepcionista no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		txtNombre.requestFocus();
	}

	protected void do_btnBuscarr_actionPerformed(ActionEvent arg0) {
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
