package ex04;

import java.util.Scanner;

public class MonthSchedule {
	Scanner sc = new Scanner(System.in);
	boolean state = true;
	private int num;
	private int x;
	Day day[];
	
	public MonthSchedule(int x) {
		this.x = x;
		day = new Day[x];
		for( int i=0 ; i<day.length ; i++ ) {
			day[i] = new Day();
		}
	}
	
	private void input() {
		System.out.print("��¥ 1~30 >>");
		int i = sc.nextInt();
		System.out.print("���� ��ĭ���� �Է� >>");
		String work = sc.next();
		day[i-1].set(work);
		
	}
	
	private void view() {
		System.out.print("��¥ 1~30 >>");
		int i = sc.nextInt();
		System.out.print(i+"���� �� ���� �ڹٰ��� �Դϴ�.");
		day[i-1].show();
	}
	
	private void finish() {
		System.out.print("���α׷��� �����մϴ�.");
		state = false;
		return;
	}
	
	public void run() {		
		System.out.println("�̹��� ������ ���� ���α׷�");
		while(state) {
			System.out.print("�Է�1 ����2 ������3 >>");
			num = sc.nextInt();
			switch(num) {
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
					System.out.print("1~3���� �Է�");
					break;
			}
			System.out.println();
			
		}
	}
	
}
