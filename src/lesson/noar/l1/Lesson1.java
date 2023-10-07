package lesson.noar.l1;

import java.util.Random;

public class Lesson1 {

	private static final String LONG_CRY = "みーん";
	private static final String SHORT_CRY = "みん";
	private static final int REPEAT_TIME = 5;
	private static final int FIRST_CRY_TIME = 2;
	private static final int END_CRY_TIME = 1;
	private static final int RANDOM_CRY_TIME_MAX = 8;
	private static final Random rnd = new Random();

	public static void main(String[] args) {
		for (int i = 0; i < REPEAT_TIME; i++) {
			System.out.println(getCicadaCry(getCryTime()));
		}
	}

	public static int getCryTime() {
		return rnd.nextInt(RANDOM_CRY_TIME_MAX) + 1;
	}

	public static String getCicadaCry(int cryTime) {
		StringBuffer sb = new StringBuffer();
		sb.append(LONG_CRY.repeat(FIRST_CRY_TIME));
		sb.append(SHORT_CRY.repeat(cryTime));
		sb.append(LONG_CRY.repeat(END_CRY_TIME));
		return sb.toString();
	}
}
