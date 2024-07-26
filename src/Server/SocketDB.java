package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketDB {
	
	public static String socketBancoDeDados(String id) throws IOException {
		try (Socket socket = new Socket("localhost", 12348); //ip database
             DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
             DataInputStream entrada = new DataInputStream(socket.getInputStream())) {

            saida.writeUTF(id);
            return entrada.readUTF();
        }
    }
}
