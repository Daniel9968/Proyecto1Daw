package Uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;

public class InterfazCocina {

	private JFrame frame;
	private JTextField textField_EscribirNombreUsuario;
	private JTextField textField_EscribirContrasenya;
	private LogicaCocina lcocina;
	JTextArea textArea_Pedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCocina window = new InterfazCocina();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazCocina() {
		initialize();
		lcocina=new LogicaCocina(textArea_Pedidos);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfazCocina.class.getResource("/Imagenes/escritorio.png")));
		frame.setBounds(100, 100, 801, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBounds(10, 11, 758, 43);
		frame.getContentPane().add(panelUsuario);
		
		JLabel lblNewLabel_NombreUsuario = new JLabel("Usuario:");
		lblNewLabel_NombreUsuario.setBounds(7, 11, 58, 14);
		panelUsuario.add(lblNewLabel_NombreUsuario);
		
		textField_EscribirNombreUsuario = new JTextField();
		textField_EscribirNombreUsuario.setColumns(10);
		textField_EscribirNombreUsuario.setBounds(75, 8, 154, 20);
		panelUsuario.add(textField_EscribirNombreUsuario);
		
		JLabel lblNewLabel_4 = new JLabel("Contrasenya: ");
		lblNewLabel_4.setBounds(239, 11, 79, 14);
		panelUsuario.add(lblNewLabel_4);
		
		textField_EscribirContrasenya = new JTextField();
		textField_EscribirContrasenya.setForeground(Color.WHITE);
		textField_EscribirContrasenya.setColumns(10);
		textField_EscribirContrasenya.setBounds(329, 8, 154, 20);
		panelUsuario.add(textField_EscribirContrasenya);
		
		JButton btnNewButton_CerrarSesion = new JButton("Cerrar Sesion");
		btnNewButton_CerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lcocina.cerrarSesion(textField_EscribirNombreUsuario, textField_EscribirContrasenya);
			}
		});
		btnNewButton_CerrarSesion.setBounds(616, 7, 132, 23);
		panelUsuario.add(btnNewButton_CerrarSesion);
		
		JButton btnNewButton_IniciarSesion = new JButton("Inciar Sesion");
		btnNewButton_IniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lcocina.iniciarSeion(textField_EscribirNombreUsuario, textField_EscribirContrasenya);
			}
		});
		btnNewButton_IniciarSesion.setBounds(493, 7, 113, 23);
		panelUsuario.add(btnNewButton_IniciarSesion);
		
		JLabel lblNewLabel_IDpedido = new JLabel("Numero del ID del pedido ha borrar: ");
		lblNewLabel_IDpedido.setBounds(10, 358, 211, 14);
		frame.getContentPane().add(lblNewLabel_IDpedido);
		
		JSpinner spinner_ID = new JSpinner();
		spinner_ID.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lcocina.unidadesSpinner(spinner_ID);
			}
		});
		spinner_ID.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_ID.setBounds(275, 354, 51, 23);
		frame.getContentPane().add(spinner_ID);
		
		JButton btnNewButton_Borrar = new JButton("Borrar");
		btnNewButton_Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lcocina.borrar();
			}
		});
		btnNewButton_Borrar.setBounds(368, 354, 89, 23);
		frame.getContentPane().add(btnNewButton_Borrar);
		
		JPanel panel_vista = new JPanel();
		panel_vista.setBounds(10, 65, 758, 269);
		frame.getContentPane().add(panel_vista);
		panel_vista.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 738, 247);
		panel_vista.add(scrollPane);
		
		textArea_Pedidos = new JTextArea();
		scrollPane.setViewportView(textArea_Pedidos);
		textArea_Pedidos.setTabSize(255);
		textArea_Pedidos.setRows(255);
		textArea_Pedidos.setLineWrap(true);
		textArea_Pedidos.setEditable(false);
		
	}
}
