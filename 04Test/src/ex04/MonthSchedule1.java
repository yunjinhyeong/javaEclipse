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
		System.out.println("날짜(1~30)?");
		int i = sc.nextInt();
		System.out.println("할일 빈칸없이 입력");
		String work =sc.next();
		day[i-1].set(work);
		
	}
	
	private void view() {
		System.out.println("날짜(1~30)?");
		int i = sc.nextInt();
		System.out.print(i+"일의 할 일은 ");
		day[i].show();
	}

	private void finish() {
		System.out.println("프로그램을 종료합니다.");
		state = false;
	}

	private void run() {
		int option;
		System.out.println("이번달 스케쥴 관리 프로그램.");
		while(state) {
			System.out.println("할일 입력1 보기2 끝내기3 >> ");
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
				System.out.println("다시 입력해주세요!");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		MonthSchedule1 april = new MonthSchedule1(30);
		april.run();

	}

}
