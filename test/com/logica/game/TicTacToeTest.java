/**
 * 
 */
package com.logica.game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;


/**
 * @author gopalj
 *
 */
public class TicTacToeTest {
	
	private static final String excpMessage = "Provided gameboard is not valid";
	
	int[][] gameStatus;

	@Test
    public void testNull() throws Exception {
		int[][] gameBoard = null;
		try {
	        TicTacToe ttt = new TicTacToe(gameBoard);
        }
        catch (RuntimeException e) {
        	assertEquals(IllegalArgumentException.class, e.getClass());
        	assertEquals(excpMessage, e.getMessage());
        }
    }
	
	@Test
	public void testGameBoardWithInvalidRowCount() throws Exception {
		int[][] gameBoard = {{1,2,3},{3,4,8}};
		try {
			TicTacToe ttt = new TicTacToe(gameBoard);
		}
		catch (RuntimeException e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
			assertEquals(excpMessage, e.getMessage());
		}
	}
	
	@Test
	public void testGameBoardWithInvalidColumnCount() throws Exception {
		int[][] gameBoard = {
				{1,1,1,1,1},
				{3,4,4,5}
		};
		try {
			TicTacToe ttt = new TicTacToe(gameBoard);
		}
		catch (RuntimeException e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
			assertEquals(excpMessage, e.getMessage());
		}
	}

	@Test
	public void testGameBoardInvalidWhereMovesDifferByMoreThanOneUnit() throws Exception {
		int[][] gameBoard = {
				{2,3,3},
				{1,2,3},
				{2,3,3}
		};
		try {
			TicTacToe ttt = new TicTacToe(gameBoard);
		}
		catch (RuntimeException e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
			assertEquals(excpMessage, e.getMessage());
		}
	}
	
	@Test
	public void testGameBoardInvalidWhereOtherBoardIdentitiesAreUsed() throws Exception {
		int[][] gameBoard = {
				{2,3,3},
				{1,2,7},
				{3,8,3}
		};
		try {
			TicTacToe ttt = new TicTacToe(gameBoard);
		}
		catch (RuntimeException e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
			assertEquals(excpMessage, e.getMessage());
		}
	}
	
	@Test
	public void testGameBoardWithValidRowAndColumn() throws Exception {
		int[][] gameBoard = {
				{1,2,1},
				{3,2,2},
				{3,3,1}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertNotNull(ttt);
	}
	
	@Test
	public void testWhereOWinsinFirstRow() throws Exception {
		int[][] gameBoard = {
				{1,1,1},
				{2,3,2},
				{3,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("O Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereOWinsinSecondRow() throws Exception {
		int[][] gameBoard = {
				{2,3,2},
				{1,1,1},
				{3,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("O Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereOWinsinThirdRow() throws Exception {
		int[][] gameBoard = {
				{3,3,3},
				{2,3,2},
				{1,1,1}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("O Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereOWinsinFirstColumn() throws Exception {
		int[][] gameBoard = {
				{1,2,3},
				{1,3,2},
				{1,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("O Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereOWinsinSecondColumn() throws Exception {
		int[][] gameBoard = {
				{2,1,2},
				{3,1,3},
				{3,1,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("O Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereOWinsinThirdColumn() throws Exception {
		int[][] gameBoard = {
				{3,3,1},
				{2,3,1},
				{3,2,1}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("O Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereOWinsDiagonally() throws Exception {
		int[][] gameBoard = {
				{1,3,3},
				{2,1,2},
				{3,3,1}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("O Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereOWinsReverseDiagonally() throws Exception {
		int[][] gameBoard = {
				{3,3,1},
				{2,1,2},
				{1,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("O Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereXWinsinFirstRow() throws Exception {
		int[][] gameBoard = {
				{2,2,2},
				{1,3,1},
				{3,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("X Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereXWinsinSecondRow() throws Exception {
		int[][] gameBoard = {
				{1,3,1},
				{2,2,2},
				{3,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("X Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereXWinsinThirdRow() throws Exception {
		int[][] gameBoard = {
				{3,3,3},
				{1,3,1},
				{2,2,2}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("X Wins", ttt.analyse());
	}

	@Test
	public void testWhereXWinsinFirstColumn() throws Exception {
		int[][] gameBoard = {
				{2,1,3},
				{2,3,1},
				{2,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("X Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereXWinsinSecondColumn() throws Exception {
		int[][] gameBoard = {
				{1,2,1},
				{3,2,3},
				{3,2,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("X Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereXWinsinThirdColumn() throws Exception {
		int[][] gameBoard = {
				{3,3,2},
				{1,3,2},
				{3,1,2}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("X Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereXWinsDiagonally() throws Exception {
		int[][] gameBoard = {
				{2,3,3},
				{1,2,1},
				{3,3,2}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("X Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereXWinsReverseDiagonally() throws Exception {
		int[][] gameBoard = {
				{3,3,2},
				{1,2,1},
				{2,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("X Wins", ttt.analyse());
	}
	
	@Test
	public void testWhereStatusIsPlaying() throws Exception {
		int[][] gameBoard = {
				{3,3,2},
				{1,2,1},
				{3,3,3}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("Playing", ttt.analyse());
	}
	
	@Test
	public void testWhereStatusIsStalemate() throws Exception {
		int[][] gameBoard = {
				{1,2,1},
				{1,2,1},
				{2,1,2}
		};
		TicTacToe ttt = new TicTacToe(gameBoard);
		assertEquals("Stalemate", ttt.analyse());
	}
	
	@After
	public void resetPlayerMoves() {
		Player.resetMoves();
    }
}
