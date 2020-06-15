package FinalState;

public class StatePatternEx {
    public static void main(String[] args) {
        System.out.println("***State Pattern Demo***\n");
        Off initialState = new Off();
        TV tv = new TV(initialState);
        tv.pressButton();
        tv.pressButton();
    }
}
