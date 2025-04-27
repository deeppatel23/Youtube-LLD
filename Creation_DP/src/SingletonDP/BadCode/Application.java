package SingletonDP.BadCode;

public class Application {
    public static void main(String[] args) {
        System.out.println("User login process:");
        DatabaseConnection conn1 = new DatabaseConnection();
        conn1.executeQuery("SELECT * FROM users WHERE username='john'");

        System.out.println("\nProduct search process:");
        // Another connection created, wasting resources
        DatabaseConnection conn2 = new DatabaseConnection();
        conn2.executeQuery("SELECT * FROM products WHERE category='electronics'");

        System.out.println("\nOrder process:");
        // Yet another connection created
        DatabaseConnection conn3 = new DatabaseConnection();
        conn3.executeQuery("INSERT INTO orders VALUES (...)");

        // These are three separate connections consuming resources
        System.out.println("\nAre connections the same? " + (conn1 == conn2 ? "Yes" : "No"));
        System.out.println("Number of connections created: 3");
    }
}
