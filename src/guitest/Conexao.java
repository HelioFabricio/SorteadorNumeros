package guitest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    public static Connection con = null;

    public static void main(String[] args) {
        System.out.println("Conectando ao Banco...");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/nunca_mexa_db", "root","");
            System.out.println("Conectado.");
            PreparedStatement stmt = con.prepareStatement("select * from tb_nunca_mexa");
            ResultSet rs = stmt.executeQuery();
    
            while(rs.next()){
            String name = rs.getString("name");
            Integer number = rs.getInt("number");
            System.out.println("Nome: "+name+", Numero Sorteado: "+number);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
        
    }
}
