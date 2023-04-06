package br.com.cadastroClientes.view;

import javax.swing.*;
import java.awt.*;

public class BotoesComponente extends JComponent {
    public BotoesComponente() {
        JButton consultar = new JButton("Consultar");
        JButton excluir = new JButton("Excluir");
        JButton salvar = new JButton("Salvar");

        add(salvar);
        add(excluir);
        add(consultar);

        setLayout(new GridLayout(1,3,10,20));
        setVisible(true);
    }
}
