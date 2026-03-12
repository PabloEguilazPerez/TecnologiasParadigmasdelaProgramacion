package db;

public class MySqlConnectionQueryFactory implements ConexionConsultaFactory {

	@Override
	public DBConnection createConnection() {
		return new MySQLConnection();
	}

	@Override
	public DBQuery createQuery() {
		return new MySQLQuery();
	}



}
