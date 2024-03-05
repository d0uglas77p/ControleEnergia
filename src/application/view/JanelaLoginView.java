package application.view;

import application.events.JanelaLoginEvents;

import javax.swing.*;
import java.awt.*;

// Classe front da Lanela de Login
public class JanelaLoginView extends JanelaLoginEvents {

    public JanelaLoginView() {

        // Criar painel de login
        JPanel panelLogin = new JPanel();

        // Configuração do painel de login
        setTitle("Controle de Energia - Login");
        setSize(new Dimension(500, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelLogin);

        // Configuração layout como GridBagLayout
        panelLogin.setLayout(new GridBagLayout());

        // Configuração do GridBagConstraints
        // Posicionamentos: espaçamentos, colunas e linhas
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Adicionando e posicionando os objetos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        getTxtUsuario().setFont(new Font("Arial",Font.BOLD,12));
        panelLogin.add(getTxtUsuario(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 0, 5);
        panelLogin.add(getFieldUsuario());

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        getTxtSenha().setFont(new Font("Arial",Font.BOLD,12));
        panelLogin.add(getTxtSenha(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 0, 5);
        panelLogin.add(getFieldSenha(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        getBtnLogin().setFont(new Font("Arial",Font.BOLD,12));
        panelLogin.add(getBtnLogin(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 5, 10, 5);
        getBtnCadastro().setFont(new Font("Arial",Font.BOLD,12));
        panelLogin.add(getBtnCadastro(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, -220, -80);
        getBtnSobre().setFont(new Font("Arial",Font.BOLD,12));
        panelLogin.add(getBtnSobre(), gbc);
    }

}
