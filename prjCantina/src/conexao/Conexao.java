package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Pedro
 */
public class Conexao {
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bdcantina?useTimezone=true&serverTimezone=UTC",
            "root", "");
            
            System.out.println(" conexão realizada com sucesso ");
            return conn;
        }
            catch (Exception e){
                    System.out.println("erro ao conectar ao bd" +e.getMessage());
                    return null;
                    }
                
            
        }
        }