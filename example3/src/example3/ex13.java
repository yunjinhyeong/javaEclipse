package example3;

public class ex13 {

	public static void main(String[] args) {
		double sum = 0.0;
		
		for( int i=0 ; i<args.length ; i++ )
			sum += Double.parseDouble(args[i]);
		System.out.println("ÇÕ°è:"+sum);
		System.out.println("Æò±Õ:"+sum/args.length);

	}

}
