
package br.usp.pcs.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class ApoliceDAO {
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

    public boolean setStatus(int numeroApolice, Apolice.Status status) {
        String query = "UPDATE Apolice SET status = ? WHERE numeroApolice = ?";

        PreparedStatement statement = null;
        Connection connection = getConnection();

        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, status.toString());
            statement.setInt(2, numeroApolice);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed");
            throw new RuntimeException(e);
        } finally {
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

    public int insertApolice(Apolice apolice) {
        final String query = "INSERT INTO Apolice (nomeSegurado, marcaVeiculo, modeloVeiculo, " +
                "anoVeiculo, valorContratacao, tiposCobertura, tipoFranquiaCasco, franquiaAcessorios, " +
                "valorFranquiaCasco, valorPremio, CPF, email, endereco, dataNascimento, " +
                "status, valorAcessorios, valorFranquiaAcessorios, danosMateriais, danosCorporais, createdAt) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        final String queryID = "SELECT LAST_INSERT_ID();";
        PreparedStatement statement = null;
        ResultSet result = null;
        int idApolice = 0;


        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, apolice.getNomeSegurado());
            statement.setString(2, apolice.getMarcaVeiculo());
            statement.setString(3, apolice.getModeloVeiculo());
            statement.setInt(4, apolice.getAnoVeiculo());
            statement.setDouble(5, apolice.getValorContratacao());
            statement.setString(6, apolice.getCoberturasString());
            statement.setString(7, apolice.getTipoFranquiaCasco().toString());
            statement.setBoolean(8, apolice.getFranquiaAcessorios());
            statement.setDouble(9, apolice.getValorFranquiaCasco());
            statement.setDouble(10, apolice.getValorPremio());
            statement.setString(11, apolice.getCPF());
            statement.setString(12, apolice.getEmail());
            statement.setString(13, apolice.getEndereco());
            statement.setDate(14, new java.sql.Date(apolice.getDataNascimento().getTime()));
            statement.setString(15, Apolice.Status.Ativa.toString());
            statement.setDouble(16, apolice.getValorAcessorios());
            statement.setDouble(17, apolice.getValorFranquiaAcessorios());
            statement.setBoolean(18, apolice.getDanosMateriais());
            statement.setBoolean(19, apolice.getDanosCorporais());
            statement.setDate(20, new java.sql.Date(new Date().getTime()));
            statement.execute();
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = connection.prepareStatement(queryID);
            result = statement.executeQuery();
            result.first();
            idApolice = result.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idApolice;
    }

    private Apolice apoliceFromResult(ResultSet res) {
        try {
            return new Apolice(res.getString("marcaVeiculo"), res.getString("modeloVeiculo"),
                    res.getInt("anoVeiculo"), res.getDouble("valorContratacao"),
                    Apolice.TipoFranquiaCasco.valueOf(res.getString("tipoFranquiaCasco")),
                    res.getBoolean("franquiaAcessorios"), res.getDouble("valorAcessorios"), res.getDouble("valorFranquiaCasco"), res.getDouble("valorFranquiaAcessorios"),
                    res.getDouble("valorPremio"), res.getDouble("valorSegurado"),
                    res.getInt("numeroApolice"), res.getString("nomeSegurado"),
                    res.getString("CPF"), res.getString("email"), res.getString("endereco"),
                    res.getDate("dataNascimento"), Apolice.Status.valueOf(res.getString("status")), res.getBoolean("danosMateriais"), res.getBoolean("danosCorporais"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}

