package Uno;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class LogicaCocina {

	private Connection connect;
	private ObjectInputStream inObjeto;
	private readingFromSocket read;
	ArrayList<Pedido> lista = new ArrayList<Pedido>();
	JTextArea textArea_Pedidos;
	private String intentoContrasenya = "";
	private String nombreUsuario = "";
	private String contrasenya = "";
	private JFrame frame;
	private int numID=0;
	
	public LogicaCocina(JTextArea textArea_Pedidos) {
		this.textArea_Pedidos=textArea_Pedidos;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Pizzeria";
			String user = "root";
			String password = "administrador";
			connect = DriverManager.getConnection(url, user, password);
			//SOCKET
			String Host = "127.0.0.1";
            int Puerto = 4545;//puerto remoto
            Socket cliente = new Socket(Host, Puerto);
            inObjeto = new ObjectInputStream(cliente.getInputStream());
            read = new readingFromSocket (inObjeto, lista, textArea_Pedidos);
			read.start();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void cerrarSesion(JTextField textField_EscribirNombreUsuario, JTextField textField_EscribirContrasenya) {
		intentoContrasenya = "";
		nombreUsuario = "";
		contrasenya = "";
		textField_EscribirNombreUsuario.setText("");
		textField_EscribirContrasenya.setText("");
	}

	public void unidadesSpinner(JSpinner spinner_ID) {
		numID = (Integer) spinner_ID.getValue();
	}

	public void borrar() {
		if (!(nombreUsuario.equals(""))) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == numID) {
					lista.remove(i);
					JOptionPane.showMessageDialog(frame, "Ha sido borrado el pedido con ID: "+ numID, "Pedido Borrado",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			}
		else {
			JOptionPane.showMessageDialog(frame, "Inicie sesion para poder borrar pedidos", "ERROR: Pedido NO Borrado",
					JOptionPane.ERROR_MESSAGE);
	}
			textArea_Pedidos.setText("");
			for (int i = 0; i < lista.size(); i++) {
				textArea_Pedidos.append(lista.get(i).toString() + "\n" + "-----------------" + "\n");
			}
		numID=0;
	}
}
