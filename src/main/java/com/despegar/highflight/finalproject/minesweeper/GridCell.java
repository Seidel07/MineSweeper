package com.despegar.highflight.finalproject.minesweeper;

import java.util.Random;
import com.despegar.highflight.utils.MatrixUtils;

public class GridCell {
	private Cell cells[][];
	private int remaining;
	private int columns;
	private int rows;
	private int binaryGridCell[][];
	
	public int[][] getBinaryGridCell() {
		return binaryGridCell;
	}

	public void setBinaryGridCell(int[][] binaryGridCell) {
		this.binaryGridCell = binaryGridCell;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public void createGridCell() {
		
		this.cells = new Cell[this.rows][this.columns];
		this.binaryGridCell = new int[this.rows][this.columns];
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++) {
				this.cells[i][j] = new Cell();
				this.cells[i][j].setMinesAround(0);
				this.cells[i][j].setCovered(true);
				this.binaryGridCell[i][j]=0;
			}
		}
	}
	
	private void setMines() {
		int mines = (this.columns*this.rows)-this.remaining; //calculate how many mines i need
		int cantMines = 0; //counter to see how many mines i have so far
		while (cantMines < mines) { //beginning the assignment of mines
			Random rand = new Random();
			int i = rand.nextInt(this.rows); //randomly selecting the row
			int j = rand.nextInt(this.columns); //randomly selecting the column
			if (!cells[i][j].hasMine()) { //asking whether cells[i][j] it has mine or not
				cantMines = cantMines + 1; //if it doesn't have a mine I sum 1 to the cantMines
				cells[i][j].setMine(true); //and assign a mine to that cell
			}
		}
	}
	
	private void setNumbers() { 
		for (int i=0; i < this.rows ; i++) { 
			for (int j=0; j<this.columns ; j++) {
				if (cells[i][j].hasMine()) { //asking if each cell has a mine
					for (int a=i-1; a <= i+1 ; a++) { //going throw the adjacent rows of [i][j]
						for (int b=j-1; b <= j+1 ; b++) { //going throw the adjacent columns of [i][j]
							if (a>=0 && b>=0 && a<this.rows && b<this.columns) { //asking if the adjacent cells of cells[i][j] is inbounds
								if(!cells[a][b].hasMine()) {
									cells[a][b].setMinesAround(cells[a][b].getMinesAround()+1); //if it doesn't, adding 1 to the mines that a cell has around
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void newGame() {
		setMines(); //setting where are the mines in the game
		setNumbers(); //setting which the numbers are in the game 
	}
	
	public void display () {
		for (int i=0;i<rows;i++) {
			for (int j=0;j<columns;j++) {
				if (cells[i][j].isCovered()) { //asking if a cell is covered
					if (cells[i][j].isFlagged()) { //if it's not covered, i ask if it's flagged 
						System.out.print("F "); //if it's flagged, I print an F
					} else {
						System.out.print(". "); //if it's not flagged, I print a C
					}
				} else {
					if (cells[i][j].hasMine()) {
						System.out.print("M "); //if is uncovered, i print the number of mines around with a space
					} else {
						System.out.print(cells[i][j].getMinesAround() + " ");
					}
				}
			}
			System.out.println(); //going one row down to have the matrix design
		}
		
		
	}
	
	public boolean isGameOver() {
		boolean finished = false;
		for (int i=0;i<this.rows;i++) {
			for (int j=0;j<this.columns;j++) {
				if (cells[i][j].hasMine()) {
					if (!cells[i][j].isCovered()) {
						finished = true;
						this.remaining = -1;
					}
				}
			}
		}
		if (this.remaining == 0) {
			finished = true;
		}
		return finished;
	}
	
	public void uncover(int row, int column) {
		if (cells[row][column].isCovered()) {
			cells[row][column].setCovered(false);
			cells[row][column].setFlagged(false);
			this.remaining = this.remaining - 1;
			MatrixUtils.cascade(getBinaryGridCell(), row, column);
			
			
		}
		
	}
	
	public void flagAsMine (int row, int column) {
		if (cells[row][column].isFlagged()) {
			cells[row][column].setFlagged(false);
		} else {
			cells[row][column].setFlagged(true);
		}
	}
	
	public void isWinningGame() {
		if (this.remaining == 0) {
			System.out.println("Ganaste");
		} else {
			System.out.println("Perdiste");
		}
	}
	
	public void displayInternal () {
		for (int i=0;i<this.rows;i++) {
			for (int j=0;j<this.columns;j++) {
				if (cells[i][j].hasMine()) { //asking if a cell is covered
					System.out.print("M ");
				} else {
					System.out.print(cells[i][j].getMinesAround() + " "); //if is uncovered, i print the number of mines around with a space
				}
			}
			System.out.println(); //going one row down to have the matrix design
		}
	
	}
	
	public void displayRaw () {
		for (int i=0;i<this.rows;i++) {
			for (int j=0;j<this.columns;j++) {
				System.out.print(getBinaryGridCell() + " ");
			}
			System.out.println(); //going one row down to have the matrix design
		}
	
	}
	
	public int[][] binaryGridCell () {
		int binaryGridCell[][] = new int[this.rows][this.columns];
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++) {
				if (cells[i][j].hasMine()) {
					binaryGridCell[i][j] = 1;
				} else {
					binaryGridCell[i][j] = 0;
				}
			}
		}
		return binaryGridCell;
	}
	
	
}