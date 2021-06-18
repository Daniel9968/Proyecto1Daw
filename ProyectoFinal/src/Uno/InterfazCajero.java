package Uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class InterfazCajero {

	private JFrame frame;
	private JTextField textField_EscribirNombreUsuario;
	private JTextField textField_EscribirContrasenya;
	// -------
	String nombreProducto = "";
	String nombreSpinner = "";
	private LogicaCajero lcajero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCajero window = new InterfazCajero();
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
	public InterfazCajero() {
		initialize();
		lcajero=new LogicaCajero();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InterfazCajero.class.getResource("/Imagenes/porcion-de-pizza.png")));
		frame.setBounds(100, 100, 814, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelGlobal = new JPanel();
		panelGlobal.setBounds(10, 11, 778, 487);
		frame.getContentPane().add(panelGlobal);
		panelGlobal.setLayout(null);

		JPanel panel_Entrante = new JPanel();
		panel_Entrante.setBounds(196, 65, 176, 259);
		panelGlobal.add(panel_Entrante);
		panel_Entrante.setLayout(null);

		JLabel lblNewLabel_ImagenEntrante = new JLabel("New label");
		lblNewLabel_ImagenEntrante.setIcon(new ImageIcon(InterfazCajero.class.getResource("/Imagenes/Entrante.png")));
		lblNewLabel_ImagenEntrante.setBounds(10, 11, 156, 156);
		panel_Entrante.add(lblNewLabel_ImagenEntrante);

		JSpinner spinner_ContadorEntrante = new JSpinner();
		spinner_ContadorEntrante.setModel(new SpinnerNumberModel(1, 1, 45, 1));
		spinner_ContadorEntrante.setBounds(126, 188, 40, 23);
		panel_Entrante.add(spinner_ContadorEntrante);

		JMenuBar menuBar_Entrante = new JMenuBar();
		menuBar_Entrante.setBounds(10, 222, 156, 26);
		panel_Entrante.add(menuBar_Entrante);

		JMenu MenuDesplegable_Entrante = new JMenu(
				"Entrantes                                                                                                                                            ");
		menuBar_Entrante.add(MenuDesplegable_Entrante);

		JMenuItem mntmNewMenuItem_Patatas = new JMenuItem("Patatas (2\u20AC)");
		MenuDesplegable_Entrante.add(mntmNewMenuItem_Patatas);

		JMenuItem mntmNewMenuItem_AlitasPollo = new JMenuItem("Alitas de Pollo (2,50\u20AC)");
		MenuDesplegable_Entrante.add(mntmNewMenuItem_AlitasPollo);

		JMenuItem mntmNewMenuItem_PanAjo = new JMenuItem("Pan de Ajo (1,50\u20AC)");
		MenuDesplegable_Entrante.add(mntmNewMenuItem_PanAjo);

		JButton NewButton_CartaEntrante = new JButton("Entrantes");
		NewButton_CartaEntrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame,
						"Patatas: patata, queso, beacon y salsa. Precio: 2€" + "\n"
								+ "Alitas de Pollo: pòllo y salsa. Precio: 2,50€" + "\n"
								+ "Pan de Ajo: pan, queso y ajo. Precio: 1,50€",
						"Carta Entrantes", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		NewButton_CartaEntrante.setBounds(10, 188, 107, 23);
		panel_Entrante.add(NewButton_CartaEntrante);

		JPanel panel_Bebida = new JPanel();
		panel_Bebida.setBounds(382, 65, 176, 259);
		panelGlobal.add(panel_Bebida);
		panel_Bebida.setLayout(null);

		JLabel lblNewLabel_ImagenBebida = new JLabel("New label");
		lblNewLabel_ImagenBebida.setIcon(new ImageIcon(InterfazCajero.class.getResource("/Imagenes/Bebida.png")));
		lblNewLabel_ImagenBebida.setBounds(10, 11, 156, 156);
		panel_Bebida.add(lblNewLabel_ImagenBebida);

		JSpinner spinner_ContadorBebida = new JSpinner();
		spinner_ContadorBebida.setModel(new SpinnerNumberModel(1, 1, 60, 1));
		spinner_ContadorBebida.setBounds(126, 188, 40, 23);
		panel_Bebida.add(spinner_ContadorBebida);

		JButton NewButton_CartaBebidas = new JButton("Bebidas");
		NewButton_CartaBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Agua: agua. Precio: 1,50€" + "\n"
						+ "Fanta Naranja: agua carbonatada, azucar, acido citrico, saborizantes natural y artificial. Precio: 1,50€"
						+ "\n"
						+ "Coca Cola: agua carbonatada, edulcorantes naturales como fructosa o sacarosa, conservadores. Precio: 1,50€",
						"Carta Bebidas", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		NewButton_CartaBebidas.setBounds(10, 188, 107, 23);
		panel_Bebida.add(NewButton_CartaBebidas);

		JMenuBar menuBar_Bebida = new JMenuBar();
		menuBar_Bebida.setBounds(10, 222, 156, 26);
		panel_Bebida.add(menuBar_Bebida);

		JMenu MenuDesplegable_Bebida = new JMenu(
				"Bebidas                                                                                                                                                                                             ");
		menuBar_Bebida.add(MenuDesplegable_Bebida);

		JMenuItem mntmNewMenuItem_Agua = new JMenuItem("Agua 50cl. (1,50\u20AC)");
		MenuDesplegable_Bebida.add(mntmNewMenuItem_Agua);

		JMenuItem mntmNewMenuItem_FantaNaranja = new JMenuItem("Fanta Naraja 50cl. (2,50\u20AC)");
		MenuDesplegable_Bebida.add(mntmNewMenuItem_FantaNaranja);

		JMenuItem mntmNewMenuItem_CocaCola = new JMenuItem("Coca Cola 50cl. (2,50\u20AC)");
		MenuDesplegable_Bebida.add(mntmNewMenuItem_CocaCola);

		JPanel panel_Pizzas = new JPanel();
		panel_Pizzas.setBounds(10, 65, 176, 259);
		panelGlobal.add(panel_Pizzas);
		panel_Pizzas.setLayout(null);

		JLabel lblNewLabel_ImagenPizza = new JLabel("New label");
		lblNewLabel_ImagenPizza.setIcon(new ImageIcon(InterfazCajero.class.getResource("/Imagenes/Pizza2.png")));
		lblNewLabel_ImagenPizza.setBounds(10, 11, 156, 156);
		panel_Pizzas.add(lblNewLabel_ImagenPizza);

		JSpinner spinner_ContadorPizza = new JSpinner();

		spinner_ContadorPizza.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinner_ContadorPizza.setBounds(127, 188, 40, 23);
		panel_Pizzas.add(spinner_ContadorPizza);

		JMenuBar menuBar_Pizza = new JMenuBar();
		menuBar_Pizza.setBounds(10, 222, 156, 26);
		panel_Pizzas.add(menuBar_Pizza);

		JMenu MenuDesplegable_Pizza = new JMenu(
				"PIzzas                                                                                                                ");
		menuBar_Pizza.add(MenuDesplegable_Pizza);

		JMenuItem mntmNewMenuItem_Margarita = new JMenuItem("Margarita (6\u20AC)");
		MenuDesplegable_Pizza.add(mntmNewMenuItem_Margarita);

		JMenuItem mntmNewMenuItem_Barbacoa = new JMenuItem("Barbacoa (7\u20AC)");
		MenuDesplegable_Pizza.add(mntmNewMenuItem_Barbacoa);

		JMenuItem mntmNewMenuItem_Carbonara = new JMenuItem("Carbonara (8\u20AC)");
		MenuDesplegable_Pizza.add(mntmNewMenuItem_Carbonara);

		JButton NewButton_CartaPizza = new JButton("Pizzas");
		NewButton_CartaPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame,
						"Magarita: tomate y queso. Precio: 6€" + "\n"
								+ "Barbacoa: queso, beacon, cebolla, salsa barbacoa. Precio: 7€" + "\n"
								+ "Carbonara: queso, beacon, huevo y salsa carbonara. Precio: 8€",
						"Carta Pizzas", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		NewButton_CartaPizza.setBounds(10, 188, 107, 23);
		panel_Pizzas.add(NewButton_CartaPizza);

		JPanel panelUsuario = new JPanel();
		panelUsuario.setBounds(10, 11, 758, 43);
		panelGlobal.add(panelUsuario);
		panelUsuario.setLayout(null);

		JLabel lblNewLabel_NombreUsuario = new JLabel("Usuario:");
		lblNewLabel_NombreUsuario.setBounds(7, 11, 58, 14);
		panelUsuario.add(lblNewLabel_NombreUsuario);

		textField_EscribirNombreUsuario = new JTextField();
		textField_EscribirNombreUsuario.setBounds(75, 8, 154, 20);
		panelUsuario.add(textField_EscribirNombreUsuario);
		textField_EscribirNombreUsuario.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Contrasenya: ");
		lblNewLabel_4.setBounds(239, 11, 79, 14);
		panelUsuario.add(lblNewLabel_4);

		textField_EscribirContrasenya = new JTextField();
		textField_EscribirContrasenya.setForeground(Color.WHITE);
		textField_EscribirContrasenya.setBounds(329, 8, 154, 20);
		panelUsuario.add(textField_EscribirContrasenya);
		textField_EscribirContrasenya.setColumns(10);

		JButton btnNewButton_CerrarSesion = new JButton("Cerrar Sesion");

		btnNewButton_CerrarSesion.setBounds(616, 7, 132, 23);
		panelUsuario.add(btnNewButton_CerrarSesion);

		JButton btnNewButton_IniciarSesion = new JButton("Inciar Sesion");

		btnNewButton_IniciarSesion.setBounds(493, 7, 113, 23);
		panelUsuario.add(btnNewButton_IniciarSesion);

		JButton btnNewButton_Comprar = new JButton("Comprar");

		btnNewButton_Comprar.setBounds(568, 360, 200, 49);
		panelGlobal.add(btnNewButton_Comprar);

		JLabel lblNewLabel_Comentarios = new JLabel("Comentarios: ");
		lblNewLabel_Comentarios.setBounds(10, 335, 82, 14);
		panelGlobal.add(lblNewLabel_Comentarios);

		JLabel lblNewLabel_MostrarPrecio = new JLabel("Precio: ");
		lblNewLabel_MostrarPrecio.setBounds(568, 335, 200, 14);
		panelGlobal.add(lblNewLabel_MostrarPrecio);

		JButton btnNewButton_BorrarPedido = new JButton("Borrar Pedido");

		btnNewButton_BorrarPedido.setBounds(568, 420, 200, 49);
		panelGlobal.add(btnNewButton_BorrarPedido);

		JTextPane textPane_EscribirDetalles = new JTextPane();
		textPane_EscribirDetalles.setBounds(102, 335, 456, 134);
		panelGlobal.add(textPane_EscribirDetalles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(568, 65, 200, 259);
		panelGlobal.add(scrollPane);
		
		JTextArea textArea_Carrito = new JTextArea();
		textArea_Carrito.setTabSize(255);
		textArea_Carrito.setRows(255);
		scrollPane.setViewportView(textArea_Carrito);
		textArea_Carrito.setEditable(false);

		// ----------------------------------------------

		// Contadores - Spinners
		spinner_ContadorPizza.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				nombreSpinner = "spinner_ContadorPizza";
				lcajero.unidadesSpinner(nombreSpinner, spinner_ContadorPizza);
			}
		});

		spinner_ContadorEntrante.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				nombreSpinner = "spinner_ContadorEntrante";
				lcajero.unidadesSpinner(nombreSpinner, spinner_ContadorEntrante);
			}
		});

		spinner_ContadorBebida.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				nombreSpinner = "spinner_ContadorBebida";
				lcajero.unidadesSpinner(nombreSpinner, spinner_ContadorBebida);
			}
		});

		// Productos-Pizza
		mntmNewMenuItem_Margarita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "Margarita";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_Margarita);
			}
		});

		mntmNewMenuItem_Barbacoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "Barbacoa";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_Barbacoa);
			}
		});

		mntmNewMenuItem_Carbonara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "Carbonara";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_Carbonara);
			}
		});

		// Productos-Entrante
		mntmNewMenuItem_Patatas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "Patatas";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_Patatas);
			}
		});

		mntmNewMenuItem_AlitasPollo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "AlitasPollo";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_AlitasPollo);
			}
		});

		mntmNewMenuItem_PanAjo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "PanAjo";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_PanAjo);
			}
		});

		// Productos-Bebidas
		mntmNewMenuItem_Agua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "Agua";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_Agua);
			}
		});

		mntmNewMenuItem_FantaNaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "FantaNaranja";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_FantaNaranja);
			}
		});

		mntmNewMenuItem_CocaCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreProducto = "CocaCola";
				lcajero.selecionarProducto(nombreProducto, textArea_Carrito, lblNewLabel_MostrarPrecio,
						mntmNewMenuItem_CocaCola);
			}
		});

		// INICIAR SESION
		btnNewButton_IniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcajero.iniciarSeion(textField_EscribirNombreUsuario, textField_EscribirContrasenya);
			}
		});

		// COMPRAR
		btnNewButton_Comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcajero.comprar(textPane_EscribirDetalles);
				lcajero.borrarPedido(textArea_Carrito, textPane_EscribirDetalles, lblNewLabel_MostrarPrecio,
						spinner_ContadorPizza, spinner_ContadorEntrante, spinner_ContadorBebida,
						mntmNewMenuItem_Margarita, mntmNewMenuItem_Barbacoa, mntmNewMenuItem_Carbonara,
						mntmNewMenuItem_Patatas, mntmNewMenuItem_AlitasPollo, mntmNewMenuItem_PanAjo,
						mntmNewMenuItem_Agua, mntmNewMenuItem_FantaNaranja, mntmNewMenuItem_CocaCola);
			}
		});

		// Borrar Pedido
		btnNewButton_BorrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcajero.borrarPedido(textArea_Carrito, textPane_EscribirDetalles, lblNewLabel_MostrarPrecio,
						spinner_ContadorPizza, spinner_ContadorEntrante, spinner_ContadorBebida,
						mntmNewMenuItem_Margarita, mntmNewMenuItem_Barbacoa, mntmNewMenuItem_Carbonara,
						mntmNewMenuItem_Patatas, mntmNewMenuItem_AlitasPollo, mntmNewMenuItem_PanAjo,
						mntmNewMenuItem_Agua, mntmNewMenuItem_FantaNaranja, mntmNewMenuItem_CocaCola);
			}
		});
		// Cerrar Sesion
		btnNewButton_CerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lcajero.cerrarSesion(textField_EscribirNombreUsuario, textField_EscribirContrasenya);
			}
		});
	}
}
