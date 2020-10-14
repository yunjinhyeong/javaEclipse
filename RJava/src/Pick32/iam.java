package Pick32;

public class iam {

	public static void main(String[] args) {
		Samp ob1 = new Samp(3);
		Samp ob2 = new Samp(4);
		Samp s;
		
		s = ob2;
		ob1 = ob2;
		
		System.out.println("ob1.id="+ob1.id);
		System.out.println("ob2.id="+ob2.id);
	}

}
