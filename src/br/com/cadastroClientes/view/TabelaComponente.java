package br.com.cadastroClientes.view;

import javax.swing.*;
import java.awt.*;

public class TabelaComponente extends JComponent {
    private String[][] dados;

    public TabelaComponente () {
        this.dados = new String[][]{{"1","Teste","teste","11"}};
        String[] colunas = {"CPF","Nome","E-mail","Telefone"};

        JTable tabela = new JTable(this.dados, colunas);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setPreferredScrollableViewportSize(tabela.getPreferredSize());
        tabela.setFillsViewportHeight(true);

        FontMetrics tamanhoFonte = tabela.getFontMetrics(tabela.getFont());
        int alturaLinha = tamanhoFonte.getHeight() * this.dados.length;
        tabela.setRowHeight(alturaLinha);

        JScrollPane scroll = new JScrollPane(tabela);

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);

        add(scroll);
        setVisible(true);
    }
}
