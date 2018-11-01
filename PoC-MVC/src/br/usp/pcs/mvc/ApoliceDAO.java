
package br.usp.pcs.mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class ApoliceDAO {

	
	private Connection connection;
	private static final String ADDRESS = "jdbc:mariadb://143.107.102.7:3306/t1g1" +
			"?user=t1g1&password=H?M@UgvW";

	
		public ApoliceDAO () {
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("MariaDB driver not found");
				throw new RuntimeException(e);
			}
			try {
				connection = DriverManager.getConnection(ADDRESS);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Database connection failed");
				throw new RuntimeException(e);
			}
			
		}
			
		public Apolice getApolice(int numeroApolice) {
			String query = "SELECT * FROM Apolice WHERE numeroApolice = ?";
			
			PreparedStatement statement = null;
			ResultSet result = null;
			try {
				statement = connection.prepareStatement(query);
				statement.setInt(1, numeroApolice);
				result = statement.executeQuery();
				result.first();
				return apoliceFromResult(result);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Query failed");
				throw new RuntimeException(e);
			} finally {
				try {
					result.close();
				} catch (SQLException e1) {
				}
				try {
					statement.close();
				} catch (SQLException e) {
				}
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
			
			
	
				


		private Apolice apoliceFromResult(ResultSet res) {
			
			
			
			try {
				return new Apolice(res.getString("marcaVeiculo"), res.getString("modeloVeiculo"), res.getInt("anoVeiculo"), res.getInt("valorContratacao"), res.getString("tipoFranquiaCasco"), res.getBoolean("franquiaAcessorios"), res.getInt("valorFranquia"), res.getInt("valorPremio"), res.getInt("valorSegurado"), res.getInt("numeroApolice"), res.getString("nomeSegurado"), res.getString("CPF"), res.getString("email"), res.getString("endereco"), res.getString("dataNascimento"), res.getString("status"));
			//public Apolice(String marcaVeiculo, String modeloVeiculo, String anoVeiculo, Double valorContratacao, TipoFranquiaCasco tipoFranquiaCasco, Boolean franquiaAcessorios, Double valorFranquia, Double valorPremio, Double valorSegurado, int numeroApolice, String nomeSegurado, String CPF, String email, String endereco, Date dataNascimento, Status status) {
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}

		}

}

