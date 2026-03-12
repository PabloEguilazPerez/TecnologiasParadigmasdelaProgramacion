package db;

public class MongoDBQueryFactory implements QueryFactory {

    public MongoDBQueryFactory() {
        System.out.println("MongoDBQueryFactory instantiated");
    }

    @Override
    public DBQuery createQuery() {
        return new MongoDBQuery();
    }
}
