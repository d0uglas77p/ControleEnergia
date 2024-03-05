package application.view;

import application.events.JanelaCadastroEvents;

import javax.swing.*;
import java.awt.*;

// Classe front da Janela de Cadastro
public class JanelaCadastroView extends JanelaCadastroEvents {

    public JanelaCadastroView() {

        // Criar painel de cadastro
        JPanel panelCadastro = new JPanel();

        // Configuração do painel de cadastro
        setTitle("Controle de Energia - Cadastro");
        setSize(new Dimension(700,600));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelCadastro);

        // Configuração layout como GridBagLayout
        panelCadastro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adicionando e posicionando dos objetos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-250,-300,0,0);
        getTxtNome().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getTxtNome(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-250,0,0,-35);
        panelCadastro.add(getFieldNome(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-180,-331,0,0);
        getTxtSobrenome().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getTxtSobrenome(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-180,0,0,-35);
        panelCadastro.add(getFieldSobrenome(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-110,-317,0,0);
        getTxtTelefone().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getTxtTelefone(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-110,0,0,-35);
        panelCadastro.add(getFieldTelefone(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(-40,-37,0,0);
        getTxtEmail().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getTxtEmail(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-40,0,0,-35);
        panelCadastro.add(getFieldEmail(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,-380,-46,0);
        getTxtDtNascimento().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getTxtDtNascimento(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,0,-50,0);
        panelCadastro.add(getComboBoxDtNascimento().getPanel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(60,-305,0,0);
        getTxtUsuario().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getTxtUsuario(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(60,0,0,-35);
        panelCadastro.add(getFieldUsuario(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(17,-300,0,0);
        getTxtSenha().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getTxtSenha(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(17,0,0,-35);
        panelCadastro.add(getFieldSenha(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,-200,0);
        getBtnConfirmar().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getBtnConfirmar(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,-100,-300,0);
        getBtnLimpar().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getBtnLimpar(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0,0,-300,-100);
        getBtnCancelar().setFont(new Font("Arial",Font.BOLD,12));
        panelCadastro.add(getBtnCancelar(), gbc);

    }

}
