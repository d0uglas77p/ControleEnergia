package application.controller;

import application.model.DAO.UsuarioDAO;
import application.model.entity.Companhia;
import application.model.entity.Endereco;
import application.model.entity.Usuario;

import java.sql.SQLException;

// Classe de validação e exeções dos dados
public class ValidarDados {
    public static void validarCadastro(Usuario usuario) throws IllegalArgumentException {
        // Verifica se os campos obrigatórios estão vazios
        if (usuario.getNome() == null || usuario.getNome().isEmpty() ||
                usuario.getSobrenome() == null || usuario.getSobrenome().isEmpty() ||
                usuario.getTelefone() == null || usuario.getTelefone().isEmpty() ||
                usuario.getEmail() == null || usuario.getEmail().isEmpty() ||
                usuario.getUsuario() == null || usuario.getUsuario().isEmpty() ||
                usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Preencha todos os dados!");
        }
        // Verifica se o nome de usuario já existe
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.verificarUsuario(usuario.getUsuario())) {
                throw new IllegalArgumentException("Nome de usuário já existe!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Erro ao verificar usuário!");
        }
    }

    public static void validarAlteracaoDados(Usuario dados) throws IllegalArgumentException {
        // Verifica se os campos obrigatórios estão vazios
        if (dados.getNome() == null || dados.getNome().isEmpty() ||
                dados.getSobrenome() == null || dados.getSobrenome().isEmpty() ||
                dados.getTelefone() == null || dados.getTelefone().isEmpty() ||
                dados.getEmail() == null || dados.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Preencha todos os dados!"); // Printa a falha
        }
    }

    public static void validarAlteracaoEndereco(Endereco endereco) throws  IllegalArgumentException {
        // Verifica se os campos obrigatórios estão vazios
        if (endereco.getCep() == null || endereco.getCep().isEmpty() ||
                endereco.getRua() == null || endereco.getRua().isEmpty() ||
                endereco.getNumero() == null || endereco.getNumero().isEmpty() ||
                endereco.getBairro() == null || endereco.getBairro().isEmpty() ||
                endereco.getCidade() == null || endereco.getCidade().isEmpty() ||
                endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
            throw new IllegalArgumentException("Preencha todos os dados!") ; // Printa a falha
        }
    }

    public static void validarCompanhia(Companhia companhia) throws  IllegalArgumentException {
        // Verifica se os campos obrigatórios estão vazios
        if (companhia.getNomeCompanhia() == null || companhia.getNomeCompanhia().isEmpty() ||
                companhia.getCnpj() == null || companhia.getCnpj().isEmpty() ||
                companhia.getTelefoneCompanhia() == null || companhia.getTelefoneCompanhia().isEmpty() ||
                companhia.getTipoFornecimento() == null || companhia.getTipoFornecimento().isEmpty() ||
                companhia.getMedidor() == null || companhia.getMedidor().isEmpty() ||
                companhia.getTarifa() == null || companhia.getTarifa().isEmpty()) {
            throw new IllegalArgumentException("Preencha todos os dados!") ; // Printa a falha
        }
    }
}
