package LibraryManagementSystemIncomplete;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private String email;
    private List<Book>history= new ArrayList<>();
    private List<Book>currentBooks= new ArrayList<>();
    private int maxAllowed;
    private int loanDays;

    public Member(int memberId, String email, String name, int maxAllowed, int loanDays) {
        this.memberId = memberId;
        this.email = email;
        this.name = name;
        this.maxAllowed=maxAllowed;
        this.loanDays=loanDays;
    }

    public void borrowBooks(Book book)
    {

             if(currentBooks.size()>maxAllowed)
            {
                System.out.println("Max number of books that can be borrowed finished");
            }
            else {
                currentBooks.add(book);
                history.add(book);
            }


    }

    public void returnBooks(Book book)
    {
            currentBooks.remove(book);
    }
    public void getMemberBooks(){
        for(Book book: currentBooks)
            System.out.println(book.getTitle()+" ");
    }

}
