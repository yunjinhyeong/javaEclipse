import java.util.Scanner;

public class practiceEx09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double radius = sc.nextDouble();
		
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		
		double length = Math.sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) );
		
		if(length > radius)
			System.out.println("¾È°ãÄ§");
		else System.out.println("°ãÄ§");
	
	}

}
