package lesson.noar.l5;

import java.util.Random;

public class Player {
	private static Random r = new Random();
	private String name;
	private int rangeG;
	private int rangeP;
	private int rangeC;
	private int rangeA;
	public static int seq = 0;

	public Player() {

	}

	public Player(String name, int rangeG, int rangeC, int rangeP) {
		this();
		seq++;
		this.name = name;
		this.rangeG = rangeG;
		this.rangeC = rangeC;
		this.rangeP = rangeP;
		this.rangeA = this.rangeG + this.rangeC + this.rangeP;
	}

	public int choiseHand() {
		int random = r.nextInt(this.rangeA);
		if (random >= 0 && random < this.rangeG) {
			return 0;
		} else if (random >= this.rangeG && random < this.rangeG + this.rangeC) {
			return 1;
		} else {
			return 2;
		}
	}

	public String getName() {
		return name;
	}

	public int getRangeA() {
		return this.rangeA;
	}

}
