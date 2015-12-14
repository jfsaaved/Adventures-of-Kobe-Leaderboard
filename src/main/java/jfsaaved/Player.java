package jfsaaved;

public class Player {
	
	private String name;
	private int gold;
	private int score;
	
	public Player(){
		
	}
	
	public Player(String name, int gold, int score){
		this.setName(name);
		this.setGold(gold);
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold){
		this.gold = gold;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
