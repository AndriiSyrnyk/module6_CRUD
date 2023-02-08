package javadeveloper.module6.client;

import jakarta.validation.constraints.Size;
import javadeveloper.module6.storage.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    Database database;

    public ClientService(Database database) {
        this.database = database;
    }

    public long create(@Size(min = 2, max = 1000) String name) {
        String sqlInsert = "INSERT INTO client (name) VALUES ?";
        long generatedId = -1;

        try(Connection connection = database.getConnection();
            PreparedStatement insertSt = connection.prepareStatement(sqlInsert,
                                         Statement.RETURN_GENERATED_KEYS)) {
            insertSt.setString(1, name);
            insertSt.executeUpdate();

            try (ResultSet generatedKeys = insertSt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }

    public String getById(@Size(min = 1) long id) {
        String sql = "SELECT name FROM client WHERE id = ?";
        String name = "";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }

    public void setName(@Size(min = 1) long id,
                        @Size(min = 2, max = 1000) String name) {
        String sql = "UPDATE client SET name = ? WHERE id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(@Size(min = 1) long id) {
        String sql = "DELETE FROM client WHERE id = ?";

        try(Connection connection = database.getConnection();
            PreparedStatement deleteSt = connection.prepareStatement(sql)) {
            deleteSt.setLong(1, id);
            deleteSt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listAll() {
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT id, name FROM client";

        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientList;
    }
}