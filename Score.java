public class Score {
	private int score;
	private String name;
	
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public boolean compareWith(int score) {
		if(this.score > score) { return true; }
		return false;
	}
}
		