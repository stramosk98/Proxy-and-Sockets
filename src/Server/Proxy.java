package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Proxy {

	 private static HashMap<String, Cache> cache = new HashMap<>();
	 
	  public static void main(String[] args) {
		  try (ServerSocket serverSocket = new ServerSocket(12349)) {
	            while (true) {
	                try (Socket clientSocket = serverSocket.accept()) {
	                    DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());
	                    DataOutputStream saida = new DataOutputStream(clientSocket.getOutputStream());

	                    String id = entrada.readUTF();
	                    System.out.println("Recebido ID: " + id);

	                    String dados = "";
	                    if (cache.containsKey(id) && !cache.get(id).isExpired()) {
	                        dados = cache.get(id).getData();
	                        System.out.println("Produto obtido do cache: " + dados);
	                    } else {
	                        dados = SocketDB.socketBancoDeDados(id);
	                        cache.put(id, new Cache(dados, System.currentTimeMillis()));
	                        System.out.println("Produto obtido do banco de dados: " + dados);
	                    }

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