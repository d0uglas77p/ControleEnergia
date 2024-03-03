package application.view;

import application.events.JanelaLoginEvents;

import javax.swing.*;
import java.awt.*;

public class JanelaLoginView extends JanelaLoginEvents {

    public JanelaLoginView() {


        // Criar painel de login
        JPanel panelLogin = new JPanel();

        // Configuração do painel de login
        setTitle("Controle de Energia - Login"); // Titulo da janela
        setSize(new Dimension(500, 400)); // Dimensão
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelLogin);

        // Configuração layout como GridBagLayout
        panelLogin.setLayout(new GridBagLayout());

        // Configuração do GridBagConstraints
        // Posicionamentos: espaçamentos, colunas e linhas
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre componentes

        // Adicionando e posicionando os objetos
        gbc.gridx = 0; // Coluna
        gbc.gridy = 0; // Linha
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        getTxtUsuario().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelLogin.add(getTxtUsuario(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 0; // Linha
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        gbc.insets = new Insets(0, 5, 0, 5);
        panelLogin.add(getFieldUsuario());

        gbc.gridx = 0; // Coluna
        gbc.gridy = 1; // Linha
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        getTxtSenha().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelLogin.add(getTxtSenha(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 1; // linha
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        gbc.insets = new Insets(0, 5, 0, 5);
        panelLogin.add(getFieldSenha(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 3; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(10, 0, 10, 0); // Espaçamento vertical
        getBtnLogin().setFont(new Font("Arial",Font.BOLD,12)); // Fonte
        panelLogin.add(getBtnLogin(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 3; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        gbc.insets = new Insets(10, 5, 10, 5); // Espaçamento vertical
        getBtnCadastro().setFont(new Font("Arial",Font.BOLD,12)); // Fonte
        panelLogin.add(getBtnCadastro(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 4; // Linha
        gbc.gridwidth = 0; //  O botão ocula colunas
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        gbc.insets = new Insets(0, 0, -220, -80); // Espaçamento vertical
        getBtnSobre().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelLogin.add(getBtnSobre(), gbc);


    }

}
