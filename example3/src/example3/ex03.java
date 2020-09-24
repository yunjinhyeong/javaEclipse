package example3;

public class ex03 {

	public static void main(String[] args) {
		char a = '#';
		
		do {
			System.out.print(a);
			a = (char)(a + 1);
		} while (a <= '}');
		
	}

}
