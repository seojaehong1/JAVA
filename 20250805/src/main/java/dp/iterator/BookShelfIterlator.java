package dp.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterlator implements Iterator<Book>{
	
	private BookShelf bookShelf; //책장(도서저장)
	private int index;
	
	public BookShelfIterlator(BookShelf bookShelf) { //책장초기화
		this.bookShelf = bookShelf;
		this.index=0;
	}
	
	@Override
	public boolean hasNext() {
		if(index < bookShelf.getLength()) { //다음책이 있느냐
			return true;
		} else {
		return false;
		}
	}

	@Override
	public Book next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		} 
		Book book = bookShelf.getBookAt(index); //해당인데스 책 가져오기
		index++;
		return book;
	}
	
}
