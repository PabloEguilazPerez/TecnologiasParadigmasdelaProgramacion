package db;

public class MongoDBConnectionFactory implements DBConnectionFactory {
	@Override
	public DBConnection createConnection( ) {
		return new MongoDBConnection();
	}
}
