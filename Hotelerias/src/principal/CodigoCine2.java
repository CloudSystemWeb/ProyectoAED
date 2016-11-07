package principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arraylist.ArregloCine;
import clases.Cine;
public class CodigoCine2 extends JDialog implements ActionListener, MouseListener {
	
	ArregloCine c = new ArregloCine("Cine.txt");
	
	private JButton btnListar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	
	public DefaultTableModel dtm;	
	String cabecera[] = {"Código","Nombres","Departamento","Provincia","Distrito","Fecha","Tipo	"};
	private JTable tabla;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JLabel lblBuscar;
	private JLabel lblCdigo;
	private JLabel label;
	
	int posicion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CodigoCine2 dialog = new CodigoCine2();
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
	public CodigoCine2() {
		setTitle("C\u00D3DIGOS DE CINE");
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
			btnSalir.setIcon(new ImageIcon(CodigoCine2.class.getResource("/imagenes/exit_button.gif")));
			btnSalir.setBounds(461, 12, 102, 23);
			btnSalir.addActionListener(this);
			getContentPane().add(btnSalir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 76, 553, 185);
			getContentPane().add(scrollPane);
			{
				dtm = new DefaultTableModel(null,cabecera);
				tabla = new JTable();
				tabla.setModel(dtm);
				scrollPane.setViewportView(tabla);
			}
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(66, 41, 125, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setBackground(Color.WHITE);
			SNumeros(txtCodigo);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setForeground(SystemColor.desktop);
			btnBuscar.setBackground(SystemColor.activeCaption);
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(213, 40, 78, 23);
			getContentPane().add(btnBuscar);
		}
		{
			lblBuscar = new JLabel("Buscar");
			lblBuscar.setForeground(SystemColor.inactiveCaptionBorder);
			lblBuscar.setBounds(10, 15, 46, 14);
			getContentPane().add(lblBuscar);
		}
		{
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(SystemColor.inactiveCaptionBorder);
			lblCdigo.setBounds(10, 40, 46, 23);
			getContentPane().add(lblCdigo);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(CodigoCine2.class.getResource("/imagenes/the-desktop-hd-Windows-7-Black-wallpapers (1).jpeg")));
			label.setBounds(0, 0, 573, 263);
			getContentPane().add(label);
		}
		tabla.addMouseListener(this);
	}
	public void actionPerformed(ActionEvent arg0) {
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
	
	void listar(){
		if(c.tamaño()>0){
			for(int i=0; i<c.tamaño(); i++){
				clases.Cine clien=c.obtener(i);
				Object datos [] = {clien.getCodCine(),clien.getNombre(),clien.getDepartamento(),
						clien.getProvincia(),clien.getDistrito(),clien.getFechaIniOper()};
				dtm.addRow(datos);
				}
		}
		else{
			JOptionPane.showMessageDialog(null, "No hay Cine","MENSAJE",JOptionPane.ERROR_MESSAGE);
	   }
	}	
	void consultar(){
		try{
		Cine clien=c.buscar(leerCodigo());
		if(clien!=null){
			Object datos [] = {clien.getCodCine(),clien.getNombre(),clien.getDepartamento(),
					clien.getProvincia(),clien.getDistrito(),clien.getFechaIniOper(), clien.getEstadoCine()};
				dtm.addRow(datos);
				
				mensaje("Cine Encontrado");
				txtCodigo.requestFocus();
		}
		else
		JOptionPane.showMessageDialog(null, "Cine no existe","ALERTA",JOptionPane.ERROR_MESSAGE);
		txtCodigo.requestFocus();
	}catch(Exception e){
		mensaje("Ingrese Un Código");
	}
	}	
	void mensaje(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	
	 int leerCodigo(){return Integer.parseInt(txtCodigo.getText());}
	
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		try{
		String dato;
		dato=txtCodigo.getText();
		Funcion.txtCodigoCine.setText(dato);
		this.dispose();
		}catch(Exception e){
			this.dispose();
		}
		
	}

	void selecionarRegistro(){
		posicion = tabla.getSelectedRow();
		txtCodigo.setText(String.valueOf(tabla.getValueAt(posicion, 0)));
		//txtNombre.setText(String.valueOf(tabla.getValueAt(posicion, 1)));
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
		try{
			consultar();
				}catch(Exception h){
					txtCodigo.requestFocus();
		}
		}
	//---------------------------------------
	//-------------------------------------
	
	public  void SNumeros(JTextField a){
		a.addKeyListener(new KeyAdapter() {
			public  void  keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(Character.isLetter(c)){
					e.consume();
					getToolkit().beep();
					mensaje("Solo Ingrese Números");
				}
			}
		});
	}
	
	public void SLetras(JTextField a){
	}
}
