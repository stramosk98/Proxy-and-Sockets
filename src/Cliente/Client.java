package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
            Socket socket = new Socket(InetAddress.getByName("localhost"), 12349); //ip proxy
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            String id = "2";
            saida.writeUTF(id);
            saida.flush();
            
            entrada.close();
            saida.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
