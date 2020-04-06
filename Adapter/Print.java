package Adapter;

public interface Print { //만약 interface 가 아닌 추상 클래스 일경우 위임하여 사용
    public abstract void printWeak();
    public abstract void printStrong();
}
