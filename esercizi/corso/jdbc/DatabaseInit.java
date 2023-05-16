package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInit {
    /* connessione al database  */
    public Connection connectionToDb(){
        Connection conn = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(DatabaseConfig.DB_URL,DatabaseConfig.USER,DatabaseConfig.PASS);

        // per salvare la connection sul db in modo che se si spegnie viene salvato
        conn.setAutoCommit(true);
        System.out.println("CONNESSIONE AL DB RIUSCITA");

        // il catch ha due condizzioni e la prima che viene sollevata fara uscire il messaggio
        }catch (ClassNotFoundException | SQLException e){
            System.err.println("ERRORE DI CONNESSIONE"+e.getMessage());
        }
        return conn;
    }
    /* chiusura della connessione */
    public void closeConnection(Connection conn){

        try {
            conn.close();
            System.out.println("CHIUSURA CONNESSIONE RIUSCITA");
        }catch (SQLException e){
            System.out.println("ERRORE DI CHIUSURA DI CONNESSIONE"+e.getMessage());
        }
    }
}
