package BadCode;

class InvoiceManager {

    public void generateInvoice() {
        double baseAmount = 5000.0;
        String customerType = "PREMIUM";

        // Calculate total
        double total = baseAmount;
        if (customerType.equals("PREMIUM")) {
            total = total * 0.9; // 10% discount
        } else if (customerType.equals("REGULAR")) {
            // no discount
        } else if (customerType.equals("SUPER_PREMIUM")) {
            total = total * 0.8; // 20% discount
        }

        // Print invoice
        System.out.println("---------- INVOICE ----------");
        System.out.println("Customer Type: " + customerType);
        System.out.println("Amount: ₹" + total);
        System.out.println("-----------------------------");

        // Save to database
//            MySQLDatabase db = new MySQLDatabase();
//            db.connect();
//            db.save("Invoice: " + total + ", Type: " + customerType);
    }
}

