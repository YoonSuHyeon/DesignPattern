package Observer;

public class Main {
    public static void main(String[] args){
        NumberGenerator png = new PrimeNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new NamePrintObserver();

        png.addObserver(observer1);
        png.addObserver(observer2);
        png.addObserver(observer3);

        png.execute();
    }
}
