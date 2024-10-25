//package be.kdg.programming3.database;
//
////import org.springframework.data.repository.query.ReturnedType;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataBase {
//    private static final String connectionString = "jdbc:postgresql://10.134.178.167:5432/postgres";
//    private static final String connectionUser = "postgres";
//    private static final String connectionPassword = "DBP@ss";
//
//    public DataBase() {
//        createTables();
//    }
//
//    public static void createTables() {
//        try (Connection connection = DriverManager.getConnection(connectionString, connectionUser, connectionPassword)) {
//            try (Statement statement = connection.createStatement()) {
//                // Create delivery_table first
//                statement.executeUpdate("""
//                        CREATE TABLE DELIVERY_TABLE (
//                                                                DELIVERY_ID INTEGER CONSTRAINT DELIVERY_PK PRIMARY KEY,
//                                                                DELIVERY_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//                                                                OBSTACLE_QUANTITY INTEGER DEFAULT 1,
//                                                                DROP_POINT VARCHAR(50),
//                                                                STATUS VARCHAR(50)
//                                );""");
//
//                // Now create obstacle_table which references delivery_table
//                statement.executeUpdate("""
//                        CREATE TABLE IF NOT EXISTS OBSTACLE_TABLE (
//                               DELIVERY_ID INTEGER CONSTRAINT DELIVERY_FK REFERENCES DELIVERY_TABLE,
//                               OBSTACLE_ID INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
//                               OBSTACLE_TIMESTAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//                               OBSTACLE_DISTANCE INTEGER
//                             );""");
//
//                System.out.println("Connected to the database successfully: (If the tables don't appear make sure you reload the database).");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error connecting to the database: " + e.getMessage() + " (Make sure you are connected to KdG's network and you have inserted the correct properties for the database connection).");
//        }
//    }
//
//    public static void insertDistance(int distance) {
//        try (Connection connection = DriverManager.getConnection(connectionString, connectionUser, connectionPassword)) {
//            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO OBSTACLE_TABLE(delivery_id, obstacle_distance) VALUES (1, ?);")) {
//
//                statement.setObject(1, distance);
//                statement.execute();
//
//
//
//            }
//        } catch (SQLException e) {
//            System.err.println("Error connecting to the database: " + e.getMessage() + " (Make sure you are connected to KdG's network and you have inserted the correct properties for the database connection).");
//        }
//    }
//    public static List<List<String>> getObstacles() {
//        List<List<String>> obstacles = new ArrayList<>();
//
//        try (Connection connection = DriverManager.getConnection(connectionString, connectionUser, connectionPassword)) {
//            try (Statement statement = connection.createStatement()) {
//
//                ResultSet resultSet = statement.executeQuery(
//                        "SELECT DELIVERY_ID, OBSTACLE_TIMESTAMP, OBSTACLE_DISTANCE " +
//                                "FROM OBSTACLE_TABLE " +
//                                "ORDER BY OBSTACLE_TIMESTAMP DESC;"
//                );
//
//                while (resultSet.next()) {
//                    // Fetch integers and convert them to strings
//                    String deliveryId = String.valueOf(resultSet.getInt("DELIVERY_ID"));
//                    String timestamp = resultSet.getString("OBSTACLE_TIMESTAMP");
//                    String distance = String.valueOf(resultSet.getInt("OBSTACLE_DISTANCE")); // Convert int to String
//
//                    // Add all the values as strings to the list
//                    List<String> obstacle = new ArrayList<>(List.of(deliveryId, timestamp, distance));
//                    obstacles.add(obstacle);
//                }
//            }
//        } catch (SQLException e) {
//            System.err.println("Error connecting to the database: " + e.getMessage());
//        }
//
//        return obstacles;
//    }
//
//
//
//    public static String getConnectionString() {
//        return connectionString;
//    }
//    public static String getConnectionUser() {
//        return connectionUser;
//    }
//    public static String getConnectionPassword(){
//        return connectionPassword;
//    }
//}