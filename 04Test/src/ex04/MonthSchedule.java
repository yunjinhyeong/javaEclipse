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
		System.out.print("날짜 1~30 >>");
		int i = sc.nextInt();
		System.out.print("할일 빈칸없이 입력 >>");
		String work = sc.next();
		day[i-1].set(work);
		
	}
	
	private void view() {
		System.out.print("날짜 1~30 >>");
		int i = sc.nextInt();
		System.out.print(i+"일의 할 일은 자바공부 입니다.");
		day[i-1].show();
	}
	
	private void finish() {
		System.out.print("프로그램을 종료합니다.");
		state = false;
		return;
	}
	
	public void run() {		
		System.out.println("이번달 스케쥴 관리 프로그램");
		while(state) {
			System.out.print("입력1 보기2 끝내기3 >>");
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
					System.out.print("1~3까지 입력");
					break;
			}
			System.out.println();
			
		}
	}
	
}
