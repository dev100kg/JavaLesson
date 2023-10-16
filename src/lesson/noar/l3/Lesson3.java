package lesson.noar.l3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Lesson3 {

	/**
	 * メインメソッド
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Human> humanList = new ArrayList<>();

		humanList.add(new Human("鈴木", BigDecimal.valueOf(1.533), BigDecimal.valueOf(67.5)));
		humanList.add(new Human("伊藤", BigDecimal.valueOf(1.769), BigDecimal.valueOf(46)));
		humanList.add(new Human("広田", BigDecimal.valueOf(1.65), BigDecimal.valueOf(59.8)));
		humanList.forEach(h -> System.out.println(h.adviceMessage()));
	}

}
