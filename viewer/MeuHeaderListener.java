package viewer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MeuHeaderListener extends MouseAdapter {
	//
	// ATRIBUTOS
	//
	private JTable tabela;
	private SortOrder ordem = SortOrder.DESCENDING;
	private int colunaSelecionada = -1;

    public MeuHeaderListener(JTable table) {
        this.tabela = table;
        this.tabela.getTableHeader().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Obter o ponto onde o clique ocorreu
        int col = this.tabela.columnAtPoint(e.getPoint());

        // Verificar se o clique foi em uma célula válida do cabeçalho
        if (e.getClickCount() == 1 && col != -1) {
            // Chamar a função que você quer que aconteça
            tratarCliqueNoCabecalho(col);
        }
    }

    private void tratarCliqueNoCabecalho(int columnIndex) {
    	// Pego o TableModel associado ao JTable
    	TableModel meuTableModel = this.tabela.getModel();
        
        // Exemplo de como criar um TableRowSorter 
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(meuTableModel);
        meuTableModel.addTableModelListener(e1 -> { // Adicionar listener para reordenar ao alterar os dados
            sorter.modelStructureChanged();
        });
        this.tabela.setRowSorter(sorter); // Define o sorter na tabela

        // Lógica para inverter a ordem de ordenação a cada clique na coluna
        List<RowSorter.SortKey> keys = new ArrayList<>(sorter.getSortKeys());
//        if (!keys.isEmpty() && keys.get(0).getColumn() == columnIndex) {
//            // Se já está ordenado pela coluna, inverte a ordem (crescente/decrescente)
//            RowSorter.SortKey currentKey = keys.get(0);
//            SortOrder newOrder = (
//            keys.set(0, new RowSorter.SortKey(columnIndex, newOrder));
//        } else {
//            // Se é a primeira vez, ordena em ordem crescente
//
        	if(this.colunaSelecionada != columnIndex) {
        		this.colunaSelecionada = columnIndex;
        		ordem = SortOrder.ASCENDING;           	
        	} 
        	ordem = ordem == SortOrder.ASCENDING ? SortOrder.DESCENDING : SortOrder.ASCENDING;
        	keys.add(new RowSorter.SortKey(columnIndex, ordem));            	
//        }
        sorter.setSortKeys(keys);
    }
}
