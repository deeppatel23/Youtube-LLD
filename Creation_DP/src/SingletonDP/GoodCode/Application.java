package SingletonDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        System.out.println("User login process:");
        // Get the singleton instance
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        System.out.printf("Var A value: "+ DatabaseConnection.varA + "\n");
        conn1.executeQuery("SELECT * FROM users WHERE username='john'");

        System.out.println("\nProduct search process:");
        // Reuse the same connection - no new connection created
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        conn2.executeQuery("SELECT * FROM products WHERE category='electronics'");

        System.out.println("\nOrder process:");
        // Still the same connection being reused
        DatabaseConnection conn3 = DatabaseConnection.getInstance();
        conn3.executeQuery("INSERT INTO orders VALUES (...)");

        // These are all references to the same connection
        System.out.println("\nAre connections the same? " + (conn1 == conn2 ? "Yes" : "No"));
        System.out.println("Number of connections created: 1");

        // Only one connection to close at the end
        conn1.close();
    }
}
