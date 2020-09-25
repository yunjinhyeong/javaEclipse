package ex04;

public class Day {
	private String work;
	public void set(String work) { this.work = work; }
	public String get() { return work; }
	public void show() {
		if(work == null) System.out.println("없습니다.");
		else System.out.println(work + "입니다.");
	}
	
	public static void main(String[] args) {
//		MonthSchedule april = new MonthSchedule(30);
//		april.run();
		new MonthSchedule(30).run();
	}
}