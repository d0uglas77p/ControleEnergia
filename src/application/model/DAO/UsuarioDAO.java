package application.model.DAO;

import application.controller.ValidarDados;
import application.model.conexao.ConexaoBD;
import application.model.entity.Usuario;


import javax.swing.*;
import java.sql.*;

public class UsuarioDAO {

    // Método para inserir um novo usuário no banco de dados
    public boolean inserirUsuario(Usuario usuario) {
        // Verifica se os campos estão preenchidos
        try {
            ValidarDados.validarCadastro(usuario);

            // Se extiver ok na classe ValidarCadastro, irá fazer a inserção dos dados na tabela usuarios
            try (Connection conn = new ConexaoBD().conectar();
                 PreparedStatement statement = conn.prepareStatement(
                         "INSERT INTO usuarios (nome, sobrenome, telefone, email, dtNascimento, usuario, senha) VALUES (?,?,?,?,?,?,?)")) {

                // Definindo os valores para os parâmetros do PreparedStatement
                statement.setString(1, usuario.getNome());
                statement.setString(2, usuario.getSobrenome());
                statement.setString(3, usuario.getTelefone());
                statement.setString(4, usuario.getEmail());
                statement.setString(5, usuario.getDtNascimento());
                statement.setString(6, usuario.getUsuario());
                statement.setString(7, usuario.getSenha());

                // Executando a inserção no banco de dados
                statement.executeUpdate();

                return true; // Retorna que foi cadastrado
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IllegalArgumentException e) {
            // Exibir mensagem de erro para usuario
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }

    public boolean verificarUsuarioId(int id) throws SQLException {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE id = ?")) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Se coun for maior que 0, o nome de usuário já existe
                }
            }
        }
        return false; // Retorna false se ocorrer algum erro
    }

    // Método para verificar se o usuário já existe no banco de dados - por nome
    public boolean verificarUsuario(String nomeUsuario) throws SQLException {
        try (Connection conn = new ConexaoBD().conectar();
            PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE usuario = ?")) {

            statement.setString(1, nomeUsuario);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Se coun for maior que 0, o nome de usuário já existe
                }
            }
        }
        return false; // Retorna false se ocorrer algum erro
    }

    // Método para buscar um usuario pelo nome do usuario no banco de dados
    public Usuario buscarUsuario(String nomeUsuario) {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?")) {

            // Definindo o valor para o parâmetro do PreparedStatement
            statement.setString(1, nomeUsuario);

            // Executando SQL para a consulta no banco de dados
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Construir e retornar o objeto Usuário
                return construirUsuario(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // retorna null se não encontrar o usuario
    }

    // Método para buscar um usuario pelo id do usuario no banco de dados
    public Usuario buscarId(int idUsuario) {
        try (Connection conn = new ConexaoBD().conectar();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuarios WHERE id=?")) {

            // Definindo o valor para o parâmetro do PreparedStatement
            statement.setInt(1, idUsuario);

            // Executando SQL para a consulta no banco de dados
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Construir e retornar o objeto Usuário
                return construirUsuario(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null; // retorna null se não encontrar o id do usuário
    }

    // Método para alterar os dados do usuário no banco de dados
    public boolean alterarDadosUsuario(Usuario alterarDados) {
        try {
            // Validação dos novos dados
            ValidarDados.validarAlteracaoDados(alterarDados);

            // Conecta ao banco
            try (Connection conn = new ConexaoBD().conectar();
                 PreparedStatement statement = conn.prepareStatement(
                         "UPDATE usuarios SET nome=?, sobrenome=?, telefone=?, email=? WHERE usuario=?")) {

                // Definindo os valores para os parâmetros do PreparedStatement
                statement.setString(1, alterarDados.getNome());
                statement.setString(2, alterarDados.getSobrenome());
                statement.setString(3, alterarDados.getTelefone());
                statement.setString(4, alterarDados.getEmail());

                statement.setString(5, alterarDados.getUsuario()); // Condição do WHERE

                // Executa a atualização no banco de dados
                int linhasAfetadas = statement.executeUpdate();
                return linhasAfetadas > 0; // Retorna true se a atualização for bem-sucedida
            } catch (SQLException e) { // Captura de erro
                e.printStackTrace();
                return false;
            }
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return false;
    }


    public boolean excluirUsuario(int idUsuario) throws SQLException {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement(
                     "DELETE FROM usuarios WHERE id=?")) {

            // Definindo os valores para os parâmetros do PreparedStatement
            statement.setInt(1, idUsuario);

            // Executando a atualização no banco de dados
            int linhasAfetadas = statement.executeUpdate();
            return linhasAfetadas >0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private Usuario construirUsuario(ResultSet resultSet) throws  SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("id"));
        usuario.setNome(resultSet.getString("nome"));
        usuario.setSobrenome(resultSet.getString("sobrenome"));
        usuario.setTelefone(resultSet.getString("telefone"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setDtNascimento(resultSet.getString("dtNascimento"));
        usuario.setUsuario(resultSet.getString("usuario"));
        usuario.setSenha(resultSet.getString("senha"));

        return usuario;
    }

}
