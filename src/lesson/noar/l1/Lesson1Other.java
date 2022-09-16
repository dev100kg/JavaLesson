package lesson.noar.l1;

import java.util.Collections;
import java.util.Random;

public class Lesson1Other {

	static final String LONG_CALL = "みーん";
	static final String SHORT_CALL = "みん";
	static final int FIRST_CALL_TIME = 2;
	static final int END_CALL_TIME = 1;
	static final int RANDOM_CALL_TIME_MAX = 8;

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			Random rnd = new Random();
			int randomCallTime = rnd.nextInt(RANDOM_CALL_TIME_MAX) + 1;
			String call = String.join("", 
					String.join("", Collections.nCopies(FIRST_CALL_TIME, LONG_CALL)),
					String.join("", Collections.nCopies(randomCallTime, SHORT_CALL)),
					String.join("", Collections.nCopies(END_CALL_TIME, LONG_CALL))
					);
			System.out.println(call);
		}

	}

}
