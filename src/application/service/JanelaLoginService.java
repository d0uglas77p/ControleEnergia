package application.service;

import javax.swing.*;

/**
 * service --> events --> view
 * view = vizualização
 * events = eventos/ações dos objetos
 * service  = classe para criação dos objetos interáveis
 * model = requisições
 **/
public class JanelaLoginService extends JFrame {

    // Atributo dos objetos interáveiss
    private JLabel txtUsuario = new JLabel("Usuário");
    private JLabel txtSenha = new JLabel("Senha");
    private JTextField fieldUsuario = new JTextField(20);
    private JPasswordField fieldSenha = new JPasswordField(20);
    private JButton btnLogin = new JButton("Login");
    private JButton btnCadastro = new JButton("Cadastrar");
    private JButton btnSobre = new JButton("...");

    public JLabel getTxtUsuario() {
        return txtUsuario;
    }
    public JLabel getTxtSenha() {
        return txtSenha;
    }
    public JTextField getFieldUsuario() {
        return fieldUsuario;
    }
    public JPasswordField getFieldSenha() {
        return fieldSenha;
    }
    public JButton getBtnLogin() {
        return btnLogin;
    }
    public JButton getBtnCadastro() {
        return btnCadastro;
    }
    public JButton getBtnSobre() {
        return btnSobre;
    }
}
