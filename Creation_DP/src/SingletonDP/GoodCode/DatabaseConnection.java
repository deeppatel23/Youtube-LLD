package SingletonDP.GoodCode;

public class DatabaseConnection {
    // Private static instance variable
    private static DatabaseConnection instance;

    // Connection properties
    private String url;
    private String username;
    private String password;
    private boolean isConnected;

    // Private constructor prevents direct instantiation
    private DatabaseConnection() {
        this.url = "jdbc:mysql://localhost:3306/mydb";
        this.username = "root";
        this.password = "password";
        this.isConnected = true;
        System.out.println("Creating new database connection");
        // In real code, this would establish an actual connection
    }

    // Public static method to get the singleton instance
    public static DatabaseConnection getInstance() {
        // Lazy initialization - create only when needed
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeQuery(String query) {
        if (!isConnected) {
            System.out.println("Error: Connection is closed");
            return;
        }
        System.out.println("Executing query: " + query + " using connection to " + url);
    }

    public void close() {
        if (isConnected) {
            System.out.println("Closing database connection");
            isConnected = false;
            // In real code, this would close the actual connection
        }
    }

    // Thread-safe version (more advanced)
    // Needed when Multiple threads are accessing the Singleton
    public static synchronized DatabaseConnection getThreadSafeInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
