package practice03;

public class ex12 {

	public static void main(String[] args) {
		double sum=0.0;
		for( int i=0; i<args.length ; i++) {
			if(isStringDouble(args[i])) {
//				System.out.println("숫자");
				sum=Double.parseDouble(args[i])+sum;
			} else
				System.out.println("숫자아님");
		}
		System.out.println(sum);
		
	}
	
	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
