package guitest;

import geradores.GeradorDeNumeros;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

public class GuiTest extends javax.swing.JFrame {

    private DefaultTableModel jobsModel;
    private GeradorDeNumeros gerador;
    protected List<Integer> listNumerosAleatorios;
    protected int id = 0;
    private int contador = 0;
    protected int quantidadeMaximaParticipantes = 4;
    private int quantidadeNumerosRandomicos = 5;    
    private PrintWriter writer;
    private BufferedReader br;
    private Conexao conec;
    
    
    public GuiTest() throws FileNotFoundException, IOException {
        initComponents();

        jobsModel = new DefaultTableModel(new String[] {"id", "name", "number", "num Prox", "difference"}, 0);
        jTable1.setModel(jobsModel);
        gerador = new GeradorDeNumeros();
        listNumerosAleatorios = new ArrayList<>();
        conec = new Conexao();
        
        try {
            FileWriter fileWriter = new FileWriter("meuBanco.txt", true);
            writer = new PrintWriter(fileWriter, true);
            
            br = new BufferedReader(new FileReader("meuBanco.txt"));
        } catch (IOException ex) {
            Logger.getLogger(GuiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jNome = new javax.swing.JTextField();
        jNumero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonCadastro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonGerarNumeros = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonConectarBanco = new javax.swing.JButton();
        jButtonSincronizarTabela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Infomações");

        jNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNomeKeyTyped(evt);
            }
        });

        jNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNumeroActionPerformed(evt);
            }
        });
        jNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNumeroKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonCadastro.setText("Cadrastrar");
        jButtonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("Numero:");

        jLabel6.setText("Numeros Aleatorios: ");

        jButtonGerarNumeros.setText("Gerar");
        jButtonGerarNumeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarNumerosActionPerformed(evt);
            }
        });

        jButtonConectarBanco.setText("Conectar Banco");
        jButtonConectarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarBancoActionPerformed(evt);
            }
        });

        jButtonSincronizarTabela.setText("Sincronizar Tabela");
        jButtonSincronizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSincronizarTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jNome)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButtonCadastro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jButtonGerarNumeros))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButtonConectarBanco)
                        .addGap(101, 101, 101)
                        .addComponent(jButtonSincronizarTabela)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCadastro))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGerarNumeros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConectarBanco)
                    .addComponent(jButtonSincronizarTabela))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNumeroActionPerformed

    private void jButtonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroActionPerformed
        if(contador > quantidadeMaximaParticipantes-1){
            JOptionPane.showMessageDialog(null, "Numero ", "Erro", JOptionPane.ERROR_MESSAGE);
        } else{
            String idString = String.valueOf(id);
            jobsModel.addRow(new String[]{idString, jNome.getText(), jNumero.getText()});
            id++;
            contador++;
            
            try {
                // Manda pro banco de dados Jnome e Numero
                conec.cadastrarUsuario(jNome.getText(), Integer.parseInt(jNumero.getText()), 0, 0);
            } catch (SQLException ex) {
                Logger.getLogger(GuiTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GuiTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            gravarArquivo(idString, jNome.getText(), jNumero.getText());
            
            jNome.setText("");
            jNumero.setText("");
        }
    }//GEN-LAST:event_jButtonCadastroActionPerformed

    public void registrarBanco(String nome, int numero) throws SQLException{
        PreparedStatement stmt = con.prepareStatement("INSERT INTO `tb_nunca_mexa`(`id`, `name`) VALUES ("+nome+" ,"+numero+" );");
        
        try {
            
        } catch (Exception e) {
            
        }
    }
    public static Connection con = null;
    public void conectarBanco(){
        System.out.println("Conectando Banco...");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/nunca_mexa_db", "root","");
            System.out.println("Conectado");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    public void gravarArquivo(String id, String nome, String numero){
        String idString = id;
        String nomeString = nome;
        String numeroString = numero;

        writer.println("ID: {" + idString + "}\nNome: {"+ nomeString +"}\nNumero: {" + numeroString + "}\n");
    }
    private void jNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNumeroKeyTyped
        String permitido = "0987654321";
        char entrada = evt.getKeyChar();
        
        if(!permitido.contains(String.valueOf(entrada))){
            evt.consume();
        }
    }//GEN-LAST:event_jNumeroKeyTyped

    private void jNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNomeKeyTyped
        String permitido = "0987654321";
        char entrada = evt.getKeyChar();
        
        if(permitido.contains(String.valueOf(entrada))){
            evt.consume();
        }
    }//GEN-LAST:event_jNomeKeyTyped

    private void jButtonGerarNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarNumerosActionPerformed
        listNumerosAleatorios.removeAll(listNumerosAleatorios);
        
        for(int i = 0; i < quantidadeNumerosRandomicos; i++){
            listNumerosAleatorios.add(gerador.gerarNumeroRandomico());
        }
        String numerosAleatorios = String.valueOf(listNumerosAleatorios);
        
        jLabel5.setText(numerosAleatorios);
        
        for(int i = 0; i < jTable1.getRowCount(); i++){
            int diferenca = 0;
            int numeroEscolhido = Integer.parseInt((String) jTable1.getValueAt(i, 2));
            int numeroMaisProximo = buscarNumeroProximo(numeroEscolhido);
            
            diferenca = calculaDiferenca(numeroEscolhido, numeroMaisProximo);
            
            jTable1.setValueAt(diferenca, i, 4);
            jTable1.setValueAt(numeroMaisProximo, i, 3);
        }
        
    }//GEN-LAST:event_jButtonGerarNumerosActionPerformed

    public void atualizarTabelaBanco(){
        try {
            conec.checarConectadoConectar();
            
            PreparedStatement stmt = con.prepareStatement("select * from tb_nunca_mexa");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String name = rs.getNString("name");
                Integer number = rs.getInt("number");
                Integer numProximo = rs.getInt("num_prox");
                Integer difference = rs.getInt("difference");
                
                
                String[] arrayInfoPessoa = {name, number.toString(), numProximo.toString(), difference.toString()};
                jobsModel.addRow(arrayInfoPessoa);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    private void limparTabela(){
        
    }
    private void jButtonSincronizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSincronizarTabelaActionPerformed
        atualizarTabelaBanco();
        
        
    }//GEN-LAST:event_jButtonSincronizarTabelaActionPerformed

    private void jButtonConectarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarBancoActionPerformed
        conectarBanco();
    }//GEN-LAST:event_jButtonConectarBancoActionPerformed

    public int buscarNumeroProximo(int numeroReferencia){
    int numeroMaisProximo = listNumerosAleatorios.get(0); // Começa com o primeiro número da lista

    for (int numero : listNumerosAleatorios) {
        if (Math.abs(numero - numeroReferencia) < Math.abs(numeroMaisProximo - numeroReferencia)) {
            numeroMaisProximo = numero;
        }
    }
        
        return numeroMaisProximo;
    }
    
    public int calculaDiferenca(int numeroEscolhido, int numeroMaisProximo){
        int diferenca = 0;
        
        diferenca = numeroMaisProximo - numeroEscolhido;
        if(diferenca < 0){
            return diferenca * -1;
        }
        return diferenca;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GuiTest().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GuiTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GuiTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastro;
    private javax.swing.JButton jButtonConectarBanco;
    private javax.swing.JButton jButtonGerarNumeros;
    private javax.swing.JButton jButtonSincronizarTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jNome;
    private javax.swing.JTextField jNumero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
