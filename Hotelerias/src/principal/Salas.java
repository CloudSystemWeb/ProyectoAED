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
import arraylist.ArregloSala;
import clases.Cine;


public class Salas extends JDialog implements ActionListener {
	ArregloSala c = new ArregloSala("Sala.txt");
	int contador;
 
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTeléfono;
	private JLabel lblEstado;
	private JTextField txtCodigoSala;
	static JTextField txtCodigoCine;
	private JTextField txtNumeroSala;
	private JTextField txtNumeroFilas;
	private JLabel lblOpciones;
	private JComboBox cbbOpciones;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JButton btnSalir;
	// private JLabel lblFecNac1;

	private JTextArea txtS;
	private JTextField txtNumeroButacas;
	private JButton button;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salas dialog = new Salas();
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
	public Salas() {
		getContentPane().setForeground(new Color(106, 90, 205));
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("REGISTRO DE SALAS");
		setBounds(100, 100, 1020, 730);
		getContentPane().setLayout(null);

		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCdigo.setForeground(new Color(0, 0, 0));
			lblCdigo.setIcon(new ImageIcon(Salas.class.getResource("/imagenes/icono139.gif")));
			lblCdigo.setBounds(10, 178, 128, 14);
			getContentPane().add(lblCdigo);
		}
		{
			lblNombre = new JLabel("Codigo Cine");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNombre.setBackground(Color.PINK);
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setBounds(10, 218, 128, 14);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("N\u00FAmero Sala");
			lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblApellido.setBackground(Color.PINK);
			lblApellido.setForeground(Color.BLACK);
			lblApellido.setBounds(10, 256, 128, 14);
			getContentPane().add(lblApellido);
		}
		{
			lblTeléfono = new JLabel("N\u00FAmero Filas");
			lblTeléfono.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTeléfono.setForeground(Color.BLACK);
			lblTeléfono.setBounds(10, 295, 128, 14);
			getContentPane().add(lblTeléfono);
		}
		{
			lblEstado = new JLabel("N\u00FAmero Butacas");
			lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblEstado.setForeground(Color.BLACK);
			lblEstado.setBounds(10, 330, 128, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtCodigoSala = new JTextField();
			txtCodigoSala.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtCodigoSala.setBackground(Color.WHITE);
			txtCodigoSala.setBounds(148, 175, 148, 20);
			getContentPane().add(txtCodigoSala);
			txtCodigoSala.setColumns(10);
			txtCodigoSala.setText("" + c.codigoMayor(contador));
		}
		{
			txtCodigoCine = new JTextField();
			txtCodigoCine.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtCodigoCine.setBackground(Color.WHITE);
			txtCodigoCine.addActionListener(this);
			txtCodigoCine.setEditable(false);
			txtCodigoCine.setBounds(148, 215, 148, 20);
			getContentPane().add(txtCodigoCine);
			txtCodigoCine.setColumns(10);
			SNumeros(txtCodigoCine);
		}
		{
			txtNumeroSala = new JTextField();
			txtNumeroSala.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtNumeroSala.setBackground(Color.WHITE);
			txtNumeroSala.addActionListener(this);
			txtNumeroSala.setBounds(148, 253, 148, 20);
			getContentPane().add(txtNumeroSala);
			txtNumeroSala.setColumns(10);
			SNumeros(txtNumeroSala);
		}
		{
			txtNumeroFilas = new JTextField();
			txtNumeroFilas.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtNumeroFilas.setBackground(Color.WHITE);
			txtNumeroFilas.addActionListener(this);
			txtNumeroFilas.setBounds(148, 292, 148, 20);
			getContentPane().add(txtNumeroFilas);
			txtNumeroFilas.setColumns(10);
			SNumeros(txtNumeroFilas);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblOpciones.setForeground(Color.BLACK);
			lblOpciones.setBounds(10, 377, 128, 18);
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
			cbbOpciones.setBounds(148, 373, 148, 22);
			getContentPane().add(cbbOpciones);
		}
		{
			btnProcesar = new JButton("");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar.setBackground(new Color(169, 169, 169));
			btnProcesar.setForeground(new Color(0, 0, 205));
			btnProcesar.setIcon(new ImageIcon(Salas.class.getResource("/imagenes/procesar.png")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(10, 481, 115, 47);
			getContentPane().add(btnProcesar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(361, 113, 633, 568);
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
			btnSalir.setIcon(new ImageIcon(Salas.class.getResource("/imagenes/cancelar.png")));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(181, 481, 115, 47);
			getContentPane().add(btnSalir);
		}
		{
			txtNumeroButacas = new JTextField();
			txtNumeroButacas.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtNumeroButacas.setColumns(10);
			txtNumeroButacas.setBackground(Color.WHITE);
			txtNumeroButacas.setBounds(148, 330, 148, 20);
			getContentPane().add(txtNumeroButacas);
			SNumeros(txtNumeroButacas);
		}
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(Salas.class.getResource("/imagenes/lupa.png")));
		button.setBounds(293, 214, 51, 22);
		getContentPane().add(button);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Salas.class.getResource("/imagenes/registrosalas.png")));
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
		if (arg0.getSource() == this.cbbOpciones) {
			do_cbbOpciones_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		if (arg0.getSource() == this.button) {
			do_btnBuscar_Cine_actionPerformed(arg0);
		}
		limpiar();
	}

	protected void do_btnBuscar_Cine_actionPerformed(ActionEvent arg0) {
		CodigoCine cine = new CodigoCine();
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
		if (String.valueOf(leerCod()).equals("") && String.valueOf(leerCodigoCine()).equals("")
				&& String.valueOf(leerNumeroFilas()).equals("") 
				&& String.valueOf(leerNumeroSala()).equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtCodigoCine.requestFocus();
		} else {
			clases.Sala clien = c.buscar(leerCod());
			if (clien == null) {
				//int codButaca, int codSala, int numeroFilas, int numeroColumna, int estadoButaca)
				clien = new clases.Sala(leerCod(), leerCodigoCine(), leerNumeroSala(), leerNumeroFilas(),
						leerNumeroButaca());
				c.adicionar(clien);
				listar();
				txtCodigoSala.setText("" + c.codigoMayor(contador));

				// mensaje de confirmación
				JOptionPane.showMessageDialog(this, "Sala Ingresado", "ALERTA", JOptionPane.WARNING_MESSAGE);

			} else
				mensaje("Código  ya existe");
		}
	}

	public void actulizaciones() {

		if (c.existeSala()) {
			int ok = 0;
			if (ok == 0) {
				c.grabarSala();
			} else
				c.getSala();
		} else {
			c.grabarSala();
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
			if (c.tamano() > 0) {
				txtS.setText("\t\t REGISTRO DE DATOS DE LOS BUTACA " + "\n");
				imprimir(
						"Código \t Cine \t numeroColumna \t numeroFilas \t Butacas");
				imprimir("");
				for (int i = 0; i < c.tamano(); i++) {
					clases.Sala clien = c.obtener(i);
					imprimir(clien.getCodSala() + "\t" + clien.getCodCine() + "\t"
							+ clien.getNumeroSala() + "\t" + clien.getNumeroFilas() + "\t\t"
							+ clien.getNumeroButacas()) ;
				imprimir("");
				if(c.tamano()-1==i){
					imprimir("Total de Butaca : " + c.tamano());	
				}
				}
			} else
				imprimir("No hay Butaca.......");
		} catch (Exception e) {
			mensaje("Ingrese Datos");
		}
	}

	void consultar() {
		clases.Sala clien = c.buscar(leerCod());
		if (clien != null) {
			imprimir();
			imprimir(" \t REGISTRO DE DATOS" + "\n");
			imprimir(" a) Código          : " + clien.getCodSala());
			imprimir(" b) Cine      : " + clien.getCodCine());
			imprimir(" c) Número Sala  : " + clien.getNumeroSala());
			imprimir(" d) Número Filas   : " + clien.getNumeroFilas());
			imprimir(" e) Número Butacas   : " + clien.getNumeroButacas());
		
			

		} else
			JOptionPane.showMessageDialog(null, "Butaca no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
	}

	void modificar() {
		if (String.valueOf(leerCod()).equals("") && String.valueOf(leerNumeroButaca()).equals("")
				&& String.valueOf(leerNumeroSala()).equals("") 
				&& String.valueOf(leerNumeroFilas()).equals("")
				&& String.valueOf(leerCodCine()).equals("")) {
			mensaje("POR FAVOR INGRESE LOS DATOS CORRECTAMENTE");
			txtCodigoCine.requestFocus();
		} else {
			clases.Sala clien = c.buscar(leerCod());
			if (clien != null) {
				clien.setCodSala(leerCod());
				clien.setCodCine(leerCodCine());
				clien.setNumeroSala(leerNumeroSala());
				clien.setNumeroFilas(leerNumeroFilas());
				clien.setNumeroButacas(leerNumeroButaca());
			
				listar();
				// mensaje que muestre que el cliente ha sido modificado
				JOptionPane.showMessageDialog(null, "Butaca Modificado", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Butaca no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
	}

	void eliminar() {
		clases.Sala clien = c.buscar(leerCod());
		if (clien != null) {
			c.eliminar(clien);
			listar();
			// mensaje que muestre que el cliente ha sido eliminado
			JOptionPane.showMessageDialog(null, "Sala Eliminado", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Sala no existe", "ALERTA", JOptionPane.ERROR_MESSAGE);

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

	public int leerCodigoCine() {
		return Integer.parseInt(txtCodigoCine.getText().toString());
	}
	
	public int leerNumeroFilas() {
		return Integer.parseInt(txtNumeroFilas.getText().toString());
	}

	public int leerNumeroSala() {
		return Integer.parseInt(txtNumeroSala.getText().toString());
	}
	
	public int leerNumeroButaca() {
		return Integer.parseInt(txtNumeroButacas.getText().toString());
	}
	
	public int leerCodCine() {
		return Integer.parseInt(txtCodigoSala.getText());
	}

	public int leerCod() {
		return Integer.parseInt(txtCodigoSala.getText());
	}

	public void limpiar() {
		txtNumeroSala.setText("");
		txtCodigoCine.setText("");
		txtNumeroFilas.setText("");
		txtNumeroButacas.setText("");
		txtCodigoCine.requestFocus();
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
			txtCodigoCine.setVisible(true);
			txtNumeroSala.setVisible(true);
			lblCdigo.setVisible(true);
			txtNumeroFilas.setVisible(true);
			txtCodigoSala.setVisible(true);
			lblEstado.setVisible(true);
			button.setVisible(true);
			txtNumeroButacas.setVisible(true);
		

		} else if (opcion == 1 || opcion == 3) {
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtCodigoCine.setVisible(false);
			txtNumeroSala.setVisible(false);
			txtNumeroFilas.setVisible(false);
			button.setVisible(false);
			txtCodigoSala.setVisible(true);
			lblCdigo.setVisible(true);
			txtNumeroButacas.setVisible(false);
	
			lblEstado.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			button.setVisible(false);
		

		} else {
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);
			lblTeléfono.setVisible(false);
			lblEstado.setVisible(false);
			txtCodigoCine.setVisible(false);
			txtNumeroSala.setVisible(false);
			txtNumeroButacas.setVisible(false);
			txtNumeroFilas.setVisible(false);
			txtCodigoSala.setVisible(false);
			lblCdigo.setVisible(false);
			button.setVisible(false);
			
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
			txtCodigoSala.setEditable(false);
		} else if (cbbOpciones.getSelectedIndex() == 1) {
			txtCodigoSala.setEditable(true);
		} else if (cbbOpciones.getSelectedIndex() == 2) {
			txtCodigoSala.setEditable(true);
		} else if (cbbOpciones.getSelectedIndex() == 3) {
			txtCodigoSala.setEditable(true);
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
