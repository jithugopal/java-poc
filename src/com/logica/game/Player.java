package com.logica.game;

public enum Player {
	
	X("X", 2),
	O("O", 1),
	BOARD("BOARD",3) {
		//Override error checking functionality
		public void incrementMoves(){ ++super.moves; }
	},
	NULL("Invalid player", 0);
	
	Player(final String name, final int boardIdentity) {
		this.name = name;
		this.boardIdentity= boardIdentity;
	}
	
	private String name;
	private int boardIdentity;
	private int moves;
	
    public String getName() { return name; }
    
    public int getBoardIdentity() { return boardIdentity;}
    
    public int getMoves() { return moves; };
	
    public void incrementMoves() { 
    	if (++moves > 5) {
	        throw new IllegalStateException("Total moves for any player cannot be greater than 5");
        }
    }
    
    public void decrementMoves() { moves--; }
    
    public static void resetMoves() {
    	for (Player player : values()) {
	        player.moves = 0;
        }
    }
    
    public static Player getPlayer(int boardIdentity) {
    	for(Player player : values()) {
    		if (player.boardIdentity == boardIdentity) {
	            return player;
            }
    	}
    	return NULL;
    }

	public static String getWinnerIfAny() {
	    String ret = (X.moves == 3) ? X.toString() : 
							((O.moves == 3) ? O.toString() : null);
	    return ret;
    }

}
