package tw.brad.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiftTable extends JTable{
	private GiftModel model;
	private GiftDB db;
	
	public GiftTable() {
		
		try {
			db = new GiftDB();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		model = new GiftModel();
		setModel(model);
		model.setColumnIdentifiers(db.getColNames());
	}
	
	public void delRow() {
		int del = getSelectedRow();
		if (del != -1) {
			db.delData(del);
			repaint();
		}
	}
	
	private class GiftModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row, column);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			db.updateData((String)aValue, row, column);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column != 0;
		}
		
		
		
	}
	
}
