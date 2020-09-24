package practice03;

public class ex11 {

	public static void main(String[] args) {
		int k=0;
		for( int i=0 ; i<args.length ; i++, System.out.println('\s')) {
			int j = Integer.parseInt(args[i]);
			k = j+k;
			System.out.print(j);
		} 
		System.out.println(k/args.length);
	}
}
