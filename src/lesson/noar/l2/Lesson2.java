package lesson.noar.l2;

public class Lesson2 {

	public static void main(String[] args) {
		int i = 11;
		while (true) {
			if (isDecimalPalindrome(i) && isBinaryPalindrome(i) && isOctalPalindrome(i)) {
				System.out.println(i);
				break;
			}
			i += 2;
		}
	}


	private static boolean isDecimalPalindrome(int num) {
		String strDec = String.valueOf(num);
		return strDec.equals(reverseString(strDec));
	}

	private static boolean isBinaryPalindrome(int num) {
		String strBin = Integer.toBinaryString(num);
		return strBin.equals(reverseString(strBin));
	}


	private static boolean isOctalPalindrome(int num) {
		String strOct = Integer.toOctalString(num);
		return strOct.equals(reverseString(strOct));
	}

	private static String reverseString(String strInt) {
		return new StringBuffer(strInt).reverse().toString();
	}

}
