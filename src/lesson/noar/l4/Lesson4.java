package lesson.noar.l4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

	private static Scanner scanner;
	private final static Random r = new Random();
	private final static String[] STATIONS = { 
			"長野", "市役所前", "権堂", "善光寺下", "本郷", "桐原", "信濃吉田", "朝陽", "附属中学前", 
			"柳原","村山", "日野", "須坂", "北須坂", "小布施", "都住", "桜沢", "延徳", "信州中野",
			"中野松川", "信濃竹原", "夜間瀬", "上条", "湯田中" };
	private final static String GAME_START_MSG = "長野電鉄長野線ゲーム！いえーい！";
	private final static String GAME_END_MSG = "congratulation!!";
	private final static String GAME_BOO_MSG = "ぶーーーーーー";

	public static void main(String[] args) {
		System.out.println(GAME_START_MSG);
		List<String> stationList = new LinkedList<String>(Arrays.asList(STATIONS));
		while (true) {
			// P1
			String playerChoise = inputStation();

			// 判定
			if (stationList.contains(playerChoise)) {
				stationList.remove(playerChoise);
			} else {
				System.out.println(GAME_BOO_MSG);
				break;
			}

			// CPU
			int cpuChoiseIdx = r.nextInt(stationList.size());
			System.out.println("CPU:"+stationList.get(cpuChoiseIdx));
			stationList.remove(cpuChoiseIdx);

			// エンディング
			if (stationList.size() == 0) {
				System.out.println(GAME_END_MSG);
				break;
			}
		}
	}

	public static String inputStation() {
		System.out.print("YOU:");
		scanner = new Scanner(System.in);
		return scanner.next();
	}

}
