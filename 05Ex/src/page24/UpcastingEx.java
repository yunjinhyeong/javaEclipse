package page24;

public class UpcastingEx {

	public static void main(String[] args) {
		Person p;
		Student s = new Student("¿Ã¿ÁπÆ");
		p = s;
		
		System.out.println(p.name);

	}

}
