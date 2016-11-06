package principal;

import imagenes.Fondo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;

public class MenuPrincipal extends JFrame implements ActionListener, Runnable {

	Thread hilo;

	private Fondo contentPane;
	private JMenuItem mntmCliente;
	private JMenuItem mntmEmpleado;
	private JMenuItem mntmCine;
	private JMenuItem mntmSala;
	private JMenuItem mntmButaca;
	private JMenuItem mntmSalir;
	private JMenu mnReserva;
	private JMenuItem mntmReservarHabitacin;
	private JMenuItem mntmAcercaDeHospedaje;
	private JMenuItem mntmIniciarConsulta;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Sistema de Gestion de Cines");
		setBounds(100, 100, 1089, 785);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(184, 134, 11));
		setJMenuBar(menuBar);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/procesar.gif")));
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnMantenimiento);

		mntmCliente = new JMenuItem("Registrar Cliente");
		mntmCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/buscar.png")));
		mntmCliente.addActionListener(this);
		mnMantenimiento.add(mntmCliente);

		mntmEmpleado = new JMenuItem("Registrar Empleado");
		mntmEmpleado.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/buscar.png")));
		mntmEmpleado.addActionListener(this);
		mnMantenimiento.add(mntmEmpleado);

		mntmCine = new JMenuItem("Registrar Cine");
		mntmCine.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/buscar.png")));
		mntmCine.addActionListener(this);
		mnMantenimiento.add(mntmCine);
		
		mntmSala = new JMenuItem("Registrar Sala");
		mntmSala.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/buscar.png")));
		mntmSala.addActionListener(this);
		mnMantenimiento.add(mntmSala);
		
		mntmButaca = new JMenuItem("Registrar Butaca");
		mntmButaca.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/buscar.png")));
		mntmButaca.addActionListener(this);
		mnMantenimiento.add(mntmButaca);

		mnReserva = new JMenu("Reserva");
		mnReserva.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/procesar.gif")));
		mnReserva.addActionListener(this);
		mnReserva.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnReserva);
		{
			mntmReservarHabitacin = new JMenuItem("INICIAR RESERVA HABITACI\u00D3N");
			mntmReservarHabitacin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/icono_buscar.gif")));
			mntmReservarHabitacin.addActionListener(this);
			mnReserva.add(mntmReservarHabitacin);
		}

		JMenu mnHospedaje = new JMenu("Hospedaje");
		mnHospedaje.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/procesar.gif")));
		mnHospedaje.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnHospedaje);

		mntmAcercaDeHospedaje = new JMenuItem("ACERCA DE HOSPEDAJE");
		mntmAcercaDeHospedaje.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/lupa.png")));
		mntmAcercaDeHospedaje.addActionListener(this);
		mnHospedaje.add(mntmAcercaDeHospedaje);

		JMenu mnReportesYConsultas = new JMenu("Reportes y Consultas");
		mnReportesYConsultas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/procesar.gif")));
		mnReportesYConsultas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnReportesYConsultas);
		{
			mntmIniciarConsulta = new JMenuItem("INICIAR CONSULTA");
			mntmIniciarConsulta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/lupa.png")));
			mntmIniciarConsulta.addActionListener(this);
			mnReportesYConsultas.add(mntmIniciarConsulta);
		}

		JMenu mnOpciones = new JMenu("Salir");
		mnOpciones.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/procesar.gif")));
		mnOpciones.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnOpciones);

		mntmSalir = new JMenuItem("SALIR");
		mntmSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/closelabel.gif")));
		mntmSalir.addActionListener(this);
		mnOpciones.add(mntmSalir);
		contentPane = new Fondo("/Imagenes/fondo1.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.white);
		contentPane.add(lblNewLabel);

		hilo = new Thread(this);
		hilo.start();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmIniciarConsulta) {
			do_mntmIniciarConsulta_actionPerformed(e);
		}
		if (e.getSource() == mntmAcercaDeHospedaje) {
			do_mntmAcercaDeHospedaje_actionPerformed(e);
		}
		if (e.getSource() == mntmReservarHabitacin) {
			do_mntmReservarHabitacin_actionPerformed(e);
		}

		if (e.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(e);
		}
		if (e.getSource() == mntmCliente) {
			do_mntmCliente_actionPerformed(e);
		}
		if (e.getSource() == mntmEmpleado) {
			do_mntmEmpleado_actionPerformed(e);
		}
		if (e.getSource() == mntmCine) {
			do_mntmCine_actionPerformed(e);
		}
		if (e.getSource() == mntmSala) {
			do_mntmSala_actionPerformed(e);
		}
		if (e.getSource() == mntmButaca) {
			do_mntmButaca_actionPerformed(e);
		}
	}

	protected void do_mntmButaca_actionPerformed(ActionEvent e) {
		new Butaca().setVisible(true);
	}
	protected void do_mntmSala_actionPerformed(ActionEvent e) {
		new Salas().setVisible(true);
	}
	protected void do_mntmCine_actionPerformed(ActionEvent e) {
		new Cines().setVisible(true);
	}
	protected void do_mntmCliente_actionPerformed(ActionEvent e) {
		new Clientes().setVisible(true);
	}

	protected void do_mntmEmpleado_actionPerformed(ActionEvent e) {
		new Empleados().setVisible(true);
	}

	protected void do_mntmSalir_actionPerformed(ActionEvent e) {
		int dato = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea Salir", "ALERTA",
				JOptionPane.WARNING_MESSAGE);
		if (dato == 0) {
			this.dispose();
		}
	}

	protected void do_mntmReservarHabitacin_actionPerformed(ActionEvent e) {
		new Reserva().setVisible(true);
	}

	protected void do_mntmAcercaDeHospedaje_actionPerformed(ActionEvent e) {
		new Hospedaje().setVisible(true);
	}

	protected void do_mntmIniciarConsulta_actionPerformed(ActionEvent e) {
		new Consultas().setVisible(true);
	}

	public void run() {
		while (hilo != null)
			try {
				Thread.sleep(1);
				actualizarFechaYhora();
			} catch (Exception e) {
			}
	}

	// Métodos tipo void (sin parámetros)
	void actualizarFechaYhora() {
		lblNewLabel.setText("Fecha = " + fecha() + " \n  " + "Hora = " + hora());
	}

	// Métodos que retornan valor (sin parámetros)
	String fecha() {
		Calendar calendario = new GregorianCalendar();
		return String.format("%02d/", calendario.get(Calendar.DAY_OF_MONTH))
				+ String.format("%02d/", calendario.get(Calendar.MONTH) + 1) + calendario.get(Calendar.YEAR);
	}

	String hora() {
		Calendar calendario = new GregorianCalendar();
		return String.format("%02d:", calendario.get(Calendar.HOUR_OF_DAY))
				+ String.format("%02d:", calendario.get(Calendar.MINUTE))
				+ String.format("%02d", calendario.get(Calendar.SECOND));
	}
}
