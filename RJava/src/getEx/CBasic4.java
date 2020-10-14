package getEx;

public class CBasic4 {
	
	
	public static void main(String[] args) {
		char c[]= {'T','h','i','s',' ','i','s',' ','a',' ','p','e','n','c','i','l','.'};
		
		Goods3 gd = new Goods3();
		gd.printCharArray(c);
		gd.replaceSpace(c);
		gd.printCharArray(c);
		
		Goods3.replaceSpace(c);
		Goods3.printCharArray(c);
	}
} 