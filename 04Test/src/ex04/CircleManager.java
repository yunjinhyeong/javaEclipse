package ex04;

import java.util.Scanner;

public class CircleManager {
	
	void run() {
		Scanner scanner = new Scanner(System.in);
		Circle c[] = new Circle[3];
		
		for( int i=0 ; i<c.length ; i++ ) {
			System.out.print("x, y, radius >>");
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			int radius = scanner.nextInt();
			c[i] = new Circle(x, y, radius);
		}
		
		for( int i=0 ; i<c.length ; i++ ) {
			c[i].show();
		}
		
		int k=0;
		for( int i=1 ; i<c.length ; i++ ) {
			if(c[k].bigCircle()<c[i].bigCircle())
				k=i;
		}
		c[k].show();
		
		scanner.close();
	}
	

	public static void main(String[] args) {
		new CircleManager().run();
	}
}
