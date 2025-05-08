package SingletonDP.BadCode;

public class DatabaseConnection {
    private String url;
    private String username;
    private String password;

    public DatabaseConnection() {
        // Expensive operation - connecting to database
        this.url = "jdbc:mysql://localhost:3306/mydb";
        this.username = "root";
        this.password = "password";
        System.out.println("Creating new database connection");
        // In real code, this would establish an actual connection
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " using connection to " + url);
    }
}
