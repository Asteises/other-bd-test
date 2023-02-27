package ru.asteises.otherbdtest.storage;

import lombok.SneakyThrows;
import ru.asteises.otherbdtest.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserJdbcStorage {
    private final String url = "jdbc:postgresql://127.0.0.1:5432/test";
    private final String userName = "postgres";
    private final String password = "postgres";

    @SneakyThrows
    public User findUserById(UUID userId) {

        User result = new User();

        String SQL_SELECT = "select * from USERS where ID = userId";

        try (Connection conn = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.setId(userId);
                result.setName(resultSet.getString("NAME"));
                result.setEmail(resultSet.getString("EMAIL"));
                result.setPassword(resultSet.getString("PASSWORD"));
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

}
