package practice03;

public class ex10 {

	public static void main(String[] args) {
		int a[][] = new int [4][4];
		
		for( int i=0 ; i<4 ; i++,System.out.println()) {
			for( int j=0 ; j<4 ; j++, System.out.print('\s')) {
				if(i!=j) {
					a[i][j]=(int)(Math.random()*10 +1);
				} else {
					a[i][j]=0;
				}
				System.out.print(a[i][j]);
			}
		}


	}

}
