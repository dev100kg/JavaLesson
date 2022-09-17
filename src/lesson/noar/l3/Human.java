package lesson.noar.l3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Humanクラス
 */
public class Human {
	//小数点以下の桁数（小数点以下第二位を四捨五入）
	private static final int DECIMAL_DEGIT = 1;
	//理想体重のBMI
	private static final BigDecimal IBW_BMI = new BigDecimal("22");
	//メッセージフォーマット
	private static final String MESSAGE_FORMAT = "%sさんのBMIは%.1fです。標準体重は%.1fkgです。%s";

	private String name;
	private BigDecimal bmi;
	private BigDecimal ibw;
	private BigDecimal gap;

	/**
	 * コンストラクタ
	 * @param name
	 * @param height
	 * @param weight
	 */
	public Human(String name, BigDecimal height, BigDecimal weight) {
		this.name = name;
		this.bmi = weight.divide(height.pow(2), DECIMAL_DEGIT, RoundingMode.FLOOR);
		this.ibw = height.pow(2).multiply(IBW_BMI).setScale(DECIMAL_DEGIT, RoundingMode.FLOOR);
		this.gap = this.ibw.subtract(weight).setScale(DECIMAL_DEGIT, RoundingMode.FLOOR);
	}

	/**
	 * アドバイスメッセージの作成
	 * 【出力例】
	 * 〇〇さんのBMIは14.3です。理想体重は〇〇.〇kgです。〇〇.〇kg増やしましょう。
	 * 〇〇さんのBMIは56.7です。理想体重は〇〇.〇kgです。〇〇.〇kg痩せましょう。
	 * 〇〇さんのBMIは22.0です。理想体重は〇〇.〇kgです。維持しましょう。
	 * @return アドバイスメッセージ
	 */
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
