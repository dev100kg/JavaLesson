package lesson.noar.l1;

import java.util.Collections;
import java.util.Random;

public class Lesson1Other {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			String longCall = "みーん";
			String shortCall = "みん";
			int firstCallTime = 2;
			int endCallTime = 1;
			int randomCallTimeMax = 8;
			Random rnd = new Random();
			int randomCallTime = rnd.nextInt(randomCallTimeMax) + 1;
			String call = String.join("", 
					String.join("", Collections.nCopies(firstCallTime, longCall)),
					String.join("", Collections.nCopies(randomCallTime, shortCall)),
					String.join("", Collections.nCopies(endCallTime, longCall))
					);
			System.out.println(call);
		}

	}

}
