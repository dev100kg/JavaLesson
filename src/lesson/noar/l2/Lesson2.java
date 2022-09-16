package lesson.noar.l2;

public class Lesson2 {

	public static void main(String[] args) {
		int i = 11;
		while (true) {
			String strInt = String.valueOf(i);
			String rStrInt = new StringBuffer(strInt).reverse().toString();
			if (strInt.equals(rStrInt)) {
				String strBin = Integer.toBinaryString(i);
				String rStrBin = new StringBuffer(strBin).reverse().toString();
				if (strBin.equals(rStrBin)) {
					String strOct = Integer.toOctalString(i);
					String rStrOct = new StringBuffer(strOct).reverse().toString();
					if (strOct.equals(rStrOct)) {
						System.out.println(i);
						break;
					}
				}
			}
			i += 2;
		}
	}

}
