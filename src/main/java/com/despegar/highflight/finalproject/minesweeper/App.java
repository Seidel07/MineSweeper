package com.despegar.highflight.finalproject.minesweeper;

import java.util.Scanner;

import com.despegar.highflight.utils.MatrixUtils;


public class App {
	public static void main (String[]args) {
		System.out.println("¿Cuantas filas y columnas desea que tenga?");
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		GridCell game = new GridCell();
		//GridCell binary = new GridCell();
		game.setRows(rows);
		game.setColumns(columns);
		game.setRemaining(rows*columns*85/100+1);
		game.createGridCell();
		game.newGame();
		game.displayRaw();
		game.display();
		while (!game.isGameOver()) {
			System.out.println("Seleccione una opcion 1.U/2.F");
			int opt = sc.nextInt();
			System.out.println("Seleccione las coordenadas");
			int i = sc.nextInt();
			int j = sc.nextInt();
			switch (opt) {
			case 1: game.uncover(i-1, j-1);
			break;
			case 2: game.flagAsMine(i-1, j-1);
			break;
			default : System.out.println(opt + " no es una opcion valida");
			}
			game.display();
			System.out.println(game.getRemaining());
		}
		game.isWinningGame();
		game.displayInternal();
		
			
	}
}
        