package lesson.noar.l1;

import java.util.Random;

public class Lesson1 {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			String semi = "みーんみーん";
			Random rnd = new Random();
			int seq = rnd.nextInt(8) + 1;
			for (int j = 1; j <= seq; j++) {
				semi += "みん";
			}
			semi += "みーん";
			System.out.println(semi);
		}

	}

}