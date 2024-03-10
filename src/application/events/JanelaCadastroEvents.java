package application.events;

import application.controller.JanelaCadastroControl;
import application.model.DAO.UsuarioDAO;
import application.model.entity.Usuario;
import application.view.JanelaLoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastroEvents extends JanelaCadastroControl {

    // Eventos dos objetos
    public JanelaCadastroEvents() {

        getBtnLimpar().addActionListener(new ActionListener() {
            @Override
            // Limpa os campos
            public void actionPerformed(ActionEvent e) {
                getFieldNome().setText("");
                getFieldSobrenome().setText("");
                getComboBoxDtNascimento().resetarSelecoes();
                getFieldTelefone().setText("");
                getFieldEmail().setText("");
                getFieldUsuario().setText("");
                getFieldSenha().setText("");
            }
        });

        getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaLoginView janelaLoginView = new JanelaLoginView(); // Cria a janela de login
                janelaLoginView.setVisible(true); // Seta a visualização da janela de login
                dispose(); // Fecha janela de cadastro
            }
        });

        getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario novoUsuario = new Usuario();
                // Obter os dados do formulario
                novoUsuario.setNome(getFieldNome().getText());
                novoUsuario.setSobrenome(getFieldSobrenome().getText());
                novoUsuario.setTelefone(getFieldTelefone().getText());
                novoUsuario.setEmail(getFieldEmail().getText());
                novoUsuario.setDtNascimento(getComboBoxDtNascimento().formatarDataSelecionada());
                novoUsuario.setUsuario(getFieldUsuario().getText());
                novoUsuario.setSenha(getFieldSenha().getText());

                // Inserir no banco de dados
                if (new UsuarioDAO().inserirUsuario(novoUsuario)) {
                    // Cadastro efetuado com sucesso
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    // Se for efetuado o cadastro, irá fechar
                    JanelaLoginView janelaLoginView = new JanelaLoginView(); // Cria a janela de login
                    janelaLoginView.setVisible(true); // Seta a visualização da janela de login
                    JanelaCadastroEvents.this.dispose();
                }
            }
        });
    }
}
