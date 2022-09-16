package lesson.noar.l1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			Random r = new Random();
			//TODO:範囲指定のやり方検討
			int num = r.nextInt(7);
			a.add(num);
		}
		System.out.println(a.stream().max(Comparator.naturalOrder()).get());
		System.out.println(a.stream().min(Comparator.naturalOrder()).get());
	}

}
