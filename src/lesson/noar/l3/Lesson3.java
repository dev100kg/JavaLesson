package lesson.noar.l3;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class Lesson3 {

	/**
	 * メインメソッド
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Human> humanSet = new LinkedHashSet<>();
		humanSet.add(new Human("鈴木", BigDecimal.valueOf(1.533), BigDecimal.valueOf(67.5)));
		humanSet.add(new Human("伊藤", BigDecimal.valueOf(1.769), BigDecimal.valueOf(46)));
		humanSet.add(new Human("広田", BigDecimal.valueOf(1.65), BigDecimal.valueOf(59.9)));
		humanSet.forEach(h -> System.out.println(h.adviceMessage()));
	}

}
