package com.despegar.highflight.finalproject.minesweeper;

import java.util.Random;

public class Cell extends GridCell{
	private boolean isFlaged = false;
	private boolean hasMine = false;
	private boolean isCovered = true; 
	private int minesAround = 0;
	private Cell ms[][];
	
		
	public void uncover(int file, int row) {
		isCovered = true;
	}
	
	public void flagAsMine(int file, int row) {
		if(isFlaged) {
			isFlaged=false;
		} else {
			isFlaged=true;
		}
	}
	
	private void setMine(int file, int row) {
		hasMine = true;
	}
	
	private void setMinesAround (int file, int row) {
		minesAround = minesAround + 1;
	}
	
	public void newGame(int files, int rows) {
		Cell ms[][] = new Cell[files][rows];
		double mines = files*rows*15/100;
		for (int p=0; p<mines;) { //assigning the mines
        	Random rand = new Random();
        	int value1 = rand.nextInt(files);
        	int value2 = rand.nextInt(rows) ;
        	if (!ms[value1][value2].hasMine) {
        		ms[value1][value2].hasMine = true;
        		p=p+1;
        	}

		}
		for (int i=0 ; i<files;i++) { //assigning the corresponding numbers to each element that isn't a mine
        	for (int j=0;j<rows;j++) {
        		if(ms[i][j].hasMine) {
        			for (int a = i-1;a<=i+1;a++) {
        				for (int b=j-1;b<=j+1;b++) {
        					if (a>=0 && b>=0 && a<=files-1 && b<=rows-1) {
        						if (!ms[a][b].hasMine) {
        							ms[a][b].setMinesAround(a, b);
        						}
        					}
        				}
        			}
        		}
        		
        	}
        }
	
	}
	
	public boolean isGameOver() {
		
		return false;
	}
	
	public boolean isWinningGame() {
		return false;
	}
	
	public void display() {
		
	}
	
	public void displayInternal(int files, int rows, Cell[][] game) {
		for (int i = 0;i<files;i++) {
			for (int j=0;j<rows;j++) {
				System.out.print(game[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
