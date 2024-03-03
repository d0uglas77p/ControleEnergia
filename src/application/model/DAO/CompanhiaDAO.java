package application.model.DAO;

import application.controller.ValidarDados;
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
            // Se extiver ok na classe ValidarCadastro, irá fazer a inserção dos dados na tabela comapnhia
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
                    e.printStackTrace(); // Captura erro
                }
            } catch (IllegalArgumentException exception) { // Captura de erro
                exception.printStackTrace();
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
}
