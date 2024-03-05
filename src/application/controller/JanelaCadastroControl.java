package application.controller;

import javax.swing.*;

/**
 * control --> events --> view
 * view = vizualização
 * events = eventos/ações dos objetos
 * control = classe para criação dos objetos interáveis
 * model = requisições
 **/

public class JanelaCadastroControl extends JFrame {

    // Atributo dos objetos interáveis
    private JLabel txtNome = new JLabel("Nome");
    private JLabel txtSobrenome = new JLabel("Sobrenome");
    private JLabel txtTelefone = new JLabel("Telefone");
    private JLabel txtEmail = new JLabel("Email");
    private JLabel txtDtNascimento = new JLabel("Data de Nascimento");
    private JLabel txtUsuario = new JLabel("Usuario");
    private JLabel txtSenha = new JLabel("Senha");
    private JTextField fieldNome = new JTextField(25);
    private JTextField fieldSobrenome = new JTextField(25);
    private JTextField fieldTelefone = new JTextField(25);
    private JTextField fieldEmail = new JTextField(25);
    private ComboBoxDtNascimento comboBoxDtNascimento = new ComboBoxDtNascimento();
    private JTextField fieldUsuario = new JTextField(25);
    private JPasswordField fieldSenha = new JPasswordField(25);
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnCancelar = new JButton("Cancelar");
    private JButton btnConfirmar = new JButton("Confirmar");

    public JLabel getTxtNome() {
        return txtNome;
    }
    public JLabel getTxtSobrenome() {
        return txtSobrenome;
    }
    public JLabel getTxtTelefone() {
        return txtTelefone;
    }
    public JLabel getTxtEmail() {
        return txtEmail;
    }
    public JLabel getTxtDtNascimento() {
        return txtDtNascimento;
    }
    public JLabel getTxtUsuario() {
        return txtUsuario;
    }
    public JLabel getTxtSenha() {
        return txtSenha;
    }
    public JTextField getFieldNome() {
        return fieldNome;
    }
    public JTextField getFieldSobrenome() {
        return fieldSobrenome;
    }
    public JTextField getFieldTelefone() {
        return fieldTelefone;
    }
    public JTextField getFieldEmail() {
        return fieldEmail;
    }
    public ComboBoxDtNascimento getComboBoxDtNascimento() {
        return comboBoxDtNascimento;
    }
    public JTextField getFieldUsuario() {
        return fieldUsuario;
    }
    public JPasswordField getFieldSenha() {
        return fieldSenha;
    }
    public JButton getBtnLimpar() {
        return btnLimpar;
    }
    public JButton getBtnCancelar() {
        return btnCancelar;
    }
    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }
}
