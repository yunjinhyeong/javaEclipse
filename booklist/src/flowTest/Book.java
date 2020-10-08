package flowTest;

public class Book {
	private int bookId;
	private	String bookName;
	private String bookPublisher;
	private	int bookPrice;
	
	public Book(int bookId, String bookName, String bookPublisher, int bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
	}
	

	public void printBookObject() {
		System.out.println(bookId+"\t"
							+bookName+"\t"
							+bookPublisher+"\t"
							+bookPrice);
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

}
