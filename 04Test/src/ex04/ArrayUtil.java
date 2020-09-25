package ex04;

public class ArrayUtil {
//	public static int [] concat(int[] a, int[] b) {
//		int [] array = new int[(a.length+b.length)];
//		for(int i=0; i<a.length; i++) {
//			array[i] = a[i];
//		}
//		for(int i=0; i<b.length; i++) {
//			array[a.length+i] = b[i];
//		}
//		return array;
//
//
//		int array[] = new int[(a.length+b.length)];
//		for( int i=0 ; i<a.length ; i++ ) {
//			array[i]=a[i];
//		}
//		for( int i=0 ; i<b.length ; i++ ) {
//			array[a.length+i]=b[i];
//		}
//		return array;
//	}
//	
//	public static void print(int[] a) {
//		System.out.print("[");
//		for( int i=0 ; i<a.length ; i++ ) {
//			System.out.print(a[i]);
//		}
//		System.out.print("]");
//		System.out.print("{ ");
//		for(int i=0; i<a.length; i++) {
//			System.out.print(a[i]+" ");
//		}
//		System.out.println(" }");
//
//
//	}
	
	public static int [] concat(int[] a, int[] b) {
		int [] array = new int[(a.length+b.length)];
		for(int i=0; i<a.length; i++) {
			array[i] = a[i];
		}
		for(int i=0; i<b.length; i++) {
			array[a.length+i] = b[i];
		}
		return array;
	}
	public static void print(int[] a) {
		System.out.print("{ ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println(" }");
	}


	
	public static void main(String[] args) {
		int[] array1 = { 1, 5, 7, 9};
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);

	}

}
