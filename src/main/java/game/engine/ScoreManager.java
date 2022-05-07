package game.engine;

import java.util.List;

import game.util.Leaderboard;
import game.util.Pair;

/**
 * ScoreManager calculates the current score.
 * Edits table values.
 */
public class ScoreManager {

	private int score;
	private String playerName;
	private final Leaderboard leaderboard;
	private boolean readOnly;
	
    /**
     * Creates & initializes this class.
     * @param playerName
     * @param score
     * @param leaderboard
     * @param application
     */
    public ScoreManager(final String playerName, final int score, final Leaderboard leaderboard) {
    	this.score = score;
    	this.playerName = playerName;
    	this.leaderboard = leaderboard;

    	this.leaderboard.load();
    	this.leaderboard.addToRanking(this.playerName, this.score);
    	//save in file after adding current record
    	this.leaderboard.save();
    }

    /**
     * This constructor is useful when all you want to do is to view current leaderboard, without editing it.
     * @param leaderboard
     * @param application
     */
    public ScoreManager(final Leaderboard leaderboard) {
    	this.readOnly = true;
    	this.leaderboard = leaderboard;

    	this.leaderboard.load();
    }

    /**
     * Gets a copy of the ranking list inside Leaderboard.
     * @return current ranking
     */
    public List<Pair<String, Integer>> getRanking() {
    	return this.leaderboard.getRanking();
    }

    /**
     * Gets current player name.
     * @return player name
     */
    public String getPlayerName() {
    	return this.playerName;
    }

    /**
     * Gets current player's score (at gameover).
     * @return score
     */
    public int getScore() {
    	return this.score;
    }

    /**
     * Gets current player's rank (at gameover).
     * @return rank
     */
    public String getRank() {
    	return String.valueOf(this.leaderboard.getRank(this.getPlayerName(), this.getScore()));
    }

    /**
     * Checks whether the leaderboard should be read-only or not.
     * @return true if read-only, false if leaderboard shall be edited
     */
    public boolean isReadOnly() {
    	return this.readOnly;
    }

}
