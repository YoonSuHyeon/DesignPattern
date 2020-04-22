package Bridge;

public class Display {
    private DisplayImpl impl;
    public Display(DisplayImpl impl) {
        this.impl = impl;
    }
    public void open() {
        impl.rawOpen();//위임
    }
    public void print() {
        impl.rawPrint();//위임
    }
    public void close() {
        impl.rawClose();//위임
    }
    public final void display(){
        open();
        print();
        close();
    }
}
