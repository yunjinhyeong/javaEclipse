package practice03;

public class ex07 {

	public static void main(String[] args) {
		int i [] = new int [10];
		System.out.print("·£´ýÇÑ Á¤¼öµé : ");
		double sum = 0.0;
		for( int a=0 ; a<10 ; a++,System.out.print('\s')) {
			i[a] = (int)(Math.random()*10 +1);
			sum = sum+i[a];
			System.out.print(i[a]);
		}
		System.out.println();
		System.out.println("Æò±ÕÀº "+sum/i.length);
	}
}
