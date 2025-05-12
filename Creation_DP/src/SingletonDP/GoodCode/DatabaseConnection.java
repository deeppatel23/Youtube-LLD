package SingletonDP.GoodCode;

public class DatabaseConnection {
    // Private static instance variable
    private static DatabaseConnection instance;
    public static int varA = 0;

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
    //T1 T2
    public static DatabaseConnection getInstance() {
        // Lazy initialization - create only when needed
        //T1 T2
        if (instance == null) { //T1 this is true //T2 this is ture
            instance = new DatabaseConnection(); //before T1 initialise instance
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
    //T1 T2
    public static synchronized DatabaseConnection getThreadSafeInstance() {
        //T1, but T2 cannot enter until T1 exit
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
