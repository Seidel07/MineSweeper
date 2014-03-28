package com.despegar.highflight.finalproject.minesweeper;

import java.util.Random;

public class GridCell {
	private Cell cells[][];
	
	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public void createGridCell(int rows, int columns) {
		
		this.cells = new Cell[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				this.cells[i][j] = new Cell();
				this.cells[i][j].setMinesAround(0);
				this.cells[i][j].setCovered(true);
			}
		}
	}
	
	private void setMines(int rows, int columns) {
		double mines = Math.floor(rows*columns*15/100); //calculate how many mines i need
		int cantMines = 0; //counter to see how many mines i have so far
		while (cantMines < mines) { //beginning the assignment of mines
			Random rand = new Random();
			int i = rand.nextInt(rows); //randomly selecting the row
			int j = rand.nextInt(columns); //randomly selecting the column
			if (!cells[i][j].hasMine()) { //asking whether cells[i][j] it has mine or not
				cantMines = cantMines + 1; //if it doesn't have a mine I sum 1 to the cantMines
				cells[i][j].setMine(true); //and assign a mine to that cell
			}
		}
	}
	
	private void setNumbers(int rows, int columns) { 
		for (int i=0; i <= (rows-1) ; i++) { 
			for (int j=0; j<= (columns-1) ; j++) {
				if (cells[i][j].hasMine()) { //asking if each cell has a mine
					for (int a=i-1; a <= i+1 ; a++) { //going throw the adjacent rows of [i][j]
						for (int b=j-1; b <= j+1 ; b++) { //going throw the adjacent columns of [i][j]
							if (!cells[a][b].hasMine()) { //asking if an adjacent cell of cells[i][j] has a mine
								cells[a][b].setMinesAround(cells[a][b].getMinesAround()+1); //if it doesn't, adding 1 to the mines that a cell has around 
							}
						}
					}
				}
			}
		}
	}
	
	public void newGame(int rows, int columns) {
		setMines(rows,columns); //setting where are the mines in the game
		setNumbers(rows,columns); //setting which the numbers are in the game 
	}
	
	public void display (int rows, int columns) {
		for (int i=0;i<=(rows-1);i++) {
			for (int j=0;j<=(columns-1);j++) {
				if (cells[i][j].isCovered()) { //asking if a cell is covered
					if (cells[i][j].isFlaged()) { //if it's not covered, i ask if it's flaged 
						System.out.print("F "); //if it's flaged, I print an F
					} else {
						System.out.print("C "); //if it's not flaged, I print a C
					}
				} else {
					System.out.print(cells[i][j].getMinesAround() + " "); //if is uncovered, i print the number of mines around with a space
				}
			}
			System.out.println(); //going one row down to have the matrix design
		}
		
		
	}
	
	public boolean isGameOver(int rows, int columns, double remaining) {
		boolean finished = false;
		if (remaining > 0) {
			for (int i=0;i<=(rows-1);i++) {
				for (int j=0;j<=(columns-1);j++) {
					if (cells[i][j].hasMine()) {
						if (!cells[i][j].isCovered()) {
							finished = true;
							remaining = -1;
						}
					}
				}
			}
		} else {
			finished = true;
		}
		return finished;
	}
	
	public void uncover(int row, int column, double remaining) {
		cells[row][column].setCovered(false);
		remaining = remaining - 1;
		cells[row][column].setFlaged(false);
	}
	
	public void flagAsMine (int row, int column) {
		if (cells[row][column].isFlaged()) {
			cells[row][column].setFlaged(false);
		} else {
			cells[row][column].setFlaged(true);
		}
	}
	
	public String isWinningGame(double remaining) {
		if (remaining == 0) {
			return "Ganaste";
		} else {
			return "Perdiste";
		}
	}
	
	
}