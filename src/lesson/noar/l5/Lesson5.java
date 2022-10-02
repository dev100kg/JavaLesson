package lesson.noar.l5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lesson5 {
	private static Scanner sc = new Scanner(System.in);
	private final static String[] CHAR_HAND = { "g", "c", "p" };
	private final static String[] STR_HAND = { "グー", "チョキ", "パー" };
	private final static List<String> HAND = new LinkedList<String>(Arrays.asList(CHAR_HAND));
	private final static String BEGIN_MSG = "じゃん・けん・ぽん！";
	private final static String DRAW_MSG = "あいこで・しょ！";
	private final static String LOSE_MSG = "残念！ここで敗退です！";
	private final static String WIN_MSG = "見事！あなたの勝ちです！";
	private final static String SEPARATOR = System.getProperty("line.separator");;
	private final static String START_MSG = "じゃんけん大会を開始します";
	private final static String FINISH_MSG = "百獣の王はあなたに決定しました！";

	public static void main(String[] args) {
		List<Player> players = new ArrayList<>();
		players.add(new Ostrich());
		players.add(new Gorilla());
		players.add(new Lion());
		players.add(new Elephant());

		System.out.println(START_MSG);
		int gameCounter = 1;
		for (Player p : players) {
			System.out.println("第" + gameCounter + "回戦の相手は" + p.getName() + "さんです！");
			if (gameJanken(p)) {
				System.out.println(WIN_MSG);
				gameCounter++;
			} else {
				System.out.println(LOSE_MSG);
				break;
			}
			System.out.println(SEPARATOR);
		}
		if (gameCounter == 5) {
			System.out.println(FINISH_MSG);
		}
	}

	private static boolean gameJanken(Player p) {
		boolean isDraw = false;
		while (true) {
			if (isDraw) {
				System.out.println(DRAW_MSG);
			} else {
				System.out.println(BEGIN_MSG);
			}
			int userHand = setHand();
			if (userHand == -1) {
				return false;
			}
			System.out.println("あなた：" + STR_HAND[userHand]);
			int cpuHand = p.choiseHand();
			System.out.println(p.getName() + "：" + STR_HAND[cpuHand]);
			switch (judge(userHand, cpuHand)) {
			case 0: {
				isDraw = true;
				break;
			}
			case 1: {
				return false;
			}
			case 2: {
				return true;
			}
			}
		}
	}

	private static int setHand() {
		int hand;
		while (true) {
			String input = sc.next();
			if (HAND.contains(input)) {
				hand = HAND.indexOf(input);
				break;
			} else if (input.equals("0") || input.equals("1") || input.equals("2")) {
				hand = Integer.parseInt(input);
				break;
			} else {
				return -1;
			}
		}
		return hand;
	}

	private static int judge(int a, int b) {
		return (a - b + 3) % 3;
	}
}
