package application.events;

import application.service.JanelaLoginService;
import application.model.DAO.UsuarioDAO;
import application.model.entity.Usuario;
import application.view.JanelaCadastroView;
import application.view.JanelaMenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class JanelaLoginEvents extends JanelaLoginService {

    public JanelaLoginEvents() {
        // Eventos dos objetos
        getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // VERIFICAÇÃO DO USUARIO NO BANCO DE DADOS PARA EFETUAR 0O LOGIN
                String nomeUsuario = getFieldUsuario().getText();
                String senhaUsuario = getFieldSenha().getText();

                try {
                    // Verificar se o usuario existe no banco de dados
                    if (new UsuarioDAO().verificarUsuario(nomeUsuario)) {
                        // O Usuario existe, agora verificar senha
                        Usuario usuario = new UsuarioDAO().buscarUsuario(nomeUsuario);

                        if (usuario != null && senhaUsuario.equals(usuario.getSenha())) {
                            // Login bem sucedido
                            JanelaMenuView janelaMenuView = new JanelaMenuView(usuario);
                            // Abrir a janela de menu
                            dispose(); // fechar janela de login
                        } else {
                            // Senha incorreta
                            JOptionPane.showMessageDialog(null, "Senha incorreta!","ERRO DE LOGIN", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // usuario não econtrado
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado!","ERRO DE LOGIN",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Tratando a exceção do banco de dados
                }
            }
        });

        getBtnCadastro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaCadastroView janelaCadastroView = new JanelaCadastroView(); // Cria a janela de cadastro
                janelaCadastroView.setVisible(true); // Seta a visualização da janela de cadastro
                dispose(); // Fecha a janela de login
            }
        });

        getBtnSobre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sobre
                JOptionPane.showMessageDialog(null,"Aplicativo em desenvolvimento.\n              Versão 1.0");
            }
        });
    }
}
