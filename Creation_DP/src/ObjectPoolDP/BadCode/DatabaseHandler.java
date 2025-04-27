package ObjectPoolDP.BadCode;

public class DatabaseHandler {
    public void processRequest(String query) {
        // Har baar nayi connection create karna - expensive operation
        DatabaseConnection connection = new DatabaseConnection();
        connection.open();

        // Query execute karna
        connection.executeQuery(query);

        // Connection close karna
        connection.close();
    }
}
