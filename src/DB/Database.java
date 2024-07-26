package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	private String name;
	private Connect connection;
	
	public Database() {
		
	}

	public Database(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Connect getConnection() {
		return connection;
	}

	public void setConnection(Connect connection) {
		this.connection = connection;
	}
	
   public String checkId(String id) {
		
		if(connection != null) {
			try {
//	            Statement statement = connection.getConnection().createStatement();

	            String sql = "SELECT * FROM " + name + ".produtos WHERE idProduto = " + id;
	            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);
//	            preparedStatement.setInt(1, parseInt(id));

	            // Executar a consulta
	            ResultSet resultSet = preparedStatement.executeQuery();

	            // Processar o resultado
	            String resultado = "";
	            if (resultSet.next()) {
	                resultado = "ID: " + resultSet.getString("idProduto") + ", ";
	                resultado += "Nome: " + resultSet.getString("nomeProduto") + ", ";
	                resultado += "Quantidade: " + resultSet.getString("quantidade") + ", ";
	            } else {
	                resultado = "Nenhum dado encontrado para ID: " + id;
	            }
				return resultado;
			}catch (SQLException excep) {
				System.out.println(excep);
			}
		}else {
			System.out.println("Fail to connect on database");
			
		}
		return id;
	}

	
}
