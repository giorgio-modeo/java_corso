package jdbc;

public class DatabaseConfig {
    /* dati per la connessione al db */
    protected static final String USER ="root";
    protected static final String PASS ="";
    /*                                      standard              port | da qui in poi sono comandi sql */
    /*                                      standard              port | se non esiste il db farm lo crea */
    protected static final String DB_URL = "jdbc:mysql://localhost:3306/farm?createDatabaseIfNotExist=true&autoReconnect=true&useSLL=false&useLegacyDatetimeCode=false";




}