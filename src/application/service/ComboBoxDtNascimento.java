package application.service;

import javax.swing.*;

// Classe especial para conversão de data
public class ComboBoxDtNascimento {

    private JComboBox<String> comboDia;
    private JComboBox<String> comboMes;
    private JComboBox<String> comboAno;

    public ComboBoxDtNascimento() {
        // Adicionar as strings de dia, mês e ano
        String[] dias = criarArrayNumerico(01,31);
        String[] meses = criarArrayNumerico(01,12);
        String[] anos = criarArrayNumerico(1950, 2024);

        // Criar os JComboBox para dia, mês e ano
        comboDia = new JComboBox<String>(dias);
        comboMes = new JComboBox<String>(meses);
        comboAno = new JComboBox<String>(anos);
    }

    public JPanel getPanel() {
        // Cria um painel e adiciona os combos
        JPanel panel = new JPanel();
        panel.add(comboDia);
        panel.add(comboMes);
        panel.add(comboAno);
        return panel;
    }

    public void resetarSelecoes() {
        // Reseta as seleções nos JComboBox de dia, mês e ano
        comboDia.setSelectedIndex(0);
        comboMes.setSelectedIndex(0);
        comboAno.setSelectedIndex(0);
    }

    private String[] criarArrayNumerico(int inicio, int fim) {
        String[] arrayNumerico = new String[fim - inicio +1];
        for (int i =0; i < arrayNumerico.length; i++) {
            arrayNumerico[i] = String.valueOf(inicio + i);
        }
        return arrayNumerico;
    }

    // Formatar data para string
    public String formatarDataSelecionada() {
        String diaSelecionado = (String) comboDia.getSelectedItem();
        String mesSelecionado = (String) comboMes.getSelectedItem();
        String anoSelecionado = (String) comboAno.getSelectedItem();
        return diaSelecionado + "/" + mesSelecionado + "/" + anoSelecionado;
    }
}
