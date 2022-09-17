package lesson.noar.l3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Lesson3 {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		List<Human> humanList = new ArrayList<>();
		humanList.add(new Human("鈴木", new BigDecimal("1.533"), new BigDecimal("67.5")));
		humanList.add(new Human("伊藤", new BigDecimal("1.769"), new BigDecimal("46")));
		humanList.add(new Human("広田", new BigDecimal("1.65"), new BigDecimal("59.8")));
		humanList.forEach(h -> System.out.println(h.adviceMessage()));
	}

}
