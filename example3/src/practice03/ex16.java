package practice03;

import java.util.Scanner;

public class ex16 {

	public static void main(String[] args) {
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		Scanner sc = new Scanner(System.in);
		String str [] = { "가위", "바위", "보" };
		int n = (int)(Math.random()*3);
		do {
			System.out.print("가위 바위 보! >> ");
			String attack = sc.next();
			n = (int)(Math.random()*3);
			if(attack.equals(str[n])) {
				System.out.println("비겼습니다..");
			} else if(attack.equals("가위") && str[n].equals("보")) {
				System.out.println("사용자 = 가위, 컴퓨터 = 보, 컴퓨터가 졌습니다..");
			} else if(attack.equals("가위") && str[n].equals("바위")) {
				System.out.println("사용자 = 가위, 컴퓨터 = 바위, 다시하세요.");
			} else if(attack.equals("보") && str[n].equals("가위")) {
				System.out.println("사용자 = 보, 컴퓨터 = 가위, 컴퓨터가 이겼습니다.");
			} else if(attack.equals("보") && str[n].equals("바위")) {
				System.out.println("사용자 = 보, 컴퓨터 = 바위, 컴퓨터가 이겼습니다.");
			} else if(attack.equals("바위") && str[n].equals("가위")) {
				System.out.println("사용자 = 바위, 컴퓨터 = 가위, 컴퓨터가 이겼습니다.");
			} else if(attack.equals("바위") && str[n].equals("보")) {
				System.out.println("사용자 = 바위, 컴퓨터 = 보, 컴퓨터가 이겼습니다.");
			} else if(attack.equals("그만")) {
				System.out.println("게임을 종료합니다...");
				sc.close();
				return;
			}
		} while(str[n].equals("가위") || str[n].equals("보") || str[n].equals("바위"));
		
	}
}
