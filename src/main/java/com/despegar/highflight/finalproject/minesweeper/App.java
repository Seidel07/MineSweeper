package com.despegar.highflight.finalproject.minesweeper;

import java.util.Scanner;


public class App {
	public static void main (String[]args) {
		System.out.println("¿Cuantas filas y columnas desea que tenga");
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		GridCell game = new GridCell();
		game.createGridCell();
		game.newGame();
		game.display();
		game.setRemaining(rows*columns*85/100+1);
		game.setRows(rows);
		game.setColumns(columns);
		System.out.println(game.getRemaining());
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
			
	}
}
        