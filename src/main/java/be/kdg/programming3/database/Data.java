package be.kdg.programming3.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Data {
    private final Connection connection;

    public Data() throws SQLException {
        connection = DriverManager.getConnection(DataBase.getConnectionString(), DataBase.getConnectionUser(), DataBase.getConnectionPassword());
    }

    public List<List<Object>> retrieveDataInformation(int orderBY, boolean ascending) throws SQLException {
        List<List<Object>> allRows = new LinkedList<>();

        final String dataQuery = "SELECT * FROM deliverytable ORDER BY " + orderBY + " " + (ascending ? "ASC;" : "DESC;");

        System.out.println("ABOUT TO TRY CONNECTION");


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(dataQuery);

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                List<Object> row = new LinkedList<>();

                int deliveryId = resultSet.getInt(1);
                int employeeId = resultSet.getInt(2);
                String deliveryTime = resultSet.getString(3);

                row.add(deliveryId);
                row.add(employeeId);
                row.add(deliveryTime);

                allRows.add(row);
            }
        } catch (SQLException e) {
            System.out.println("CONNECTION FAILED");
        }
        return allRows;
    }
}
