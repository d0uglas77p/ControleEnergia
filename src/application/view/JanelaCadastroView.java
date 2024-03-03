package application.view;

import application.events.JanelaCadastroEvents;

import javax.swing.*;
import java.awt.*;

public class JanelaCadastroView extends JanelaCadastroEvents {

    public JanelaCadastroView() {

        // Criar painel de cadastro
        JPanel panelCadastro = new JPanel();

        // Configuração do painel de cadastro
        setTitle("Controle de Energia - Cadastro"); // Titulo da janela
        setSize(new Dimension(700,600)); // Dimensão
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelCadastro);

        // Configuração layout como GridBagLayout
        panelCadastro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adicionando e posicionando dos objetos
        gbc.gridx = 0; // Coluna
        gbc.gridy = 0; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(-250,-300,0,0);
        getTxtNome().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getTxtNome(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 0; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(-250,0,0,-35);
        panelCadastro.add(getFieldNome(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 1; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(-180,-331,0,0);
        getTxtSobrenome().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getTxtSobrenome(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 1; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(-180,0,0,-35);
        panelCadastro.add(getFieldSobrenome(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 2; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(-110,-317,0,0);
        getTxtTelefone().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getTxtTelefone(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 2; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(-110,0,0,-35);
        panelCadastro.add(getFieldTelefone(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 3; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        gbc.insets = new Insets(-40,-37,0,0);
        getTxtEmail().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getTxtEmail(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 3; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(-40,0,0,-35);
        panelCadastro.add(getFieldEmail(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 4; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(5,-380,-46,0);
        getTxtDtNascimento().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getTxtDtNascimento(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 4; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        gbc.insets = new Insets(0,0,-50,0);
        panelCadastro.add(getComboBoxDtNascimento().getPanel(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 5; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(60,-305,0,0);
        getTxtUsuario().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getTxtUsuario(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 5; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(60,0,0,-35);
        panelCadastro.add(getFieldUsuario(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 6; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(17,-300,0,0);
        getTxtSenha().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getTxtSenha(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 6; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(17,0,0,-35);
        panelCadastro.add(getFieldSenha(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 7; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.CENTER; // Alinha ao centro
        gbc.insets = new Insets(0,0,-200,0);
        getBtnConfirmar().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getBtnConfirmar(), gbc);

        gbc.gridx = 0; // Coluna
        gbc.gridy = 8; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        gbc.insets = new Insets(0,-100,-300,0);
        getBtnLimpar().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getBtnLimpar(), gbc);

        gbc.gridx = 1; // Coluna
        gbc.gridy = 8; // Linha
        gbc.gridwidth = 0; // O botão ocupa colunas
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        gbc.insets = new Insets(0,0,-300,-100);
        getBtnCancelar().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        panelCadastro.add(getBtnCancelar(), gbc);

    }

}
