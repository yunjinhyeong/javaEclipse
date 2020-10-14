package Ex24;

public class Person {
	public String name;
	public int age;
	public Person(String s) {
		name = s;
	}
	
	
	public void setAge(MyInt i) {
		age = i.val;
		i.val++;
	}
}
