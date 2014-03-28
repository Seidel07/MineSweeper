package com.despegar.highflight.finalproject.minesweeper;

public class Cell {
	private boolean isFlagged;
	private boolean isMine;
	private boolean isCovered; 
	private int minesAround;
	
	
		
	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged(boolean isFlaged) {
		this.isFlagged = isFlaged;
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