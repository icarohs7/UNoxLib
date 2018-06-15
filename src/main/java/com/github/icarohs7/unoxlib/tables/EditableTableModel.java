package com.github.icarohs7.unoxlib.tables;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Implementacao do modelo de tabela que permite a edicao da mesma apos a
 * instanciacao<br>
 * <br>
 * Feito por codejava.net, Codigo e documentacao em<br>
 * <a href="http://www.codejava.net/java-se/swing/editable-jtable-example">
 * http://www.codejava.net/java-se/swing/editable-jtable-example
 * </a>
 */
@SuppressWarnings("unused")
public class EditableTableModel extends AbstractTableModel {
	
	/**
	 * Titulos das colunas
	 */
	private String[] columnTitles;
	
	/**
	 * Dados contidos na tabela
	 */
	private List<Object[]> dataEntries = new LinkedList<>();
	
	/**
	 * Quantidade de linhas da tabela
	 */
	private int rowCount;
	
	
	/**
	 * Inicializar tabela
	 * @param dataEntries  Dados contidos nas colunas
	 * @param columnTitles Títulos das colunas
	 */
	public EditableTableModel(Object[][] dataEntries, String[] columnTitles) {
		this.columnTitles = columnTitles;
		Collections.addAll(this.dataEntries, dataEntries);
	}
	
	/**
	 * Adiciona uma linha à coluna
	 * @param entry Array contendo os elementos referentes às colunas
	 */
	public void addRow(Object[] entry) {
		dataEntries.add(entry);
		fireTableDataChanged();
	}
	
	/**
	 * Remove uma linha da coluna
	 * @param position Indice da linha a ser removido, começando de 0
	 */
	public void removeRow(int position) {
		dataEntries.remove(position);
		fireTableDataChanged();
	}
	
	/**
	 * Retorna o numero de linhas contidas na tabela
	 * @return O numero de linhas da tabela
	 */
	@Override
	public int getRowCount() {
		return dataEntries.size();
	}
	
	/**
	 * Retorna o numero de colunas contidas na tabela
	 * @return O numero de colunas da tabela
	 */
	@Override
	public int getColumnCount() {
		return columnTitles.length;
	}
	
	/**
	 * Retorna o valor contido na celula selecionada
	 * @param row    Indice da linha da celula a ser selecionada, de 0 a n
	 * @param column Indice da coluna da celula a ser selecionada, de 0 a n
	 * @return O conteudo da celula selecionada
	 */
	@Override
	public Object getValueAt(int row, int column) {
		return dataEntries.get(row)[column];
	}
	
	/**
	 * Retorna o nome da coluna selecionada
	 * @param column Indice da coluna que se deseja obter o nome, de 0 a n
	 * @return O nome da coluna indicada
	 */
	@Override
	public String getColumnName(int column) {
		return columnTitles[column];
	}
	
	/**
	 * Retorna se a celula indicada e ou nao editavel
	 * @param row    Indice da linha da celula a ser selecionada, de 0 a n
	 * @param column Indice da coluna da celula a ser selecionada, de 0 a n
	 * @return Se a celula e ou nao editavel
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	/**
	 * Edita uma celula da tabela
	 * @param value  O conteudo que se deseja inserir na celula
	 * @param row    Indice da linha onde a celula desejada se encontra, de 0 a n
	 * @param column Indice da coluna onde a celula desejada se encontra, de 0 a n
	 */
	@Override
	public void setValueAt(Object value, int row, int column) {
		dataEntries.get(row)[column] = value;
		fireTableCellUpdated(row, column);
	}
	
	/**
	 * Edita uma linha da tabela
	 * @param rowValue Valor a ser definido na linha
	 * @param row      Indice da linha, de 0 a n
	 */
	public void setValueAt(Object rowValue[], int row) {
		dataEntries.set(row, rowValue);
		fireTableDataChanged();
	}
	
}
