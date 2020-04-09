package Prototype;

public interface Product extends Cloneable {
    public abstract void use(String s);
    public abstract Product createClone();
    //Cloneable 인터페이스를 상속 하지 않은경우
    //CloneNotSupportedException 이 발생하게 됩니다.
    //클래스 명은 같다 .  hashCode()의 리턴값이 다르다. 얉은 복사가 이루어진다.
    //객체가 생성되는 것이 아니라 복사되는 것이다 .
}
