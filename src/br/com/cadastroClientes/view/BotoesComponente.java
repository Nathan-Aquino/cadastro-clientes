package br.com.cadastroClientes.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotoesComponente extends JComponent implements ActionListener {

    private FormularioComponente forms;

    public BotoesComponente(FormularioComponente forms) {
        JButton consultar = new JButton("Consultar");
        JButton excluir = new JButton("Excluir");
        JButton salvar = new JButton("Salvar");

        this.forms = forms;

        salvar.addActionListener(this);
        excluir.addActionListener(this);
        consultar.addActionListener(this);

        add(salvar);
        add(excluir);
        add(consultar);

        setLayout(new GridLayout(1,3,10,20));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Salvar":
                forms.salvarCliente();
                break;
            case "Excluir":
                break;
            case "Consultar":
                break;
        }
    }
}
