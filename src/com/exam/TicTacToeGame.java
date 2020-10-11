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
		int turn = toss();
		boolean win = false;
		for (int i = 1; i <= 9; i++) {
			if (turn == 1) {
				selectIndexToMove(player);
				showBoard(board);
				win = winState();
				if (win) {
					System.out.println("Player won the game");
					break;
				}
				turn = 0;
			} else {
				computerMove();
				showBoard(board);
				win = winState();
				if (win) {
					System.out.println("Computer won the game");
					break;
				}
				turn = 1;
			}
		}
		if (!win)
			System.out.println("Tie Game");

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
		for (int i = 1; i < boardToShow.length; i++) {
			System.out.print("(" + boardToShow[i] + ")");
			if (i % 3 == 0 && i != 9) {
				System.out.println(" \n---------");
			}
		}
		System.out.println("\n");
	}

	public static void selectIndexToMove(char nextTurn) {
		System.out.println("\nEnter index where you want to move: ");
		int index = sc.nextInt();
		if (index <= 9 && index >= 1) {
			if (board[index] == ' ') {
				System.out.println("Position " + index + " is free");
				makeMove(index, nextTurn);
			} else {
				System.out.println("Position already taken, choose new position");
				selectIndexToMove(nextTurn);
			}

		} else {
			System.out.println("Invalid input, enter again");
			selectIndexToMove(nextTurn);
		}
	}

	public static void makeMove(int index, char nextTurn) {
		System.out.println("Make this move? Y/N");
		char confirm = sc.next().charAt(0);
		if (confirm == 'Y') {
			board[index] = nextTurn;
		} else {
			selectIndexToMove(nextTurn);
		}
	}

	public static int toss() {
		int randomNumber = (int) (Math.random() * 2);
		if (randomNumber == 0) {
			System.out.println("Computer will start the game");
			return randomNumber;
		} else {
			System.out.println("User will start the game");
			return randomNumber;
		}
	}

	public static boolean winState() {
		if (((board[1] == board[2] && board[1] == board[3]) && board[1] != ' ')
				|| ((board[4] == board[5] && board[4] == board[6]) && board[4] != ' ')
				|| ((board[7] == board[8] && board[7] == board[9]) && board[7] != ' ')
				|| ((board[1] == board[4] && board[1] == board[7]) && board[1] != ' ')
				|| ((board[2] == board[5] && board[2] == board[8]) && board[2] != ' ')
				|| ((board[3] == board[6] && board[3] == board[9]) && board[3] != ' ')
				|| ((board[1] == board[5] && board[1] == board[9]) && board[1] != ' ')
				|| ((board[3] == board[5] && board[3] == board[7]) && board[3] != ' '))

			return true;
		else
			return false;
	}

	public static void computerMove() {
		boolean moved = false;
		for (int i = 1; i < board.length; i++) {
			if (board[i] == ' ') {
				board[i] = computer;
				if (!winState()) {
					board[i] = ' ';
				} else {
					moved = true;
					break;
				}
			}
		}
		if (!moved) {
			moved = blockOpponentMove();
		}

		if (!moved) {
			moved = cornerMove();
		}

		if (!moved) {
			moved = centerOrSidesMove();
		}

	}

	public static boolean blockOpponentMove() {
		boolean moved = false;
		for (int i = 1; i < board.length; i++) {
			if (board[i] == ' ') {
				board[i] = player;
				if (!winState()) {
					board[i] = ' ';
				} else {
					board[i] = computer;
					moved = true;
				}

			}
		}
		return moved;
	}

	public static boolean cornerMove() {
		boolean moved = false;
		int[] corners = { 1, 3, 7, 9 };
		for (int i = 0; i < corners.length; i++) {
			int corner = corners[i];
			if (board[corner] == ' ') {
				board[corner] = computer;
				moved = true;
				break;
			}

		}
		return moved;
	}
	
	public static boolean centerOrSidesMove() {
		boolean moved = false;
		int[] moves = {5, 2, 4, 6, 8};
		for (int i = 0; i < moves.length; i++) {
			int move = moves[i];
			if (board[move] == ' ') {
				board[move] = computer;
				moved = true;
				break;
			}

		}
		return moved;
		
	}
}
