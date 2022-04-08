package game.engine;

import game.util.Leaderboard;
import game.util.ScoreCalc;

/**
 * ScoreManager calculates the current score.
 * Modifica i valori della tabella
 */
public class ScoreManager {
    
	private Leaderboard leaderboard;
	private ScoreCalc scoreCalc;
	
    /**
     * Creates & initializes this class.
     */
    public ScoreManager(final ScoreCalc scoreCalc) {
    	this.scoreCalc = scoreCalc;
    	
    	this.leaderboard = new Leaderboard("res/.save");
    	this.leaderboard.load();
    	
    	//this.leaderboard.addToRanking("gigiabaffa", 5);
    	//this.leaderboard.addToRanking("hehehe", 10);
    	
    	//add five entries to leaderboard (test)
    	this.leaderboard.addToRanking("fifth", 5);
    	this.leaderboard.addToRanking("fourth", 10);
    	this.leaderboard.addToRanking("third", 15);
    	this.leaderboard.addToRanking("second", 20);
    	this.leaderboard.addToRanking("first", 25);
    	//save in file after adding current record
    	this.leaderboard.save();
    }
    
    /*
     * WHO SHALL CREATE LEADERBOARD AND SCOREMANAGER?
     * - GAMEENGINE
     * - SCORESCENE
     * - APPLICATION
     */

    /**
     * Returns to menu.
     */
    public void menu() {
    	//TODO: call menu method of application
    	//ScoreScene will call this method
    }
    
}
