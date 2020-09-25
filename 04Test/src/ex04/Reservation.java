package ex04;

import java.util.Scanner;

public class Reservation {
	Scanner sc = new Scanner(System.in);
	private Seat s[];
	private String seatGrade[] = {"S","A","B"};
	
	public Reservation() {
		s = new Seat [3];
		for( int i=0 ; i<seatGrade.length ; i++ ) {
			s[i]= new Seat();
		}
	}
	
	public void reserve() {
		System.out.print("�¼����� S1 A2 B3 >>");
		int grade = sc.nextInt();
		System.out.print(seatGrade[grade-1]+">>");
		s[grade-1].show();
		
		System.out.print("�̸� >>");
		String name = sc.next();
		System.out.print("��ȣ >>");
		int num = sc.nextInt();
		s[grade-1].set(name, num);
	}
	
	public void serch() {
		for( int i=0 ; i<seatGrade.length ; i++ ) {
			System.out.print(seatGrade[i]+">>");
			s[i].show();
		}
		System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
	}
	
	public void cancel() {
		System.out.print("�¼� S:1, A:2, B:3 >>");
		int grade = sc.nextInt();
		System.out.print(seatGrade[grade-1]+">>");
		s[grade-1].show();
		System.out.print("�̸�>>>");
		String name = sc.next();
		s[grade-1].reSet(name);
	}
	
	public void run() {
		while(true) {
			System.out.print("����1, ��ȸ2, ���3, ������4 >>");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				reserve();
				break;
			case 2:
				serch();
				break;
			case 3:
				cancel();				
				break;
			case 4:
				System.out.println("�����ϴ�");
				return;

			}
		}
	}
}

