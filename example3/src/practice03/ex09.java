package practice03;

public class ex09 {

	public static void main(String[] args) {
		int a[][] = new int [4][4];
		
		for( int i=0 ; i<4 ; i++,System.out.println()) {
			for( int j=0 ; j<4 ; j++, System.out.print('\s')) {
				a[i][j]=(int)(Math.random()*10 +1);
				System.out.print(a[i][j]);
			}
		}

	}

}
