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
	}
	
	private class GiftModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return "Brad";
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			// TODO Auto-generated method stub
			super.setValueAt(aValue, row, column);
		}
		
	}
	
}
