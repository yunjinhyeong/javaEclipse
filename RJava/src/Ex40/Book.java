package Ex40;

public class Book {
	String title;
	String author;
	int ISBN;
	
	public Book(String title, String author, int ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	public Book(String title, int ISBN) {
		this(title, "Anonymous", ISBN);
	}
	public Book() {
		this(null, null ,0);
		System.out.println("생성자가 호출되었음");
	}
}
