package java1030follow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ex1 {

	public static void main(String[] args) {
		FileReader reader = null;
		
		try {
			reader = new FileReader("C:/Users/admin/testFolder/testFile.txt");
			
			int c;
			try {
				while((c=reader.read()) != -1) {
					System.out.print((char)c);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
