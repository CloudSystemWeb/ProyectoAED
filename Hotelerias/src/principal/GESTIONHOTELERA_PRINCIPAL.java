package principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Font;

public class GESTIONHOTELERA_PRINCIPAL extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblUsuario;
	private JPasswordField txtPasword;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JTextField txtIngreseUsuarioY;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GESTIONHOTELERA_PRINCIPAL dialog = new GESTIONHOTELERA_PRINCIPAL();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GESTIONHOTELERA_PRINCIPAL() {
		setTitle("Entrada  a la gesti\u00F3n Hotelera");
		setBounds(100, 100, 517, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblUsuario.setForeground(Color.CYAN);
			lblUsuario.setBounds(35, 56, 106, 20);
			contentPanel.add(lblUsuario);
		}
		{
			txtPasword = new JPasswordField();
			txtPasword.setColumns(15);
			txtPasword.setBounds(166, 121, 146, 22);
			contentPanel.add(txtPasword);
		}
		{
			lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblContrasea.setForeground(Color.CYAN);
			lblContrasea.setBounds(35, 121, 106, 20);
			contentPanel.add(lblContrasea);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(166, 56, 146, 22);
			contentPanel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			btnIngresar = new JButton("");
			btnIngresar.setIcon(new ImageIcon(GESTIONHOTELERA_PRINCIPAL.class.getResource("/imagenes/48-icono9.png")));
			btnIngresar.addActionListener(this);
			btnIngresar.setForeground(Color.BLUE);
			btnIngresar.setBounds(364, 13, 132, 99);
			contentPanel.add(btnIngresar);
		}
		{
			btnSalir = new JButton("");
			btnSalir.setIcon(new ImageIcon(GESTIONHOTELERA_PRINCIPAL.class.getResource("/imagenes/dialog-error.png")));
			btnSalir.addActionListener(this);
			btnSalir.setForeground(Color.BLUE);
			btnSalir.setBounds(364, 123, 132, 99);
			contentPanel.add(btnSalir);
		}
		{
			txtIngreseUsuarioY = new JTextField();
			txtIngreseUsuarioY.setBackground(Color.ORANGE);
			txtIngreseUsuarioY.setForeground(Color.RED);
			txtIngreseUsuarioY.setFont(new Font("Tahoma", Font.BOLD, 15));
			txtIngreseUsuarioY.setText("Ingrese Usuario y Contrase\u00F1a para entrar");
			txtIngreseUsuarioY.setBounds(10, 11, 333, 20);
			contentPanel.add(txtIngreseUsuarioY);
			txtIngreseUsuarioY.setColumns(10);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(GESTIONHOTELERA_PRINCIPAL.class.getResource("/imagenes/contra.jpg")));
			label.setBounds(0, 0, 501, 273);
			contentPanel.add(label);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
	}

	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		if (String.valueOf(txtUsuario.getText()).compareTo("") == 0 && String.valueOf(txtPasword.getPassword()).compareTo("") == 0) {
			
			JOptionPane.showMessageDialog(null,"Los Casilleros se encuentran vacios", "Alerta",JOptionPane.ERROR_MESSAGE);
		} else {
			if (String.valueOf(txtUsuario.getText()).compareTo(txtUsuario.getText()) == 0	&& String.valueOf(txtPasword.getPassword()).compareTo("") == 0) {
				
				JOptionPane.showMessageDialog(null,"El Casillero de CONTRASEÑA está vacio", "Alerta",JOptionPane.ERROR_MESSAGE);
			} else {
				if (String.valueOf(txtUsuario.getText()).compareTo("") == 0&& String.valueOf(txtPasword.getPassword()).compareTo(txtPasword.getText()) == 0) {
					
					JOptionPane.showMessageDialog(null,"El casillero de USUARIO está vacio", "Alerta",JOptionPane.ERROR_MESSAGE);
				} else {
					if (String.valueOf(txtUsuario.getText()).compareTo("alumnos") == 0 && String.valueOf(txtPasword.getPassword()).compareTo("cibertec") == 0) {
						new MenuPrincipal().setVisible(true);
						this.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"USUARIO o CONTRASEÑA incorrecta", "Alerta",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		int dato = JOptionPane.showConfirmDialog(rootPane,
				"Esta seguro que desea Salir", "ALERTA",
				JOptionPane.ERROR_MESSAGE);
		if (dato == 0) {
			this.dispose();
		}
	}
}
