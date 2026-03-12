package db;

public interface ConexionConsultaFactory {
	DBConnection createConnection();
	DBQuery createQuery();
}
