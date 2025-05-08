package BuilderDP.GoodCode;

class SQLQuery {
    private String table;
    private String condition;
    private String orderBy;

    private SQLQuery(Builder builder) {
        this.table = builder.table;
        this.condition = builder.condition;
        this.orderBy = builder.orderBy;
    }

    public String getQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(table);
        if (condition != null) {
            sb.append(" WHERE ").append(condition);
        }
        if (orderBy != null) {
            sb.append(" ORDER BY ").append(orderBy);
        }
        return sb.toString();
    }

    static class Builder {
        private String table;
        private String condition;
        private String orderBy;

        public Builder(String table) {
            this.table = table;
        }

        public Builder where(String condition) {
            this.condition = condition;
            return this;
        }

        public Builder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public SQLQuery build() {
            return new SQLQuery(this);
        }
    }
}
