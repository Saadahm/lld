package LibraryManagementSystemIncomplete;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
    private String name;
    private List<Member> members= new ArrayList<>();
    private LibraryCatalog libraryCatalog;

    void addBookToLibrary(Book book)
    {
        libraryCatalog.addBook(book);
    }

    void borrow(Book book)
    {
//        Member m=members.get(mem)
    }
}
