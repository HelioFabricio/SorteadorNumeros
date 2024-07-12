package guitest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.TryNode;

public class Conexao {
    public static Connection con = null;
    
    public void conectarMostrar() throws SQLException{
        try {
            checarConectadoConectar();
            
            PreparedStatement stmt= con.prepareStatement("select * from tb_nunca_mexa");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            String name = rs.getString("name");
            Integer number = rs.getInt("number");
            System.out.println("Nome: "+name+", Numero Sorteado: "+number);
            }
        } catch (Exception e){
            System.out.println("Erro");
            }
    }
    
    public void cadastrarUsuario(String nome, int numero, int numeroProximo, int difference) throws SQLException, ClassNotFoundException{
        checarConectadoConectar();
        
        String sqlCommand = "insert into tb_nunca_mexa(`name`, `number`, `num_prox`, difference) values(?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sqlCommand);
        
        stmt.setString(1, nome);
        stmt.setInt(2, numero);
        stmt.setInt(3, numeroProximo);
        stmt.setInt(4, difference);
        
        stmt.executeUpdate();
        
        System.out.println("Cadastrado com Sucesso!");
    }
    
    public void atualizarPalpites(int id , int numProx, int difference) throws SQLException{
        
        // TODO FAZER ATUALIZAR PALPITE PELO ID
        String sqlCommand = "insert into tb_nunca_mexa(`name`, `number`, `num_prox`, difference) values(?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sqlCommand);
        
    }
    
    
    public void checarConectadoConectar() throws ClassNotFoundException, SQLException{
        if(con == null){
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/nunca_mexa_db", "root","");
            System.out.println("Conectado");
        } 
    }

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

    void cadastrarUsuario(String text, int parseInt, Object object, Object object0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
