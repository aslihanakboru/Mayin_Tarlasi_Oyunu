package mayin_tarlasi;

import javax.swing.JButton;

public class Btn extends JButton {
	private int row,col,count;
	private boolean mayin,bayrak;
	public Btn(int row, int col) {
		this.row = row;
		this.col = col;
		this.count = 0;
		this.mayin = false;
		this.bayrak = false;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isMayin() {
		return mayin;
	}
	public void setMayin(boolean mayin) {
		this.mayin = mayin;
	}
	public boolean isBayrak() {
		return bayrak;
	}
	public void setBayrak(boolean bayrak) {
		this.bayrak = bayrak;
	}
	
	
	

}
