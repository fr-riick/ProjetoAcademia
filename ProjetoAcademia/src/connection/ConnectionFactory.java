/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author rickf
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            //Caso o mysql seja versão 5 excluir essa parte: ?serverTimezone=UTC
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia?serverTimezone=UTC", //Linha de conexão
                    "root", //Usuário do mysql
                    "091725" //Senha do mysql
            );
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
  
    }
    
}
