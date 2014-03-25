package com.despegar.highflight.finalproject.minesweeper;

import java.lang.reflect.Array;
import java.util.Random;

public class App 
{
		
	
    private void NewGame()  {
        int m=3; //file quantity
        int n=4;  //column quantity  	
        int ms[][];
        ms = new int[m][n]; //Creating the matrix
        //Array [][] ms = new Array [m][n]; 
        double k = Math.floor(m*n*0.15); //mine quantity
        for (int i=0;i<m;i++) { //assigning 0 to each element of the  matrix
        	for (int j=0;j<n;j++) {
        		ms[i][j] = 0;
        	}
        }
        for (int p=1; p<=k;) { //assigning 9 to the mines
        	Random rand = new Random();
        	int value1 = rand.nextInt(m) + 1;
        	int value2 = rand.nextInt(n) + 1;
        	if (ms[value1][value2] != 9) {
        		ms[value1][value2] = 9;
        		p=p+1;
       }
        
    }
        for (int i=0 ; i<m;i++) { //assigning the corresponding numbers to each element that isn't a mine
        	for (int j=0;j<n;j++) {
        		if(ms[i][j]==9) {
        			for (int a = i-1;a<=i+1;a++) {
        				for (int b=j-1;b<=j+1;b++) {
        					if (a*b>0 || a<=m || b<=n) {
        						if (ms[a][b] !=9) {
        							ms[a][b] = ms[a][b] + 1;
        						}
        					}
        				}
        			}
        		}
        		ms[i][j] = 9; //assigning F to the mines
        	}
        }
	
	}
    public static void main (String []args) {
    	
    	
    }
}
