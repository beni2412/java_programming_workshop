package com.exam;

public class TicTacToeGame {
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		char[] board = creatingBoard();
	}

	public static char[] creatingBoard() {
		char[] board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;	
		
		}
	}