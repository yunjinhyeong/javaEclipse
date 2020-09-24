package flowTest;
import java.util.*;
public class ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		
		if(a1 > 0 && a1 <= 99)
		{
			int n10;
			int n01;
			
			n10 = a1 / 10;
			n01 = a1 % 10;
			
			int cnt=0;
			
			if( n10 !=0 && n10 % 3 == 0)
				cnt++;
			
			if( n01 !=0 && n01 % 3 == 0)
				cnt++;
			
			if( cnt==2)
				System.out.println("¹Ú¼öÂ¦Â¦");
			else if(cnt==1)
				System.out.println("¹Ú¼öÂ¦");
			else
				System.out.println("¹Ú¼ö X");
			
		}
		sc.close();

	}

}
