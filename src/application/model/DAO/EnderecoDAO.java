package application.model.DAO;

import application.controller.ValidarDados;
import application.model.conexao.ConexaoBD;
import application.model.entity.Endereco;
import application.model.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {

    // Método para inserir um novo endereço no banco de dados
    public boolean inserirEndereco(Endereco endereco, int usuarioId) {
        try (Connection conn = new ConexaoBD().conectar()) {
            // Verificar se o usuário já possui um endereço
            if (usuarioPossuiEndereco(usuarioId)) {
                // Se já possui, atualizar os dados do endereço existente
                return atualizarEndereco(endereco, usuarioId);
            } else {
                // Se não possui, inserir um novo endereço
                return inserirNovoEndereco(endereco, usuarioId);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Informações sobre erros em caso de falhas
            return false;
        }
    }

    // Método para verificar se o usuário já possui um endereço
    public boolean usuarioPossuiEndereco(int usuarioId) throws SQLException {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM endereco WHERE usuario_id = ?")) {
            statement.setInt(1, usuarioId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Se count for maior que 0, o usuário já possui um endereço
                }
            }
        }
        return false; // Retorna false se ocorrer algum erro
    }

    // Método para inserir um novo endereço quando o usuário não possui um
    private boolean inserirNovoEndereco(Endereco endereco, int usuarioId) throws SQLException {
        try {
            ValidarDados.validarAlteracaoEndereco(endereco);
            try (Connection conn = new ConexaoBD().conectar();
                 PreparedStatement statement = conn.prepareStatement(
                         "INSERT INTO endereco (cep, rua, numero, bairro, cidade, estado, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

                // Definindo os valores para os parâmetros do PreparedStatement
                statement.setString(1, endereco.getCep());
                statement.setString(2, endereco.getRua());
                statement.setString(3, endereco.getNumero());
                statement.setString(4, endereco.getBairro());
                statement.setString(5, endereco.getCidade());
                statement.setString(6, endereco.getEstado());
                statement.setInt(7, usuarioId);

                // Executando a inserção no banco de dados
                statement.executeUpdate();
                return true; // Indica que foi cadastrado
            }
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    // Método para atualizar o endereço existente do usuário
    private boolean atualizarEndereco(Endereco endereco, int usuarioId) throws SQLException {
        try {
            ValidarDados.validarAlteracaoEndereco(endereco);
            try (Connection conn = new ConexaoBD().conectar();
                 PreparedStatement statement = conn.prepareStatement(
                         "UPDATE endereco SET cep=?, rua=?, numero=?, bairro=?, cidade=?, estado=? WHERE usuario_id=?")) {

                // Definindo os valores para os parâmetros do PreparedStatement
                statement.setString(1, endereco.getCep());
                statement.setString(2, endereco.getRua());
                statement.setString(3, endereco.getNumero());
                statement.setString(4, endereco.getBairro());
                statement.setString(5, endereco.getCidade());
                statement.setString(6, endereco.getEstado());
                statement.setInt(7, usuarioId);

                // Executando a atualização no banco de dados
                int linhasAfetadas = statement.executeUpdate();
                return linhasAfetadas > 0; // Retorna true se a atualização for bem-sucedida
            }
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public boolean excluirEndereco(int usuarioId) throws SQLException {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement(
                     "DELETE FROM endereco WHERE usuario_id=?")) {

            // Definindo os valores para os parâmetros do PreparedStatement
            statement.setInt(1, usuarioId);

            // Executando a atualização no banco de dados
            int linhasAfetadas = statement.executeUpdate();
            return linhasAfetadas >0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo para buscar o endereco do usuario
    public Endereco buscarEndereco(int usuarioId) throws SQLException {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement(
                     "SELECT * FROM endereco WHERE usuario_id=?")) {

            statement.setInt(1,usuarioId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Endereco endereco = new Endereco();
                    endereco.setCep(resultSet.getString("cep"));
                    endereco.setRua(resultSet.getString("rua"));
                    endereco.setNumero(resultSet.getString("numero"));
                    endereco.setBairro(resultSet.getString("bairro"));
                    endereco.setCidade(resultSet.getString("cidade"));
                    endereco.setEstado(resultSet.getString("estado"));

                    return endereco;
                }
            }
        }
        return null;
    }

    private Endereco construirUsuario(ResultSet resultSet) throws  SQLException {
        Endereco endereco = new Endereco();
        endereco.setId(resultSet.getInt("id"));
        endereco.setCep(resultSet.getString("cep"));
        endereco.setRua(resultSet.getString("rua"));
        endereco.setNumero(resultSet.getString("numero"));
        endereco.setBairro(resultSet.getString("bairro"));
        endereco.setCidade(resultSet.getString("cidade"));
        endereco.setEstado(resultSet.getString("estado"));

        return endereco;
    }
}
