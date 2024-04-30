package application;

import application.model.conexao.ConexaoBD;
import application.view.JanelaLoginView;
import javax.swing.*;

// Classe principal
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Look and Feell
                SwingUtilities.updateComponentTreeUI(new JFrame());
                new JanelaLoginView().setVisible(true);

            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalStateException | IllegalAccessException e){
                e.printStackTrace();

            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
        });
        // Cria tabelas do banco de dados
        new ConexaoBD().criarTabelaUsuario();
        new ConexaoBD().criarTabelaEndereco();
        new ConexaoBD().criarTabelaCompanhias();
        new ConexaoBD().criarTabelaAparelho();
    }

}
