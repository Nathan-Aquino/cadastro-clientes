package br.com.cadastroClientes.view;

import javax.swing.*;
import java.awt.*;

public class FormularioComponente extends JComponent {
    public  FormularioComponente () {

        JLabel[] labels = {
                new JLabel("Nome"),
                new JLabel("Sobrenome"),
                new JLabel("Idade"),
                new JLabel("CPF"),
                new JLabel("E-mail"),
                new JLabel("Telefone")
        };

        JTextField[] textFields = {
                new JTextField(),
                new JTextField(),
                new JTextField(),
                new JTextField(),
                new JTextField(),
                new JTextField()
        };

        for (int i = 0; i < 6; i++) {
            add(labels[i]);
            add(textFields[i]);
        }

        setLayout(new GridLayout(6,2,0,40));
        setSize(450, 350);
        setVisible(true);
    }
}
