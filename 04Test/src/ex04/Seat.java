package ex04;

public class Seat {
	private String Seat[];
	public Seat() {
		Seat = new String[10];
		for( int i=0 ; i<Seat.length ; i++ ) {
			Seat[i]="---";
		}
	}
	
	public void show() {
		for( int i=0 ; i<Seat.length ; i++ ) {
			System.out.print(Seat[i]+" ");
		}
		System.out.println();
	}
	
	public void set(String name, int num) {
		Seat[num-1] = name;
	}
	
	public boolean reSet(String name) {
		for( int i=0 ; i<Seat.length ; i++ ) {
			if(name.equals(Seat[i])) {
				Seat[i]="---";
				System.out.println("<<<취소가 완료>>");
				return true;
			}
		}
		System.out.println("<<<잘 못 입력했습니다.>>");
		return false;
		
	}
}
