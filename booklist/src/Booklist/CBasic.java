package Booklist;


public class CBasic 
{
	public static void main(String args[]) { // �޼ҵ��̸鼭 ���α׷����࿡ ������
		
		//1.��ü bl1 �����
		BookList bl1 = new BookList();
		
		//2.å���� ��������
		bl1.getCon();
		bl1.selectBookList();
//		bl1.printBook(); 	   //1�� ������ ��� �޼ҵ�
//		bl1.printBook_arr();   //2�� �迭�� ��� �޼ҵ�
//		bl1.printBook_object();//3�� ��ü�� ��� �޼ҵ� 1
		bl1.book1.printBook_object();//3�� ��ü�� ��� �޼ҵ� 2
		bl1.closeDB();
		
//		//3.������ ��������
//		CustomerList cl1 = new CustomerList();
//		cl1.getCon();
//		cl1.selectCustomerList();
//		cl1.closeDB();
		
//		new BookList().selectBookList();
//		new BookList().selectCustomerList();
		
	}
}
