package practice03;

public class ex13 {

	public static void main(String[] args) {
		int a[][] = new int [10][10];
		
		for ( int i=0 ; i<a.length ; i++) {
				for ( int j=0 ; j<a[i].length ; j++) {
					a[i][j]=i*10+j;
					
					if(i>0) {
						if(j!=0) {
							if(i%3==0 || j%3==0) {
								if(i==j) {
									System.out.println(a[i][j]+"¹Ú¼ö Â¦Â¦");		
								} else {
									System.out.println(a[i][j]+"¹Ú¼ö Â¦");
								}
							}
						}
					} else {
						if((j!=0) & (j%3==0)) {
							if(i%3==0 || j%3==0) {
								if(i==j) {
									System.out.println(a[i][j]+"¹Ú¼ö Â¦Â¦");		
								} else {
									System.out.println(a[i][j]+"¹Ú¼ö Â¦");
								}
							}
						}
					}
				}
		}
	}
}