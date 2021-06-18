package Uno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.SocketException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class readingFromSocket extends Thread {

	PrintStream output;
	ObjectInputStream input = null;
	JTextPane textArea1;
	boolean disconnect;
	ArrayList<Pedido> lista;
	private JTextArea textArea_Pedidos;
	
	
	public readingFromSocket(ObjectInputStream initialinput, ArrayList<Pedido> lista, JTextArea textArea_Pedidos) {
		this.input = initialinput;
		this.lista=lista;
		this.textArea_Pedidos=textArea_Pedidos;
	}
	
	

	//@override
	public void run() {
		while (!disconnect) {
			try {
				try {
				lista.add((Pedido) input.readObject());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				textArea_Pedidos.setText("");
				for (int i = 0; i < lista.size(); i++) {
					textArea_Pedidos.append(lista.get(i).toString()+"\n"+"-----------------"+"\n");
				}
			} catch (SocketException e1) {
				System.out.println("Conexión cerrada");
			} catch (IOException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void kill() {
		disconnect = true;
	}
}