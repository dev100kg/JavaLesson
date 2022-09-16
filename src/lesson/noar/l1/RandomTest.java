package lesson.noar.l1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			Random rnd = new Random();
			int randomCallTime = rnd.nextInt(8) + 1;
			a.add(randomCallTime);
		}
		System.out.println(a.stream().max(Comparator.naturalOrder()).get());
		System.out.println(a.stream().min(Comparator.naturalOrder()).get());
	}

}
