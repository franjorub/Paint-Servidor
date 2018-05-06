package gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import conection.Servidor;

public class Ventana extends JFrame{
	
	private Servidor server;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana= new Ventana("Servidor");
	}

	public Ventana(String titulo) throws HeadlessException {
		super(titulo);
		Panel p = new Panel();
		// TODO Auto-generated constructor stub
		server = new Servidor(5000, p.mensajes);
		super.setSize(300, 300);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setContentPane(p);
		super.setVisible(true);
	}
	
	
	private class Panel extends JPanel{
		 JTextArea mensajes;
		 JLabel titulo;
		public Panel() {
			super();
			super.setLayout(new BorderLayout());
			mensajes = new JTextArea();
			titulo = new JLabel("Mensajes recibidos");
			super.add(mensajes, BorderLayout.CENTER);
			super.add(titulo, BorderLayout.NORTH);
		}
		
	}
	
}
