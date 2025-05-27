package LibraryManagementSystemIncomplete;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private List<Book> availableBooks = new ArrayList<>();

    public LibraryCatalog(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void addBook(Book book)
    {
        availableBooks.add(book);
    }

    public void removeBook(Book book)
    {
        availableBooks.remove(book);
        book.setAvailable(false);
    }

}
