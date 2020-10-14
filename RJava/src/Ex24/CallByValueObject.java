package Ex24;

public class CallByValueObject {

	public static void main(String[] args) {
		Person aPerson = new Person("ȫ�浿");
		MyInt a = new MyInt(33);
		
		aPerson.setAge(a);
		
		System.out.println(a.val);

	}

}
