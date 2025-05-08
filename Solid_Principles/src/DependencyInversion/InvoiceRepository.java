package DependencyInversion;

import DependencyInversion.Repository.Database;

public class InvoiceRepository {
    Database database;

    public  InvoiceRepository(Database database) {
        this.database = database;
    }

    public void saveToDB() {
        database.save();
    }
}
