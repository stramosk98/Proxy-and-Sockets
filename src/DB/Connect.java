package DB;

import java.sql.DriverManager;
import java.sql.Connection;

public class Connect {
	
	private String host;
	private int port;
	private String user;
	private String password;
	private String name;
	
	public Connect(String host, int port, String user, String password, String name) {
		this.setHost(host);
		this.setPort(port);
		this.setUser(user);
		this.setPassword(password);
		this.setName(name);
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Connection getConnection() {
		try {
    		Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + name;
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            return null;
        }
	}
}
