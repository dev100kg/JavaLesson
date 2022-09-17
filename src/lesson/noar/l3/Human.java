package lesson.noar.l3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Human {
	private static final int DECIMAL_DEGIT = 1;
	private static final BigDecimal IBW_BMI = new BigDecimal("22");
	private static final String MESSAGE_FORMAT = "%sさんのBMIは%.1fです。標準体重は%.1fkgです。%s";

	private String name;
	private BigDecimal bmi;
	private BigDecimal ibw;
	private BigDecimal gap;

	public Human(String name, BigDecimal height, BigDecimal weight) {
		this.name = name;
		this.bmi = weight.divide(height.pow(2), DECIMAL_DEGIT, RoundingMode.FLOOR);
		this.ibw = height.pow(2).multiply(IBW_BMI).setScale(DECIMAL_DEGIT, RoundingMode.FLOOR);
		this.gap = this.ibw.subtract(weight).setScale(DECIMAL_DEGIT, RoundingMode.FLOOR);
	}

	public String adviceMessage() {
		final String ACTION_FORMAT = "%.1fkg%sましょう。";
		String action;
		if (gap.compareTo(new BigDecimal(0)) > 0) {
			action = String.format(ACTION_FORMAT, gap.abs(), "増やし");
		} else if (gap.compareTo(new BigDecimal(0)) < 0) {
			action = String.format(ACTION_FORMAT, gap.abs(), "痩せ");
		} else {
			action = "維持しましょう。";
		}
		return String.format(MESSAGE_FORMAT, name, bmi, ibw, action);
	}
}
