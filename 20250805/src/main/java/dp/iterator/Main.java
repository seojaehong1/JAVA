package dp.iterator;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("a"));
		bookShelf.appendBook(new Book("b"));
		bookShelf.appendBook(new Book("c"));
		bookShelf.appendBook(new Book("d"));
		
		Iterator<Book> it = bookShelf.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			System.out.println(book.getName());
		}
		System.out.println();

		for(Book book : bookShelf) {
			System.out.println(book.getName());
		}
	}

}
