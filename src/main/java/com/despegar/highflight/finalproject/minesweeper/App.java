package com.despegar.highflight.finalproject.minesweeper;

import java.lang.reflect.Array;
import java.util.Random;
import java.lang.Object; 
import java.util.Scanner;


public class App {
	public static void main (String[]args) {
		System.out.println("¿Cuántas filas y columnas desea que tenga?");
		Scanner sc = new Scanner(System.in);
		int files = sc.nextInt();
		int rows = sc.nextInt();
		Cell[][] game = new Cell[files][rows];
		game.newGame(files,rows);
		//game.displayInternal(files, rows, game);
	}
}
        