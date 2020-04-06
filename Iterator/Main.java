package Iterator;

public class Main {
    public static void main(String[] args){

        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBookList(new Book("Around the World in 80 Days"));
        bookShelf.appendBookList(new Book("Bible"));
        bookShelf.appendBookList(new Book("Cinderella"));
        bookShelf.appendBookList(new Book("Daddy-Long-Legs"));


        //배열을 이용할때 사용...
       // BookShelf bookShelf = new BookShelf(4);
       // bookShelf.appendBook(new Book("Around the World in 80 Days"));
       // bookShelf.appendBook(new Book("Bible"));
       // bookShelf.appendBook(new Book("Cinderella"));
      //  bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        Iterator it = bookShelf.iterator();
        while(it.hasNext()){
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }

    }
}
