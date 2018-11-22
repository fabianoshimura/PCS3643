
package br.usp.pcs.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


class ApoliceDAO {
	private static final String ADDRESS = "jdbc:mysql://143.107.102.7:3306/t1g1" +
			"?user=t1g1&password=H?M@UgvW";

    public ApoliceDAO () {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MariaDB driver not found");
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(ADDRESS);
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
        Connection connection = getConnection();

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

    public ArrayList<Apolice> getAll() {
        String query = "SELECT * FROM Apolice";

        PreparedStatement statement = null;
        ResultSet result = null;
        Connection connection = getConnection();

        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            ArrayList<Apolice> list = new ArrayList<>();
            while (result.next()) {
                list.add(apoliceFromResult(result));
            }
            return list;
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
            return new Apolice(res.getString("marcaVeiculo"), res.getString("modeloVeiculo"),
                    res.getInt("anoVeiculo"), res.getDouble("valorContratacao"),
                    Apolice.TipoFranquiaCasco.valueOf(res.getString("tipoFranquiaCasco")),
                    res.getBoolean("franquiaAcessorios"), null, res.getDouble("valorFranquia"), null,
                    res.getDouble("valorPremio"), res.getDouble("valorSegurado"),
                    res.getInt("numeroApolice"), res.getString("nomeSegurado"),
                    res.getString("CPF"), res.getString("email"), res.getString("endereco"),
                    res.getDate("dataNascimento"), Status.valueOf(res.getString("status")), true, true);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}

