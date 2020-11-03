package java1030follow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter("C:/Users/admin/testFolder/testWrite.txt", true);
			System.out.println("키보드로 문자입력하시오");
			String line="";
			while(true) {
				line = sc.nextLine();
				if(line.length()==0) {
					break;
				}
				writer.write(line+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
