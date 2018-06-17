package com.github.icarohs7.unoxlib.tables;


import java.awt.Dimension;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * Sobrescrita da JTable padrao para fazer o tamanho do JScroll se adaptar automaticamente a tabela
 * @author <a href="https://github.com/icarohs7">Icaro D Temponi</a>
 */
@SuppressWarnings("unused")
public class ScrollTable extends JTable {
	/**
	 * Instanciar uma tabela mutavel com scroll
	 * @param data        Os dados a serem inseridos na tabela
	 * @param columnNames Os nomes das colunas da tabela
	 * @return the scroll table
	 */
	public static ScrollTable ofMutableCells(Object[][] data, String[] columnNames) {
		return ofACustomModel(new EditableTableModel(data, columnNames));
	}
	
	/**
	 * Instanciar uma tabela mutavel com scroll
	 * @param data        Os dados a serem inseridos na tabela
	 * @param columnNames Os nomes das colunas da tabela
	 * @return the scroll table
	 */
	public static ScrollTable ofMutableCells(List<? extends Object[]> data, String[] columnNames) {
		return ofACustomModel(new EditableTableModel(data, columnNames));
	}
	
	/**
	 * Instanciar uma tabela apartir de um tablemodel personalizado
	 * @param model Tablemodel personalizado
	 * @return Instância da tabela com o modelo definido
	 */
	public static ScrollTable ofACustomModel(TableModel model) {
		ScrollTable table = new ScrollTable(new String[][] {}, new String[] {});
		table.setModel(model);
		return table;
	}
	
	/**
	 * Instanciar uma tabela imutavel com scroll
	 * @param data        Os dados a serem inseridos na tabela
	 * @param columnNames Os nomes das colunas da tabela
	 */
	public ScrollTable(Object[][] data, String[] columnNames) {
		super(data, columnNames);
		/* Desativar a reordenacao das colunas */
		tableHeader.setReorderingAllowed(false);
		/* Desativar o redimensionamento das colunas */
		tableHeader.setResizingAllowed(false);
	}
	
	
	/**
	 * Retorna um JScrollPane contendo a tabela atual
	 * @return the scrollable table
	 */
	public JScrollPane getScrollableTable() {
		return new JScrollPane(this);
	}
	
	/**
	 * Desativar a selecao de celulas
	 * @param i  the
	 * @param i1 the 1
	 * @return the boolean
	 */
	@Override
	public boolean isCellSelected(int i, int i1) {
		return false;
	}
	
	/**
	 * Desativar a edicao de celulas
	 * @param i  the
	 * @param i1 the 1
	 * @return the boolean
	 */
	@Override
	public boolean isCellEditable(int i, int i1) {
		return false;
	}
	
	/**
	 * Definir o tamanho da tabela quando embrulhada para o seu tamanho completo
	 * @return the preferred scrollable viewport size
	 */
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return getPreferredSize();
	}
}
