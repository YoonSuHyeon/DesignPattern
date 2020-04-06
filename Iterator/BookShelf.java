package Iterator;


import java.util.ArrayList;

public class BookShelf implements Aggregate {
    private Book[] books;
    private int last=0;
    private ArrayList<Book> booksList; //ArrayList
    public BookShelf(){
        booksList= new ArrayList<Book>();
    }
    public BookShelf(int maxsize){
        this.books=new Book[maxsize];
    }
    public Book getBookAt(int index){
        return books[index];
    }
    public void appendBookList(Book book){
        booksList.add(book);
    }
    public int getLengthList(){
        return booksList.size();
    }
    public Book getBookAtList(int index){
        return booksList.get(index);
    }
    public void appendBook(Book book){
        this.books[last]=book;
        last++;
    }
    public int getLength(){
        return last;
    }
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
