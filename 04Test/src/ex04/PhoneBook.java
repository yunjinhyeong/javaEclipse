package ex04;

import java.util.Scanner;

public class PhoneBook {
	Scanner sc = new Scanner(System.in);
	private Phone phone[];
	private int num;
	
	public void getNum() {
		System.out.print("�ο���>>");
		this.num = sc.nextInt();
		phone = new Phone[num];
	}
	
	public void getInfo() {
		for( int i=0 ; i<phone.length ; i++ ) {
			System.out.print("�̸��� ��ȭ��ȣ(��ĭ���� �Է�)>>");
			String name = sc.next();
			String tel = sc.next();		
			phone[i] = new Phone(name,tel);
		}
		System.out.println("����Ǿ����ϴ�....");
	}
	
	public void serch() {
		boolean state=false;
		while(true) {
			System.out.print("�˻��� �̸�>>");
			String name = sc.next();
			if(name.equals("�׸�")) {
				return;
			}
			
			for( int i=0 ; i<phone.length ; i++ ) {
				if(name.equals(phone[i].name())) {
					System.out.println(name+"�� ��ȣ�� "+phone[i].tel()+" �Դϴ�.");
					state=true;
				}
			}
			if(state==false) {
				System.out.println("�̸��� �����ϴ�.");
			}
		}
		
	}
	
	
	public static void main(String args[]) {
		PhoneBook p = new PhoneBook();
		p.getNum();
		p.getInfo();
		p.serch();
	}
	





}
