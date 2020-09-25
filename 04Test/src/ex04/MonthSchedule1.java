package ex04;

import java.util.Scanner;

public class MonthSchedule1 {
	Scanner sc = new Scanner(System.in);
	
	int dayNum;
	Day1 day[];
	boolean state = true;
	
	
	MonthSchedule1(int x) {
		dayNum = x;
		day = new Day1[dayNum];
		for( int i=0 ; i<day.length ; i++ ) {
			day[i] = new Day1();
		}
	}
	
	private void input() {
		System.out.println("��¥(1~30)?");
		int i = sc.nextInt();
		System.out.println("���� ��ĭ���� �Է�");
		String work =sc.next();
		day[i-1].set(work);
		
	}
	
	private void view() {
		System.out.println("��¥(1~30)?");
		int i = sc.nextInt();
		System.out.print(i+"���� �� ���� ");
		day[i].show();
	}

	private void finish() {
		System.out.println("���α׷��� �����մϴ�.");
		state = false;
	}

	private void run() {
		int option;
		System.out.println("�̹��� ������ ���� ���α׷�.");
		while(state) {
			System.out.println("���� �Է�1 ����2 ������3 >> ");
			option = sc.nextInt();
			switch(option) {
			case 1:
				input();
				break;
			case 2:
				view();
				break;
			case 3:
				finish();
				break;
			default:
				System.out.println("�ٽ� �Է����ּ���!");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		MonthSchedule1 april = new MonthSchedule1(30);
		april.run();

	}

}
