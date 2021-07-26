package backendchallenge.aluraflix;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {

    public Connection getConexao(){

        try
        {
            //tenta estabelecer a conexão
            Connection conexao = DriverManager.getConnection(
                    "jdbc:h2:mem:aluraflix?serverTimezone=UTC",
                    "sa",
                    ""
            );
            return conexao;

        } catch (Exception e){
            System.out.println("Erro ao conectar - " + e.getMessage());
            return null;
        }
    }
}
