package com.exam;

import java.util.Scanner;

public class TicTacToeGame {
	public static char[] board;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		board = creatingBoard();
		char player = chooseLetter();
		char computer = ' ';
		if (player == 'X')
			computer = 'O';
		else
			computer = 'X';
		showBoard(board);
		selectIndexToMove();
	}

	public static char[] creatingBoard() {
		char[] board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;

	}

	public static char chooseLetter() {
		System.out.println("Choose a letter X or O: ");
		char user = sc.next().charAt(0);
		return user;

	}
	
	public static void showBoard(char[] boardToShow) {
		for(int i =1;i<boardToShow.length;i++)
		{
			System.out.print("("+boardToShow[i]+")");
			if(i%3==0 && i!=9) {
				System.out.println(" \n---------");
			}
		}
	}
	
	public static void selectIndexToMove() {
		System.out.println("Enter index where you want to move: ");
		int index = sc.nextInt();
		if(index<=9 && index>=1) {
			if (board[index] == ' ')
			{
				System.out.println("Position is free");
			}
			else
			{
				System.out.println("Position already taken, choose new position");
				selectIndexToMove();
			}
			
		}
		else
		{
			System.out.println("Invalid input, enter again");
			selectIndexToMove();
		}
	}
	
	

}