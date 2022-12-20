public class Score {
	private int score;
	private String name;
	
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() { return name;}
	public int getScore() { return score; }
	public boolean isSmaller(Score a) {
		if(this.score < a.score) { return true; }
		return false;
	}
}
		