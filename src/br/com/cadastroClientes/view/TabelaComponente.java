package br.com.cadastroClientes.view;

import br.com.cadastroClientes.dao.ClienteDao;
import br.com.cadastroClientes.dao.InicializacaoDao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.services.ClienteService;
import br.com.cadastroClientes.util.Transformacao;
import br.com.cadastroClientes.util.modeloTabelaCustomizado;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TabelaComponente extends JComponent {
    private String[][] dados = new String[0][0];
    private String[] colunas;
    private JTable tabela;
    private FormularioComponente forms;

    public TabelaComponente () {
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

        this.tabela.setRowSelectionAllowed(true);

        ListSelectionModel select = this.tabela.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        Integer linha = tabela.getSelectedRow();
                        if (linha != -1){
                            String cpf = (String) tabela.getValueAt(linha,0);
                            forms.consultarCliente(cpf);
                        }
                    }
                }
        );

        JScrollPane scroll = new JScrollPane(this.tabela);

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);

        add(scroll);
        setVisible(true);
    }

    public void recebeClientes () {
        ClienteDao dao = InicializacaoDao.clienteDao();
        ClienteService service = ClienteService.service(dao);

        List<Cliente> clientes = service.consultarObjetos();

        if (clientes.size() != 0) {
            this.dados = Transformacao.listaParaMatriz(clientes);
            this.resetaTabela();
        } else {
            this.dados = new String[0][0];
            this.resetaTabela();
        }
    }

    public void recebeForms (FormularioComponente forms) {
        this.forms = forms;
    }

    public void resetaTabela () {
        this.tabela.setModel(new modeloTabelaCustomizado(this.dados, this.colunas));
    }
}
