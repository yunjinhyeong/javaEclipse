package page24;

public class UpcastingEx {

	public static void main(String[] args) {
		Person p;
		Student s = new Student("���繮");
		p = s;
		
		System.out.println(p.name);

	}

}
