package ex4_6;

public class CBasic {

	public static void main(String[] args) 
	{
		String a = new String("Good");
		String b = new String("Bad");
		String c = new String("Normal");
		String d, e;//미생, 객체변수, 널포인터, 그냥 레퍼런스
		a = null; //다시 미생으로, 널포인터로, 객체변수로
		d = c;//미생에서 완생으로, 널포인터에서 객체포인터로, normal을 가리키는 객체로
		c = null;// 다시 미생으로, 
	}

}
