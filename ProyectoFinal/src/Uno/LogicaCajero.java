package Uno;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class LogicaCajero {

	private int id=0;
	private String carrito = "";
	private double precio = 0;
	private String detalles = "";
	private String intentoContrasenya = "";
	private String nombreUsuario = "";
	private String contrasenya = "";
	private JFrame frame;
	private int unidadesEntrante = 1;
	private int unidadesBebida = 1;
	private int unidadesPizza = 1;
	private Connection connect;
	private ObjectOutputStream outObjeto;

	public LogicaCajero() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Pizzeria";
			String user = "root";
			String password = "administrador";
			connect = DriverManager.getConnection(url, user, password);
			//SOCKET
			int numeroPuerto = 4545;// Puerto
            ServerSocket servidor = new ServerSocket(numeroPuerto);
            Socket cliente = servidor.accept();
            outObjeto = new ObjectOutputStream(cliente.getOutputStream());// Se prepara un flujo de salida para objetos
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unidadesSpinner(String nombreSpinner, JSpinner spinner_Contador) {
		switch (nombreSpinner) {
		case "spinner_ContadorPizza":
			unidadesPizza = (Integer) spinner_Contador.getValue();
			nombreSpinner = "";
			break;
		case "spinner_ContadorEntrante":
			unidadesEntrante = (Integer) spinner_Contador.getValue();
			nombreSpinner = "";
			break;
		case "spinner_ContadorBebida":
			unidadesBebida = (Integer) spinner_Contador.getValue();
			nombreSpinner = "";
			break;
		default:
			JOptionPane.showMessageDialog(frame, "Operacion fallida", "Operacion unidadesSpinner fallida",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void selecionarProducto(String nombreProducto, JTextArea textArea_Carrito, JLabel lblNewLabel_MostrarPrecio,
			JMenuItem mntmNewMenuItem) {
		switch (nombreProducto) {
		case "Margarita":
			carrito += (unidadesPizza + "X " + "Margarita" + "\n");
			precio += unidadesPizza * 6;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		case "Barbacoa":
			carrito += (unidadesPizza + "X " + "Barbacoa" + "\n");
			precio += unidadesPizza * 7;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		case "Carbonara":
			carrito += (unidadesPizza + "X " + "Carbonara" + "\n");
			precio += unidadesPizza * 8;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		case "Patatas":
			carrito += (unidadesEntrante + "X " + "Patatas" + "\n");
			precio += unidadesEntrante * 2;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		case "AlitasPollo":
			carrito += (unidadesEntrante + "X " + "Alitas de Pollo" + "\n");
			precio += unidadesEntrante * 2.50;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		case "PanAjo":
			carrito += (unidadesEntrante + "X " + "Pan de Ajo" + "\n");
			precio += unidadesEntrante * 1.50;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		case "Agua":
			carrito += (unidadesBebida + "X " + "Agua" + "\n");
			precio += unidadesBebida * 1.50;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		case "FantaNaranja":
			carrito += (unidadesBebida + "X " + "Fanta de Naranja" + "\n");
			precio += unidadesBebida * 2.50;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		case "CocaCola":
			carrito += (unidadesBebida + "X " + "Coca Cola" + "\n");
			precio += unidadesBebida * 2.50;
			textArea_Carrito.setText(carrito);
			lblNewLabel_MostrarPrecio.setText("Precio: " + precio + "€");
			mntmNewMenuItem.setEnabled(false);
			nombreProducto = "";
			break;
		default:
			JOptionPane.showMessageDialog(frame, "Operacion fallida", "Operacion selecionarProducto fallida",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	public void iniciarSeion(JTextField textField_EscribirNombreUsuario,
			JTextField textField_EscribirContrasenya) {
		nombreUsuario = textField_EscribirNombreUsuario.getText();
		intentoContrasenya = textField_EscribirContrasenya.getText();
		try {
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery("select contrasenya from Empleados where usuario='"+nombreUsuario+"';");
			
			if(rs.next()) {
				contrasenya=rs.getString(1);
				if (intentoContrasenya.equals(contrasenya)) {
					textField_EscribirContrasenya.setText("");

					JOptionPane.showMessageDialog(frame, "Disfrute del turno, " + nombreUsuario, "Ha iniciado sesion",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(frame, "Contrasenya inconrrecta", "Error al inicar sesion",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(frame, "Nombre inconrrecto", "Error al inicar sesion",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public void comprar(JTextPane textPane_EscribirDetalles) {// <--------------------------------------------------------@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		detalles = textPane_EscribirDetalles.getText();
		if (!(nombreUsuario.equals("")) && !(carrito.equals("")) && !(precio == 0)) {

			
			try {
				outObjeto.writeObject(new Pedido(id, nombreUsuario, carrito, detalles, precio));// hacer que se mande esto;
				id = id + 1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(frame, "Exito", "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame, "Asegurese de haber iniciado sesion y selecionar al menos un producto",
					"Error al realizar la compra", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void borrarPedido(JTextArea textArea_Carrito, JTextPane textPane_EscribirDetalles,
			JLabel lblNewLabel_MostrarPrecio, JSpinner spinner_ContadorPizza, JSpinner spinner_ContadorEntrante,
			JSpinner spinner_ContadorBebida, JMenuItem mntmNewMenuItem_Margarita, JMenuItem mntmNewMenuItem_Barbacoa,
			JMenuItem mntmNewMenuItem_Carbonara, JMenuItem mntmNewMenuItem_Patatas,
			JMenuItem mntmNewMenuItem_AlitasPollo, JMenuItem mntmNewMenuItem_PanAjo, JMenuItem mntmNewMenuItem_Agua,
			JMenuItem mntmNewMenuItem_FantaNaranja, JMenuItem mntmNewMenuItem_CocaCola) {
		carrito = "";
		precio = 0;
		unidadesEntrante = 1;
		unidadesBebida = 1;
		unidadesPizza = 1;
		detalles = "";
		textArea_Carrito.setText("");
		textPane_EscribirDetalles.setText("");
		lblNewLabel_MostrarPrecio.setText("Precio: ");
		spinner_ContadorPizza.setValue(1);
		spinner_ContadorEntrante.setValue(1);
		spinner_ContadorBebida.setValue(1);
		mntmNewMenuItem_Margarita.setEnabled(true);
		mntmNewMenuItem_Barbacoa.setEnabled(true);
		mntmNewMenuItem_Carbonara.setEnabled(true);
		mntmNewMenuItem_Patatas.setEnabled(true);
		mntmNewMenuItem_AlitasPollo.setEnabled(true);
		mntmNewMenuItem_PanAjo.setEnabled(true);
		mntmNewMenuItem_Agua.setEnabled(true);
		mntmNewMenuItem_FantaNaranja.setEnabled(true);
		mntmNewMenuItem_CocaCola.setEnabled(true);
	}

	public void cerrarSesion(JTextField textField_EscribirNombreUsuario, JTextField textField_EscribirContrasenya) {
		intentoContrasenya = "";
		nombreUsuario = "";
		contrasenya = "";
		textField_EscribirNombreUsuario.setText("");
		textField_EscribirContrasenya.setText("");
	}
}
