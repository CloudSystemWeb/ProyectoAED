package principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import arraylist.ArregloButaca;
import clases.Cine;


public class Butaca extends JDialog implements ActionListener {
	ArregloButaca c = new ArregloButaca("Butaca.txt");
	int contador;
 
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTeléfono;
	private JLabel lblEstado;
	private JTextField txtCodigoButaca;
	static JTextField txtCodigoSala;
	private JTextField txtNumeroFila;
	private JTextField txtNumeroColumna;
	private JComboBox cboTipo;
	private JLabel lblOpciones;
	private JComboBox cbbOpciones;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JButton btnSalir;
	// private JLabel lblFecNac1;

	private JTextArea txtS;
	private JButton btnBuscarSala;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Butaca dialog = new Butaca();
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
	public Butaca() {
		getContentPane().setForeground(new Color(106, 90, 205));
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("REGISTRO DE BUTACAS");
		setBounds(100, 100, 1020, 730);
		getContentPane().setLayout(null);

		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCdigo.setForeground(new Color(0, 0, 0));
			lblCdigo.setIcon(new ImageIcon(Butaca.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(10, 192, 109, 14);
			getContentPane().add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Codigo Sala");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNombre.setBackground(Color.PINK);
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setBounds(10, 242, 102, 14);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("N\u00FAmero Fila");
			lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblApellido.setBackground(Color.PINK);
			lblApellido.setForeground(Color.BLACK);
			lblApellido.setBounds(10, 288, 102, 14);
			getContentPane().add(lblApellido);
		}
		{
			lblTeléfono = new JLabel("N\u00FAmero Columna");
			lblTeléfono.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTeléfono.setForeground(Color.BLACK);
			lblTeléfono.setBounds(10, 331, 132, 14);
			getContentPane().add(lblTeléfono);
		}
		{
			lblEstado = new JLabel("Tipo");
			lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblEstado.setForeground(Color.BLACK);
			lblEstado.setBounds(10, 387, 77, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtCodigoButaca = new JTextField();
			txtCodigoButaca.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtCodigoButaca.setBackground(Color.WHITE);
			txtCodigoButaca.setBounds(152, 192, 159, 20);
			getContentPane().add(txtCodigoButaca);
			txtCodigoButaca.setColumns(10);
			txtCodigoButaca.setText("" + c.codigoMayor(contador));
		}
		{
			txtCodigoSala = new JTextField();
			txtCodigoSala.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtCodigoSala.setEditable(false);
			txtCodigoSala.setBackground(Color.WHITE);
			txtCodigoSala.addActionListener(this);
			txtCodigoSala.setBounds(152, 242, 159, 20);
			getContentPane().add(txtCodigoSala);
			txtCodigoSala.setColumns(10);
			SNumeros(txtCodigoSala);
		}
		{
			txtNumeroFila = new JTextField();
			txtNumeroFila.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtNumeroFila.setBackground(Color.WHITE);
			txtNumeroFila.addActionListener(this);
			txtNumeroFila.setBounds(152, 288, 164, 20);
			getContentPane().add(txtNumeroFila);
			txtNumeroFila.setColumns(10);
			SNumeros(txtNumeroFila);
		}
		{
			txtNumeroColumna = new JTextField();
			txtNumeroColumna.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtNumeroColumna.setBackground(Color.WHITE);
			txtNumeroColumna.addActionListener(this);
			txtNumeroColumna.setBounds(152, 331, 164, 20);
			getContentPane().add(txtNumeroColumna);
			txtNumeroColumna.setColumns(10);
			SNumeros(txtNumeroColumna);
		}
		{
			cboTipo = new JComboBox();
			cboTipo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			cboTipo.setForeground(new Color(160, 82, 45));
			cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Reservada", "Disponible"}));
			cboTipo.setBounds(150, 386, 166, 22);
			getContentPane().add(cboTipo);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblOpciones.setForeground(Color.BLACK);
			lblOpciones.setBounds(10, 453, 87, 14);
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
			cbbOpciones.setBounds(152, 445, 164, 22);
			getContentPane().add(cbbOpciones);
		}
		{
			btnProcesar = new JButton("");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar.setBackground(new Color(169, 169, 169));
			btnProcesar.setForeground(new Color(0, 0, 205));
			btnProcesar.setIcon(new ImageIcon(Butaca.class.getResource("/imagenes/procesar.png")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(23, 583, 115, 47);
			getContentPane().add(btnProcesar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(368, 148, 626, 533);
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
			btnSalir.setIcon(new ImageIcon(Butaca.class.getResource("/imagenes/cancelar.png")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(152, 583, 115, 47);
			getContentPane().add(btnSalir);
		}
		{
			btnBuscarSala = new JButton("");
			btnBuscarSala.setIcon(new ImageIcon(Butaca.class.getResource("/imagenes/lupa.png")));
			btnBuscarSala.addActionListener(this);
			btnBuscarSala.setBounds(307, 241, 51, 22);
			getContentPane().add(btnBuscarSala);
		}
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Butaca.class.getResource("/imagenes/registrobutacas.png")));
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
		if (arg0.getSource() == this.cboTipo) {
			do_cbbEstado_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.cbbOpciones) {
			do_cbbOpciones_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.btnBuscarSala) {
			do_btnBuscarSala_actionPerformed(arg0);
		}
		limpiar();
	}

	protected void do_btnBuscarSala_actionPerformed(ActionEvent arg0) {
		CodigoSala cine = new CodigoSala();
		cine.setVisible(true);
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
		if (String.valueOf(leerCod()).equals("") && String.valueOf(leerCodigoSalas()).equals("")
				&& String.valueOf(leerNumeroFilas()).equals("") 
				&& String.valueOf(leerNumeroColumna()).equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtCodigoSala.requestFocus();
		} else {
			clases.Butaca clien = c.buscar(leerCod());
			if (clien == null) {
				//int codButaca, int codSala, int numeroFilas, int numeroColumna, int estadoButaca)
				clien = new clases.Butaca(leerCod(), leerCodigoSalas(), leerNumeroFilas(), leerNumeroColumna(),
						leerTipo());
				c.adicionar(clien);
				listar();
				txtCodigoButaca.setText("" + c.codigoMayor(contador));

				// mensaje de confirmación
				JOptionPane.showMessageDialog(this, "Butaca Ingresado", "ALERTA", JOptionPane.WARNING_MESSAGE);

			} else
				mensaje("Código  ya existe");
		}
	}

	public void actulizaciones() {

		if (c.existebutacate()) {
			int ok = 0;
			if (ok == 0) {
				c.grabarbutacates();
			} else
				c.getbutacate();
		} else {
			c.grabarbutacates();
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
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS BUTACA " + "\n");
				imprimir(
						"Código \t Sala \t numeroFilas \t numeroColumna \t estadoButaca");
				imprimir("");
				for (int i = 0; i < c.tamaño(); i++) {
					clases.Butaca clien = c.obtener(i);
					imprimir(clien.getCodButaca() + "\t" + clien.getCodSala() + "\t"
							+ clien.getNumeroFilas() + "\t" + clien.getNumeroColumna() + "\t\t"
							+ clien.getEstadoButaca()) ;
				imprimir("");
				imprimir("Total de Butaca : " + c.tamaño());
				}
			} else
				imprimir("No hay Butaca.......");
		} catch (Exception e) {
			mensaje("Ingrese Datos");
		}
	}

	void consultar() {
		clases.Butaca clien = c.buscar(leerCod());
		if (clien != null) {
			imprimir();
			imprimir(" \t REGISTRO DE DATOS" + "\n");
			imprimir(" a) Código          : " + clien.getCodButaca());
			imprimir(" b) Sala      : " + clien.getCodSala());
			imprimir(" c) Filas  : " + clien.getNumeroFilas());
			imprimir(" d) Columnas   : " + clien.getNumeroColumna());
			imprimir(" e) Estado    : " + clien.getEstadoButaca());
		
			

		} else
			JOptionPane.showMessageDialog(null, "Butaca no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	void modificar() {
		if (String.valueOf(leerCod()).equals("") && String.valueOf(leerCodigoSalas()).equals("")
				&& String.valueOf(leerNumeroFilas()).equals("") 
				&& String.valueOf(leerNumeroColumna()).equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtCodigoSala.requestFocus();
		} else {
			clases.Butaca clien = c.buscar(leerCod());
			if (clien != null) {
				clien.setCodSala(leerCodigoSalas());
				clien.setNumeroFilas(leerNumeroFilas());
				clien.setNumeroColumna(leerNumeroColumna());
				clien.setEstadoButaca(leerTipo());
			
				listar();
				// mensaje que muestre que el cliente ha sido modificado
				JOptionPane.showMessageDialog(null, "Butaca Modificado", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Butaca no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
	}

	void eliminar() {
		clases.Butaca clien = c.buscar(leerCod());
		if (clien != null) {
			c.eliminar(clien);
			listar();
			// mensaje que muestre que el cliente ha sido eliminado
			JOptionPane.showMessageDialog(null, "Butaca Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Butaca no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

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

	public int leerCodigoSalas() {
		return Integer.parseInt(txtCodigoSala.getText().toString());
	}
	
	public int leerNumeroFilas() {
		return Integer.parseInt(txtNumeroFila.getText().toString());
	}

	public int leerNumeroColumna() {
		return Integer.parseInt(txtNumeroColumna.getText().toString());
	}

	public int leerTipo() {
		return cboTipo.getSelectedIndex();
	}

	public int leerCod() {
		return Integer.parseInt(txtCodigoButaca.getText());
	}

	public void limpiar() {
		txtNumeroFila.setText("");
		txtCodigoSala.setText("");
		txtNumeroColumna.setText("");
		txtCodigoSala.requestFocus();
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
			txtCodigoSala.setVisible(true);
			txtNumeroFila.setVisible(true);
			cboTipo.setVisible(true);
			lblCdigo.setVisible(true);
			txtNumeroColumna.setVisible(true);
			txtCodigoButaca.setVisible(true);
			btnBuscarSala.setVisible(true);
			lblEstado.setVisible(true);
		

		} else if (opcion == 1 || opcion == 3) {
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtCodigoSala.setVisible(false);
			txtNumeroFila.setVisible(false);
			cboTipo.setVisible(false);
			txtNumeroColumna.setVisible(false);
			txtCodigoButaca.setVisible(true);
			lblCdigo.setVisible(true);
			btnBuscarSala.setVisible(false);
			lblEstado.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
		

		} else {
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtCodigoSala.setVisible(false);
			txtNumeroFila.setVisible(false);
			cboTipo.setVisible(false);
			txtNumeroColumna.setVisible(false);
			txtCodigoButaca.setVisible(false);
			lblCdigo.setVisible(false);
			
			lblEstado.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);

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
			txtCodigoButaca.setEditable(false);
			cboTipo.setEnabled(true);
			cboTipo.setSelectedIndex(0);
		} else if (cbbOpciones.getSelectedIndex() == 1) {
			txtCodigoButaca.setEditable(true);
			cboTipo.setEnabled(true);
		} else if (cbbOpciones.getSelectedIndex() == 2) {
			txtCodigoButaca.setEditable(true);
			cboTipo.setEnabled(true);
		} else if (cbbOpciones.getSelectedIndex() == 3) {
			txtCodigoButaca.setEditable(true);
			cboTipo.setEnabled(true);
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
