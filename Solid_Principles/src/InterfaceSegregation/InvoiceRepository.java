package InterfaceSegregation;

public class InvoiceRepository {
    public void saveToDB() {
        //save to MySql
        System.out.println("Saved to MySQL");

        //save to MongoDB
        System.out.println("Saved to MongoDB");
    }
}
