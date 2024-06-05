package application.model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

    // Método para estabelecer uma conexão com o banco de dados SQLite
    public Connection conectar() {
        try {
            // Carrega o driver JDBC do SQLite
            Class.forName("org.sqlite.JDBC");
            // Retorna a conexão usando o caminhp do banco de dados
            return DriverManager.getConnection("jdbc:sqlite:controledb");
        } catch (ClassNotFoundException | SQLException e) {
            // Tratando exceções relacionadas à conexão
            e.printStackTrace();
            return null;
        }
    }

    // Método para criar a tabela usuarios no banco de dados
    public void criarTabelaUsuario() {
        try (Connection conn = conectar();
             Statement statement = conn.createStatement()) {
            // Define a instrução SQL para criar a tabela
            String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL," +
                    "sobrenome TEXT NOT NULL," +
                    "telefone TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    "dtNascimento TEXT NOT NULL," +
                    "usuario TEXT NOT NULL," +
                    "senha TEXT NOT NULL);";
            // Executa a instrução SQl para criar a tabela
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            // trata exceções relacionadas à execução da instrução SQL
            e.printStackTrace();
        }
    }

    // Método para criar a tabela de endereços no banco de dados
    public void criarTabelaEndereco() {
        try (Connection conn = conectar();
            Statement statement = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS endereco (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "cep TEXT NOT NULL," +
                    "rua TEXT NOT NULL," +
                    "numero TEXT NOT NULL," +
                    "bairro TEXT NOT NULL," +
                    "cidade TEXT NOT NULL," +
                    "estado TEXT NOT NULL," +
                    "usuario_id INTEGER," +
                    "FOREIGN KEY(usuario_id) REFERENCES usuario(id));";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // método para criar a tabela de companhias no banco de dados
    public void criarTabelaCompanhias() {
        try (Connection conn = conectar();
            Statement statement = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS companhias (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nomeCompanhia TEXT NOT NULL," +
                    "cnpj TEXT NOT NULL," +
                    "telefoneCompanhia TEXT NOT NULL," +
                    "tipoFornecimento TEXT NOT NULL," +
                    "medidor TEXT NOT NULL," +
                    "tarifa TEXT NOT NULL," +
                    "usuario_id INTEGER," +
                    "FOREIGN KEY(usuario_id) REFERENCES usuario(id));";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // método para criar a tabela de aparelhos no banco de dados
    public void criarTabelaAparelho() {
        try (Connection conn = conectar();
             Statement statement = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS aparelhos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nomeAparelho TEXT NOT NULL," +
                    "nomeFabribricante TEXT NOT NULL," +
                    "marca TEXT NOT NULL," +
                    "modelo TEXT NOT NULL," +
                    "volts TEXT NOT NULL," +
                    "watts TEXT NOT NULL," +
                    "tempo TEXT NOT NULL," +
                    "kwh TEXT NOT NULL," +
                    "usuario_id INTEGER," +
                    "FOREIGN KEY(usuario_id) REFERENCES usuario(id));";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


