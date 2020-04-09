package Singleton;

public class Singleton {
    private static Singleton signleton= new Singleton();
    private Singleton(){
        System.out.println("인스턴스를 생성했습니다.");
    }
    public static Singleton getInstance(){ //synchronized를 선언 해주어야한다. 멀티쓰레드 사용시
        return signleton;
    }
}
