package com.exam;

import java.util.Scanner;

public class TicTacToeGame {
	public static char[] board;
	public static char player;
	public static char computer;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		board = creatingBoard();
		player = chooseLetter();
		computer = ' ';
		if (player == 'X')
			computer = 'O';
		else
			computer = 'X';
		showBoard(board);
		boolean turn =toss();
		if(turn) {
		selectIndexToMove();
		showBoard(board);
		}

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
		System.out.println("\nEnter index where you want to move: ");
		int index = sc.nextInt();
		if(index<=9 && index>=1) {
			if (board[index] == ' ')
			{
				System.out.println("Position "+index+" is free");
				makeMove(index);
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
	
	public static void makeMove(int index) {
		System.out.println("Make this move? Y/N");	
		char confirm = sc.next().charAt(0);
		if(confirm=='Y')
		{
			board[index] = player;
		}
		else {
			selectIndexToMove();
		}
	}
	
	public static boolean toss() {
		int randomNumber = (int)(Math.random()*2);
		if(randomNumber==0) {
			System.out.println("Computer will start the game");
			return false;
		}
		else {
			System.out.println("User will start the game");
			return true;
		}
	}
	
	

}