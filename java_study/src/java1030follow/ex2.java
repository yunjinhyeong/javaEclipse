package java1030follow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader reader = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("C:/Users/admin/testFolder/testFile.txt");
			
			try {
				reader = new InputStreamReader(fis,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int c;
			
			try {
				while ((c=reader.read()) != -1) {
					System.out.print((char)c);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
