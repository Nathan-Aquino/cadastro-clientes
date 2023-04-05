package br.com.cadastroClientes.view;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal () {
        super("Cadastro de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(new FormularioComponente());

        setLocation(250,100);
        setVisible(true);
        setSize(1250, 950);
    }
}
