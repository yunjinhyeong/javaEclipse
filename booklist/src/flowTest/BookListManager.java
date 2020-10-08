package flowTest;

public class BookListManager {
	void run() {
		BookList bl1 = new BookList();
		bl1.getCon();
		bl1.selectBookList();
		bl1.closeDB();
	}
}
