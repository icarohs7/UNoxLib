package com.github.icarohs7.unoxlib.tables;

import javax.swing.JFrame;
import javax.swing.JTable;

class Test {
	
	public static void main(String[] args) {
		final int DELAY = 1000;
		String[] colunas = { "ID", "Nome", "Idade" };
		String[][] dados = {
				{ "1", "Icaro", "21" },
				{ "2", "Daniel", "20" }
		};
		JTable tabela = ScrollTable.ofMutableCells(dados, colunas);
		EditableTableModel model = (EditableTableModel) tabela.getModel();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(((ScrollTable) tabela).getScrollableTable());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(() -> {
			try {
				Thread.sleep(DELAY);
				model.addRow(new String[] { "3", "Maria", "30" });
				frame.pack();
				Thread.sleep(DELAY);
				model.addRow(new String[] { "4", "João", "32" });
				frame.pack();
				Thread.sleep(DELAY);
				model.addRow(new String[] { "5", "Geraldo", "25" });
				frame.pack();
				Thread.sleep(DELAY);
				model.addRow(new String[] { "6", "Daniel2", "20" });
				frame.pack();
				Thread.sleep(DELAY);
				model.addRow(new String[] { "7", "Railander", "21" });
				frame.pack();
				Thread.sleep(DELAY);
				model.removeRow(0);
				frame.pack();
				Thread.sleep(DELAY);
				model.removeRow(0);
				frame.pack();
				Thread.sleep(DELAY);
				model.setValueAt(new String[] { "4", "Marcos", "28" }, 3);
				frame.pack();
				Thread.sleep(DELAY);
				model.setValueAt("Marta", 2, 1);
				frame.pack();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
