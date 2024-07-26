package DB;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		Connect connection = new Connect("localhost", 3306, "root", "", "mvcsimplesjdbc");
		Database db = new Database("marketplace1");
		db.setConnection(connection);
		
		try (ServerSocket serverSocket = new ServerSocket(12348)) {
	        while (true) {
	            try (Socket clientSocket = serverSocket.accept()) {
	                DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());
	                DataOutputStream saida = new DataOutputStream(clientSocket.getOutputStream());
	
	                String id = entrada.readUTF();
	                System.out.println("Consulta recebida para ID: " + id);
	
	                String dados = db.checkId(id);
	                saida.writeUTF(dados);

	                entrada.close();
	                saida.close();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
