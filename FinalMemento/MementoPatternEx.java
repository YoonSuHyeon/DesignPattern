package FinalMemento;

public class MementoPatternEx {
    public static void main(String[] args) {
        System.out.println("***Memento Pattern Demo***\n");
        Originator o = new Originator();
        o.setState("First state");
        Caretaker c = new Caretaker();
        c.SaveMemento(o.OriginatorMemento());
        o.setState("Second state");
        o.Revert(c.RetrieveMemento());

    }
}
