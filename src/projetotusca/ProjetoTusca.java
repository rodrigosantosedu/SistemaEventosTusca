package projetotusca;
import gui.TelaPrincipal;
import java.sql.*;
import javax.swing.JOptionPane;
public class ProjetoTusca {
    private static String sql;
    public static void main(String[] args) throws Exception {
        new TelaPrincipal().setVisible(true);
    }
    
    // Essa função chama a conexão e faz uma consulta teste
    public static void busca()throws Exception{
        Connection conexao = ObterConexao();
        Statement statement = conexao.createStatement();
        String query = "select nome,cnpj from "
                + "atracao";
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
           // JOptionPane.showMessageDialog(TelaPrincipal.rootPane,"Chupa Federal");
            System.out.println(resultSet.getString("nome"));
            System.out.println(resultSet.getString("cnpj"));
        }
    }
    
    private static Connection ObterConexao() {
        String user = "G7143510";
        String pass = "G7143510";
        Connection conexao = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl",user,pass);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
            System.out.println("Não conectou");
        }
            return conexao;
    }
}
