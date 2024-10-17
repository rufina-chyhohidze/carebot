package be.kdg.programming3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static final String connectionString = "jdbc:postgresql://10.134.178.167:5432/postgres";
    private static final String connectionUser = "postgres";
    private static final String connectionPassword = "DBP@ss";

    public DataBase() {
        createTables();
    }

    public static void createTables() {
        try (Connection connection = DriverManager.getConnection(connectionString, connectionUser, connectionPassword)) {
            try (Statement statement = connection.createStatement()) {
                // Create delivery_table first
                statement.executeUpdate("""
                        CREATE TABLE IF NOT EXISTS delivery_table (
                            delivery_id INTEGER CONSTRAINT delivery_pk PRIMARY KEY,
                            delivery_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            obstacle_quantity INTEGER,
                            drop_point VARCHAR(50),
                            status VARCHAR(50)
                        );""");

                // Now create obstacle_table which references delivery_table
                statement.executeUpdate("""
                        CREATE TABLE IF NOT EXISTS obstacle_table (
                            delivery_id INTEGER CONSTRAINT delivery_fk REFERENCES delivery_table,
                            obstacle_id INTEGER,
                            obstacle_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                        );""");

                System.out.println("Connected to the database successfully: (If the tables don't appear make sure you reload the database).");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage() + " (Make sure you are connected to KdG's network and you have inserted the correct properties for the database connection).");
        }
    }

    public static String getConnectionString() {
        return connectionString;
    }
    public static String getConnectionUser() {
        return connectionUser;
    }
    public static String getConnectionPassword(){
        return connectionPassword;
    }
}