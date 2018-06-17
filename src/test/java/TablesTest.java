import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.github.icarohs7.unoxlib.tables.EditableTableModel;
import com.github.icarohs7.unoxlib.tables.ScrollTable;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TablesTest {
	private final int DELAY = 300;
	@SuppressWarnings("FieldCanBeLocal")
	private final boolean FRAME_VISIBLE = true;
	private JFrame frame;
	private EditableTableModel model;
	
	
	private void gerarComponentes() {
		String[] colunas = { "ID", "Nome", "Idade" };
		//		String[][] dados = {
		//				{ "1", "Icaro", "21" },
		//				{ "2", "Daniel", "20" }
		//		};
		List<String[]> dados = new LinkedList<>();
		dados.add(new String[] { "1", "Icaro", "21" });
		dados.add(new String[] { "2", "Daniel", "20" });
		
		ScrollTable tabela = ScrollTable.ofMutableCells(dados, colunas);
		model = (EditableTableModel) tabela.getModel();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tabela.getScrollableTable());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(FRAME_VISIBLE);
	}
	
	@Test
	@DisplayName("Teste de inserção de dados")
	void insertDataTest() throws InterruptedException {
		gerarComponentes();
		
		Thread.sleep(DELAY);
		model.addRow(new String[] { "3", "Maria", "30" });
		frame.pack();
		
		Assertions.assertEquals(3, model.getRowCount(), "Quantidade de linhas após inserção 1");
		Assertions.assertEquals("30", model.getValueAt(2, 2), "Valor em posição específica após inserção 1");
		
		Thread.sleep(DELAY);
		model.addRow(new String[] { "4", "João", "32" });
		frame.pack();
		
		Thread.sleep(DELAY);
		model.addRow(new String[] { "5", "Geraldo", "25" });
		frame.pack();
		
		Assertions.assertEquals(5, model.getRowCount(), "Quantidade de linhas após inserção 2");
		Assertions.assertEquals("Geraldo", model.getValueAt(4, 1), "Valor em posição específica após inserção 2");
		
		Thread.sleep(DELAY);
		model.addRow(new String[] { "6", "Daniel2", "20" });
		frame.pack();
		
		Thread.sleep(DELAY);
		model.addRow(new String[] { "7", "Railander", "21" });
		frame.pack();
		
		Assertions.assertEquals(7, model.getRowCount(), "Quantidade de linhas após inserção 3");
		Assertions.assertEquals("21", model.getValueAt(6, 2), "Valor em posição específica após inserção 3");
	}
	
	@Test
	@DisplayName("Teste de remoção de dados")
	void removeDataTest() throws InterruptedException {
		Thread.sleep(DELAY);
		model.removeRow(0);
		frame.pack();
		
		Assertions.assertEquals(6, model.getRowCount(), "Quantidade de linhas após remoção 1");
		Assertions.assertEquals("Daniel", model.getValueAt(0, 1), "Valor específico após remoção 1");
		
		Thread.sleep(DELAY);
		model.removeRow(0);
		frame.pack();
		
		Assertions.assertEquals(5, model.getRowCount(), "Quantidade de linhas após remoção 2");
		Assertions.assertEquals("Maria", model.getValueAt(0, 1), "Valor específico após remoção 2");
	}
	
	@Test
	@DisplayName("Teste de inserção de dados em posições específicas")
	void setValueTest() throws InterruptedException {
		Thread.sleep(DELAY);
		model.setValueAt(new String[] { "4", "Marcos", "28" }, 3);
		frame.pack();
		
		Assertions.assertEquals("4", model.getValueAt(3, 0), "Testar novo ID Após alteração 1");
		Assertions.assertEquals("Marcos", model.getValueAt(3, 1), "Testar novo Nome Após alteração 1");
		Assertions.assertEquals("28", model.getValueAt(3, 2), "Testar nova Idade Após alteração 1");
		
		Thread.sleep(DELAY);
		model.setValueAt("Marta", 2, 1);
		frame.pack();
		
		Assertions.assertEquals("Marta", model.getValueAt(2, 1), "Testar valor específico após alteração 1");
	}
	
	@Test
	@DisplayName("Teste da redefinição dos dados da tabela")
	void setAllRowsTest() throws InterruptedException {
		Thread.sleep(DELAY);
		String[][] novosDados = {
				{ "1", "Railander", "21" },
				{ "2", "Jefersom", "22" }
		};
		
		Assertions.assertEquals(5, model.getRowCount(), "Confirmar tamanho da tabela antes da redefinição 1");
		
		model.setAllRows(novosDados);
		
		Thread.sleep(DELAY);
		
		Assertions.assertEquals(2, model.getRowCount(), "Confirmar tamanho da tabela depois da redefinição 1");
		
		Assertions.assertEquals("1", model.getValueAt(0, 0), "Confirmar id específico após redefinição 1");
		Assertions.assertEquals("Railander", model.getValueAt(0, 1), "Confirmar nome específico após redefinição 1");
		Assertions.assertEquals("21", model.getValueAt(0, 2), "Confirmar idade específica após redefinição 1");
		
		Assertions.assertEquals("2", model.getValueAt(1, 0), "Confirmar id específico após redefinição 2");
		Assertions.assertEquals("Jefersom", model.getValueAt(1, 1), "Confirmar nome específico após redefinição 2");
		Assertions.assertEquals("22", model.getValueAt(1, 2), "Confirmar idade específica após redefinição 2");
		
		List<String[]> novosDados2 = new LinkedList<>();
		novosDados2.add(new String[] { "1", "Daniel G", "20" });
		novosDados2.add(new String[] { "2", "Daniel S", "20" });
		novosDados2.add(new String[] { "3", "Icaro", "21" });
		
		Assertions.assertEquals(2, model.getRowCount(), "Confirmar tamanho da tabela antes da redefinição 2");
		
		model.setAllRows(novosDados2);
		
		Thread.sleep(DELAY);
		
		Assertions.assertEquals(3, model.getRowCount(), "Confirmar tamanho da tabela depois da redefinição 2");
		
		Assertions.assertEquals("1", model.getValueAt(0, 0), "Confirmar id específico após redefinição 1");
		Assertions.assertEquals("Daniel G", model.getValueAt(0, 1), "Confirmar nome específico após redefinição 1");
		Assertions.assertEquals("20", model.getValueAt(0, 2), "Confirmar idade específica após redefinição 1");
		
		Assertions.assertEquals("2", model.getValueAt(1, 0), "Confirmar id específico após redefinição 2");
		Assertions.assertEquals("Daniel S", model.getValueAt(1, 1), "Confirmar nome específico após redefinição 2");
		Assertions.assertEquals("20", model.getValueAt(1, 2), "Confirmar idade específica após redefinição 2");
		
		Assertions.assertEquals("3", model.getValueAt(2, 0), "Confirmar id específico após redefinição 3");
		Assertions.assertEquals("Icaro", model.getValueAt(2, 1), "Confirmar nome específico após redefinição 3");
		Assertions.assertEquals("21", model.getValueAt(2, 2), "Confirmar idade específica após redefinição 3");
	}
}
