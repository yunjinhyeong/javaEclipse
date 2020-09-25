package ex04;

import java.util.Scanner;

public class PhoneBook {
	Scanner sc = new Scanner(System.in);
	private Phone phone[];
	private int num;
	
	public void getNum() {
		System.out.print("인원수>>");
		this.num = sc.nextInt();
		phone = new Phone[num];
	}
	
	public void getInfo() {
		for( int i=0 ; i<phone.length ; i++ ) {
			System.out.print("이름과 전화번호(빈칸없이 입력)>>");
			String name = sc.next();
			String tel = sc.next();		
			phone[i] = new Phone(name,tel);
		}
		System.out.println("저장되었습니다....");
	}
	
	public void serch() {
		boolean state=false;
		while(true) {
			System.out.print("검색할 이름>>");
			String name = sc.next();
			if(name.equals("그만")) {
				return;
			}
			
			for( int i=0 ; i<phone.length ; i++ ) {
				if(name.equals(phone[i].name())) {
					System.out.println(name+"의 번호는 "+phone[i].tel()+" 입니다.");
					state=true;
				}
			}
			if(state==false) {
				System.out.println("이름이 없습니다.");
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
