package application.model.DAO;

import application.service.ValidarDados;
import application.model.conexao.ConexaoBD;
import application.model.entity.Companhia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanhiaDAO {

    // Método para inserir um novo usuário no banco de dados
    public boolean inserirNovaCompanhia(Companhia companhia, int usuarioId) {

            if (verificarCnpjExistente(companhia.getCnpj(), usuarioId)) {
                return false;
            }

            try {
                ValidarDados.validarCompanhia(companhia);
                try (Connection conn = new ConexaoBD().conectar();
                     PreparedStatement statement = conn.prepareStatement(
                             "INSERT INTO companhias (nomeCompanhia, cnpj, telefoneCompanhia, tipoFornecimento, medidor, tarifa, usuario_id) VALUES (?,?,?,?,?,?,?)")) {

                    // Definindo os valores para os parâmetros do PreparedStatement
                    statement.setString(1, companhia.getNomeCompanhia());
                    statement.setString(2, companhia.getCnpj());
                    statement.setString(3, companhia.getTelefoneCompanhia());
                    statement.setString(4, companhia.getTipoFornecimento());
                    statement.setString(5, companhia.getMedidor());
                    statement.setString(6, companhia.getTarifa());
                    statement.setInt(7, usuarioId);

                    // Executando a inserção no banco de dados
                    statement.executeUpdate();
                    return true; // Retorna que foi cadastrado

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace();
            }
            return false;
    }

    // Método para verificar se já existe um CNPJ da companhia cadastrado
    private boolean verificarCnpjExistente(String cnpj, int usuarioId) {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement(
                     "SELECT COUNT(*) FROM companhias WHERE cnpj=? AND usuario_id=?")) {

            statement.setString(1, cnpj);
            statement.setInt(2, usuarioId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Retorna true se o CNPJ existe para o usuário específico
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Metodo para buscar companhia do usuario
    public List<Companhia> buscarCompanhias(int usuarioId) {
        List<Companhia> companhias = new ArrayList<>();

        try (Connection conn = new ConexaoBD().conectar();
            PreparedStatement statement = conn.prepareStatement(
                     "SELECT * FROM companhias WHERE usuario_id=?");) {

            statement.setInt(1,usuarioId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Companhia companhia = new Companhia();
                    companhia.setNomeCompanhia(resultSet.getString("nomeCompanhia"));
                    companhia.setCnpj(resultSet.getString("cnpj"));
                    companhia.setTelefoneCompanhia(resultSet.getString("telefoneCompanhia"));
                    companhia.setTipoFornecimento(resultSet.getString("tipoFornecimento"));
                    companhia.setMedidor(resultSet.getString("medidor"));
                    companhia.setTarifa(resultSet.getString("tarifa"));
                    companhias.add(companhia);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return companhias;
    }

    // Método para excluir companhia do banco por cnpj
    public boolean excluirCompanhiaCnpj(String cnpj, int usuarioId) {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement(
                     "DELETE FROM companhias WHERE cnpj=? AND usuario_id=?")) {

            statement.setString(1, cnpj);
            statement.setInt(2, usuarioId);

            // Executando a exclusão no banco de dados
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (excluída)

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
