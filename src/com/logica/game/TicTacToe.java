/**
 * 
 */
package com.logica.game;

/**
 * @author gopalj
 *
 */
public class TicTacToe {
	
	private final int[][] gameBoard;
	
	public TicTacToe(int[][] gameBoard) {
		if (!isValidGameBoard(gameBoard)) {
			throw new IllegalArgumentException("Provided gameboard is not valid");
        }
		this.gameBoard = gameBoard;
		
    }

	private boolean isValidGameBoard(int[][] gameBoard) {
	    if (gameBoard == null) {
	        return false;
        }
	    //Row length check
	    if (gameBoard.length != 3) {
	        return false;
        }
	    for (int row = 0; row < gameBoard.length; row++) {
	    	//Column length check
	        if (gameBoard[row].length != 3) {
	            return false;
            }
	        for (int column = 0; column < gameBoard[row].length; column++) {
	        	Player.getPlayer(gameBoard[row][column]).incrementMoves();
            }
        }
	    if (Player.NULL.getMoves() > 0) {
	        return false;
        }
	    //At any point of time, the moves made by both players shouldn't differ by more than one
	    if (Player.X.getMoves() - Player.O.getMoves() > 1) {
	        return false;
        }
	    return true;
    }

	public String analyse() {
		if (Player.BOARD.getMoves() == 0) {
	        return "Stalemate";
        }
		String winner;
		//Horizontal row check
		for (int row = 0; row < gameBoard.length; row++) {
			Player.resetMoves();
	        for (int column = 0; column < gameBoard[row].length; column++) {
	        	Player.getPlayer(gameBoard[row][column]).incrementMoves();
            }
	        if((winner = Player.getWinnerIfAny()) != null)
	        	return winner + " Wins";
        }
		//Vertical column check
		for (int column = 0; column < gameBoard.length; column++) {
			Player.resetMoves();
			for (int row = 0; row < gameBoard[column].length; row++) {
				Player.getPlayer(gameBoard[row][column]).incrementMoves();
			}
			if((winner = Player.getWinnerIfAny()) != null)
				return winner + " Wins";
		}
		//Diagonal check
		Player.resetMoves();
		for (int row = 0; row < gameBoard.length; row++) {
			Player.getPlayer(gameBoard[row][row]).incrementMoves();
        }
		if((winner = Player.getWinnerIfAny()) != null)
			return winner + " Wins";
		
		//Reverse diagonal check
		Player.resetMoves();
		for (int row = 0, len = gameBoard.length; row < len; row++) {
			Player.getPlayer(gameBoard[row][len - row -1]).incrementMoves();
		}
		if((winner = Player.getWinnerIfAny()) != null)
			return winner + " Wins";
		
	    return "Playing";
    }
}
