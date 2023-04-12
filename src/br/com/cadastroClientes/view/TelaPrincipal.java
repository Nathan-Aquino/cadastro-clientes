package br.com.cadastroClientes.view;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal () {
        super("Cadastro de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GroupLayout gpLayout = new GroupLayout(this.getContentPane());
        setLayout(gpLayout);

        TabelaComponente tabela = new TabelaComponente();
        FormularioComponente forms = new FormularioComponente(tabela);
        BotoesComponente menu = new BotoesComponente(forms);
        tabela.recebeForms(forms);

        gpLayout.setAutoCreateGaps(true);
        gpLayout.setAutoCreateContainerGaps(true);

        gpLayout.setHorizontalGroup(
                gpLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGap(1250)
                        .addComponent(forms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(menu, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tabela, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
        );
        gpLayout.setVerticalGroup(
                gpLayout.createSequentialGroup()
                        .addGap(30)
                        .addComponent(forms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(35)
                        .addComponent(menu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(35)
                        .addComponent(tabela)
        );

        setLocation(270,40);
        setVisible(true);
        setSize(1250, 950);
    }
}
