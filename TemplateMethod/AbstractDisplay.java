package TemplateMethod;

public abstract class AbstractDisplay {
    public abstract void open();//추상 메소드
    public abstract void print();
    public abstract void close();

    public final void display(){ //Template Method
        open();
        for(int i=0;i<5;i++) print();
        close();
    }
}
