package principal;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;

import clases.Habitacion;
import arraylist.ArregloHabitacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Habitaciones extends JFrame implements ActionListener {
	
	ArregloHabitacion h=new ArregloHabitacion("Habitaciones.txt");
	int contador;
	
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblCosto;
	private JTextField txtCosto;
	private JTextField txtTipo;
	private JTextField txtDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblTipo;
	private JLabel lblOpciones;
	private JTextField txtUbicacion;
	private JLabel lblUbicacion;
	private JComboBox cboOpcion;
	private JButton btnProcesar;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Habitaciones frame = new Habitaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Habitaciones() {
		setTitle("HABITACIONES");
		setBounds(100, 100, 664, 355);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		{
			lblCodigo = new JLabel("C\u00F3digo");
			lblCodigo.setForeground(new Color(128, 0, 0));
			lblCodigo.setIcon(new ImageIcon(Habitaciones.class.getResource("/imagenes/icono139.gif")));
			lblCodigo.setBounds(0, 14, 84, 14);
			getContentPane().add(lblCodigo);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtCodigo.setText("101");
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(91, 11, 130, 20);
			getContentPane().add(txtCodigo);
			SNumeros(txtCodigo);
			txtCodigo.setText(""+h.codigoMayor(contador));
		}
		{
			lblCosto = new JLabel("Costo S/.");
			lblCosto.setForeground(new Color(128, 0, 0));
			lblCosto.setBounds(245, 14, 59, 14);
			getContentPane().add(lblCosto);
		}
		{
			txtCosto = new JTextField();
			txtCosto.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtCosto.setColumns(10);
			txtCosto.setBounds(344, 11, 137, 20);
			getContentPane().add(txtCosto);
			SNumeros(txtCosto);
		}
		{
			txtTipo = new JTextField();
			txtTipo.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtTipo.setColumns(10);
			txtTipo.setBounds(344, 47, 137, 20);
			getContentPane().add(txtTipo);
			SLetras(txtTipo);
		}
		{
			txtDescripcion = new JTextField();
			txtDescripcion.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtDescripcion.setColumns(10);
			txtDescripcion.setBounds(91, 47, 130, 20);
			getContentPane().add(txtDescripcion);
			SLetras(txtDescripcion);
		}
		{
			lblDescripcion = new JLabel("Descripci\u00F3n");
			lblDescripcion.setForeground(new Color(128, 0, 0));
			lblDescripcion.setBounds(10, 50, 74, 14);
			getContentPane().add(lblDescripcion);
		}
		{
			lblTipo = new JLabel("Tipo Habitaci\u00F3n");
			lblTipo.setForeground(new Color(128, 0, 0));
			lblTipo.setBounds(245, 50, 107, 14);
			getContentPane().add(lblTipo);
		}
		{
			lblOpciones = new JLabel("Opciones");
			lblOpciones.setForeground(new Color(128, 0, 0));
			lblOpciones.setBounds(245, 87, 59, 14);
			getContentPane().add(lblOpciones);
		}
		{
			txtUbicacion = new JTextField();
			txtUbicacion.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtUbicacion.setColumns(10);
			txtUbicacion.setBounds(91, 84, 130, 20);
			getContentPane().add(txtUbicacion);
			SLetras(txtUbicacion);
		}
		{
			lblUbicacion = new JLabel("Ubicaci\u00F3n");
			lblUbicacion.setForeground(new Color(128, 0, 0));
			lblUbicacion.setBounds(10, 87, 59, 14);
			getContentPane().add(lblUbicacion);
		}
		{
			cboOpcion = new JComboBox();
			cboOpcion.addActionListener(this);
			cboOpcion.setModel(new DefaultComboBoxModel(new String[] {"Ingresar", "Modificar", "Consultar", "Eliminar", "Listar"}));
			cboOpcion.setBounds(345, 84, 137, 20);
			getContentPane().add(cboOpcion);
		}
		{
			btnProcesar = new JButton("  Procesar  ");
			btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnProcesar.setForeground(new Color(0, 0, 128));
			btnProcesar.setIcon(new ImageIcon(Habitaciones.class.getResource("/imagenes/procesar.gif")));
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(502, 14, 136, 42);
			getContentPane().add(btnProcesar);
		}
		{
			btnNewButton = new JButton("");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setForeground(new Color(0, 0, 128));
			btnNewButton.setIcon(new ImageIcon(Habitaciones.class.getResource("/imagenes/exit_button.gif")));
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(502, 67, 136, 34);
			getContentPane().add(btnNewButton);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 122, 628, 183);
			getContentPane().add(scrollPane);
			{
				txtS = new JTextArea();
				txtS.setForeground(new Color(0, 0, 0));
				txtS.setBackground(new Color(238, 232, 170));
				scrollPane.setViewportView(txtS);
			}
		}
		{
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setForeground(new Color(128, 0, 0));
			lblNewLabel.setIcon(new ImageIcon(Habitaciones.class.getResource("/imagenes/fondos-de-escritorio-para-windows-7-2.png")));
			lblNewLabel.setBounds(0, 0, 648, 316);
			getContentPane().add(lblNewLabel);
		}
		codigo();
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboOpcion) {
			do_cboOpcion_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		limpiar();
	}
	protected void do_btnProcesar_actionPerformed(ActionEvent arg0) {
		procesar();
	}
	
	void procesar(){
		switch(cboOpcion.getSelectedIndex()){
			case 0 : 
				ingresar();
				break;
			case 1:
				modificar();
				break;
			case 2:
				consultar();
				break;
			case 3:
				eliminar();
				break;
			default:
				listar();
		}
		}
		
		void ingresar(){
			try{
		      Habitacion habi=h.buscar(leerCodigo());
		       if(habi==null){
		       	 habi=new Habitacion(leerCodigo(), leerDescripcion(), leertipo(), leerUbicacion(), leerCosto());
			  	 h.adicionar(habi);
			  	 listar();
			  	txtCodigo.setText(""+h.codigoMayor(contador));
			  	 mensaje("Habitación Ingresada");
		       }
		       else {
		    	   mensaj("Código ya existe");}
		       
		       actulizaciones();
			}
			catch(Exception e){
				mensaj("Ingrese Datos");
			}
		}
		public void actulizaciones(){
	    	   if (h.existeHabitacion()) {
	   			int  ok = 0;
	   			if (ok == 0) {
	   				h.grabarHabitacion();
	   				 h.getArchivo();
	   			}
	   			else
	   			h.getArchivo();
	   		}
	   		else {
	   			h.grabarHabitacion();
	   			h.getArchivo();
	   		}	
	    	}

	    	/*
	    	 * mensajesss
	    	 */
	    	int confirmar(String s) {
	    		return JOptionPane.showConfirmDialog(this,s);	
	    	}	

	    	void mensaj(String s) {
	    		JOptionPane.showMessageDialog(this,s);
	    	}
	    	
	    	void listar(){
	    		imprimir();
	    		System.out.println("Tamaño...: " + h.tamaño());
	    		
	    		if(h.tamaño()>0){
	    			imprimir("\t\t REGISTRO DE DATOS DE LAS HABITACIONES "+"\n");
	    			imprimir("Código \t Decripción \t\t Tipo Habitación \t Ubicación \t\t Costo");
	    			for(int i=0; i<h.tamaño(); i++){
	    				Habitacion habi=h.obtener(i);
	    				imprimir(habi.getCodigoHabitacion()+"\t" + rellena(habi.getDescripcion())+"\t\t"+ habi.getUbicacion() +
	    				"\t\t"+habi.getTipo()+"\t\t"+habi.getCosto());
	    				}
	    			imprimir("");
	    			imprimir("Mayor precio Habitación : "+h.mayorPrecio());
	    			imprimir("Menor Precio Habitación : "+h.menorPrecio());
	    			imprimir("Total de Habitaciones : "+h.tamaño());
	    		}
	    		else{
	    			JOptionPane.showMessageDialog(this, "No hay Habitaciones","MENSAJE",JOptionPane.ERROR_MESSAGE);}
	    	}
	
	void consultar(){
		imprimir();
		Habitacion habi=h.buscar(leerCodigo());
		if(habi!=null){
			txtS.setText("                                                                REGISTRO DE DATOS"+"\n");
			imprimir("Código          : "+habi.getCodigoHabitacion());
			imprimir("Descripción          : "+habi.getDescripcion());
			imprimir("Ubicación Habitación  : "+habi.getUbicacion());
			imprimir("Tipo Habitación  : "+habi.getTipo());
			imprimir("Costo Habitación  : "+habi.getCosto());
			
		}
		else
		JOptionPane.showMessageDialog(null, "Habitación no existe","ALERTA",JOptionPane.ERROR_MESSAGE);
	}	

	void modificar(){
		try{
		Habitacion habi=h.buscar(leerCodigo());
		if(habi!=null){
			habi.setDescripcion(leerDescripcion());
			habi.setUbicacion(leerUbicacion());
			habi.setCosto(leerCosto());
			habi.setTipo(leertipo());
			listar();
			
		}
		else
			JOptionPane.showMessageDialog(null, "Habitación no existe","ALERTA",JOptionPane.ERROR_MESSAGE);
	}
		catch(Exception e){
		mensaj("Ingresar Datos");
	}
	}
	
	void eliminar(){
		Habitacion habi=h.buscar(leerCodigo());
		if(habi!=null){
			h.eliminar(habi);
			listar();
			mensaje("Habitación Eliminado");
		}
		else
			JOptionPane.showMessageDialog(null, "Habitación no existe","ALERTA",JOptionPane.ERROR_MESSAGE);
		
	}
	
	String rellena(String cad){
		int longitud=cad.length();
		for(int i=longitud; i<15; i++)
			cad+=" ";
		return cad;
	}
	
	
	
		
		 public void imprimir(String s){txtS.append(s+"\n");}
		    public void imprimir(){txtS.setText("");}
		    
			private String leertipo(){return (txtTipo.getText().toString()); }
			private String leerUbicacion(){return txtUbicacion.getText().toString();}
			private int leerCodigo(){return Integer.parseInt(txtCodigo.getText());}
			private double leerCosto(){return Double.parseDouble(txtCosto.getText());}
			public String leerDescripcion (){return (txtDescripcion.getText().toString());}
			public int leerOpciones (){return cboOpcion.getSelectedIndex();}
		
			public void limpiar(){
				txtCosto.setText("");
				txtDescripcion.setText("");
				txtTipo.setText("");
				txtUbicacion.setText("");
				txtDescripcion.requestFocus();
			}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		int dato=JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea Salir","ALERTA",JOptionPane.INFORMATION_MESSAGE);
		if(dato==0){
			this.dispose();
		}
	}
	protected void do_cboOpcion_actionPerformed(ActionEvent arg0) {
		codigo();
		mostrarIconos();
	}
	
	private void mostrarIconos() {
		if(cboOpcion.getSelectedIndex()==0 || cboOpcion.getSelectedIndex()==1){
			lblCodigo.setVisible(true);
			txtCodigo.setVisible(true);
			lblDescripcion.setVisible(true);
			txtDescripcion.setVisible(true);
			lblCosto.setVisible(true);
			txtCosto.setVisible(true);
			lblTipo.setVisible(true);
			txtTipo.setVisible(true);
			lblUbicacion.setVisible(true);
			txtUbicacion.setVisible(true);
			lblOpciones.setVisible(true);
			cboOpcion.setVisible(true);
		}
		else if(cboOpcion.getSelectedIndex()==2 || cboOpcion.getSelectedIndex()==3){
			lblCodigo.setVisible(true);
			txtCodigo.setVisible(true);
			lblDescripcion.setVisible(false);
			txtDescripcion.setVisible(false);
			lblCosto.setVisible(false);
			txtCosto.setVisible(false);
			lblTipo.setVisible(false);
			txtTipo.setVisible(false);
			lblUbicacion.setVisible(false);
			txtUbicacion.setVisible(false);
			lblOpciones.setVisible(true);
			cboOpcion.setVisible(true);
		}
		else {
			lblCodigo.setVisible(false);
			txtCodigo.setVisible(false);
			lblDescripcion.setVisible(false);
			txtDescripcion.setVisible(false);
			lblCosto.setVisible(false);
			txtCosto.setVisible(false);
			lblTipo.setVisible(false);
			txtTipo.setVisible(false);
			lblUbicacion.setVisible(false);
			txtUbicacion.setVisible(false);
			lblOpciones.setVisible(true);
			cboOpcion.setVisible(true);
		}
	}
	
	void codigo(){
		if(cboOpcion.getSelectedIndex()==0){
			txtCodigo.setEditable(false);
		}
		else if(cboOpcion.getSelectedIndex()==1){
			txtCodigo.setEditable(true);
		}
		else if(cboOpcion.getSelectedIndex()==2){
			txtCodigo.setEditable(true);
		}
		else if(cboOpcion.getSelectedIndex()==3){
			txtCodigo.setEditable(true);
		}
	}
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
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(Character.isDigit(c)){
					getToolkit().beep();
					e.consume();
					mensaje("Solo Ingrese Letras");
				}
			}
		});
	}
	
	void mensaje(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	
}
