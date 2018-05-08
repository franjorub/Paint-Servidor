package conection;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

import gui.AreaDibujo;

/**
 * @author Francisco Rubial
 * @version 0.0.1
 *          <h1>Conexion</h1> Clase para la aceptar mensajes de la conexion @
 */
public class Servidor implements Runnable {
	private Thread hilo;
	private int puerto;
	
    private AreaDibujo area;
	/**
	 * 
	 * Crea un hilo en el que se van a estar aceptando peticiones
	 * 
	 * @param puerto:
	 *            numero del puerto que estara a la escucha de peticiones
	 * @param componente:
	 *            TextArea que se modificara con los mensajes
	 */
	public Servidor(int puerto, AreaDibujo area) {
		this.puerto = puerto;
		this.area = area;
		hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		ServerSocket servidor;
		DataInputStream inputStream;
		Socket entrada;

		try {

			servidor = new ServerSocket(puerto);
			while (true) {

				entrada = servidor.accept();
				inputStream = new DataInputStream(entrada.getInputStream());
				int x = inputStream.readInt();
				int y = inputStream.readInt();
				area.dibujar(x, y);
				entrada.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
