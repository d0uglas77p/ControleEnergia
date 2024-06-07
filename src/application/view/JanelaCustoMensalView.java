package application.view;

import javax.swing.*;
import java.awt.*;

public class JanelaCustoMensalView extends JFrame {
    public JanelaCustoMensalView(double custoMensal) {
        setTitle("Custo Mensal");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel labelTexto = new JLabel("O custo mensal dos aparelhos elétricos:");
        labelTexto.setBounds(60,50,300,20);
        labelTexto.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelTexto);

        JLabel labelCustoMensal = new JLabel("R$ " + String.format("%.2f", custoMensal));
        labelCustoMensal.setBounds(160,70,300,20);
        labelCustoMensal.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(labelCustoMensal);

        add(panel);
    }
}
