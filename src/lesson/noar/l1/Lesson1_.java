package lesson.noar.l1;

import java.util.Random;

public class Lesson1_ {
	private static final Random r = new Random();
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			String semi = "みーんみーん";
			int seq = r.nextInt(8) + 1;
			for (int j = 1; j <= seq; j++) {
				semi += "みん";
			}
			semi += "みーん";
			System.out.println(semi);
		}

	}

}
