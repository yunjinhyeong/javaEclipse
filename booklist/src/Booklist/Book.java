package Booklist;


public class Book 
{
	//1.�������
	int bookid;
	String bookname;
	String publisher;
	int price;
	
	//3.�޼ҵ� - ȭ�� ��� �޼ҵ� 3�� <��ü>��
	public void printBook_object()
	{
		System.out.println(bookid + "\t" 
				 + bookname + "\t"
				 + publisher + "\t"
				 + price + "\t"
				 );
	}

	public int getBookid() {
		return bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
