public class Score {
	private int score;   //Score of the player	
	private String name; //Name of the player
	
	public Score(String name, int score) {  //Constructor of Class Score
		this.name = name;
		this.score = score;
	}
	public String getName() { return name;}   //getter for name
	public int getScore() { return score; }   //getter for score
	public boolean isSmaller(Score a) {       //comparing a player to another player. Returns true if player 1's score is smaller than player 2, else returns false
		if(this.score < a.score) { return true; }
		return false;
	}
}
		