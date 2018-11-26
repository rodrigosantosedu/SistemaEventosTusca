package projetotusca;
import java.sql.*;
public class ProjetoTusca {
    private static String sql;
    public static void main(String[] args) throws Exception {
        Connection conexao = ObterConexao();
        Statement statement = conexao.createStatement();
        String query = "select nome,cnpj from "
                + "atracao";
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
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
            System.out.println("Não conectado");
        }
            return conexao;
    }
}
