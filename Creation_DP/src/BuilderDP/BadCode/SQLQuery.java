package BuilderDP.BadCode;

public class SQLQuery {
    String query;

    SQLQuery(String table, String condition, String orderBy) {
        query = "SELECT * FROM " + table;
        if (condition != null) {
            query += " WHERE " + condition;
        }
        if (orderBy != null) {
            query += " ORDER BY " + orderBy;
        }
    }

    String getQuery() {
        return query;
    }
}

