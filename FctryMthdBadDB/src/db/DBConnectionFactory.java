package db;

public interface DBConnectionFactory {
	DBConnection createConnection();
}

/*

enum TipoDB {
	MYSQL,
	MONGODB
}

public class DBFactory {
	
	private static DBConnection instance;

	public DBFactory(TipoDB tipo) {
		createConnection(tipo);
	}
    
    private static DBConnection createConnection(TipoDB tipo) {
    	
    	switch (tipo) {
    		case MYSQL:
    			instance = new MySQLConnection();
			case MONGODB:
				instance = new MongoDBConnection();
			default:
				throw new IllegalArgumentException("TipoDB no soportado: " + tipo);
    	}
    	
    }

}
*/