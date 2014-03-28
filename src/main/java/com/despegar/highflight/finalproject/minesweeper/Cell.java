package com.despegar.highflight.finalproject.minesweeper;

public class Cell {
	private boolean isFlaged;
	private boolean isMine;
	private boolean isCovered; 
	private int minesAround = 0;
	
	
		
	public boolean isFlaged() {
		return isFlaged;
	}

	public void setFlaged(boolean isFlaged) {
		this.isFlaged = isFlaged;
	}

	public boolean hasMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	public boolean isCovered() {
		return isCovered;
	}

	public void setCovered(boolean isCovered) {
		this.isCovered = isCovered;
	}

	public int getMinesAround() {
		return minesAround;
	}

	public void setMinesAround(int minesAround) {
		this.minesAround = minesAround;
	}

	

}