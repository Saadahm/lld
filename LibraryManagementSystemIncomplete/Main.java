package LibraryManagementSystemIncomplete;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Librarian librarian= new Librarian();
        Book b1= new Book("title1", "author1", "123");
        Book b2= new Book("title2", "author2", "124");
        LibraryCatalog libraryCatalog= new LibraryCatalog(Arrays.asList(b1,b2));
        Member m1 = new Member(1,"m1@gmail.com","member1",2, 2400);
    }
}
