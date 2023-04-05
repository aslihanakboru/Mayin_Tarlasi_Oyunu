package mayin_tarlasi;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mayin_Tarlasi implements MouseListener{
	JFrame frame;
	Btn[][] board = new Btn[10][10]; 
	int openbutton;
	
	public Mayin_Tarlasi(){
		openbutton = 0;
		frame = new JFrame("Mayin Tarlasi");
		frame.setSize(700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(10,10));
		
		for(int row=0; row < board.length ; row++){
			for(int col=0 ; col < board[0].length; col++ ){
				Btn b = new Btn(row,col);
				frame.add(b);
				b.addMouseListener(this);
				board[row][col]=b;
			}			
		}
		
		MayinTuret();
		updateCount();
		//printMayin();
		
		frame.setVisible(true);
	}
	
	public void MayinTuret(){
		int i=0;
		while(i < 10){
			int randomRow  = (int) (Math.random()*board.length);
			int randomCol  = (int) (Math.random()*board[0].length);
			
			while(board[randomRow][randomCol].isMayin()){
				randomRow  = (int) (Math.random()*board.length);
				randomCol  = (int) (Math.random()*board[0].length);				
			}
			board[randomRow][randomCol].setMayin(true);
			i++;
		}
		
	}
	public void print(){
		for(int row=0; row < board.length ; row++){
			for(int col=0 ; col < board[0].length; col++ ){
				if(board[row][col].isMayin()){
					board[row][col].setIcon(new ImageIcon("src/mayin2.png"));
				}
				else{
					board[row][col].setText(board[row][col].getCount() + "");
					board[row][col].setEnabled(false);
				}	
		}}
	}
	public void printMayin(){
		for(int row=0; row < board.length ; row++){
			for(int col=0 ; col < board[0].length; col++ ){
				if(board[row][col].isMayin()){
					board[row][col].setIcon(new ImageIcon("src/mayin2.png"));
				}
		    }
		}
	}
	
	public void updateCount(){
		for(int row=0; row < board.length ; row++){
			for(int col=0 ; col < board[0].length; col++ ){
				if(board[row][col].isMayin()){
					counting(row,col);
				}
			}
		}
	}

	private void counting(int row, int col) {
		for(int i = row -1 ; i<= row + 1 ; i++){
			for(int k = col - 1 ; k <= col + 1; k++ ){
				try{
					int value = board[i][k].getCount();
					board[i][k].setCount(++value);					
				}catch(Exception e){
					
				}
				
			}}
		
	}
	public void open(int r,int c){
		if(r < 0 || r >= board.length ||c < 0 || c >= board[0].length || board[r][c].getText().length() > 0 || board[r][c].isEnabled()==false){
			return;
		}
		else if(board[r][c].getCount() != 0 ) {
			board[r][c].setText(board[r][c].getCount() + "");
			board[r][c].setEnabled(false);
		}else{
			openbutton++;
			board[r][c].setEnabled(false);
			open(r-1,c);
			open(r+1,c);
			open(r,c-1);
			open(r,c+1);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Btn b = (Btn)e.getComponent();
		if (e.getButton()==1){
			System.out.println("sol tik");
			if(b.isMayin()){
				JOptionPane.showMessageDialog(frame, "Mayina Bastiniz! Oyunu kaybettiniz!");
				print();
			}else{
				open(b.getRow(),b.getCol());
				if(openbutton == (board.length * board[0].length)- 10){
					JOptionPane.showMessageDialog(frame, "TEBRIKLER  OYUNU KAZANDINIZ !!!");
				}
			}
		}
		else if(e.getButton()==3){
			System.out.println("sag tik");
			if(!b.isBayrak()){
				b.setIcon(new ImageIcon("src/flag2.png")); 
				b.setBayrak(true);
			}else{
				b.setIcon(null);
				b.setBayrak(false);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
