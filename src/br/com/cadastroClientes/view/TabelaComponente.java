package br.com.cadastroClientes.view;

import br.com.cadastroClientes.dao.ClienteDao;
import br.com.cadastroClientes.dao.InicializacaoDao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.util.Transformacao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TabelaComponente extends JComponent {
    private String[][] dados = new String[0][0];
    private String[] colunas;
    private JTable tabela;

    public TabelaComponente () {
        this.recebeClientes();
        this.colunas = new String[] {"CPF","Nome","E-mail","Telefone"};

        this.tabela = new JTable(this.dados, colunas);
        this.tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.tabela.setPreferredScrollableViewportSize(this.tabela.getPreferredSize());
        this.tabela.setFillsViewportHeight(true);

        FontMetrics tamanhoFonte = this.tabela.getFontMetrics(this.tabela.getFont());
        int alturaLinha;
        if (this.dados.length == 0) {
            alturaLinha = tamanhoFonte.getHeight() ;
        } else {
            alturaLinha = tamanhoFonte.getHeight() * this.dados.length;
        }
        this.tabela.setRowHeight(alturaLinha);

        JScrollPane scroll = new JScrollPane(this.tabela);

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);

        add(scroll);
        setVisible(true);
    }

    public void recebeClientes () {
        ClienteDao dao = InicializacaoDao.clienteDao();
        List<Cliente> clientes = dao.consultarClientes();

        if (clientes.size() != 0) {
            this.dados = Transformacao.listaParaMatriz(clientes);
            this.tabela.setModel(new DefaultTableModel(this.dados, this.colunas));
        }
    }
}
