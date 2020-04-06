package Iterator;

public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;
    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf=bookShelf;
        this.index=0;
    }
    public boolean hasNext(){
        if(index < bookShelf.getLengthList()){ //배열을 사용하기 위해서는 .getLength 이용
            return true;
        }else{
            return false;
        }
    }

    public Object next(){
        Book book = bookShelf.getBookAtList(index);   //배열을 사용하기 위해서는 getBookAt 이용
        index++;
        return book;
    }
}
