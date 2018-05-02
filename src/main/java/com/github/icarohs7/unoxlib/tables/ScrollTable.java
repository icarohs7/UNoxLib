package com.github.icarohs7.unoxlib.tables;


import com.sun.istack.internal.NotNull;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Sobrescrita da JTable padrão para fazer o tamanho do JScroll se adaptar automaticamente à tabela
 *
 * @author <a href="https://github.com/icarohs7">Icaro D Temponi</a>
 */
public class ScrollTable extends JTable {
	/**
	 * Instanciar uma tabela mutável com scroll
	 *
	 * @param data        Os dados a serem inseridos na tabela
	 * @param columnNames Os nomes das colunas da tabela
	 *
	 * @return the scroll table
	 */
	public static ScrollTable ofMutableCells( @NotNull Object[][] data, @NotNull String[] columnNames ) {
		ScrollTable table = new ScrollTable( data, columnNames );
		table.setModel( new EditableTableModel( data, columnNames ) );
		return table;
	}
	
	/**
	 * Instanciar uma tabela imutável com scroll
	 *
	 * @param data        Os dados a serem inseridos na tabela
	 * @param columnNames Os nomes das colunas da tabela
	 */
	public ScrollTable( @NotNull Object[][] data, @NotNull String[] columnNames ) {
		super( data, columnNames );
		/* Desativar a reordenação das colunas */
		tableHeader.setReorderingAllowed( false );
		/* Desativar o redimensionamento das colunas */
		tableHeader.setResizingAllowed( false );
	}
	
	/**
	 * Retorna um JScrollPane contendo a tabela atual
	 *
	 * @return the scrollable table
	 */
	public JScrollPane getScrollableTable() {
		return new JScrollPane( this );
	}
	
	/**
	 * Desativar a seleção de células
	 *
	 * @param i  the
	 * @param i1 the 1
	 *
	 * @return the boolean
	 */
	@Override
	public boolean isCellSelected( int i, int i1 ) {
		return false;
	}
	
	/**
	 * Desativar a edição de células
	 *
	 * @param i  the
	 * @param i1 the 1
	 *
	 * @return the boolean
	 */
	@Override
	public boolean isCellEditable( int i, int i1 ) {
		return false;
	}
	
	/**
	 * Definir o tamanho da tabela quando embrulhada para o seu tamanho completo
	 *
	 * @return the preferred scrollable viewport size
	 */
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return getPreferredSize();
	}
	
	
}
