package com.despegar.highflight.finalproject.minesweeper;

import java.util.Scanner;


public class App {
	public static void main (String[]args) {
		System.out.println("¿Cuántas filas y columnas desea que tenga?");
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		double remaining = Math.ceil(rows*columns*85/100);
		GridCell game = new GridCell();
		game.createGridCell(rows, columns);
		game.newGame(rows, columns);
		game.display(rows, columns);
		while (!game.isGameOver(rows, columns, remaining)) {
			System.out.println("Seleccione una opción 1.U/2.F");
			int opt = sc.nextInt();
			System.out.println("Seleccione las coordenadas");
			int i = sc.nextInt();
			int j = sc.nextInt();
			switch (opt) {
			case 1: game.uncover(i, j, remaining);
			
			case 2: game.flagAsMine(i, j);
			
			default : System.out.println(opt + " no es una opción válida");
			}
			game.display(rows, columns);;
		}
		game.isWinningGame(remaining);
	}
}
        