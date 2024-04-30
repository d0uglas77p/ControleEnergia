package application.model.DAO;

import application.controller.ValidarDados;
import application.model.conexao.ConexaoBD;
import application.model.entity.Aparelho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AparelhoDAO {

    // Método para inserir um novo aparelho no banco de dados
    public boolean inserirNovoAparelho(Aparelho aparelho, int usuarioId) {

        try {
            ValidarDados.validarAparelho(aparelho);
            try (Connection conn = new ConexaoBD().conectar();
                 PreparedStatement statement = conn.prepareStatement(
                         "INSERT INTO aparelhos (nomeAparelho, nomeFabribricante, marca, modelo, volts, watts, tempo, usuario_id) VALUES (?,?,?,?,?,?,?,?)")) {

                // Definindo os valores para os parâmetros do PreparedStatement
                statement.setString(1, aparelho.getNomeAparelho());
                statement.setString(2, aparelho.getNomeFabricante());
                statement.setString(3, aparelho.getMarca());
                statement.setString(4, aparelho.getModelo());
                statement.setString(5, aparelho.getVolts());
                statement.setString(6, aparelho.getWatts());
                statement.setString(7, aparelho.getTempo());
                //statement.setString(8, aparelho.getKwh());
                statement.setInt(8, usuarioId);

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

    // Metodo para buscar aparelhos do usuario
    public List<Aparelho> buscarAparelhos(int usuarioId) {
        List<Aparelho> aparelhos = new ArrayList<>();

        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement(
                     "SELECT * FROM aparelhos WHERE usuario_id=?");) {

            statement.setInt(1,usuarioId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Aparelho aparelho = new Aparelho();
                    aparelho.setNomeAparelho(resultSet.getString("nomeAparelho"));
                    aparelho.setNomeFabricante(resultSet.getString("nomeFabribricante"));
                    aparelho.setMarca(resultSet.getString("marca"));
                    aparelho.setModelo(resultSet.getString("modelo"));
                    aparelho.setVolts(resultSet.getString("volts"));
                    aparelho.setWatts(resultSet.getString("watts"));
                    aparelho.setTempo(resultSet.getString("tempo"));
                    //aparelho.setKwh(resultSet.getString("kwh"));
                    aparelhos.add(aparelho);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aparelhos;
    }

    // Método para excluir aparelho do banco pelo id do aparelho
    public boolean excluirAparelhoId(int idAparelho, int idUsuario) {
        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement(
                     "DELETE FROM aparelhos WHERE id=? AND usuario_id=?")) {

            statement.setInt(1, idAparelho);
            statement.setInt(2, idUsuario);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (excluída)

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar o ID do aparelho pelo nome
    public int buscarIdAparelhoPorNome(String nomeAparelho) {
        String sql = "SELECT id FROM aparelhos WHERE nomeAparelho = ?";

        try (Connection conn = new ConexaoBD().conectar();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, nomeAparelho);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Retorna o ID do aparelho
                    return resultSet.getInt("id");
                } else {
                    return -1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
