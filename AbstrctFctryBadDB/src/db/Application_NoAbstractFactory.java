package db;

public class Application_NoAbstractFactory {

    private final ConnectionFactory connectionFactory;
    private final QueryFactory queryFactory;

    DBConnection connection;
    DBQuery query;

    public Application_NoAbstractFactory(ConnectionFactory connectionFactory, QueryFactory queryFactory) {
        this.connectionFactory = connectionFactory;
        this.queryFactory = queryFactory;
    }
    
    private static void run(ConexionConsultaFactory factory) {
		DBConnection connection = factory.createConnection();
		DBQuery query = factory.createQuery();
		
	}

    public void createConnection() {
        connection = connectionFactory.createConnection();
    }

    public void createQuery() {
        query = queryFactory.createQuery();
    }

    public static void main(String[] args) {

        System.out.println("=== CASE 1 (consistent): MySQL connection + MySQL query ===");
        Application_NoAbstractFactory app1 =
            new Application_NoAbstractFactory(new MySQLConnectionFactory(), new MySQLQueryFactory());

        run(new MySqlConnectionQueryFactory());
        	
        app1.createConnection();
        app1.connection.open();
        app1.connection.close();

        app1.createQuery();
        app1.query.execute();
        app1.query.print();

        System.out.println();
        System.out.println("=== CASE 2 (inconsistent): MySQL connection + MongoDB query ===");
        Application_NoAbstractFactory app2 =
            new Application_NoAbstractFactory(new MySQLConnectionFactory(), new MongoDBQueryFactory());

        app2.createConnection();
        app2.connection.open();
        app2.connection.close();

        app2.createQuery();
        app2.query.execute();
        app2.query.print();
    }
}
