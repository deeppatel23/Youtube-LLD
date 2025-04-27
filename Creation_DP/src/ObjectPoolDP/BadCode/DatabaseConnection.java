package ObjectPoolDP.BadCode;

public class DatabaseConnection {
    public void open() {
        // Very expensive operation (time and resources)
        System.out.println("Database connection opened");
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }

    public void close() {
        System.out.println("Database connection closed");
    }
}
