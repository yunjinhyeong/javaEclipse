package practice03;
import java.util.Scanner;

public class lunchMenuPicker {
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menuList[][] = {{"버거킹", "맘스터치", "맥도날드", "KFC"},
						{"잔치국수", "쌀국수", "짜장면", "짬뽕"},
						{"비빔밥", "된짱찌개", "김치찌개", "옹해야"},
						{"편의점 도시락", "컵라면", "김밥", "샌드위치"},
						{"고구마", "에너지바", "닭가슴살", "샐러드"}};

		int num1 = getRandomNumber(0,4);
		int num2 = getRandomNumber(0,4);

		System.out.println("찾으시는 음식 있으세요? 번호 입력해주세요 (1 = 어 / 2 = 아무거나 골라줘)");

		int flavorOfUser = sc.nextInt();

		switch(flavorOfUser) {
			case 1: 
				System.out.println("원하시는 음식종류를 입력해주세요.");
				System.out.println("햄버거, 면, 한식, 편의점, 건강식 중에 입력해주세요.");
				String menuOfUser = sc.next();

				switch(menuOfUser) {
					case "햄버거": num1 = 0;
					break;
					case "면": num1 = 1;
					break;
					case "한식": num1 = 2;
					break;
					case "편의점": num1 = 3;
					break;
					case "건강식": num1 = 4;
					break;
					default: System.out.println("다시 한번 입력해주세요.");
				}
				break;
			case 2:
				System.out.println("우주의 기운을 받아 메뉴를 고른 결과...");
				break;
			default: System.out.println("1, 2 중에 입력해주세요.");
		}
		System.out.println("오늘의 점심은...");
		System.out.println(menuList[num1][num2] + " 입니다!");
	}

}