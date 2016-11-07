package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GESTIONHOTELERA_PRINCIPAL extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblUsuario;
	private JPasswordField txtPasword;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JButton btnSalir;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GESTIONHOTELERA_PRINCIPAL.class.getResource("/imagenes/7.jpg")));
		setTitle("Sistema de Gestion de Cines");
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblUsuario.setForeground(Color.BLACK);
			lblUsuario.setBounds(218, 164, 106, 20);
			contentPanel.add(lblUsuario);
		}
		{
			txtPasword = new JPasswordField();
			txtPasword.setColumns(15);
			txtPasword.setBounds(349, 229, 146, 22);
			contentPanel.add(txtPasword);
		}
		{
			lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblContrasea.setForeground(Color.BLACK);
			lblContrasea.setBounds(218, 229, 106, 20);
			contentPanel.add(lblContrasea);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(349, 164, 146, 22);
			contentPanel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			btnIngresar = new JButton("");
			btnIngresar.setBackground(Color.WHITE);
			btnIngresar.setIcon(new ImageIcon(GESTIONHOTELERA_PRINCIPAL.class.getResource("/imagenes/entrar.png")));
			btnIngresar.addActionListener(this);
			btnIngresar.setForeground(new Color(0, 0, 255));
			btnIngresar.setBounds(521, 148, 115, 47);
			contentPanel.add(btnIngresar);
		}
		{
			btnSalir = new JButton("");
			btnSalir.setIcon(new ImageIcon(GESTIONHOTELERA_PRINCIPAL.class.getResource("/imagenes/cancelar.png")));
			btnSalir.addActionListener(this);
			btnSalir.setForeground(Color.BLUE);
			btnSalir.setBounds(521, 216, 115, 47);
			contentPanel.add(btnSalir);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(GESTIONHOTELERA_PRINCIPAL.class.getResource("/imagenes/Loing.png")));
			label.setBounds(0, 0, 684, 462);
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
