package practice03;
import java.util.Scanner;

public class lunchMenuPicker {
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menuList[][] = {{"����ŷ", "������ġ", "�Ƶ�����", "KFC"},
						{"��ġ����", "�ұ���", "¥���", "«��"},
						{"�����", "��¯�", "��ġ�", "���ؾ�"},
						{"������ ���ö�", "�Ŷ��", "���", "������ġ"},
						{"����", "��������", "�߰�����", "������"}};

		int num1 = getRandomNumber(0,4);
		int num2 = getRandomNumber(0,4);

		System.out.println("ã���ô� ���� ��������? ��ȣ �Է����ּ��� (1 = �� / 2 = �ƹ��ų� �����)");

		int flavorOfUser = sc.nextInt();

		switch(flavorOfUser) {
			case 1: 
				System.out.println("���Ͻô� ���������� �Է����ּ���.");
				System.out.println("�ܹ���, ��, �ѽ�, ������, �ǰ��� �߿� �Է����ּ���.");
				String menuOfUser = sc.next();

				switch(menuOfUser) {
					case "�ܹ���": num1 = 0;
					break;
					case "��": num1 = 1;
					break;
					case "�ѽ�": num1 = 2;
					break;
					case "������": num1 = 3;
					break;
					case "�ǰ���": num1 = 4;
					break;
					default: System.out.println("�ٽ� �ѹ� �Է����ּ���.");
				}
				break;
			case 2:
				System.out.println("������ ����� �޾� �޴��� �� ���...");
				break;
			default: System.out.println("1, 2 �߿� �Է����ּ���.");
		}
		System.out.println("������ ������...");
		System.out.println(menuList[num1][num2] + " �Դϴ�!");
	}

}